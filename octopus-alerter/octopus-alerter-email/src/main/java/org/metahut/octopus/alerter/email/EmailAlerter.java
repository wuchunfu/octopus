package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AlerterException;
import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.api.IAlerter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

public class EmailAlerter implements IAlerter {

    private EmailParameter emailParameter;

    public EmailAlerter(EmailParameter emailParameter) {
        this.emailParameter = emailParameter;
    }

    @Override
    public AlerterResult send(String title, String content) {
        if (StringUtils.isBlank(content)) {
            throw new AlerterException(
                "please input email messages!");
        }
        Properties properties = emailParameter.getProp();
        DefaultAuthenticator authenticator = null;
        if (Objects.nonNull(emailParameter.isValidate()) && emailParameter.isValidate()) {
            authenticator = new DefaultAuthenticator(emailParameter.getUserName(),
                emailParameter.getPassword());
        }
        Session sendMailSession = Session.getDefaultInstance(properties, authenticator);
        Message mailMessage = new MimeMessage(sendMailSession);
        try {
            Address from = null;
            if (Objects.nonNull(emailParameter.getNickName())) {
                String nick = MimeUtility.encodeText(emailParameter.getNickName());
                from = new InternetAddress(emailParameter.getFromAddress(), nick);
            } else {
                from = new InternetAddress(emailParameter.getFromAddress());
            }
            mailMessage.setFrom(from);
            if (CollectionUtils.isNotEmpty(emailParameter.getToAddress())) {
                String toListStr = emailParameter.getToAddress().stream()
                    .collect(Collectors.joining(","));
                mailMessage
                    .setRecipients(Message.RecipientType.TO, InternetAddress.parse(toListStr));
            }
            if (CollectionUtils.isNotEmpty(emailParameter.getCopyto())) {
                String ccListStr = emailParameter.getCopyto().stream()
                    .collect(Collectors.joining(","));
                mailMessage
                    .setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccListStr));
            }
        } catch (Exception e) {
            return new AlerterResult(false, e.getMessage());
        }
        switch (emailParameter.getEmailMsgType()) {
            case TEXT:
                createTextMsg(mailMessage, title, content);
                break;
            case HTML:
                createHtmlMsg(mailMessage, title, content);
                break;
            default:
                throw new AlerterException(
                    "Unexpected value: " + emailParameter.getEmailMsgType().getCode());
        }
        try {
            Transport.send(mailMessage);
        } catch (MessagingException e) {
            throw new AlerterException(e.getMessage(), e);
        }
        return new AlerterResult(true, mailMessage.toString());
    }

    public void createTextMsg(Message mailMessage, String title, String content) {
        try {
            mailMessage.setSubject(title);
            mailMessage.setSentDate(new Date());
            String mailContent = content;
            mailMessage.setText(mailContent);
        } catch (MessagingException e) {
            throw new AlerterException(e.getMessage(), e);
        }
    }

    public void createHtmlMsg(Message mailMessage, String title, String content) {
        try {
            mailMessage.setSubject(title);
            mailMessage.setSentDate(new Date());
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(content, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);
        } catch (MessagingException e) {
            throw new AlerterException(e.getMessage(), e);
        }
    }
}
