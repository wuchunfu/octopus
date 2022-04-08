package org.metahut.octopus.alerter.api;

public interface IAlerter {

    AlerterResult send(String title, String content);

}
