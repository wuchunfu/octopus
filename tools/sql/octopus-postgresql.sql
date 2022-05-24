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

DROP TABLE IF EXISTS tb_octopus_user;
CREATE TABLE tb_octopus_user
(
    id             serial      NOT NULL,
    user_name     varchar(64) DEFAULT NULL,
    user_password varchar(64) DEFAULT NULL,
    user_type     tinyint(4)  DEFAULT NULL,
    email         varchar(64) DEFAULT NULL,
    phone         varchar(11) DEFAULT NULL,
    tenant_id     int(11)     DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    queue         varchar(64) DEFAULT NULL,
    state         int(1)      DEFAULT 1,
    time_zone     varchar(32) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_name_unique UNIQUE(user_name)
);

DROP TABLE IF EXISTS tb_octopus_metrics;
CREATE TABLE tb_octopus_metrics
(
    id             serial      NOT NULL,
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
    CONSTRAINT metrics_code_unique UNIQUE(code),
    CONSTRAINT metrics_name_unique UNIQUE(name)
);

DROP TABLE IF EXISTS tb_octopus_metrics_config;
CREATE TABLE tb_octopus_metrics_config
(
    id             serial      NOT NULL,
    code             int(11)     NOT NULL,
    name             varchar(64) DEFAULT NULL,

    metrics_code     varchar(64) NOT NULL,
    create_type      varchar(16) DEFAULT 'CUSTOM',
    metrics_params   varchar(64) NOT NULL,
    subject_category varchar(16) DEFAULT 'TABLE',
    source_category  varchar(64) NOT NULL,

    description      varchar(64) DEFAULT NULL,
    create_time      datetime    DEFAULT NULL,
    update_time      datetime    DEFAULT NULL,
    creator          int(11)     DEFAULT NULL,
    updater          int(11)     DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT metrics_config_code_unique UNIQUE(code)
);

DROP TABLE IF EXISTS tb_octopus_rule_template;
CREATE TABLE tb_octopus_rule_template
(
    id             serial      NOT NULL,
    code              int(11)     NOT NULL,
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
    CONSTRAINT rule_template_code_unique UNIQUE(code)
);

DROP TABLE IF EXISTS tb_octopus_sample_instance;
CREATE TABLE tb_octopus_sample_instance
(
    id             serial      NOT NULL,
    code          int(11)     NOT NULL,

    dataset_code   varchar(64) NOT NULL,
    executor_type varchar(64),
    parameter     text,

    create_time   datetime DEFAULT NULL,
    update_time   datetime DEFAULT NULL,
    creator       int(11)  DEFAULT NULL,
    updater       int(11)  DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT sample_instance_code_unique UNIQUE(dataset_code, executor_type)
);

DROP TABLE IF EXISTS tb_octopus_rule_instance;
CREATE TABLE tb_octopus_rule_instance
(
    id             serial      NOT NULL,
    code                int(11)      NOT NULL,
    name                varchar(64) DEFAULT NULL,
    dataset_code         varchar(64)  NOT NULL,

    metrics_code        varchar(64)  NOT NULL,
    -- custom execution script
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
    comparison_unit    varchar(16),
    expected_value      varchar(64),

    state               varchar(20) DEFAULT 'OFFLINE',

    description         varchar(64) DEFAULT NULL,
    create_time         datetime    DEFAULT NULL,
    update_time         datetime    DEFAULT NULL,
    creator             int(11)     DEFAULT NULL,
    updater             int(11)     DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT rule_metrics_unique UNIQUE(dataset_code, metrics_unique_key, comparison_method),
    -- One metrics of one table has only one sampling proportion
    CONSTRAINT rule_metrics_sample_unique UNIQUE(dataset_code, metrics_code, sample_code)
);

DROP TABLE IF EXISTS tb_octopus_alerter_instance;
CREATE TABLE tb_octopus_alerter_instance
(
    id             serial      NOT NULL,
    alert_type  varchar(64) NOT NULL,
    code        int(11)     NOT NULL,
    name        varchar(200) DEFAULT NULL,
    parameter   text,

    description varchar(64)  DEFAULT NULL,
    create_time datetime     DEFAULT NULL,
    update_time datetime     DEFAULT NULL,
    creator     int(11)      DEFAULT NULL,
    updater     int(11)      DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_octopus_source_alert_relation;
CREATE TABLE tb_octopus_source_alert_relation
(
    id             serial      NOT NULL,
    dataset_code         varchar(64) NOT NULL,
    alert_instance_code int(11)     NOT NULL,
    alerter             varchar(200),

    create_time         datetime DEFAULT NULL,
    update_time         datetime DEFAULT NULL,
    creator             int(11)  DEFAULT NULL,
    updater             int(11)  DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_octopus_flow_definition;
CREATE TABLE tb_octopus_flow_definition
(
    id             serial      NOT NULL,
    code           int(11)      NOT NULL,
    dataset_code    varchar(64) NOT NULL,
    env            varchar(200),
    crontab        varchar(200) NOT NULL,
    scheduler_code varchar(254) NOT NULL,

    create_time    datetime DEFAULT NULL,
    update_time    datetime DEFAULT NULL,
    creator        int(11)  DEFAULT NULL,
    updater        int(11)  DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT flow_definition_code_unique UNIQUE(dataset_code)
);