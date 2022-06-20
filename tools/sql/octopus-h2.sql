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
    id              int(11) NOT NULL AUTO_INCREMENT,
    code            bigint NOT NULL,
    name            varchar(64),
    cn_name         varchar(64) DEFAULT NULL,
    password        varchar(64),
    email           varchar(64),
    phone_number     varchar(11),
    department_name  varchar(255),
    group_name       varchar(255),
    state           varchar(255),
    create_time   timestamp   DEFAULT NULL,
    update_time   timestamp   DEFAULT NULL,
    creator        int       DEFAULT NULL,
    updater        int       DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_name_unique UNIQUE (name)
);

DROP TABLE IF EXISTS tb_octopus_flow_definition CASCADE;
CREATE TABLE tb_octopus_flow_definition
(
    id             int(11)      NOT NULL AUTO_INCREMENT,
    code           bigint(20)      NOT NULL,
    dataset_code    varchar(64) NOT NULL,
    env            varchar(200),
    crontab        varchar(200) NOT NULL,
    scheduler_code varchar(254),
    filter              text,
    date_time_fields  text DEFAULT NULL,
    window_type varchar(64) DEFAULT NULL,
    window_size varchar(64) DEFAULT NULL,
    window_unit varchar(64) DEFAULT NULL,
    create_time    datetime DEFAULT NULL,
    update_time    datetime DEFAULT NULL,
    creator        int(11)  DEFAULT NULL,
    updater        int(11)  DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY flow_definition_code_unique (dataset_code)

);

DROP TABLE IF EXISTS tb_octopus_alerter_instance CASCADE;
CREATE TABLE tb_octopus_alerter_instance
(
    id          int         NOT NULL AUTO_INCREMENT,
    dataset_code         varchar(64),
    alerter_source_code        bigint(20)     NOT NULL,
    parameter   text NOT NULL,

    description varchar(64)  DEFAULT NULL,
    create_time datetime     DEFAULT NULL,
    update_time datetime     DEFAULT NULL,
    creator     int(11)      DEFAULT NULL,
    updater     int(11)      DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_octopus_alerter_source CASCADE;
CREATE TABLE tb_octopus_alerter_source
(
    id          int         NOT NULL AUTO_INCREMENT,
    alert_type  varchar(64) NOT NULL,
    code        bigint(20)     NOT NULL,
    name        varchar(200) DEFAULT NULL,
    parameter   text NOT NULL,

    description varchar(64)  DEFAULT NULL,
    create_time datetime     DEFAULT NULL,
    update_time datetime     DEFAULT NULL,
    creator     int(11)      DEFAULT NULL,
    updater     int(11)      DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_octopus_rule_instance CASCADE;
CREATE TABLE tb_octopus_rule_instance
(
    id                  int(11)      NOT NULL AUTO_INCREMENT,
    code                bigint(20)      NOT NULL,
    name                varchar(64) DEFAULT NULL,
    dataset_code         varchar(64),

    metrics_code        varchar(64)  NOT NULL,
    -- custom execution script
    metrics_config_code bigint(20),

    metrics_params      text  NOT NULL,
    subject_category    varchar(16) DEFAULT 'TABLE',
    subject_code        varchar(64),
    metrics_unique_key  varchar(254) NOT NULL,
    filter              text,

    sample_code         bigint(20),
    task_type           varchar(64) DEFAULT 'BATCH',

    check_type          varchar(64),
    check_method        varchar(64),
    comparison_method   varchar(64),
    comparison_unit    varchar(16),
    expected_value      varchar(64),

    state               varchar(20) DEFAULT 'OFFLINE',

    description         varchar(64) DEFAULT NULL,
    create_time         datetime    DEFAULT NULL,
    update_time         datetime    DEFAULT NULL,
    creator             int(11)     DEFAULT NULL,
    updater             int(11)     DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY rule_metrics_unique (dataset_code, metrics_unique_key, comparison_method),
    -- One metrics of one table has only one sampling proportion
    UNIQUE KEY rule_metrics_sample_unique (dataset_code, metrics_code, sample_code)
);

DROP TABLE IF EXISTS tb_octopus_rule_template CASCADE;
CREATE TABLE tb_octopus_rule_template
(
    id                int(11)     NOT NULL AUTO_INCREMENT,
    code              bigint(20)     NOT NULL,
    name              varchar(64) DEFAULT NULL,
    metrics_code      varchar(64) NOT NULL,

    check_type        varchar(64),
    check_method      varchar(64),
    comparison_method varchar(64),
    expected_value    varchar(64),
    comparison_unit    varchar(16),
    subject_category  varchar(16) DEFAULT 'TABLE',
    description       varchar(64) DEFAULT NULL,
    create_time       datetime    DEFAULT NULL,
    update_time       datetime    DEFAULT NULL,
    creator           int(11)     DEFAULT NULL,
    updater           int(11)     DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY rule_template_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_sample_instance CASCADE;
CREATE TABLE tb_octopus_sample_instance
(
    id            int(11)     NOT NULL AUTO_INCREMENT,
    code          bigint(20)     NOT NULL,

    dataset_code   varchar(64),
    executor_type varchar(64),
    parameter     text,
    runtime_parameter text,
    create_time   datetime DEFAULT NULL,
    update_time   datetime DEFAULT NULL,
    creator       int(11)  DEFAULT NULL,
    updater       int(11)  DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY sample_instance_code_unique (dataset_code, executor_type)
);

DROP TABLE IF EXISTS tb_octopus_metrics_config CASCADE;
CREATE TABLE tb_octopus_metrics_config
(
    id               int(11)     NOT NULL AUTO_INCREMENT,
    code             bigint(20)     NOT NULL,
    name             varchar(64) DEFAULT NULL,

    metrics_code     varchar(64) NOT NULL,
    create_type      varchar(16) DEFAULT 'CUSTOM',
    metrics_params   text NOT NULL,
    subject_category varchar(16) DEFAULT 'TABLE',
    source_category  varchar(64) NOT NULL,

    description      varchar(64) DEFAULT NULL,
    create_time      datetime    DEFAULT NULL,
    update_time      datetime    DEFAULT NULL,
    creator          int(11)     DEFAULT NULL,
    updater          int(11)     DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_config_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_metrics CASCADE;
CREATE TABLE tb_octopus_metrics
(
    id                int(11)     NOT NULL AUTO_INCREMENT,
    code              varchar(64) NOT NULL,
    name              varchar(64) NOT NULL,
    category          varchar(64),
    metrics_dimension varchar(64),
    description       varchar(64) DEFAULT NULL,
    create_time       datetime    DEFAULT NULL,
    update_time       datetime    DEFAULT NULL,
    creator           int(11)     DEFAULT NULL,
    updater           int(11)     DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_code_unique (code),
    UNIQUE KEY metrics_name_unique (name)
);
