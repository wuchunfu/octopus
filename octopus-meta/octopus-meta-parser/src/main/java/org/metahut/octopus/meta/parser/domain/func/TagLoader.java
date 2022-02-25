package org.metahut.octopus.meta.parser.domain.func;

import org.metahut.octopus.meta.parser.domain.model.TagModel;
import org.metahut.octopus.meta.parser.domain.enums.TagLife;

import java.util.Map;

/**
 * @author XuYang
 * Create at 2022/2/19
 * @description
 */
public abstract class TagLoader {

    private Map<TagLife, TagModel> tagModelMap;

    public Map<TagLife, TagModel> getTagModelMap() {
        return tagModelMap;
    }

    public void setTagModelMap(Map<TagLife, TagModel> tagModelMap) {
        this.tagModelMap = tagModelMap;
    }
}
