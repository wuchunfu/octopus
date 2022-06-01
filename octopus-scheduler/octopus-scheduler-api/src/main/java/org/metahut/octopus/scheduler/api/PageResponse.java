package org.metahut.octopus.scheduler.api;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {

    private Integer pageNo;

    private Integer pageSize;

    private Long total;

    private List<T> data;

}
