package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.IMetaDataManager;
import org.metahut.octopus.meta.api.MetaDataProperties;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@ConditionalOnProperty(prefix = "octopus.meta", name = "type", havingValue = "starfish")
public class StarfishMetaDataManager implements IMetaDataManager {

    private final StarfishMetaData starfishMetaData;

    public StarfishMetaDataManager(MetaDataProperties properties) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(6L, TimeUnit.SECONDS);
        builder.readTimeout(6L, TimeUnit.SECONDS);
        builder.writeTimeout(6L, TimeUnit.SECONDS);
        ConnectionPool connectionPool = new ConnectionPool(50, 60, TimeUnit.SECONDS);
        builder.connectionPool(connectionPool);
        OkHttpClient client = builder.build();
        this.starfishMetaData = new StarfishMetaData(client, properties.getStarfish());
    }

    @Override
    public StarfishMetaData getMetaData() {
        return starfishMetaData;
    }
}
