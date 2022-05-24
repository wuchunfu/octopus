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

package org.metahut.octopus.scheduler.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "octopus.scheduler")
public class SchedulerProperties {

    private SchedulerTypeEnum type;
    private DolphinScheduler dolphinscheduler = new DolphinScheduler();

    public static class DolphinScheduler {
        private String serviceUrl;
        private String token;
        private String projectCode;
        private String tenantCode;
        private HttpClient httpClient;

        public String getServiceUrl() {
            return serviceUrl;
        }

        public void setServiceUrl(String serviceUrl) {
            this.serviceUrl = serviceUrl;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getProjectCode() {
            return projectCode;
        }

        public void setProjectCode(String projectCode) {
            this.projectCode = projectCode;
        }

        public String getTenantCode() {
            return Objects.isNull(tenantCode) || "".equals(tenantCode.trim()) ? "default" : tenantCode;
        }

        public void setTenantCode(String tenantCode) {
            this.tenantCode = tenantCode;
        }

        public HttpClient getHttpClient() {
            return httpClient;
        }

        public void setHttpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
        }
    }

    public static class HttpClient {
        private int connectTimeout;

        public int getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

    }

    public SchedulerTypeEnum getType() {
        return type;
    }

    public void setType(SchedulerTypeEnum type) {
        this.type = type;
    }

    public DolphinScheduler getDolphinscheduler() {
        return dolphinscheduler;
    }

    public void setDolphinscheduler(DolphinScheduler dolphinscheduler) {
        this.dolphinscheduler = dolphinscheduler;
    }
}
