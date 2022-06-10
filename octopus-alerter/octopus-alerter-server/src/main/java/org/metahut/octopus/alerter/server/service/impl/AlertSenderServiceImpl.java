package org.metahut.octopus.alerter.server.service.impl;

import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.api.IAlerter;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.alerter.server.AlerterPluginHelper;
import org.metahut.octopus.alerter.server.dto.AlertSenderBatchSendRequestDTO;
import org.metahut.octopus.alerter.server.dto.AlertSenderSendRequestDTO;
import org.metahut.octopus.alerter.server.service.AlertSenderService;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.dao.entity.AlerterInstance_;
import org.metahut.octopus.dao.repository.AlerterInstanceRepository;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
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
}
