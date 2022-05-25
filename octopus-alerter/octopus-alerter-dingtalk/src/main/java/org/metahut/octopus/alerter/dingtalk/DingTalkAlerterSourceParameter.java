package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AbstractAlerterSourceParameter;

import org.apache.commons.lang3.StringUtils;

public class DingTalkAlerterSourceParameter extends AbstractAlerterSourceParameter {

    private String keyWord;

    private String webhook;

    private String secret;

    @Override
    public boolean checkParameter() {
        if (StringUtils.isBlank(webhook)) {
            return false;
        }
        if (StringUtils.isBlank(secret) && StringUtils.isBlank(keyWord)) {
            return false;
        }
        return true;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
