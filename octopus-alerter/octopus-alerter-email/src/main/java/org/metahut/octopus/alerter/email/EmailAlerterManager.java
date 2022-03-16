package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AlerterException;
import org.metahut.octopus.alerter.api.AlerterManager;
import org.metahut.octopus.alerter.common.utils.JSONUtils;

import java.util.Objects;

public class EmailAlerterManager implements AlerterManager {

    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public EmailAlerter generateInstance(String parameter) {
        EmailParameter emailParameter =  JSONUtils
            .parseObject(parameter, EmailParameter.class);
        if (Objects.isNull(emailParameter)) {
            throw new AlerterException("Invalid parameters to convert");
        }
        boolean checkParameter = emailParameter.checkParameter();
        if (!checkParameter) {
            throw new AlerterException("The incoming parameter can not be empty");
        }
        return new EmailAlerter(emailParameter);
    }
}
