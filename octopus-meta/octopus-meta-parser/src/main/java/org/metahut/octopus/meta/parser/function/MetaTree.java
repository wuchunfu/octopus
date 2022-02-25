package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;

import java.util.List;

/**
 * cateGory 在父容器上不归这个管
 *
 */
public class MetaTree {

    public MetaTree(List<AbstractStructModel> modelNodes) {
        this.modelNodes = modelNodes;
    }

    /**
     * map or list
     */
    private final List<AbstractStructModel> modelNodes;

    /**
     *
     */
    private List<?> instanceNodes;

    /**
     * models dependency relation
     */
    private List<?> modelLinking;

    /**
     * models and instancesRelation
     */
    private List<?> modelInstanceLinking;

    /**
     * instances link
     */
    private List<?> instanceLinking;
    //1。添加新的classType
    //2。Instance 应该是独立的
    //3。modelNodes 只允许一次性构造
    //4。instance转移和再构造
    //5。instance结构 String json？
    //6。查询语言？ atlas 用的GremlinQuery
}
