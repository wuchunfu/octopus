/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/


drop table IF EXISTS monitor_metrics_result_all;
CREATE TABLE monitor_metrics_result_all
(
    `id`                 String,
    `window_begin_time`  DateTime,
    `window_size`        Int64,
    `window_unit`        String,
    `schedule_time`      DateTime,
    `report_channel`     String,
    `dataset_code`       String,
    `subject_code`       String,
    `subject_category`   String,
    `metrics_code`       String,
    `metrics_unique_key` String,
    `metrics_value`      String,
    `create_time`        DateTime default now()
) ENGINE = MergeTree()
ORDER BY create_time
PARTITION BY toYYYYMMDD(create_time)
SETTINGS index_granularity = 8192;

-- insert into monitor_metrics_result_all(id, window_begin_time, window_size, window_unit, schedule_time, report_channel, dataset_code, subject_code, subject_category, metrics_code, metrics_unique_key, metrics_value)
-- values(generateUUIDv4(),'2022-06-10 12:00:00', 1, 'HOUR', '2022-06-10 13:35:00', '', '01', '12312312', 'TABLE', 'delay', '', '123123123');

drop table IF EXISTS monitor_rule_log_all;
CREATE TABLE monitor_rule_log_all
(
    `id`                  String,
    `rule_instance_code`  Int64,
    `window_begin_time`   DateTime,
    `window_size`         Int64,
    `window_unit`         String,
    `schedule_time`       DateTime,
    `datasource_code`     String,
    `dataset_code`        String,
    `metrics_code`        String,
    `metrics_config_code` String,
    `subject_code`        String,
    `subject_category`    String,
    `check_type`          String,
    `check_method`        String,
    `comparison_method`   String,
    `comparison_unit`     String,
    `expected_value`      String,
    `result`              String,
    `error`               Int8,
    `error_info`          String,
    `error_time`          DateTime,
    `create_time`         DateTime default now()
) ENGINE = MergeTree()
ORDER BY create_time
PARTITION BY toYYYYMMDD(create_time)
SETTINGS index_granularity = 8192;

-- insert into monitor_rule_log_all(id, rule_instance_code,  window_begin_time, window_size, window_unit, schedule_time, datasource_code, dataset_code, metrics_code, metrics_config_code, subject_code, subject_category, check_type, check_method, comparison_method, comparison_unit, expected_value, result, error, error_info, error_time)
-- values(generateUUIDv4(), 5779276730530,'2022-06-10 12:00:00', 1, 'HOUR', '2022-06-10 13:35:00', '1','01', 'delay', '5637843692320', '12312334', 'TABLE', 'Num', 'FixedValue', 'GT', 'Num', '["20","30"]', 'abcsdfasfd', 1, 'error info', now());