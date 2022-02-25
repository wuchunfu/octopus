package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;

import java.util.List;

/**
 * cateGory 在父容器上不归这个管
 * 如果通过tree进行实例的创建呢 ？
 * 为何要局部和整体
 * model 整体？
 *  Object[] AbstractStructModels
 *  类名为唯一
 *  例：
 *  提供语法?
 *  var id = getId()
 *  add(id,prop,prop,prop)
 *
 * 实例 （局部） 需要给hook 提供迭代式使用方式。整体的呢
 * requestId
 *  add
 *  add
 *  add
 *
 * commit
 *  tag on
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
