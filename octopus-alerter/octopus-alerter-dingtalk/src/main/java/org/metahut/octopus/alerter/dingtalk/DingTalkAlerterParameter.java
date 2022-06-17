package org.metahut.octopus.alerter.dingtalk;

import org.metahut.octopus.alerter.api.AbstractAlerterParameter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;

import java.util.List;
import java.util.Objects;

public class DingTalkAlerterParameter extends AbstractAlerterParameter {

    private Boolean atAll;

    private List<String> mobileList;

    private List<String> userList;

    private MsgTypeEnum msgType;

    @Override
    public boolean checkParameter() {
        if (CollectionUtils.isEmpty(mobileList) && CollectionUtils.isEmpty(userList)) {
            return false;
        }
        return true;
    }

    public Boolean getAtAll() {
        return BooleanUtils.toBoolean(atAll);
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

    public MsgTypeEnum getMsgType() {
        if (Objects.isNull(msgType)) {
            msgType = MsgTypeEnum.TEXT;
        }
        return msgType;
    }

    public void setMsgType(MsgTypeEnum msgType) {
        this.msgType = msgType;
    }
}
