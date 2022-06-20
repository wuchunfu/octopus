package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AlerterException;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.common.utils.JSONUtils;

import java.util.Objects;

public class DingTalkAlerterManager implements IAlerterManager {

    @Override
    public String getType() {
        return "DingTalk";
    }

    @Override
    public DingTalkAlerterParameter deserializeParameter(String parameter) {
        DingTalkAlerterParameter dingTalkParameter =  JSONUtils.parseObject(parameter, DingTalkAlerterParameter.class);
        if (Objects.isNull(dingTalkParameter)) {
            throw new AlerterException("Invalid parameters to convert");
        }
        boolean checkParameter = dingTalkParameter.checkParameter();
        if (!checkParameter) {
            throw new AlerterException("The incoming parameter can not be empty");
        }
        return dingTalkParameter;
    }

    @Override
    public DingTalkAlerterSourceParameter deserializeSourceParameter(String parameter) {
        DingTalkAlerterSourceParameter sourceParameter =  JSONUtils.parseObject(parameter, DingTalkAlerterSourceParameter.class);
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
    public DingTalkAlerter generateInstance(String sourceParameter, String parameter) {
        DingTalkAlerterSourceParameter dingTalkAlerterSourceParameter = deserializeSourceParameter(sourceParameter);
        DingTalkAlerterParameter dingTalkAlerterParameter = deserializeParameter(parameter);
        return new DingTalkAlerter(dingTalkAlerterSourceParameter, dingTalkAlerterParameter);
    }

}
