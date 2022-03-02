package org.metahut.octopus.meta.parser.domain.model;

import org.metahut.octopus.meta.parser.domain.SymbolConstants;

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
     * name
     */
    private String name;

    /**
     * package path
     */
    private String packagePath;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
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

    public final String getFullClassName() {
        return packagePath + SymbolConstants.PACKAGE_SPLIT + name;
    }
}
