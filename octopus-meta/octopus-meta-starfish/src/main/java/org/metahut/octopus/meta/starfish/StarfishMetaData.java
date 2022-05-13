package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.IMetaData;
import org.metahut.octopus.meta.api.MetaDataProperties;

import okhttp3.OkHttpClient;

public class StarfishMetaData implements IMetaData {

    private final OkHttpClient client;
    private final MetaDataProperties.Starfish starfishProperties;

    public StarfishMetaData(OkHttpClient client, MetaDataProperties.Starfish starfishProperties) {
        this.client = client;
        this.starfishProperties = starfishProperties;
    }
}
