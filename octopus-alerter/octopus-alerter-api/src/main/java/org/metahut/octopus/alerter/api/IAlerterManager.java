package org.metahut.octopus.alerter.api;

public interface IAlerterManager {

    String getType();

    AbstractAlerterParameter deserializeParameter(String parameter);

    AbstractAlerterSourceParameter deserializeSourceParameter(String parameter);

    IAlerter generateInstance(String sourceParameter, String parameter);

}
