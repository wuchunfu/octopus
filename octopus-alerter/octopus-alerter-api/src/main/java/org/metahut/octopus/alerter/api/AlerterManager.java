package org.metahut.octopus.alerter.api;

public interface AlerterManager {

    String getType();

    Alerter generateInstance(String parameter);
}
