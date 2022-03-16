package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AbstractParameter;
import org.metahut.octopus.alerter.enums.EmailMsgType;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class EmailParameter extends AbstractParameter {

    private String mailServerHost;
    private String mailServerPort = "25";
    private String fromAddress;
    private String nickName;
    private List<String> toAddress;
    private String userName;
    private String password;
    private Boolean validate;
    private EmailMsgType emailMsgType;
    private List<String> copyto;

    @Override
    public boolean checkParameter() {
        if (StringUtils.isBlank(mailServerHost)) {
            return false;
        }
        if (StringUtils.isBlank(fromAddress)) {
            return false;
        }
        if (CollectionUtils.isEmpty(toAddress)) {
            return false;
        }
        if (StringUtils.isBlank(userName) && StringUtils.isBlank(password)) {
            return false;
        }
        if (Objects.isNull(emailMsgType)) {
            return false;
        }
        return true;
    }

    public Properties getProp() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.mailServerHost);
        properties.put("mail.smtp.port", this.mailServerPort);
        properties.put("mail.smtp.auth", validate);
        return properties;
    }

    public List<String> getCopyto() {
        return copyto;
    }

    public void setCopyto(List<String> copyto) {
        this.copyto = copyto;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public List<String> getToAddress() {
        return toAddress;
    }

    public void setToAddress(List<String> toAddress) {
        this.toAddress = toAddress;
    }

    public EmailMsgType getEmailMsgType() {
        return emailMsgType;
    }

    public void setEmailMsgType(EmailMsgType emailMsgType) {
        this.emailMsgType = emailMsgType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
