package org.metahut.octopus.rule.api;

public enum ComparisonMethodEnum {

    GT(">"),
    LT("<"),
    GTE(">="),
    LTE("<="),
    NE("<>"),
    EQ("="),
    OUTSIDE_THE_INTERVAL("><");

    private String symbol;

    ComparisonMethodEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
