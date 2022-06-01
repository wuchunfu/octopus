package org.metahut.octopus.meta.starfish.bean;

import java.io.Serializable;
import java.util.Map;

/**
 *
 */
public abstract class TagLoader implements Serializable {

    private Map<TagLife, TagModel> tagModelMap;

    public Map<TagLife, TagModel> getTagModelMap() {
        return tagModelMap;
    }

    public void setTagModelMap(Map<TagLife, TagModel> tagModelMap) {
        this.tagModelMap = tagModelMap;
    }
}
