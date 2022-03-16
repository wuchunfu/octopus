package org.metahut.octopus.alerter.dingtalk;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DingTalkAlerterTest {

    private String webhook = "XXXXXX";

    @Test
    @Disabled
    public void dingTalkMsg() {
        DingTalkAlerter dingTalkAlerter = new DingTalkAlerterManager()
            .generateInstance(
                "{\"atAll\": false,\"keyWord\": \"钉钉机器人：\",\"mobileList\": [15652560819],\"dingTalkMsgType\":\"TEXT\",\"webhook\":\""
                    + webhook
                    + "\",\"secret\":\"SECda602a546504ce693830ff914f41276106f91b65efe412675d8e72d3e96e3c38\"}");
        dingTalkAlerter.send("title", "test");
    }
}
