package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AlerterException;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.common.utils.JSONUtils;

import java.util.Objects;

public class EmailAlerterManager implements IAlerterManager {

    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public EmailAlerterParameter deserializeParameter(String parameter) {
        EmailAlerterParameter emailParameter = JSONUtils.parseObject(parameter, EmailAlerterParameter.class);
        if (Objects.isNull(emailParameter)) {
            throw new AlerterException("Invalid parameters to convert");
        }
        boolean checkParameter = emailParameter.checkParameter();
        if (!checkParameter) {
            throw new AlerterException("The incoming parameter can not be empty");
        }
        return emailParameter;
    }

    @Override
    public EmailAlerterSourceParameter deserializeSourceParameter(String parameter) {
        EmailAlerterSourceParameter sourceParameter = JSONUtils.parseObject(parameter, EmailAlerterSourceParameter.class);
        if (Objects.isNull(sourceParameter)) {
            throw new AlerterException("Invalid parameters to convert");
        }
        boolean checkParameter = sourceParameter.checkParameter();
        if (!checkParameter) {
            throw new AlerterException("The incoming parameter can not be empty");
        }
        return sourceParameter;
    }

    @Override
    public EmailAlerter generateInstance(String sourceParameter, String parameter) {
        EmailAlerterSourceParameter emailAlerterSourceParameter = deserializeSourceParameter(sourceParameter);
        EmailAlerterParameter emailAlerterParameter = deserializeParameter(parameter);
        return new EmailAlerter(emailAlerterSourceParameter, emailAlerterParameter);
    }
    
}
