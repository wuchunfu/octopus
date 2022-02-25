package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.SymbolConstants;
import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 必须单例 how
 * 解决多环境的问题？
 */
abstract class EnvironmentUnit {

    /**
     * 需要绑定
     */
    private final Map<String,AtomicLong> versionHolder = new ConcurrentHashMap<>();

    /**
     * 环境工作用的 这个类
     * 1。包括class
     * 2。包括rel 等信息
     * 3。
     */
    private final Map<String,?> storage = new ConcurrentHashMap<>();

    /**
     * 环境装载 (包含更新和卸载 )
     */
    public abstract void load(String env, List<AbstractStructModel> structModels);

    /**
     *
     * @param env
     * @return
     */
    public abstract List<AbstractStructModel> search(String env);

    /**
     * 卸载环境
     * @param env
     */
    public abstract void unload(String env);

    public final synchronized String rewrite(String env) {
        AtomicLong variableContainer = versionHolder.get(env);
        if (variableContainer == null) {
            variableContainer = new AtomicLong();
            versionHolder.put(env,variableContainer);
        }
        return env + SymbolConstants.PACKAGE_SPLIT + SymbolConstants.PREFIX + variableContainer.incrementAndGet();
    }
}
