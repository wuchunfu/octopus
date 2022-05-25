package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AlerterResult;
import org.metahut.octopus.alerter.api.IAlerter;
import org.metahut.octopus.alerter.common.utils.JSONUtils;
import org.metahut.octopus.alerter.common.utils.OkHttpUtils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

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

    private final DingTalkAlerterSourceParameter sourceParameter;
    private final DingTalkAlerterParameter parameter;

    public DingTalkAlerter(DingTalkAlerterSourceParameter sourceParameter, DingTalkAlerterParameter parameter) {
        this.sourceParameter = sourceParameter;
        this.parameter = parameter;
    }

    @Override
    public AlerterResult send(String title, String content) {

        StringBuilder webhook = new StringBuilder(sourceParameter.getWebhook());
        try {
            if (StringUtils.isNotBlank(sourceParameter.getSecret())) {
                long timestamp = Instant.now().toEpochMilli();
                String sign = generateSign(timestamp);
                webhook.append("&timestamp=").append(timestamp).append("&sign=").append(sign);
            }
            OkHttpUtils.post(webhook.toString(), generateContent(title, content));
        } catch (Exception e) {
            return new AlerterResult(true, e.getCause().getMessage());
        }
        return new AlerterResult(true);
    }

    private String generateSign(long timestamp) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String secret = sourceParameter.getSecret();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        return URLEncoder.encode(Base64.getEncoder().encodeToString(signData), "UTF-8");
    }

    private String generateContent(String title, String content) {
        Map<String, Object> reqMap = new HashMap<>();
        Map<String, Object> atMap = new HashMap<>();
        atMap.put("isAtAll", parameter.getAtAll());
        atMap.put("atMobiles", parameter.getMobileList());
        atMap.put("atUserIds", parameter.getUserList());
        reqMap.put("at", atMap);
        reqMap.put("msgtype", parameter.getDingTalkMsgType().getMessage());
        StringBuilder builder = new StringBuilder(content);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(sourceParameter.getKeyWord())) {
            builder.append(sourceParameter.getKeyWord());
        }
        if (DingTalkMsgType.MARKDOWN == parameter.getDingTalkMsgType()) {
            getMarkDownText(title, builder, reqMap);
        } else {
            getTextContent(title, builder, reqMap);
        }
        return JSONUtils.toJSONString(reqMap);
    }

    private void getMarkDownText(String title, StringBuilder builder, Map<String, Object> reqMap) {
        if (CollectionUtils.isNotEmpty(parameter.getMobileList())) {
            parameter.getMobileList().stream().forEach(value -> {
                builder.append("@");
                builder.append(value);
                builder.append(" ");
            }
            );
        }
        if (CollectionUtils.isNotEmpty(parameter.getUserList())) {
            parameter.getUserList().stream().forEach(value -> {
                builder.append("@");
                builder.append(value);
                builder.append(" ");
            }
            );
        }

        byte[] byt = org.apache.commons.codec.binary.StringUtils.getBytesUtf8(builder.toString());
        String txt = org.apache.commons.codec.binary.StringUtils.newStringUtf8(byt);
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("title", title);
        contentMap.put("text", txt);
        reqMap.put("markdown", contentMap);
    }

    private void getTextContent(String title, StringBuilder builder, Map<String, Object> reqMap) {
        byte[] byt = org.apache.commons.codec.binary.StringUtils.getBytesUtf8(builder.toString());
        String txt = org.apache.commons.codec.binary.StringUtils.newStringUtf8(byt);
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("title", title);
        contentMap.put("content", txt);
        reqMap.put("text", contentMap);
    }

}
