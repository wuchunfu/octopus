package org.metahut.octopus.alerter.api;

public interface IAlerterManager {

    String getType();

    IAlerter generateInstance(String parameter);
}
