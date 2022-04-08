package org.metahut.octopus.parser.sample.hive;

import java.util.Objects;

public class BlockSampleHiveParserParameter extends SampleHiveParserParameter {

    private Integer number;

    private BlockSampleUnit unit;

    @Override
    public void setDefaultValue() {
        unit = Objects.isNull(unit) ? BlockSampleUnit.percent : unit;
    }

    @Override
    public boolean checkParameter() {
        return Objects.nonNull(number);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BlockSampleUnit getUnit() {
        return unit;
    }

    public void setUnit(BlockSampleUnit unit) {
        this.unit = unit;
    }
}
