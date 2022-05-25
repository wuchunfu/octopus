package org.metahut.octopus.alerter.email;

import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.api.IAlerter;

import org.apache.commons.collections4.CollectionUtils;
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

    private final EmailAlerterSourceParameter sourceParameter;
    private final EmailAlerterParameter parameter;

    public EmailAlerter(EmailAlerterSourceParameter sourceParameter, EmailAlerterParameter parameter) {
        this.sourceParameter = sourceParameter;
        this.parameter = parameter;
    }

    @Override
    public AlerterResult send(String title, String content) {
        Properties properties = sourceParameter.getProp();
        DefaultAuthenticator authenticator = null;
        if (Objects.nonNull(sourceParameter.getValidate()) && sourceParameter.getValidate()) {
            authenticator = new DefaultAuthenticator(sourceParameter.getUserName(), sourceParameter.getPassword());
        }
        Session sendMailSession = Session.getDefaultInstance(properties, authenticator);
        Message mailMessage = new MimeMessage(sendMailSession);

        try {
            Address from = Objects.nonNull(sourceParameter.getNickName())
                    ? new InternetAddress(sourceParameter.getFromAddress(), MimeUtility.encodeText(sourceParameter.getNickName()))
                    : new InternetAddress(sourceParameter.getFromAddress());
            mailMessage.setFrom(from);

            String toListStr = parameter.getTo().stream().collect(Collectors.joining(","));
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toListStr));

            if (CollectionUtils.isNotEmpty(parameter.getCc())) {
                String ccListStr = parameter.getCc().stream().collect(Collectors.joining(","));
                mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccListStr));
            }

            switch (parameter.getEmailMsgType()) {
                case TEXT:
                    createTextMsg(mailMessage, title, content);
                    break;
                case HTML:
                    createHtmlMsg(mailMessage, title, content);
                    break;
                default:
                    return new AlerterResult(false, "Unexpected value: " + parameter.getEmailMsgType());
            }
            Transport.send(mailMessage);
        } catch (Exception e) {
            return new AlerterResult(false, e.getMessage());
        }

        return new AlerterResult(true);
    }

    public void createTextMsg(Message mailMessage, String title, String content) throws MessagingException {
        mailMessage.setSubject(title);
        mailMessage.setSentDate(new Date());
        String mailContent = content;
        mailMessage.setText(mailContent);

    }

    public void createHtmlMsg(Message mailMessage, String title, String content) throws MessagingException {
        mailMessage.setSubject(title);
        mailMessage.setSentDate(new Date());
        Multipart mainPart = new MimeMultipart();
        BodyPart html = new MimeBodyPart();
        html.setContent(content, "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        mailMessage.setContent(mainPart);

    }
}
