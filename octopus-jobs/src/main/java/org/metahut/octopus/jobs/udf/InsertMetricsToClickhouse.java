package org.metahut.octopus.jobs.udf;

import org.metahut.octopus.jobs.util.ClickhouseUtils;

import org.apache.flink.table.functions.ScalarFunction;

import java.text.MessageFormat;

public class InsertMetricsToClickhouse extends ScalarFunction {

    public String eval (String id, String reportChannel, String datasetCode, String subjectCode, String subjectCategory, String metricsCode, String metricsUniqueKey, String metricsValue) {

        String sql = "insert into quality.monitor_metrics_result(id, report_channel, dataset_code, subject_code, subject_category, metrics_code, metrics_unique_key, metrics_value)"
                + " values (''{0}'',''{1}'',''{2}'',''{3}'',''{4}'',''{5}'',''{6}'',''{7}'')";
        String realSql = MessageFormat.format(sql, id, reportChannel, datasetCode,subjectCode, subjectCategory, metricsCode, metricsUniqueKey, metricsValue);
        try {
            ClickhouseUtils.insert(realSql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reportChannel;
    }
}
