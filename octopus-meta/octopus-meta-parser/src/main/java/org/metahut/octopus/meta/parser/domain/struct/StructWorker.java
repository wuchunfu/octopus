package org.metahut.octopus.meta.parser.domain.struct;

import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class StructWorker {

    /**
     * 类做了绝大部分的事情，保证运行 （编译本身是因为janino来做的，运行交给classLoader）
     * 那么需要的只有 EnvironmentRouter，reload （ 内部需要简单的方法保持
     * 1。环境隔离
     * 2。运行类
     * 3。注销类实例
     * 4。
     * final
     * AbstractStructModels
     * classes
     * long id
     * id rel id (两种做法 1. 根据名字寻找类， 2.根据
     * 类的生效 是 一次性 还是需要 局部更新 类的卸载 提供当前环境的变量管理器更新的时候前面加入一个新的info
     * TODO transaction
     */
    private String javaResource;
    private String fullClassName;

    private AbstractStructModel model;

    private Set<String> relClassNames = new HashSet<>();

    public void storageNode() {

    }

    /**
     * no node !!!
     *  NODE TO WHAT
     * @param node
     */
    public void relTransform(Object node) {

    }

    public void do1 () {

    }

    public String getJavaResource() {
        return javaResource;
    }

    public void setJavaResource(String javaResource) {
        this.javaResource = javaResource;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public Set<String> getRelClassNames() {
        return relClassNames;
    }

    public void setRelClassNames(Set<String> relClassNames) {
        this.relClassNames = relClassNames;
    }
}
