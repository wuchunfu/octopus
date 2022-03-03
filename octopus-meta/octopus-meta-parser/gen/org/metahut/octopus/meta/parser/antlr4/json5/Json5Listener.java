// Generated from /Users/xuyang/JavaProject/octopus/octopus-meta/octopus-meta-parser/src/main/java/org/metahut/octopus/meta/parser/antlr4/json5/Json5.g4 by ANTLR 4.9.1
package org.metahut.octopus.meta.parser.antlr4.json5;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Json5Parser}.
 */
public interface Json5Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Json5Parser#json5}.
	 * @param ctx the parse tree
	 */
	void enterJson5(Json5Parser.Json5Context ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#json5}.
	 * @param ctx the parse tree
	 */
	void exitJson5(Json5Parser.Json5Context ctx);
	/**
	 * Enter a parse tree produced by {@link Json5Parser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(Json5Parser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(Json5Parser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link Json5Parser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(Json5Parser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(Json5Parser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Json5Parser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(Json5Parser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(Json5Parser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Json5Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(Json5Parser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(Json5Parser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Json5Parser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(Json5Parser.ArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(Json5Parser.ArrContext ctx);
	/**
	 * Enter a parse tree produced by {@link Json5Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(Json5Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link Json5Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(Json5Parser.NumberContext ctx);
}