package org.metahut.octopus.parser.sample.hive.flink;

import org.metahut.octopus.parser.api.ParserResult;

import java.text.MessageFormat;

public class BlockSampleHiveParser extends SampleHiveParser {

    private final BlockSampleHiveParserParameter parameter;

    public BlockSampleHiveParser(SampleHiveParserParameter parameter) {
        this.parameter = (BlockSampleHiveParserParameter) parameter;
    }

    private static final String SQL = "{0} tablesample({1} {2});";

    @Override
    public ParserResult parser() {
        String format = MessageFormat.format(SQL, sqlPrefix, parameter.getNumber(), parameter.getUnit());
        ParserResult parserResult = new ParserResult("flink-sql", format, sampleTableName);
        return parserResult;
    }

}
