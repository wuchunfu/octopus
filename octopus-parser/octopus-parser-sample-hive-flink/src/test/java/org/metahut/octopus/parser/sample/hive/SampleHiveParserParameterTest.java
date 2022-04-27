package org.metahut.octopus.parser.sample.hive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.metahut.octopus.parser.sample.hive.flink.BlockSampleHiveParserParameter;
import org.metahut.octopus.parser.sample.hive.flink.JSONUtils;
import org.metahut.octopus.parser.sample.hive.flink.SampleHiveParserParameter;
import org.metahut.octopus.parser.sample.hive.flink.SampleMethodEnum;

public class SampleHiveParserParameterTest {

    @Test
    public void testJsonDeserialize() {
        BlockSampleHiveParserParameter blockSampleHiveParserParameter = new BlockSampleHiveParserParameter();
        blockSampleHiveParserParameter.setMethod(SampleMethodEnum.BLOCK);
        blockSampleHiveParserParameter.setNumber(10);
        String blockSampleJson = JSONUtils.toJSONString(blockSampleHiveParserParameter);

        SampleHiveParserParameter sampleHiveParserParameter = JSONUtils.parseObject(blockSampleJson, SampleHiveParserParameter.class);

        BlockSampleHiveParserParameter targetBlockSampleHiveParserParameter = (BlockSampleHiveParserParameter) sampleHiveParserParameter;

        Assertions.assertEquals(10, targetBlockSampleHiveParserParameter.getNumber());
    }
}
