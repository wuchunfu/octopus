package org.metahut.octopus.alerter.api;

import java.util.Map;

public interface IAlerter {

    AlerterResult send(String title, String content);

    AlerterResult sendByTemplate(String titleTemplate, String contentTemplate, Map<String, String> placeholders);

}
