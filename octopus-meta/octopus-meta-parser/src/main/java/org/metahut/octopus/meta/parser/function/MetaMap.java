package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;

import java.util.List;
import java.util.Map;

/**
 * map
 *  islet -> 岛
 *  route -> seaway 海运航线表示关系
 *  gobble -> 岛吞并岛
 *  mark -> mark islet 标记islet
 *  reef -> 岛礁
 *
 *  use JSON5 parseObject and read
 *   线程安全问题
 *
 * 隐藏在框架下的
 * Model
 *     this#getByName(String) clear
 *     #valid(instances)
 *     serialize(String... instances)
 *
 *  add(String env,String classFullName,String... props) X
 *  init(String env,AbstractStructModel[] models)
 *
 * instance - islet 实例岛屿
 * markingID
 *  概念
 *      islet 岛屿
 *      groupFamily 多组群 head Instance -> MarkingId
 *                       instanceTree
 *      instances center 全部独立instance  Map<String Islet>
 *          rel [nodeId,nodeId]
 *          rel [node,node]
 *          attribute
 *             isArray    add
 *             isNotArray set
 *
 *      groupFamily的全部更新？
 *          如果需要部分更新，先要切割reef
 *          切割的时候tags进行选择保留
 *
 *
 * 解析
 *     只解析node节点
 * 实例 （局部） 需要给hook 提供迭代式使用方式。整体的呢
 * 关系主要是操作属性，那么
 * 关系接口
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
 *  如何？
 *   1。通过id
 *   2。全部？
 *   1和2是不是一个东西？联动的问题
 *      属性拆分和归类
 *      这玩意跟关系有关
 *
 *  序列化和表现形式，
 *  维护粒度 JSON OR XML
 *  JSONPath
 *      add
 *  model
 *
 *  另外  model的rel
 *    与 instance的rel -> 下级衍生上级 （双向扩展）
 *      upload(node,node,attribute)
 *      download(node,node,attribute)
 *    操作关系的目的，是维护属性
 *
 *  instance 是要遵守元数据模型的管理和维护的
 *  model上的tags
 *      1。是否必填
 *      2。是否支持从子节点开始 也就是说
 *          最开始是个全部类的列表 （选择主类型load数据）
 *          那么下面的节点先创建的时候如何基于已有数据构造完整图数据
 *          instance管理 ？
 *              里面是否有标签，标记当前instance实例
 *              ****instance 也有唯一ID 然后进行合并等操作？*** 挂载 以及，关系？
 *              instance 肯定是一组
 *              那么tag？ 模型？
 *              表现模式持有引用，实际上应该tag应该有专属维护机制 是否对当前生效
 *
 *  元数据模型应该是岛还是树？
 *      应该是数据岛
 *
 *  事物问题
 *
 *  是否受制约是可以依据
 * requestId
 *  add
 *  add
 *  add
 *
 * commit
 *  tag on
 */
public class MetaMap {
    /**
     * cateGory 在父容器上不归这个管
     * 如果通过tree进行实例的创建呢 ？
     * 为何要局部和整体
     * model（类名为唯一）
     *     classes -> package+name
     *     attribute -> relation
     *
     *     getByName(String)
     *     valid(instances)
     *     serialize(String... instances)
     *
     *     同一个环境类只允许一个实例（要么进行单独 版本控制要么进行id更新隔离）
     *
     *  add(String env,String classFullName,String... props) X
     *  init(String env,AbstractStructModel[] models)  -> constructor
     */
    public MetaMap(List<AbstractStructModel> modelNodes) {
        this.modelNodes = modelNodes;
    }

    public AbstractStructModel getModelByName(String fullClassName) {
        return null;
    }

    /**
     * instance - islet 实例岛屿
     * markingID
     *  概念
     *      islet 岛屿
     *      groupFamily 多组群 head Instance -> MarkingId
     *                       instanceTree
     *      instances center 全部独立instance  Map<String Instance>
     *          rel [nodeId,nodeId]
     *          rel [node,node]
     *          attribute
     *             isArray    add
     *             isNotArray set
     *
     *      groupFamily的全部更新？
     *          如果需要部分更新，先要切割族群
     *          切割的时候tags进行选择保留
     *
     * @param fullClassName
     * @return
     */
    /**
     * instance - islet 实例岛屿
     * markingID
     *  概念
     *      islet 岛屿
     *      groupFamily 多组群 head Instance -> MarkingId
     *                       instanceTree
     *      instances center 全部独立instance  Map<String Instance>
     *          rel [nodeId,nodeId]
     *          rel [node,node]
     *          attribute
     *             isArray    add
     *             isNotArray set
     *
     *      groupFamily的全部更新？
     *          如果需要部分更新，先要切割族群
     *          切割的时候tags进行选择保留
     */

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

    private static class ModelValidator {

    }

    private static class InstanceValidator {

    }

    private static class EnvironmentLoader {
    }

    private static class ModelSerializer {

        void toDom() {

        }

        void toJSON() {

        }

    }

    //接口一次操作平数据还是 图数据
    //三种存储方式 文件行，database，graph==classInstance == json
    //change dian
    //1。line[{Pid,id}a1,a2,a3,a4]
    //2。node[] 压缩 compus

    /**
     * 实例序列化
     */
    private static class InstanceSerializer {

    }

    /**
     * 元数据管理中心
     */
    private static class MetaConsoleCenter {
    }

    /**
     * TODO 路径搜索语法
     */
    private static class MetaIslet {
        private long markingId;
        private String env;
        private Map<Long,Object> reefMarkingMap;
        private List<Object> instances;

    }
}
