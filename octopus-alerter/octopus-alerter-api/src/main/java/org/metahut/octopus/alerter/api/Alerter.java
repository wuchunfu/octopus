package org.metahut.octopus.alerter.api;

public interface Alerter {

    AlerterResult send(String title, String content);

}
