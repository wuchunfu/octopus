package org.metahut.octopus.jobs.udf;

import org.metahut.octopus.jobs.util.ClickhouseUtils;

import com.alibaba.fastjson.JSONObject;
import org.apache.flink.table.functions.ScalarFunction;

import java.text.MessageFormat;

public class ValidateInsertRuleToClickhouse extends ScalarFunction {

    public String eval (Long id, String reportChannel, String datasetCode, String subjectCode, String subjectCategory, String metricsCode, String metricsUniqueKey, String metricsValue) {

        //interface response
        JSONObject jsonObject = new JSONObject();

        String sql = "insert into monitor_rule_log_local\n"
                + "select \n"
                + "    {0} as id,\n"
                + "    ''{1}'' as rule_instance_code,\n"
                + "    ''{2}'' as datasource_code,\n"
                + "    ''{3}'' as dataset_code,\n"
                + "    ''{4}'' as metrics_code,\n"
                + "    ''{5}'' as metrics_config_code,\n"
                + "    ''{6}'' as subject_code,\n"
                + "    ''{7}'' as subject_category,\n"
                + "    ''{8}'' as check_type,\n"
                + "    ''{9}'' as check_method,\n"
                + "    ''{10}'' as comparison_method,\n"
                + "    ''{11}'' as expected_value,\n"
                + "    ''{12}'' as result,\n"
                + "    error,\n"
                + "    if(error, 'error_info_one', 'error_info_two') as error_info,\n"
                + "    now() as error_time\n"
                + "from(\n"
                + "    select \n"
                + "        if(sum(metrics_value){13}{11}, True, False ) as error\n"
                + "    from monitor_metrics_result \n"
                + "    where create_time between ${14} and ${15}\n"
                + "        and subject_code = ''{6}''\n"
                + "        and subject_category = ''{7}''\n"
                + "        and metrics_code = ''{4}''\n"
                + ")t";

        String realSql = MessageFormat.format(sql, jsonObject.getInteger("id"),
                jsonObject.getString("rule_instance_code"),
                jsonObject.getString("datasource_code"),
                jsonObject.getString("dataset_code"),
                metricsCode,
                jsonObject.getString("metrics_config_code"),
                subjectCode,
                subjectCategory,
                jsonObject.getString("check_type"),
                jsonObject.getString("check_method"),
                jsonObject.getString("comparison_method"),
                "3", //expected_value
                //jsonObject.getString("expected_value"),
                jsonObject.getString("result"),
                ">", //comparison_symbol
                // sonObject.getString("comparison_symbol"),
                jsonObject.getString("begin_time"),
                jsonObject.getString("end_time")
                );

        try {
            ClickhouseUtils.insert(realSql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
