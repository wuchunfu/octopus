package org.metahut.octopus.scheduler.api.parameters;

import lombok.Data;

@Data
public class TaskInstanceLogRequestParameter {
    int taskInstanceId;
    int offset;
    int limit;
}
