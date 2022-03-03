package org.metahut.octopus.meta.parser.antlr4.json5;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 */
public class OctopusJson5Listener extends Json5BaseListener{

    @Override
    public void enterJson5(Json5Parser.Json5Context ctx) {
        super.enterJson5(ctx);
    }

    @Override
    public void exitJson5(Json5Parser.Json5Context ctx) {
        super.exitJson5(ctx);
    }

    @Override
    public void enterObj(Json5Parser.ObjContext ctx) {
        super.enterObj(ctx);
    }

    @Override
    public void exitObj(Json5Parser.ObjContext ctx) {
        super.exitObj(ctx);
    }

    @Override
    public void enterPair(Json5Parser.PairContext ctx) {
        super.enterPair(ctx);
    }

    @Override
    public void exitPair(Json5Parser.PairContext ctx) {
        super.exitPair(ctx);
    }

    @Override
    public void enterKey(Json5Parser.KeyContext ctx) {
        super.enterKey(ctx);
    }

    @Override
    public void exitKey(Json5Parser.KeyContext ctx) {
        super.exitKey(ctx);
    }

    @Override
    public void enterValue(Json5Parser.ValueContext ctx) {
        super.enterValue(ctx);
    }

    @Override
    public void exitValue(Json5Parser.ValueContext ctx) {
        super.exitValue(ctx);
    }

    @Override
    public void enterArr(Json5Parser.ArrContext ctx) {
        super.enterArr(ctx);
    }

    @Override
    public void exitArr(Json5Parser.ArrContext ctx) {
        super.exitArr(ctx);
    }

    @Override
    public void enterNumber(Json5Parser.NumberContext ctx) {
        super.enterNumber(ctx);
    }

    @Override
    public void exitNumber(Json5Parser.NumberContext ctx) {
        super.exitNumber(ctx);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }
}
