// Generated from /Users/xuyang/JavaProject/octopus/octopus-meta/octopus-meta-parser/src/main/java/org/metahut/octopus/meta/parser/antlr4/json5/Json5.g4 by ANTLR 4.9.1
package org.metahut.octopus.meta.parser.antlr4.json5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Json5Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Json5Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Json5Parser#json5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson5(Json5Parser.Json5Context ctx);
	/**
	 * Visit a parse tree produced by {@link Json5Parser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(Json5Parser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link Json5Parser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(Json5Parser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link Json5Parser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(Json5Parser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Json5Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(Json5Parser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Json5Parser#arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(Json5Parser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by {@link Json5Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(Json5Parser.NumberContext ctx);
}