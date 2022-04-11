package org.metahut.octopus.engine;

import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.engine.executor.ExecutorPluginHelper;
import org.metahut.octopus.engine.parser.ParserPluginHelper;
import org.metahut.octopus.executor.api.AbstractExecutor;
import org.metahut.octopus.executor.api.IExecutorManager;
import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.ParserNode;
import org.metahut.octopus.parser.api.ParserResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.metahut.octopus.parser.api.TypeUtils.generateKey;

public class GraphHandler {

    private ExecutorPluginHelper executorPluginHelper;

    private ParserPluginHelper parserPluginHelper;

    public GraphHandler(ExecutorPluginHelper executorPluginHelper, ParserPluginHelper parserPluginHelper) {
        this.executorPluginHelper = executorPluginHelper;
        this.parserPluginHelper = parserPluginHelper;
    }

    public void metricsHandler(Integer taskCode) {

        // 入参： 计算类型：实时，离线；Data:     ;环境Env

        // 根据taskCode查询任务表

        String sourceCode = "";

        // 根据sourcecode 查询 rule 表 上线 规则集合
        List<RuleInstance> ruleInstances = new ArrayList<>();

        Map<Integer, ParserNode> parserMap = new HashMap<>();
        ruleInstances.forEach(instance -> {
            Integer sampleCode = Objects.nonNull(instance.getMetricsSample()) ? instance.getMetricsSample().getCode() : -1;
            ParserNode sampleNode = parserMap.computeIfAbsent(sampleCode, entry -> parserPluginHelper.generateParser(instance.getMetricsSample()));
            String metricsInstanceKey = generateKey(instance.getMetrics().getCode().toString(), instance.getSubjectCode());
            sampleNode.getNextNodes().computeIfAbsent(metricsInstanceKey, entry -> parserPluginHelper.generateParser(instance.getMetrics()));

            // TODO 记录一个指标实例对应的规则 ？？？

        });

        Map<String, AbstractExecutor> lazyExecutorMap = new HashMap<>();
        parserMap.forEach((key, value) -> {

            // sample parser

            action(lazyExecutorMap, value.getType(), value.getParams());

            // TODO 多线程并发处理
            value.getNextNodes().forEach((nKey, nValue) -> {
                action(lazyExecutorMap, nValue.getType(), nValue.getParams());
            });

        });

        lazyExecutorMap.forEach((key, value) -> {
            value.execute();
        });

        // 指标结果表
        // subject_code, subject_category, metrics_code, metrics_value,create_time








    }

    public void action(Map<String, AbstractExecutor> lazyExecutorMap, String parserType, String params) {

        IParser parser = parserPluginHelper.generateInstance(parserType, params);
        ParserResult result = parser.parser();

        IExecutorManager executorManager = executorPluginHelper.getExecutor(result.getExecutorType());
        AbstractExecutor executor = lazyExecutorMap.get(result.getExecutorType());
        if (Objects.isNull(executor)) {
            executor = executorManager.generateInstance("");
            if (executor.isLazyRunMode()) {
                lazyExecutorMap.put(result.getExecutorType(), executor);
            }
        }

        if (executor.isLazyRunMode()) {
            executor.addTransform(result.getExecutorScript());
        } else {
            executor.execute();
        }

    }
}
