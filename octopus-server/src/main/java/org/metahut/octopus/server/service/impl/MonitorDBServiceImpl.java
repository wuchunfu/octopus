package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.entity.MetricsResult;
import org.metahut.octopus.monitordb.api.entity.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.entity.MonitorLog;
import org.metahut.octopus.monitordb.api.entity.MonitorLogRequest;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class MonitorDBServiceImpl implements MonitorDBService {

    private final IMonitorDBSource iMonitorDBSource;
    private final ConversionService conversionService;

    public MonitorDBServiceImpl(IMonitorDBSource iMonitorDBSource, ConversionService conversionService) {
        this.iMonitorDBSource = iMonitorDBSource;
        this.conversionService = conversionService;
    }

    @Override
    public List<Map<String, Object>> customSQLQuery(String sql) {
        return iMonitorDBSource.customSQLQuery(sql);
    }

    @Override
    public List<MonitorLogResponseDTO> monitorLogQueryAll(MonitorLogConditionsRequestDTO request) {
        List<MonitorLogResponseDTO> list = (List<MonitorLogResponseDTO>) conversionService.convert(
            iMonitorDBSource.queryMonitorLogs(new MonitorLogRequest()),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorLog.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorLogResponseDTO.class)));
        //TODO

        return list;
    }

    @Override
    public PageResponseDTO<MonitorLogResponseDTO> monitorLogQueryListPage(MonitorLogConditionsRequestDTO request) {
        List<MonitorLogResponseDTO> list = monitorLogQueryAll(request);
        return PageResponseDTO.of(request.getPageNo(), request.getPageSize(), (long) list.size(), list);
    }

    @Override
    public MonitorLogResponseDTO monitorLogQueryById(Integer id) {
        MonitorLogRequest request = new MonitorLogRequest();
        request.setIds(Arrays.asList(id));
        MonitorLog monitorLog = iMonitorDBSource.queryMonitorLogs(request).get(0);
        MonitorLogResponseDTO response = conversionService.convert(monitorLog, MonitorLogResponseDTO.class);
        //TODO

        return response;
    }

    @Override
    public List<MetricsResultResponseDTO> metricsResultQueryAll(MetricsResultConditionsRequestDTO request) {
        List<MetricsResultResponseDTO> list = (List<MetricsResultResponseDTO>) conversionService.convert(
            iMonitorDBSource.queryMetricsResults(new MetricsResultRequest()),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResult.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResultResponseDTO.class)));
        //TODO

        return list;
    }

    @Override
    public PageResponseDTO<MetricsResultResponseDTO> metricsResultQueryListPage(MetricsResultConditionsRequestDTO request) {
        List<MetricsResultResponseDTO> list = metricsResultQueryAll(request);
        return PageResponseDTO.of(request.getPageNo(), request.getPageSize(), (long) list.size(), list);
    }
}
