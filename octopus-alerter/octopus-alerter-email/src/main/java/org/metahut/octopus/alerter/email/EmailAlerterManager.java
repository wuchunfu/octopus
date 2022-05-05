package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AbstractParameter;
import org.metahut.octopus.alerter.api.AlerterException;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.alerter.common.utils.JSONUtils;

import java.util.Objects;

public class EmailAlerterManager implements IAlerterManager {

    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public EmailParameter getParameter(String parameter) {
        EmailParameter emailParameter =  JSONUtils.parseObject(parameter, EmailParameter.class);
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
    public EmailAlerter generateInstance(String parameter) {
        return new EmailAlerter(getParameter(parameter));
    }
}
