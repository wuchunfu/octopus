package org.metahut.octopus.alerter.server.service.impl;

import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.api.IAlerter;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.alerter.server.AlerterPluginHelper;
import org.metahut.octopus.alerter.server.dto.AlertSenderBatchSendRequestDTO;
import org.metahut.octopus.alerter.server.dto.AlertSenderSendRequestDTO;
import org.metahut.octopus.alerter.server.dto.AlertStructuralRequestDTO;
import org.metahut.octopus.alerter.server.service.AlertSenderService;
import org.metahut.octopus.common.enums.CheckMethodEnum;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.dao.entity.AlerterInstance_;
import org.metahut.octopus.dao.repository.AlerterInstanceRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertSenderServiceImpl implements AlertSenderService {

    private final AlerterPluginHelper alerterPluginHelper;

    private final AlerterInstanceRepository alerterInstanceRepository;

    public AlertSenderServiceImpl(AlerterPluginHelper alerterPluginHelper, AlerterInstanceRepository alerterInstanceRepository) {
        this.alerterPluginHelper = alerterPluginHelper;
        this.alerterInstanceRepository = alerterInstanceRepository;
    }

    @Override
    public List<AlerterResult> batchSend(AlertSenderBatchSendRequestDTO requestDTO) {
        List<AlerterInstance> instances = alerterInstanceRepository.findAll((root, query, builder) ->
                builder.equal(root.get(AlerterInstance_.datasetCode), requestDTO.getBizCode())
        );
        return instances.stream().parallel().map(instance -> send(instance, requestDTO.getTitle(), requestDTO.getContent())).collect(Collectors.toList());
    }

    @Override
    public List<AlerterResult> batchSend(AlertStructuralRequestDTO requestDTO) {
        List<AlerterInstance> instances = alerterInstanceRepository.findAll((root, query, builder) ->
            builder.equal(root.get(AlerterInstance_.datasetCode), requestDTO.getDatasetCode())
        );

        return instances.stream()
            .parallel()
            .map(instance -> sendByTemplate(instance, getTitleTemplate(), getContentTemplate(), buildPlaceHolders(requestDTO)))
            .collect(Collectors.toList());
    }

    private static String getTitleTemplate() {
        return "${metric.name}";
    }

    private  Map<String, String> buildPlaceHolders(AlertStructuralRequestDTO requestDTO) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put("metric.name", StringUtils.defaultIfBlank(requestDTO.getMetricsName(), ""));
        placeholders.put("monitor.target", StringUtils.defaultIfBlank(requestDTO.getDatasetName(), ""));
        placeholders.put("monitor.actual.value", StringUtils.defaultIfBlank(requestDTO.getActualValue(), ""));
        placeholders.put("monitor.expected.value", StringUtils.defaultIfBlank(requestDTO.getExpectedValue(), ""));
        placeholders.put("monitor.check.method", StringUtils.defaultIfBlank(CheckMethodEnum.valueOf(requestDTO.getCheckMethod()).getName(), ""));
        placeholders.put("monitor.comparator.method", StringUtils.defaultIfBlank(requestDTO.getComparisonMethod(), ""));
        placeholders.put("error.message", StringUtils.defaultIfBlank(requestDTO.getMessage(), ""));
        placeholders.put("monitor.check.time", StringUtils.defaultIfBlank(requestDTO.getCheckTime(), ""));
        return placeholders;
    }

    private static String getContentTemplate() {
        StringBuilder builder = new StringBuilder("### ");
        builder.append("${metric.name}");
        builder.append("\n");
        builder.append("> * **监测目标:** ");
        builder.append("${monitor.target}");
        builder.append("\n");
        builder.append("> * **校验方式:** ");
        builder.append("${monitor.check.method}");
        builder.append("\n");
        builder.append("> * **实际数值:** ");
        builder.append("${monitor.actual.value}");
        builder.append("\n");
        builder.append("> * **监控阀值:** ");
        builder.append("${monitor.expected.value}");
        builder.append("\n");
        builder.append("> * **对比方式:** ");
        builder.append("${monitor.actual.value} ${monitor.comparator.method} ${monitor.expected.value}");
        builder.append("\n");
        builder.append("> * **异常信息:** ");
        builder.append("${error.message}");
        builder.append("\n");
        builder.append("> * **检测时间:** ");
        builder.append("\n");
        builder.append("${monitor.check.time}");
        builder.append("\n");
        // 告警时间
        builder.append("> * **告警时间:** ");
        builder.append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .format(new Date()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()));
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public AlerterResult send(AlertSenderSendRequestDTO requestDTO) {
        Optional<AlerterInstance> optional = alerterInstanceRepository.findById(requestDTO.getInstanceId());
        if (!optional.isPresent()) {
            return new AlerterResult(false, MessageFormat.format("Alarm instance: [{0}] does not exist", requestDTO.getInstanceId()));
        }
        return send(optional.get(), requestDTO.getTitle(), requestDTO.getContent());
    }

    private AlerterResult send(AlerterInstance instance, String title, String content) {
        IAlerterManager alerterManager = alerterPluginHelper.getAlerter(instance.getSource().getAlertType());
        IAlerter alerter = alerterManager.generateInstance(instance.getSource().getParameter(), instance.getParameter());
        return alerter.send(title, content);
    }

    private AlerterResult sendByTemplate(AlerterInstance instance, String titleTemplate, String contentTemplate, Map<String, String> params) {
        IAlerterManager alerterManager = alerterPluginHelper.getAlerter(instance.getSource().getAlertType());
        IAlerter alerter = alerterManager.generateInstance(instance.getSource().getParameter(), instance.getParameter());
        return alerter.sendByTemplate(titleTemplate, contentTemplate, params);
    }
}
