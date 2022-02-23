package org.metahut.octopus.quality.parser;

public class HiveQualityTest {

    public void test() {
        // use hive catalog

        String sql = "CREATE CATALOG myhive WITH (\n" +
                "    'type' = 'hive',\n" +
                "    'default-database' = 'mydatabase',\n" +
                "    'hive-conf-dir' = '/opt/hive-conf'\n" +
                ");\n" +
                "-- set the HiveCatalog as the current catalog of the session\n" +
                "USE CATALOG myhive;";

        String sql1 = "select * from table_name where col=xxx distribute by rand() sort by rand() limit num; ";

        String sql2 = "select count(1) from table_name; ";


    }
}
