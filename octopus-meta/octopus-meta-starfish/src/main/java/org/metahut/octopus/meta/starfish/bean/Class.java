package org.metahut.octopus.meta.starfish.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class Class extends TagLoader implements Serializable {

    /**
     * Serial Version UID
     */
    private long serialVersionUID = ThreadLocalRandom.current().nextLong();

    /**
     * name attribute rel to
     */
    private String nameAttributeRel;

    /**
     * name
     */
    private String name;

    /**
     * package path
     */
    private String packagePath;

    /**
     * attribute model list
     */
    private List<Attribute> attributes;

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

    public final String fullClassName() {
        if (packagePath == null || packagePath.length() == 0) {
            return name;
        }
        return packagePath + SymbolConstants.PACKAGE_SPLIT + name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getNameAttributeRel() {
        return nameAttributeRel;
    }

    public void setNameAttributeRel(String nameAttributeRel) {
        this.nameAttributeRel = nameAttributeRel;
    }

    public Attribute findAttributeByName(String name) {
        Optional<Attribute> attributeOptional = attributes.stream().filter(attribute -> name.equals(attribute.getName())).findFirst();
        if (attributeOptional.isPresent()) {
            return attributeOptional.get();
        } else {
            return null;
        }
    }
}
