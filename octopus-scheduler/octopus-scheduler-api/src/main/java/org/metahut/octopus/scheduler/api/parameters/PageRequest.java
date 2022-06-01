package org.metahut.octopus.scheduler.api.parameters;

import lombok.Data;

@Data
public class PageRequest {
    private Integer pageNo;
    private Integer pageSize;
}
