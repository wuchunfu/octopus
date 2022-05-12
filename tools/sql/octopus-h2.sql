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

DROP TABLE IF EXISTS tb_octopus_user CASCADE;
CREATE TABLE tb_octopus_user
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    user_name     varchar(64) DEFAULT NULL,
    user_password varchar(64) DEFAULT NULL,
    user_type     tinyint(4)  DEFAULT NULL,
    email         varchar(64) DEFAULT NULL,
    phone         varchar(11) DEFAULT NULL,
    tenant_id     int(11) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    queue         varchar(64) DEFAULT NULL,
    state         int(1) DEFAULT 1,
    time_zone     varchar(32) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY user_name_unique (user_name)
);

DROP TABLE IF EXISTS tb_octopus_metrics CASCADE;
CREATE TABLE tb_octopus_metrics
(
    id                int(11) NOT NULL AUTO_INCREMENT,
    code              varchar(64) NOT NULL,
    name              varchar(64) NOT NULL,
    category          varchar(64),
    metrics_dimension varchar(64),
    description       varchar(64) DEFAULT NULL,
    create_time       datetime    DEFAULT NULL,
    update_time       datetime    DEFAULT NULL,
    creator           int(11) DEFAULT NULL,
    updater           int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_code_unique (code),
    UNIQUE KEY metrics_name_unique (name)
);

DROP TABLE IF EXISTS tb_octopus_metrics_config CASCADE;
CREATE TABLE tb_octopus_metrics_config
(
    id               int(11) NOT NULL AUTO_INCREMENT,
    code             int(11) NOT NULL,
    name             varchar(64) DEFAULT NULL,

    metrics_code     varchar(64) NOT NULL,
    create_type      varchar(16) DEFAULT 'CUSTOM',
    metrics_params   varchar(64) NOT NULL,
    subject_category varchar(16) DEFAULT 'TABLE',
    source_category  varchar(64) NOT NULL,
    compute_mode     varchar(64) NOT NULL,
    compute_script   text        NOT NULL,

    description      varchar(64) DEFAULT NULL,
    create_time      datetime    DEFAULT NULL,
    update_time      datetime    DEFAULT NULL,
    creator          int(11) DEFAULT NULL,
    updater          int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_config_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_rule_template CASCADE;
CREATE TABLE tb_octopus_rule_template
(
    id                int(11) NOT NULL AUTO_INCREMENT,
    code              int(11) NOT NULL,
    name              varchar(64) DEFAULT NULL,
    metrics_code      varchar(64) NOT NULL,

    check_type        varchar(64),
    check_method      varchar(64),
    comparison_method varchar(64),
    expected_value    varchar(64),
    threshold_unit    varchar(16),
    subject_category varchar(16) DEFAULT 'TABLE',
    description       varchar(64) DEFAULT NULL,
    create_time       datetime    DEFAULT NULL,
    update_time       datetime    DEFAULT NULL,
    creator           int(11) DEFAULT NULL,
    updater           int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY rule_template_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_sample_instance CASCADE;
CREATE TABLE tb_octopus_sample_instance
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code          int(11) NOT NULL,

    source_code   varchar(64) NOT NULL,
    executor_type varchar(64),
    params        text,

    create_time   datetime DEFAULT NULL,
    update_time   datetime DEFAULT NULL,
    creator       int(11) DEFAULT NULL,
    updater       int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY sample_instance_code_unique (source_code, executor_type)
);

DROP TABLE IF EXISTS tb_octopus_rule_instance CASCADE;
CREATE TABLE tb_octopus_rule_instance
(
    id                  int(11) NOT NULL AUTO_INCREMENT,
    code                int(11) NOT NULL,
    name                varchar(64) DEFAULT NULL,
    source_code         varchar(64)  NOT NULL,

    metrics_code        varchar(64)  NOT NULL,
    metrics_config_code int(11),

    metrics_params      varchar(64)  NOT NULL,
    subject_category    varchar(16) DEFAULT 'TABLE',
    subject_code        varchar(64),
    metrics_unique_key  varchar(254) NOT NULL,
    filter              text,

    sample_code         int(11),
    task_type           varchar(64) DEFAULT 'BATCH',

    check_type          varchar(64),
    check_method        varchar(64),
    comparison_method   varchar(64),
    expected_value      varchar(64),

    state               varchar(20) DEFAULT 'OFFLINE',

    description         varchar(64) DEFAULT NULL,
    create_time         datetime    DEFAULT NULL,
    update_time         datetime    DEFAULT NULL,
    creator             int(11) DEFAULT NULL,
    updater             int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY rule_metrics_unique (source_code, metrics_unique_key, comparison_method),
    -- One metrics of one table has only one sampling proportion
    UNIQUE KEY rule_metrics_sample_unique (source_code, metrics_code, sample_code)
);

DROP TABLE IF EXISTS tb_octopus_alerter_instance CASCADE;
CREATE TABLE tb_octopus_alerter_instance
(
    id           int         NOT NULL AUTO_INCREMENT,
    alert_type   varchar(64) NOT NULL,
    code         int(11) NOT NULL,
    name         varchar(200) DEFAULT NULL,
    alert_params text,

    description  varchar(64)  DEFAULT NULL,
    create_time  datetime     DEFAULT NULL,
    update_time  datetime     DEFAULT NULL,
    creator      int(11) DEFAULT NULL,
    updater      int(11) DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_octopus_source_alert_relation CASCADE;
CREATE TABLE tb_octopus_source_alert_relation
(
    id                  int(11) NOT NULL AUTO_INCREMENT,
    source_code         int(11) NOT NULL,
    alert_instance_code int(11) NOT NULL,
    alerter             varchar(200),

    create_time         datetime DEFAULT NULL,
    update_time         datetime DEFAULT NULL,
    creator             int(11) DEFAULT NULL,
    updater             int(11) DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_octopus_flow_definition CASCADE;
CREATE TABLE tb_octopus_flow_definition
(
    id             int(11) NOT NULL AUTO_INCREMENT,
    source_code    int(11) NOT NULL,
    env            varchar(200),
    crontab        varchar(200) NOT NULL,
    scheduler_code varchar(254) NOT NULL,

    create_time    datetime DEFAULT NULL,
    update_time    datetime DEFAULT NULL,
    creator        int(11) DEFAULT NULL,
    updater        int(11) DEFAULT NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_octopus_task_instance CASCADE;
CREATE TABLE tb_octopus_task_instance
(
    id          int(11) NOT NULL AUTO_INCREMENT,
    source_code int(11) NOT NULL,
    task_type   varchar(64) NOT NULL,
    app_ids     varchar(64),

    create_time datetime DEFAULT NULL,
    PRIMARY KEY (id)
);



