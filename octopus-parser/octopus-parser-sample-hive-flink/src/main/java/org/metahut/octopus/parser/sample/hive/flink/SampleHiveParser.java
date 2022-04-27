package org.metahut.octopus.parser.sample.hive.flink;

import org.metahut.octopus.parser.api.IParser;

import java.text.MessageFormat;

public abstract class SampleHiveParser implements IParser {

    protected final String sampleTableName = "octopus_${src_table}";
    protected final String sqlPrefix = MessageFormat.format("create table {0} as select * from ${src_table}", sampleTableName);

}
