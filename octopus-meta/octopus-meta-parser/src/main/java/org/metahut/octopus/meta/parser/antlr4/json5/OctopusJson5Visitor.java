package org.metahut.octopus.meta.parser.antlr4.json5;

import org.antlr.v4.runtime.misc.Interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class OctopusJson5Visitor extends Json5BaseVisitor {


    @Override
    public Object visitJson5(Json5Parser.Json5Context ctx) {
        return super.visitJson5(ctx);
    }

    @Override
    public Object visitObj(Json5Parser.ObjContext ctx) {
        return super.visitObj(ctx);
    }

    @Override
    public Object visitPair(Json5Parser.PairContext ctx) {
        Object key = ctx.key().getText();
        Object value = super.visitValue(ctx.value());
        System.out.println("key:" + key + " value:" +value);
        return super.visitPair(ctx);
    }

    @Override
    public Object visitKey(Json5Parser.KeyContext ctx) {
        return super.visitKey(ctx);
    }

    @Override
    public Object visitValue(Json5Parser.ValueContext ctx) {
        return super.visitValue(ctx);
    }

    @Override
    public Object visitArr(Json5Parser.ArrContext ctx) {
        List<Object> list = new ArrayList<>();
        if (ctx != null && ctx.value() != null) {
            Iterator<Json5Parser.ValueContext> it = ctx.value().iterator();
            while(it.hasNext()) {
                Json5Parser.ValueContext next = it.next();
                list.add(super.visitValue(next));
            }
        }
        return list;
    }

    @Override
    public Object visitNumber(Json5Parser.NumberContext ctx) {
        return ctx.NUMBER().toString();
    }



}
