package org.metahut.octopus.server.meta;

import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.IMetaManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetaPluginHelper {

    private final IMetaManager metaManager;

    public MetaPluginHelper(IMetaManager metaManager) {
        this.metaManager = metaManager;
    }

    @Bean
    public IMeta getMeta() {
        return metaManager.getMeta();
    }

}
