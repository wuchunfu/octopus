package org.metahut.octopus.alerter.email;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EmailAlerterTest {

    String fromAdress = "yourEmail@163.com";
    String toAddress = "yourEmail@163.com";
    String copyTo = "yourEmail@163.com";
    String userName = "userName";
    String password = "XXXXXXX";

    @Test
    @Disabled
    public void emailAlerterMsg() {
        EmailAlerter emailAlerter = new EmailAlerterManager()
            .generateInstance(
                "{\"mailServerHost\":\"smtp.163.com\",\"nickName\":\"自定义昵称\",\"mailServerPort\":25,\"fromAddress\":\""
                    + fromAdress + "\", \"toAddress\":[\"" + toAddress + "\"],\"copyto\":[\""
                    + copyTo + "\"],\"userName\":\"" + userName + "\",\"password\":\"" + password
                    + "\",\"validate\":false,\"emailMsgType\":\"HTML\"}");
        emailAlerter.send("title", "<h1>this is a email message</h1>");
    }
}
