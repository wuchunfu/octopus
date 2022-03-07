package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AlerterManager;
import org.metahut.octopus.alerter.common.utils.JSONUtils;

public class DingTalkAlerterManager implements AlerterManager {

    @Override
    public String getType() {
        return "DingTalk";
    }

    @Override
    public DingTalkAlerter generateInstance(String parameter) {

        DingTalkParameter dingTalkParameter = JSONUtils.parseObject(parameter, DingTalkParameter.class);
        boolean checkParameter = dingTalkParameter.checkParameter();
        if (!checkParameter) {

        }
        return new DingTalkAlerter();
    }

}
