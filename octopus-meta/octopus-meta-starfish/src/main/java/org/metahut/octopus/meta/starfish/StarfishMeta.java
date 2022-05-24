package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.MetaProperties;

import okhttp3.OkHttpClient;

public class StarfishMeta implements IMeta {

    private final OkHttpClient client;
    private final MetaProperties.Starfish starfishProperties;

    public StarfishMeta(OkHttpClient client, MetaProperties.Starfish starfishProperties) {
        this.client = client;
        this.starfishProperties = starfishProperties;
    }
}
