package org.metahut.octopus.jobs.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class FlowData {
    private Long id;
    private Long code;
    private JSONObject meta;
    private List alerterInstances;
    private JSONArray ruleInstances;
    private JSONObject sampleInstance;
    private String env;
    private String crontab;
    private String schedulerCode;
    private String createTime;
    private String updateTime;

    public FlowData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public JSONObject getMeta() {
        return meta;
    }

    public void setMeta(JSONObject meta) {
        this.meta = meta;
    }

    public List getAlerterInstances() {
        return alerterInstances;
    }

    public void setAlerterInstances(List alerterInstances) {
        this.alerterInstances = alerterInstances;
    }

    public JSONArray getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(JSONArray ruleInstances) {
        this.ruleInstances = ruleInstances;
    }

    public JSONObject getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(JSONObject sampleInstance) {
        this.sampleInstance = sampleInstance;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getSchedulerCode() {
        return schedulerCode;
    }

    public void setSchedulerCode(String schedulerCode) {
        this.schedulerCode = schedulerCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
