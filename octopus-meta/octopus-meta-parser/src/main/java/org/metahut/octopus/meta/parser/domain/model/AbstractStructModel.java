package org.metahut.octopus.meta.parser.domain.model;

import org.metahut.octopus.meta.parser.domain.func.IdGenerator;
import org.metahut.octopus.meta.parser.domain.func.TagLoader;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public abstract class AbstractStructModel extends TagLoader {
    /**
     * Serial Version UID
     */
    private long serialVersionUID = ThreadLocalRandom.current().nextLong();

    /**
     *  TODO
     */
    private IdGenerator idGenerator;

    /**
     * name
     */
    private String name;

    /**
     * package path
     */
    private String packagePath;

    //private boolean isFinal;

    /**
     * 是否为自定义类型，决定是否能增加属性？  这个应该在ClassModel中
     */
    //private boolean isDefType;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
