package org.metahut.octopus.parser.metrics.flink;

import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.ParserResult;

public class MetricsParser implements IParser {

    private final MetricsParserParameter parameter;

    public MetricsParser(MetricsParserParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public ParserResult parser() {

        // query 插件
        String metricsSql = "SELECT count(1) from ${src_table}";

        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append(parameter.getSubjectCategory());
        query.append(" as subject_category,");
        query.append(parameter.getSubjectCode());
        query.append(" as subject_code,");
        query.append(parameter.getMetricsCode());
        query.append(" as metrics_code,");
        query.append(parameter.getMetricsUniqueKey());
        query.append(" as metrics_unique_key,");
        query.append(parameter.getRules());
        query.append(" as rules,");
        query.append(" NOW() as create_time,");
        query.append("* as metrics_value ");
        query.append(" FROM (");
        query.append(metricsSql);
        query.append(" );");

        return null;
    }
}
