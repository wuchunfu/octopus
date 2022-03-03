package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AlerterManager;

public class DingTalkAlerterManager implements AlerterManager {

    @Override
    public String getType() {
        return "DingTalk";
    }

    @Override
    public DingTalkAlerter generateInstance(String parameter) {

        return new DingTalkAlerter();
    }

}
