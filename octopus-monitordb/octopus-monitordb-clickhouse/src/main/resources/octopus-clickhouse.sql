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

drop table IF EXISTS monitor_metrics_result;
CREATE TABLE monitor_metrics_result
(
    `id`                  Int32,
    `report_channel` String,
    `subject_code`         String,
    `subject_category` String,
    `metrics_code`        String,
    `metrics_unique_key` String,
    `metrics_value`              String,
    `create_time`         DateTime default now()
) ENGINE = MergeTree()
ORDER BY id
SETTINGS index_granularity = 8192;

drop table IF EXISTS monitor_rule_log;
CREATE TABLE monitor_rule_log
(
    `id`                  Int32,
    `rule_instance_code` Int32,
    `datasource_code`         String,
    `dataset_code` String,
    `metrics_code`        String,
    `metrics_config_code` Int32,

    `subject_code`  String,
    `subject_category` String,

    `checkType` String,
    `checkMethod`   String,
    `comparisonMethod` String,
    `expectedValue`     String,

    `result`              String,
    `error`              Boolean,
    `error_info`         String,
    `error_time`         DateTime,
    `create_time`        DateTime default now()
) ENGINE = MergeTree()
ORDER BY id
SETTINGS index_granularity = 8192;
