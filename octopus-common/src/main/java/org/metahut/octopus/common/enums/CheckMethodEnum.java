package org.metahut.octopus.common.enums;

public enum CheckMethodEnum {

    FIXED_VALUE("与固定值比较"),
    SEVEN_DAY_AVERAGE("7日均值比较波动"),
    FOURTEEN_DAY_AVERAGE("14日均值比较波动"),
    TWENTY_ONE_DAY_AVERAGE("21日均值比较波动"),
    THIRTY_DAY_AVERAGE("30日均值比较波动");

    private final String name;

    CheckMethodEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
