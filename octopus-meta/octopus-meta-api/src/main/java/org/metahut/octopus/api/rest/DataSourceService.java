package org.metahut.octopus.api.rest;

import org.metahut.octopus.api.dao.DataSourceRequest;
import org.metahut.octopus.api.dao.DataSourceResponse;

import java.util.List;

public interface DataSourceService {
    List<DataSourceResponse> queryDatasourceList(DataSourceRequest request);
}
