package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.IMetaManager;
import org.metahut.octopus.meta.api.MetaProperties;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@ConditionalOnProperty(prefix = "octopus.meta", name = "type", havingValue = "starfish")
public class StarfishMetaManager implements IMetaManager {

    private final StarfishMeta starfishMeta;

    public StarfishMetaManager(MetaProperties properties) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(6L, TimeUnit.SECONDS);
        builder.readTimeout(6L, TimeUnit.SECONDS);
        builder.writeTimeout(6L, TimeUnit.SECONDS);
        ConnectionPool connectionPool = new ConnectionPool(50, 60, TimeUnit.SECONDS);
        builder.connectionPool(connectionPool);
        OkHttpClient client = builder.build();
        this.starfishMeta = new StarfishMeta(client, properties.getStarfish());
    }

    @Override
    public StarfishMeta getMeta() {
        return starfishMeta;
    }
}
