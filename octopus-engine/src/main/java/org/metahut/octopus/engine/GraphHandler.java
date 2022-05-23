package org.metahut.octopus.engine;

import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.engine.domain.JobGraph;
import org.metahut.octopus.engine.domain.MetricsExecuteInstance;
import org.metahut.octopus.engine.domain.RuleExecuteInstance;
import org.metahut.octopus.engine.domain.SampleExecuteInstance;
import org.metahut.octopus.engine.executor.ExecutorPluginHelper;
import org.metahut.octopus.engine.parser.ParserPluginHelper;
import org.metahut.octopus.executor.api.IExecutor;
import org.metahut.octopus.executor.api.IExecutorManager;
import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.ParserResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GraphHandler {

    private final ExecutorPluginHelper executorPluginHelper;
    private final ParserPluginHelper parserPluginHelper;

    public GraphHandler(ExecutorPluginHelper executorPluginHelper, ParserPluginHelper parserPluginHelper) {
        this.executorPluginHelper = executorPluginHelper;
        this.parserPluginHelper = parserPluginHelper;
    }

    // Only supports flink engine

    /**
     * <p>
     * Only supports flink engine
     * When it is a real-time task, the task needs to be restarted to support the metrics change
     * </p>
     */
    public void metricsHandler() {
        // 根据sourceCode查询Flow表

        String sourceCategory = "";

        // query online status rule list
        List<RuleInstance> ruleInstances = new ArrayList<>();

        // monitor_metrics_result: report channel???, subject_code, subject_category, metrics_code, metrics_unique_key, metrics_value, create_time

        // executor type: flink / shell / python / automatic report

        // parser plugin

        // source: 根据不同的引擎创建 ？？？
        // sample: input: src_table, params:{"method": "BLOCK", "number": 10, "unit": "percent"}   output: src_table, executor_type, script: create table octopus_${src_table} as select * from ${src_table} tablesample(10 percent)
        // metrics: input: src_table, subject_code, subject_category, metrics_code, metrics_unique_key, params:{"executorType":"flink-sql","script":"select count(1) from ${src_table}"}, rules   output: executor_type, script
        // sink: 两个sink 必须有顺序 monitordb, pulsar/kafka

        // metrics 1.generateUniqueKey 2.parser

        // source: 读取 pulsar/kafka 数据
        // rule: input: src_table   output: executor_type, script: select func(metrics_unique_key,rules) from ${src_table}
        // alerter
        // sink: monitordb

        // flink-function -> rule plugin -> jdbc execute(monitordb plugin)
        // rule plugin: input: source_table output: executor_type, script: select value ${ComparisonSymbol} ${ExpectedValue} from ${src_table}


        // metrics instance : metrics_code, metrics_config_code, metrics_params, subject_code, subject_category, metrics_unique_key???, filter, executorType, script, task_type


        // metrics: select count(1) from ${src_table}
        // metrics: select subject_code, subject_category, metrics_code, metrics_unique_key, count(1) as value, now() as create_time from ${src_table}

        Map<String, SampleExecuteInstance> metricsAggMap = new HashMap<>();
        ruleInstances.forEach(instance -> {
            String sampleType = parserPluginHelper.generateType(sourceCategory, instance.getSampleInstance());
            SampleExecuteInstance sampleExecuteInstance = metricsAggMap.computeIfAbsent(sampleType, entry -> SampleExecuteInstance.of(instance.getSampleInstance().getParameter()));
            MetricsExecuteInstance metrics = sampleExecuteInstance.getNextNodes().computeIfAbsent(instance.getMetricsUniqueKey(), entry -> {
                MetricsExecuteInstance metricsExecuteInstance = new MetricsExecuteInstance();
                metricsExecuteInstance.setMetricsCode(instance.getMetrics().getCode());
                metricsExecuteInstance.setSubjectCategory(instance.getSubjectCategory());
                return metricsExecuteInstance;
            });

            RuleExecuteInstance ruleExecuteInstance = new RuleExecuteInstance();
            metrics.getRules().add(ruleExecuteInstance);
        });

        Map<String, IExecutor> executorMap = new HashMap<>();
        metricsAggMap.forEach((key, value) -> {
            // sample
            IExecutor action = transform(executorMap, key, value.getParameter());
            JobGraph executeGraph = new JobGraph();
            executeGraph.setExecutor(action);
            // metrics
            Map<String, MetricsExecuteInstance> nextNodes = value.getNextNodes();
            nextNodes.forEach((nKey, nValue) -> {
                transform(executorMap, nKey, nValue.generateParameter());
            });
        });
        IExecutor executor = executorMap.get("Flink");

        // add source

        // add sink

        executor.execute();
    }

    public IExecutor transform(Map<String, IExecutor> executorMap, String parserType, String params) {
        IParser parser = parserPluginHelper.generateInstance(parserType, params);
        ParserResult result = parser.parser();

        IExecutorManager executorManager = executorPluginHelper.getExecutor(result.getExecutorType());
        IExecutor executor = executorMap.get(result.getExecutorType());
        if (executorManager.isLazyRunMode() && Objects.nonNull(executor)) {
            executor.addTransform(result.getExecutorScript());
            return null;
        }
        executor = executorManager.generateInstance(result.getExecutorScript());
        executorMap.put(result.getExecutorType(), executor);
        return executor;

    }
}
