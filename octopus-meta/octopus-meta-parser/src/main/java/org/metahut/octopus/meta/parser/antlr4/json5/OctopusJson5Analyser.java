package org.metahut.octopus.meta.parser.antlr4.json5;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author XuYang
 * Create at 2022/3/3
 * @description
 */
public class OctopusJson5Analyser {

    public void visitor(String json) {
        CharStream input = CharStreams.fromString(json);
        Json5Lexer lexer = new Json5Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Json5Parser parser = new Json5Parser(tokens);
        Json5Parser.Json5Context tree = parser.json5();
        OctopusJson5Visitor tv = new OctopusJson5Visitor();
        Object object = tv.visit(tree);
        System.out.println(object);
    }


}
