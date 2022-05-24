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

import org.metahut.octopus.scheduler.api.parameters.ScheduleCronParameter;
import org.metahut.octopus.scheduler.api.parameters.ScheduleParameter;
import org.metahut.octopus.scheduler.api.parameters.TaskParameter;

import java.util.List;

public interface IScheduler extends AutoCloseable {

    List<String> previewSchedule(ScheduleCronParameter scheduleParameter);

    String createSchedule(ScheduleParameter scheduleParameter);

    void updateSchedule(ScheduleParameter scheduleParameter);

    String createSingleHttpTask(TaskParameter taskDefinitionParameter);

    void deleteFlowByCode(String flowCode);

}
