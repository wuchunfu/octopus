package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AlerterException;
import org.metahut.octopus.alerter.api.IAlerterManager;
import org.metahut.octopus.alerter.common.utils.JSONUtils;

import java.util.Objects;

public class DingTalkAlerterManager implements IAlerterManager {

    @Override
    public String getType() {
        return "DingTalk";
    }

    @Override
    public DingTalkParameter deserializeParameter(String parameter) {
        DingTalkParameter dingTalkParameter =  JSONUtils.parseObject(parameter, DingTalkParameter.class);
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
    public DingTalkAlerter generateInstance(String parameter) {
        return new DingTalkAlerter(deserializeParameter(parameter));
    }

}
