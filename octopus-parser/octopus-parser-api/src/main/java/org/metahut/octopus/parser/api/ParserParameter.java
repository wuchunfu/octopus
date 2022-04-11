package org.metahut.octopus.parser.api;

public class ParserParameter {

    private String type;
    private String category;
    private String params;
    private String source;

    public ParserParameter() {
    }

    public ParserParameter(String type, String category, String params, String source) {
        this.type = type;
        this.category = category;
        this.params = params;
        this.source = source;
    }

    public static ParserParameterBuilder builder() {
        return new ParserParameterBuilder();
    }

    public static class ParserParameterBuilder {
        private String type;
        private String category;
        private String params;
        private String source;

        public ParserParameterBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ParserParameterBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ParserParameterBuilder params(String params) {
            this.params = params;
            return this;
        }

        public ParserParameterBuilder source(String source) {
            this.source = source;
            return this;
        }

        public ParserParameter build() {
            return new ParserParameter(type, category, params, source);
        }
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
