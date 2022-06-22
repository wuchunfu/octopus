package org.metahut.octopus.server.converter;

import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.stereotype.Component;

@Component
public class CodeCommonConverter {

    public Long generateCode(Long code) {
        return code == null ? SnowflakeIdGenerator.getInstance().nextId() : code;
    }
}
