package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AbstractAlerterSourceParameter;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Properties;

public class EmailAlerterSourceParameter extends AbstractAlerterSourceParameter {

    private String mailServerHost;
    private String mailServerPort = "25";
    private String fromAddress;
    private String nickName;
    private String userName;
    private String password;
    private Boolean validate;

    public Properties getProp() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.mailServerHost);
        properties.put("mail.smtp.port", this.mailServerPort);
        properties.put("mail.smtp.auth", validate);
        return properties;
    }

    @Override
    public boolean checkParameter() {
        if (StringUtils.isBlank(mailServerHost)) {
            return false;
        }
        if (StringUtils.isBlank(fromAddress)) {
            return false;
        }

        if (Objects.nonNull(validate) && validate && StringUtils.isBlank(userName) && StringUtils.isBlank(password)) {
            return false;
        }
        return true;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }
}
