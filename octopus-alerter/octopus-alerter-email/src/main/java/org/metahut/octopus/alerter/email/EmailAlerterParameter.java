package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AbstractAlerterParameter;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class EmailAlerterParameter extends AbstractAlerterParameter {

    private List<String> to;
    private EmailMsgType emailMsgType;
    private List<String> cc;

    @Override
    public boolean checkParameter() {
        if (CollectionUtils.isEmpty(to)) {
            return false;
        }
        return true;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public EmailMsgType getEmailMsgType() {
        return emailMsgType;
    }

    public void setEmailMsgType(EmailMsgType emailMsgType) {
        this.emailMsgType = emailMsgType;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }
}
