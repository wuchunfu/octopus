package org.metahut.octopus.meta.parser.domain.compile;


import org.metahut.octopus.meta.parser.domain.compile.support.TagModel;

import java.util.List;

/**
 * @author Moouna
 * Create at 2022/2/18
 * @description
 */
public class ClassModel extends AbstractStructModel{

    /**
     * attribute model list
     */
    private List<AttributeModel> attributeModels;

    public List<AttributeModel> getAttributeModels() {
        return attributeModels;
    }

}
