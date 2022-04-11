package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.IAlerter;
import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.common.utils.JSONUtils;
import org.metahut.octopus.alerter.common.utils.OkHttpUtils;
import org.metahut.octopus.alerter.enums.DingTalkMsgType;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.collections4.CollectionUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class DingTalkAlerter implements IAlerter {

    private DingTalkParameter dingTalkParameter;

    public DingTalkAlerter(DingTalkParameter dingTalkParameter) {
        this.dingTalkParameter = dingTalkParameter;
    }

    @Override
    public AlerterResult send(String title, String content) {
        try {
            String dingTalkStr = buildDingTalkReqStr(title, content, dingTalkParameter);
            long timestamp = Instant.now().toEpochMilli();
            String sign = getSign(timestamp);
            StringBuilder dingUrl = new StringBuilder(dingTalkParameter.getWebhook());
            dingUrl.append("&timestamp=").append(timestamp).append("&sign=").append(sign);
            OkHttpUtils.post(dingUrl.toString(), dingTalkStr);
        } catch (Exception e) {
            return new AlerterResult(true, e.getCause().getMessage());
        }
        return new AlerterResult(true, content);
    }

    private String getSign(long timestamp)
        throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String secret = dingTalkParameter.getSecret();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder
            .encode(new String(Base64.getEncoder().encodeToString(signData)), "UTF-8");
        return sign;
    }

    private String buildDingTalkReqStr(String title, String content,
        DingTalkParameter dingTalkParameter) {
        Map<String, Object> reqMap = new HashMap<>();
        Map<String, Object> atMap = new HashMap<>();
        atMap.put("isAtAll", dingTalkParameter.getAtAll());
        atMap.put("atMobiles", dingTalkParameter.getMobileList());
        atMap.put("atUserIds", dingTalkParameter.getUserList());
        reqMap.put("at", atMap);
        reqMap.put("msgtype", dingTalkParameter.getDingTalkMsgType().getMessage());
        StringBuilder builder = new StringBuilder(content);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(dingTalkParameter.getKeyWord())) {
            builder.append(dingTalkParameter.getKeyWord());
        }
        if (DingTalkMsgType.MARKDOWN == dingTalkParameter.getDingTalkMsgType()) {
            getMarkDownText(title, builder, dingTalkParameter, reqMap);
        } else {
            getTextContent(title, builder, dingTalkParameter, reqMap);
        }
        return JSONUtils.toJSONString(reqMap);
    }

    private void getMarkDownText(String title, StringBuilder builder,
        DingTalkParameter dingTalkParameter,
        Map<String, Object> reqMap) {
        if (CollectionUtils.isNotEmpty(dingTalkParameter.getMobileList())) {
            dingTalkParameter.getMobileList().stream().forEach(value -> {
                    builder.append("@");
                    builder.append(value);
                    builder.append(" ");
                }
            );
        }
        if (CollectionUtils.isNotEmpty(dingTalkParameter.getUserList())) {
            dingTalkParameter.getUserList().stream().forEach(value -> {
                    builder.append("@");
                    builder.append(value);
                    builder.append(" ");
                }
            );
        }
        byte[] byt = StringUtils.getBytesUtf8(builder.toString());
        String txt = StringUtils.newStringUtf8(byt);
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("title", title);
        contentMap.put("text", txt);
        reqMap.put("markdown", contentMap);
    }

    private void getTextContent(String title, StringBuilder builder,
        DingTalkParameter dingTalkParameter,
        Map<String, Object> reqMap) {
        byte[] byt = StringUtils.getBytesUtf8(builder.toString());
        String txt = StringUtils.newStringUtf8(byt);
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("title", title);
        contentMap.put("content", txt);
        reqMap.put("text", contentMap);
    }
}
