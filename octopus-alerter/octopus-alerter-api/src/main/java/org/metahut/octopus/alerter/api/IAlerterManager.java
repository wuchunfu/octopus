package org.metahut.octopus.alerter.api;

public interface IAlerterManager {

    String getType();

    AbstractParameter deserializeParameter(String parameter);

    IAlerter generateInstance(String parameter);
}
