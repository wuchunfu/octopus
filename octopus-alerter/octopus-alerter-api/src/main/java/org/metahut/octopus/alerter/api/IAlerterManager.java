package org.metahut.octopus.alerter.api;

public interface IAlerterManager {

    String getType();

    AbstractParameter getParameter(String parameter);

    IAlerter generateInstance(String parameter);
}
