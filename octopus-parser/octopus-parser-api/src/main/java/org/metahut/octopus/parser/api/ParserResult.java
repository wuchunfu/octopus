package org.metahut.octopus.parser.api;

public class ParserResult {

    private String executorType;
    private String executorScript;
    private String srcTable;

    public ParserResult() {
    }

    public ParserResult(String executorType, String executorScript, String srcTable) {
        this.executorType = executorType;
        this.executorScript = executorScript;
        this.srcTable = srcTable;
    }

    public String getExecutorType() {
        return executorType;
    }

    public void setExecutorType(String executorType) {
        this.executorType = executorType;
    }

    public String getExecutorScript() {
        return executorScript;
    }

    public void setExecutorScript(String executorScript) {
        this.executorScript = executorScript;
    }

    public String getSrcTable() {
        return srcTable;
    }

    public void setSrcTable(String srcTable) {
        this.srcTable = srcTable;
    }
}
