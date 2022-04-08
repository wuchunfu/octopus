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
    user_type     tinyint(4) DEFAULT NULL,
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

DROP TABLE IF EXISTS tb_octopus_metrics_category CASCADE;
CREATE TABLE tb_octopus_metrics_category
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     varchar(64) NOT NULL,
    name varchar(64) NOT NULL,
    metrics_parser varchar(64) NOT NULL,

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_category_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_metrics CASCADE;
CREATE TABLE tb_octopus_metrics
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     int(11) NOT NULL,
    name varchar(64) DEFAULT NULL,
    metrics_category varchar(64) NOT NULL,
    create_type  varchar(16) DEFAULT 'CUSTOM',
    metrics_params varchar(64) NOT NULL,
    subject_category varchar(16) DEFAULT 'TABLE',

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_metrics_source_relation CASCADE;
CREATE TABLE tb_octopus_metrics_source_relation
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    source_category varchar(64) NOT NULL,
    metrics_code  int(11) NOT NULL,

    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_source_unique (source_category,metrics_code)
);

DROP TABLE IF EXISTS tb_octopus_metrics_sample CASCADE;
CREATE TABLE tb_octopus_metrics_sample
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     int(11) NOT NULL,
    name varchar(64) DEFAULT NULL,



    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY metrics_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_rule_template CASCADE;
CREATE TABLE tb_octopus_rule_template
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     int(11) NOT NULL,
    name varchar(64) DEFAULT NULL,
    metrics_code int(11) NOT NULL,
    check_type varchar(64),
    check_method varchar(64),
    comparison_method varchar(64),
    expected_value varchar(64),

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY rule_template_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_rule_instance CASCADE;
CREATE TABLE tb_octopus_rule_instance
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     int(11) NOT NULL,
    name varchar(64) DEFAULT NULL,
    source_code varchar(64) NOT NULL,

    metrics_code int(11) NOT NULL,
    subject_code varchar(64) NOT NULL,
    filter varchar(254),
    sample_code int(11),

    check_type varchar(64),
    check_method varchar(64),
    comparison_method varchar(64),
    expected_value varchar(64),
    task_type varchar(64) DEFAULT 'BATCH',
    state varchar(20) DEFAULT 'OFFLINE',

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY rule_code_unique (code),
    UNIQUE KEY rule_metrics_unique (source_code,metrics_code,metrics_fields)
);



DROP TABLE IF EXISTS tb_octopus_task CASCADE;
CREATE TABLE tb_octopus_task
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     int(11) NOT NULL,
    source_code int(11) NOT NULL,
    app_ids varchar(64),
    env varchar(64),

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY task_code_unique (code)
);


-- sourcecode, 告警实例, 告警人

DROP TABLE IF EXISTS tb_octopus_task CASCADE;
CREATE TABLE tb_octopus_task
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    code     int(11) NOT NULL,
    source_code int(11) NOT NULL,
    app_ids varchar(64),
    env varchar(64),

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY task_code_unique (code)
);

DROP TABLE IF EXISTS tb_octopus_source_alert_relation CASCADE;
CREATE TABLE tb_octopus_source_alert_relation
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    source_code int(11) NOT NULL,
    alert_instance_code int(11) NOT NULL,
    alerter varchar(200),

    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_octopus_alert_instance CASCADE;
CREATE TABLE tb_octopus_alert_instance
(
    id                     int NOT NULL AUTO_INCREMENT,
    alert_type       varchar(64) NOT NULL,
    code int(11) NOT NULL,
    name varchar(200) DEFAULT NULL,
    alert_params text,

    description         varchar(64) DEFAULT NULL,
    create_time   datetime    DEFAULT NULL,
    update_time   datetime    DEFAULT NULL,
    creator         int(11) DEFAULT NULL,
    updater     int(11) DEFAULT NULL,
    PRIMARY KEY (id)
);
