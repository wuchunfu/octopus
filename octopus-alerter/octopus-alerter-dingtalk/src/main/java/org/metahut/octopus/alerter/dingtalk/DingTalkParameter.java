package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AbstractParameter;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class DingTalkParameter extends AbstractParameter {

    private Boolean atAll;

    private List<String> mobileList;

    private List<String> userList;

    private String keyWord;

    //webhook
    private String webhook;

    //sign
    private String secret;

    private DingTalkMsgType dingTalkMsgType;

    @Override
    public boolean checkParameter() {
        if (StringUtils.isBlank(webhook)) {
            return false;
        }
        if (StringUtils.isBlank(secret)) {
            return false;
        }
        return true;
    }

    public Boolean getAtAll() {
        return atAll;
    }

    public void setAtAll(Boolean atAll) {
        this.atAll = atAll;
    }

    public List<String> getMobileList() {
        return mobileList;
    }

    public void setMobileList(List<String> mobileList) {
        this.mobileList = mobileList;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
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

    public DingTalkMsgType getDingTalkMsgType() {
        return dingTalkMsgType;
    }

    public void setDingTalkMsgType(DingTalkMsgType dingTalkMsgType) {
        this.dingTalkMsgType = dingTalkMsgType;
    }
}
