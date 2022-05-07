//package org.metahut.octopus.engine;
//
//import org.metahut.octopus.dao.entity.RuleInstance;
//import org.metahut.octopus.engine.domain.MetricsExecuteInstance;
//import org.metahut.octopus.engine.domain.RuleExecuteInstance;
//import org.metahut.octopus.engine.executor.ExecutorPluginHelper;
//import org.metahut.octopus.engine.parser.ParserPluginHelper;
//import org.metahut.octopus.executor.api.AbstractExecutor;
//import org.metahut.octopus.executor.api.IExecutorManager;
//import org.metahut.octopus.parser.api.IParser;
//import org.metahut.octopus.parser.api.ParserResult;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//public class GraphHandler {
//
//    private final ExecutorPluginHelper executorPluginHelper;
//
//    private final ParserPluginHelper parserPluginHelper;
//
//    public GraphHandler(ExecutorPluginHelper executorPluginHelper, ParserPluginHelper parserPluginHelper) {
//        this.executorPluginHelper = executorPluginHelper;
//        this.parserPluginHelper = parserPluginHelper;
//    }
//
//    // Only supports flink engine
//    public void metrics() {
//        // 根据sourceCode查询Flow表
//
//        String sourceCategory = "";
//
//        // query online status rule list
//        List<RuleInstance> ruleInstances = new ArrayList<>();
//
//        // monitor_metrics_result: 上报渠道???, subject_code, subject_category, metrics_code, metrics_unique_key, metrics_value, create_time
//
//        //executor flink / shell / python / automatic report
//
//        // parser plugin
//
//        // source: 根据不同的引擎创建 ？？？
//        // sample: input: src_table, params:{"method": "BLOCK", "number": 10, "unit": "percent"}   output: src_table, executor_type, script: create table octopus_${src_table} as select * from ${src_table} tablesample(10 percent)
//        // metrics: input: src_table, subject_code, subject_category, metrics_code, metrics_unique_key, params:{"executorType":"flink-sql","script":"select count(1) from ${src_table}"}, rules   output: executor_type, script
//        // sink: 两个sink 必须有顺序 monitordb, pulsar/kafka
//
//        // metrics 1.generateUniqueKey 2.parser
//
//        // source: 读取 pulsar/kafka 数据
//        // rule: input: src_table   output: executor_type, script: select func(metrics_unique_key,rules) from ${src_table}
//        // alerter
//        // sink: monitordb
//
//        // flink-function -> rule plugin -> jdbc execute(monitordb plugin)
//        // rule plugin: input: source_table output: executor_type, script: select value ${ComparisonSymbol} ${ExpectedValue} from ${src_table}
//
//
//        // metrics instance : metrics_code, metrics_config_code, metrics_params, subject_code, subject_category, metrics_unique_key???, filter, executorType, script, task_type
//
//
//        // metrics: select count(1) from ${src_table}
//        // metrics: select subject_code, subject_category, metrics_code, metrics_unique_key, count(1) as value, now() as create_time from ${src_table}
//
//        Map<String, MetricsFlow> metricsAggMap = new HashMap<>();
//        ruleInstances.forEach(instance -> {
//            String sampleType = parserPluginHelper.generateType(sourceCategory, instance.getSampleInstance());
//            MetricsFlow metricsFlow = metricsAggMap.computeIfAbsent(sampleType, entry -> {
//                return new MetricsFlow();
//            });
//
//            MetricsExecuteInstance metrics = metricsFlow.nextNodes.computeIfAbsent(instance.getMetricsUniqueKey(), entry -> {
//                MetricsExecuteInstance metricsExecuteInstance = new MetricsExecuteInstance();
//                metricsExecuteInstance.setMetricsCode(instance.getMetricsCode());
//                metricsExecuteInstance.setSubjectCategory(instance.getSubjectCategory());
//                return metricsExecuteInstance;
//            });
//
//            RuleExecuteInstance ruleExecuteInstance = new RuleExecuteInstance();
//
//            metrics.getRules().add(ruleExecuteInstance);
//
//        });
//
//
//        // source
//
//        // sink
//
//        Map<String, AbstractExecutor> executorMap = new HashMap<>();
//        List<ExecuteGraph> executeGraphs = new ArrayList<>();
//
//        metricsAggMap.forEach((key, value) -> {
//
//            // sample handler
//            AbstractExecutor action = action(executorMap, key, value.getSampleParams());
//
//            ExecuteGraph executeGraph = new ExecuteGraph();
//            executeGraph.setExecutor(action);
//            executeGraphs.add(executeGraph);
//
//            Map<String, MetricsExecuteInstance> nextNodes = value.getNextNodes();
//            nextNodes.forEach((nKey, nValue) -> {
//                AbstractExecutor action1 = action(executorMap, nKey, "");
//                if (Objects.nonNull(action1)) {
//                    executeGraph.getNextNodes().add(action1);
//                }
//            });
//
//        });
//
//        executeGraphs.forEach(executeGraph -> {
//
//        });
//    }
//
//    @Deprecated
//    public void metricsHandler(Integer sourceCode) {
//
//        // 根据sourceCode查询Flow表
//
//        String sourceCategory = "";
//
//        // query online status rule list
//        List<RuleInstance> ruleInstances = new ArrayList<>();
//
//        // monitor_metrics_result: 上报渠道???, subject_code, subject_category, metrics_code, metrics_unique_key, metrics_value, create_time
//
//        //executor flink / shell / python / 自动上报
//
//        // parser plugin
//
//        // source: 根据不同的引擎创建 ？？？
//        // sample: input: src_table, params:{"method": "BLOCK", "number": 10, "unit": "percent"}   output: src_table, executor_type, script: create table octopus_${src_table} as select * from ${src_table} tablesample(10 percent)
//        // metrics: input: src_table, subject_code, subject_category, metrics_code, metrics_unique_key, params:{"executorType":"flink-sql","script":"select count(1) from ${src_table}"}, rules   output: executor_type, script
//        // sink: 两个sink 必须有顺序 monitordb, pulsar/kafka
//
//        // metrics 1.generateUniqueKey 2.parser
//
//        // source: 读取 pulsar/kafka 数据
//        // rule: input: src_table   output: executor_type, script: select func(metrics_unique_key,rules) from ${src_table}
//        // alerter
//        // sink: monitordb
//
//        // flink-function -> rule plugin -> jdbc execute(monitordb plugin)
//        // rule plugin: input: source_table output: executor_type, script: select value ${ComparisonSymbol} ${ExpectedValue} from ${src_table}
//
//
//        // metrics instance : metrics_code, metrics_config_code, metrics_params, subject_code, subject_category, metrics_unique_key???, filter, executorType, script, task_type
//
//
//        // metrics: select count(1) from ${src_table}
//        // metrics: select subject_code, subject_category, metrics_code, metrics_unique_key, count(1) as value, now() as create_time from ${src_table}
//
//        Map<String, MetricsFlow> metricsAggMap = new HashMap<>();
//        ruleInstances.forEach(instance -> {
//            String sampleType = parserPluginHelper.generateType(sourceCategory, instance.getSampleInstance());
//            MetricsFlow metricsFlow = metricsAggMap.computeIfAbsent(sampleType, entry -> {
//                return new MetricsFlow();
//            });
//
//            MetricsExecuteInstance metrics = metricsFlow.nextNodes.computeIfAbsent(instance.getMetricsUniqueKey(), entry -> {
//                MetricsExecuteInstance metricsExecuteInstance = new MetricsExecuteInstance();
//                metricsExecuteInstance.setMetricsCode(instance.getMetricsCode());
//                metricsExecuteInstance.setSubjectCategory(instance.getSubjectCategory());
//                return metricsExecuteInstance;
//            });
//
//            RuleExecuteInstance ruleExecuteInstance = new RuleExecuteInstance();
//
//            metrics.getRules().add(ruleExecuteInstance);
//
//        });
//
//
//        // source
//
//        // sink
//
//        Map<String, AbstractExecutor> executorMap = new HashMap<>();
//        List<ExecuteGraph> executeGraphs = new ArrayList<>();
//
//        metricsAggMap.forEach((key, value) -> {
//
//            // sample handler
//            AbstractExecutor action = action(executorMap, key, value.getSampleParams());
//
//            ExecuteGraph executeGraph = new ExecuteGraph();
//            executeGraph.setExecutor(action);
//            executeGraphs.add(executeGraph);
//
//            Map<String, MetricsExecuteInstance> nextNodes = value.getNextNodes();
//            nextNodes.forEach((nKey, nValue) -> {
//                AbstractExecutor action1 = action(executorMap, nKey, "");
//                if (Objects.nonNull(action1)) {
//                    executeGraph.getNextNodes().add(action1);
//                }
//            });
//
//        });
//
//        executeGraphs.forEach(executeGraph -> {
//
//        });
//
//
//    }
//
//    public AbstractExecutor action(Map<String, AbstractExecutor> executorMap, String parserType, String params) {
//        IParser parser = parserPluginHelper.generateInstance(parserType, params);
//        ParserResult result = parser.parser();
//
//        IExecutorManager executorManager = executorPluginHelper.getExecutor(result.getExecutorType());
//        AbstractExecutor executor = executorMap.get(result.getExecutorType());
//        if ( /* executorManager.isLazyRunMode() && */ Objects.nonNull(executor)) {
//            executor.addTransform("");
//            return null;
//        }
//        executor = executorManager.generateInstance("result.getExecutorScript()");
//        executorMap.put(result.getExecutorType(), executor);
//        return executor;
//
//    }
//
//    public static class MetricsFlow {
//
//        private Map<String, MetricsExecuteInstance> nextNodes = new HashMap<>();
//
//        private String sampleParams;
//
//        public Map<String, MetricsExecuteInstance> getNextNodes() {
//            return nextNodes;
//        }
//
//        public void setNextNodes(Map<String, MetricsExecuteInstance> nextNodes) {
//            this.nextNodes = nextNodes;
//        }
//
//        public String getSampleParams() {
//            return sampleParams;
//        }
//
//        public void setSampleParams(String sampleParams) {
//            this.sampleParams = sampleParams;
//        }
//    }
//
//    public static class ExecuteGraph {
//
//        private AbstractExecutor executor;
//
//        private List<AbstractExecutor> nextNodes = new ArrayList<>();
//
//        public List<AbstractExecutor> getNextNodes() {
//            return nextNodes;
//        }
//
//        public void setNextNodes(List<AbstractExecutor> nextNodes) {
//            this.nextNodes = nextNodes;
//        }
//
//        public AbstractExecutor getExecutor() {
//            return executor;
//        }
//
//        public void setExecutor(AbstractExecutor executor) {
//            this.executor = executor;
//        }
//    }
//}
