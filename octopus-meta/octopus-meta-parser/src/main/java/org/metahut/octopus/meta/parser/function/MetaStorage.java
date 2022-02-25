package org.metahut.octopus.meta.parser.function;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 *
 */
public final class MetaStorage {

    private final Map<String,MetaTree> envMetaTreeMap = new ConcurrentHashMap<>();

    public Set<String> getEnvCategories() {
        return envMetaTreeMap.keySet();
    }

    public Collection<MetaTree> getTrees() {
        return envMetaTreeMap.values();
    }

    /**
     * 创建或者更新
     * @param env
     * @param tree
     */
    final void put(String env,MetaTree tree) {
        this.envMetaTreeMap.put(env,tree);
    }

    final void remove(String env) {
        this.envMetaTreeMap.remove(env);
    }

    final List<Long> search(String env,String path) {
        LinkedHashSet<String> linkedHashSet =
                Arrays
                    .stream(path.replaceAll(" ", "")
                    .split("."))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

        return null;
    }

    final List<Long> search(String path) {

        return null;
    }

}
