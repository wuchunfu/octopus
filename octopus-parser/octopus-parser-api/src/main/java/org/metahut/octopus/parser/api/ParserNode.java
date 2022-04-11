package org.metahut.octopus.parser.api;

import java.util.HashMap;
import java.util.Map;

public class ParserNode {

    private Map<String, ParserNode> nextNodes = new HashMap<>();
    private String type;
    private String category;
    private String params;
    private String srcTable;

    public ParserNode() {
    }

    public ParserNode(String type, String category, String params, String srcTable) {
        this.type = type;
        this.category = category;
        this.params = params;
        this.srcTable = srcTable;
    }

    public static ParserNode.ParserNodeBuilder builder() {
        return new ParserNode.ParserNodeBuilder();
    }

    public static class ParserNodeBuilder {
        private String type;
        private String category;
        private String params;
        private String srcTable;

        public ParserNodeBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ParserNodeBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ParserNodeBuilder params(String params) {
            this.params = params;
            return this;
        }

        public ParserNodeBuilder srcTable(String srcTable) {
            this.srcTable = srcTable;
            return this;
        }

        public ParserNode build() {
            return new ParserNode(type, category, params, srcTable);
        }
    }

    public Map<String, ParserNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(Map<String, ParserNode> nextNodes) {
        this.nextNodes = nextNodes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSrcTable() {
        return srcTable;
    }

    public void setSrcTable(String srcTable) {
        this.srcTable = srcTable;
    }
}
