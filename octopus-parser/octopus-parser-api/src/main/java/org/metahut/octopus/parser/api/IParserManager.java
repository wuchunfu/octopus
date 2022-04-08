package org.metahut.octopus.parser.api;

public interface IParserManager {

    String getType();

    IParser generateInstance(String parameter);
}
