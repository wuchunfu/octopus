package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.monitordb.api.IMonitorDBSource;
import org.metahut.octopus.monitordb.api.MetricsResult;
import org.metahut.octopus.monitordb.api.MetricsResultRequest;
import org.metahut.octopus.monitordb.api.MonitorLog;
import org.metahut.octopus.monitordb.api.MonitorLogRequest;
import org.metahut.octopus.monitordb.api.PageResponse;
import org.metahut.octopus.server.service.MonitorDBService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MonitorDBServiceImpl implements MonitorDBService {

    private final IMonitorDBSource monitorDBSource;
    private final ConversionService conversionService;

    public MonitorDBServiceImpl(IMonitorDBSource monitorDBSource, ConversionService conversionService) {
        this.monitorDBSource = monitorDBSource;
        this.conversionService = conversionService;
    }

    @Override
    public List<Map<String, Object>> customSQLQuery(String sql) {
        return monitorDBSource.customSQLQuery(sql);
    }

    @Override
    public PageResponseDTO<MonitorLogResponseDTO> queryMonitorLogListPage(MonitorLogConditionsRequestDTO requestDTO) {
        MonitorLogRequest request = conversionService.convert(requestDTO, MonitorLogRequest.class);
        PageResponse<MonitorLog> monitorLogPageResponse = monitorDBSource.queryMonitorLogListPage(request);

        List<MonitorLog> data = monitorLogPageResponse.getData();
        List<MonitorLogResponseDTO> converts = (List<MonitorLogResponseDTO>) conversionService.convert(data,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorLog.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorLogResponseDTO.class)));

        // TODO Supplementary data

        return PageResponseDTO.of(monitorLogPageResponse.getPageNo(), monitorLogPageResponse.getPageSize(), monitorLogPageResponse.getTotal(), converts);
    }

    @Override
    public PageResponseDTO<MetricsResultResponseDTO> queryMetricsResultListPage(MetricsResultConditionsRequestDTO requestDTO) {
        MetricsResultRequest request = conversionService.convert(requestDTO, MetricsResultRequest.class);
        PageResponse<MetricsResult> metricsResultPageResponse = monitorDBSource.queryMetricsResultListPage(request);

        List<MetricsResult> data = metricsResultPageResponse.getData();
        List<MetricsResultResponseDTO> converts = (List<MetricsResultResponseDTO>) conversionService.convert(data,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResult.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResultResponseDTO.class)));

        // TODO Supplementary data

        return PageResponseDTO.of(metricsResultPageResponse.getPageNo(), metricsResultPageResponse.getPageSize(), metricsResultPageResponse.getTotal(), converts);
    }
}
