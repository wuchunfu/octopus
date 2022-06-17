package org.metahut.octopus.alerter.server.controller;

import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.server.dto.AlertSenderBatchSendRequestDTO;
import org.metahut.octopus.alerter.server.dto.AlertSenderSendRequestDTO;
import org.metahut.octopus.alerter.server.dto.AlertStructuralRequestDTO;
import org.metahut.octopus.alerter.server.service.AlertSenderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("alertSender")
public class AlertSenderController {

    private final AlertSenderService alertSenderService;

    public AlertSenderController(AlertSenderService alertSenderService) {
        this.alertSenderService = alertSenderService;
    }

    @PostMapping("batchSend")
    public List<AlerterResult> batchSend(@RequestBody AlertSenderBatchSendRequestDTO requestDTO) {
        return alertSenderService.batchSend(requestDTO);
    }

    @PostMapping("batchSendWithDetails")
    public List<AlerterResult> batchSend(@RequestBody AlertStructuralRequestDTO requestDTO) {
        return alertSenderService.batchSend(requestDTO);
    }

    @PostMapping("send")
    public AlerterResult send(@RequestBody AlertSenderSendRequestDTO requestDTO) {
        return alertSenderService.send(requestDTO);
    }
}
