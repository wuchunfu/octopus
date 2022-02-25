package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.enums.TagCategory;

import java.util.List;

/**
 * 元数据模型操作借口
 */
interface MetaModelConsoleService<T> {

    /**
     * init model env
     * @param env envInfo
     * @param jsonModelInfo
     */
    void initModelEnv(String env,T jsonModelInfo);

    /**
     * 更新模型
     * @param env
     * @param root
     * @param jsonModelInfo
     */
    void changeEnvModel(String env,String root,String jsonModelInfo);

    /**
     * search by env and tagName
     * @param env
     * @param tag
     * @return
     */
    List<T> getByTag(String env,String tag);

    /**
     *
     * @param env
     * @param tagCategory
     * @param tag
     * @return
     */
    List<T> getByTag(String env, TagCategory tagCategory,String tag);

    /**
     *
     * @param env
     * @param id
     * @return
     */
    T getById(String env,long id);


    /**
     * 检查版本是否冲突
     * @param model
     * @param versionIds
     * @return
     */
    default boolean checkVersionConflict(T model, List<Long> versionIds) {
        return false;
    }

    /**
     * 校验模型是否 冲突？
     * @param model
     * @param modelNew
     * @throws Exception
     */
    default void valid(Object model,String modelNew) throws Exception {

    }

    /**
     *
     */
    default void asd() {

    }


}
