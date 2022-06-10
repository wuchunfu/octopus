package org.metahut.octopus.alerter.server.service;

import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.server.dto.AlertSenderBatchSendRequestDTO;
import org.metahut.octopus.alerter.server.dto.AlertSenderSendRequestDTO;

import java.util.List;

public interface AlertSenderService {
    List<AlerterResult> batchSend(AlertSenderBatchSendRequestDTO requestDTO);

    AlerterResult send(AlertSenderSendRequestDTO requestDTO);
}
