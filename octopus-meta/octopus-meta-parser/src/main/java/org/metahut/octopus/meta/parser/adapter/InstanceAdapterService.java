package org.metahut.octopus.meta.parser.adapter;

import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;
import org.metahut.octopus.meta.parser.exception.AbstractMetaParserException;
import org.metahut.octopus.meta.parser.function.MetaMap;

/**
 * 维护关系
 *      * 自定义的类 的id 要解析出来
 *      Map<String,Instance>
 *  1。添加新关系 （希望页面 两个图，然后节点移交 的形式，将某个instance 指向另一个instance下面的id的上面
 *     move(Long fromId ,Long toId ,String attribute)
 *  2。删除子节点
 *     delete(Long nodeId ,String attribute,Long ... deleteIds)
 *  3。删除跟节点
 *     delete(Long NodeId)
 *  4。分成多个（数组）
 *     split(Long rootId, attribute ，Long ... Id )
 */
public interface InstanceAdapterService {

    //数据
    //pId Map<attribute,value>
    //pId id attribute
    //node
    //api
    //addAttribute(id ,attribute ,value)
    //link(nodeId,NodeId,attribute)

    //语法
    //toJSON()
    //createById()

    //数据结构 + antlr4 or xpath
    //Storage -> toJSONString -antlr4-> Storage
    //Interface +
    // Map.Entry{}
    // Map<String,String>
    // Map<String,

    //default
    //如果用语法描述数据本身  与 antlr4 直接挂钩  然后做解析

    //String -> antlr4 -> class
    //class ->toJSON


    //Store
    //Query
    //  in memory
    //  in db
    //  in graph
    //map()

    //action
    //  delete()

    /**
     *
     * @param env
     * @param abstractStructModel
     * @return
     */
    MetaMap metaMap(String env, AbstractStructModel abstractStructModel);

    void move(Long fromInstanceId,Long toInstanceId,String attribute) throws AbstractMetaParserException;

    void delete(Long instanceId,String attribute,Long... deleteIds) throws AbstractMetaParserException;

    void split(Long rootId,String attribute,Long... Ids);
    /**
     * 伪删除呢 数据状态修改为不可见
     * @param instanceId
     */
    void delete(Long instanceId,boolean all);


}
