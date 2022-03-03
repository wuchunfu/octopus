// Generated from /Users/xuyang/JavaProject/octopus/octopus-meta/octopus-meta-parser/src/main/java/org/metahut/octopus/meta/parser/antlr4/xpath/XPath31.g4 by ANTLR 4.9.1
package org.metahut.octopus.meta.parser.antlr4.xpath;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPath31Parser}.
 */
public interface XPath31Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#xpath}.
	 * @param ctx the parse tree
	 */
	void enterXpath(XPath31Parser.XpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#xpath}.
	 * @param ctx the parse tree
	 */
	void exitXpath(XPath31Parser.XpathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#paramlist}.
	 * @param ctx the parse tree
	 */
	void enterParamlist(XPath31Parser.ParamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#paramlist}.
	 * @param ctx the parse tree
	 */
	void exitParamlist(XPath31Parser.ParamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(XPath31Parser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(XPath31Parser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#functionbody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionbody(XPath31Parser.FunctionbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#functionbody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionbody(XPath31Parser.FunctionbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#enclosedexpr}.
	 * @param ctx the parse tree
	 */
	void enterEnclosedexpr(XPath31Parser.EnclosedexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#enclosedexpr}.
	 * @param ctx the parse tree
	 */
	void exitEnclosedexpr(XPath31Parser.EnclosedexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(XPath31Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(XPath31Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#exprsingle}.
	 * @param ctx the parse tree
	 */
	void enterExprsingle(XPath31Parser.ExprsingleContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#exprsingle}.
	 * @param ctx the parse tree
	 */
	void exitExprsingle(XPath31Parser.ExprsingleContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#forexpr}.
	 * @param ctx the parse tree
	 */
	void enterForexpr(XPath31Parser.ForexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#forexpr}.
	 * @param ctx the parse tree
	 */
	void exitForexpr(XPath31Parser.ForexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#simpleforclause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleforclause(XPath31Parser.SimpleforclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#simpleforclause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleforclause(XPath31Parser.SimpleforclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#simpleforbinding}.
	 * @param ctx the parse tree
	 */
	void enterSimpleforbinding(XPath31Parser.SimpleforbindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#simpleforbinding}.
	 * @param ctx the parse tree
	 */
	void exitSimpleforbinding(XPath31Parser.SimpleforbindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#letexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetexpr(XPath31Parser.LetexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#letexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetexpr(XPath31Parser.LetexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#simpleletclause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleletclause(XPath31Parser.SimpleletclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#simpleletclause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleletclause(XPath31Parser.SimpleletclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#simpleletbinding}.
	 * @param ctx the parse tree
	 */
	void enterSimpleletbinding(XPath31Parser.SimpleletbindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#simpleletbinding}.
	 * @param ctx the parse tree
	 */
	void exitSimpleletbinding(XPath31Parser.SimpleletbindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#quantifiedexpr}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedexpr(XPath31Parser.QuantifiedexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#quantifiedexpr}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedexpr(XPath31Parser.QuantifiedexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void enterIfexpr(XPath31Parser.IfexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void exitIfexpr(XPath31Parser.IfexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#orexpr}.
	 * @param ctx the parse tree
	 */
	void enterOrexpr(XPath31Parser.OrexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#orexpr}.
	 * @param ctx the parse tree
	 */
	void exitOrexpr(XPath31Parser.OrexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#andexpr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(XPath31Parser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#andexpr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(XPath31Parser.AndexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#comparisonexpr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonexpr(XPath31Parser.ComparisonexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#comparisonexpr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonexpr(XPath31Parser.ComparisonexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#stringconcatexpr}.
	 * @param ctx the parse tree
	 */
	void enterStringconcatexpr(XPath31Parser.StringconcatexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#stringconcatexpr}.
	 * @param ctx the parse tree
	 */
	void exitStringconcatexpr(XPath31Parser.StringconcatexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#rangeexpr}.
	 * @param ctx the parse tree
	 */
	void enterRangeexpr(XPath31Parser.RangeexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#rangeexpr}.
	 * @param ctx the parse tree
	 */
	void exitRangeexpr(XPath31Parser.RangeexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#additiveexpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveexpr(XPath31Parser.AdditiveexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#additiveexpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveexpr(XPath31Parser.AdditiveexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#multiplicativeexpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeexpr(XPath31Parser.MultiplicativeexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#multiplicativeexpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeexpr(XPath31Parser.MultiplicativeexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#unionexpr}.
	 * @param ctx the parse tree
	 */
	void enterUnionexpr(XPath31Parser.UnionexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#unionexpr}.
	 * @param ctx the parse tree
	 */
	void exitUnionexpr(XPath31Parser.UnionexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#intersectexceptexpr}.
	 * @param ctx the parse tree
	 */
	void enterIntersectexceptexpr(XPath31Parser.IntersectexceptexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#intersectexceptexpr}.
	 * @param ctx the parse tree
	 */
	void exitIntersectexceptexpr(XPath31Parser.IntersectexceptexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#instanceofexpr}.
	 * @param ctx the parse tree
	 */
	void enterInstanceofexpr(XPath31Parser.InstanceofexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#instanceofexpr}.
	 * @param ctx the parse tree
	 */
	void exitInstanceofexpr(XPath31Parser.InstanceofexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#treatexpr}.
	 * @param ctx the parse tree
	 */
	void enterTreatexpr(XPath31Parser.TreatexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#treatexpr}.
	 * @param ctx the parse tree
	 */
	void exitTreatexpr(XPath31Parser.TreatexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#castableexpr}.
	 * @param ctx the parse tree
	 */
	void enterCastableexpr(XPath31Parser.CastableexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#castableexpr}.
	 * @param ctx the parse tree
	 */
	void exitCastableexpr(XPath31Parser.CastableexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#castexpr}.
	 * @param ctx the parse tree
	 */
	void enterCastexpr(XPath31Parser.CastexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#castexpr}.
	 * @param ctx the parse tree
	 */
	void exitCastexpr(XPath31Parser.CastexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#arrowexpr}.
	 * @param ctx the parse tree
	 */
	void enterArrowexpr(XPath31Parser.ArrowexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#arrowexpr}.
	 * @param ctx the parse tree
	 */
	void exitArrowexpr(XPath31Parser.ArrowexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#unaryexpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryexpr(XPath31Parser.UnaryexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#unaryexpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryexpr(XPath31Parser.UnaryexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#valueexpr}.
	 * @param ctx the parse tree
	 */
	void enterValueexpr(XPath31Parser.ValueexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#valueexpr}.
	 * @param ctx the parse tree
	 */
	void exitValueexpr(XPath31Parser.ValueexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#generalcomp}.
	 * @param ctx the parse tree
	 */
	void enterGeneralcomp(XPath31Parser.GeneralcompContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#generalcomp}.
	 * @param ctx the parse tree
	 */
	void exitGeneralcomp(XPath31Parser.GeneralcompContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#valuecomp}.
	 * @param ctx the parse tree
	 */
	void enterValuecomp(XPath31Parser.ValuecompContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#valuecomp}.
	 * @param ctx the parse tree
	 */
	void exitValuecomp(XPath31Parser.ValuecompContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#nodecomp}.
	 * @param ctx the parse tree
	 */
	void enterNodecomp(XPath31Parser.NodecompContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#nodecomp}.
	 * @param ctx the parse tree
	 */
	void exitNodecomp(XPath31Parser.NodecompContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#simplemapexpr}.
	 * @param ctx the parse tree
	 */
	void enterSimplemapexpr(XPath31Parser.SimplemapexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#simplemapexpr}.
	 * @param ctx the parse tree
	 */
	void exitSimplemapexpr(XPath31Parser.SimplemapexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#pathexpr}.
	 * @param ctx the parse tree
	 */
	void enterPathexpr(XPath31Parser.PathexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#pathexpr}.
	 * @param ctx the parse tree
	 */
	void exitPathexpr(XPath31Parser.PathexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#relativepathexpr}.
	 * @param ctx the parse tree
	 */
	void enterRelativepathexpr(XPath31Parser.RelativepathexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#relativepathexpr}.
	 * @param ctx the parse tree
	 */
	void exitRelativepathexpr(XPath31Parser.RelativepathexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#stepexpr}.
	 * @param ctx the parse tree
	 */
	void enterStepexpr(XPath31Parser.StepexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#stepexpr}.
	 * @param ctx the parse tree
	 */
	void exitStepexpr(XPath31Parser.StepexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#axisstep}.
	 * @param ctx the parse tree
	 */
	void enterAxisstep(XPath31Parser.AxisstepContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#axisstep}.
	 * @param ctx the parse tree
	 */
	void exitAxisstep(XPath31Parser.AxisstepContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#forwardstep}.
	 * @param ctx the parse tree
	 */
	void enterForwardstep(XPath31Parser.ForwardstepContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#forwardstep}.
	 * @param ctx the parse tree
	 */
	void exitForwardstep(XPath31Parser.ForwardstepContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#forwardaxis}.
	 * @param ctx the parse tree
	 */
	void enterForwardaxis(XPath31Parser.ForwardaxisContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#forwardaxis}.
	 * @param ctx the parse tree
	 */
	void exitForwardaxis(XPath31Parser.ForwardaxisContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#abbrevforwardstep}.
	 * @param ctx the parse tree
	 */
	void enterAbbrevforwardstep(XPath31Parser.AbbrevforwardstepContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#abbrevforwardstep}.
	 * @param ctx the parse tree
	 */
	void exitAbbrevforwardstep(XPath31Parser.AbbrevforwardstepContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#reversestep}.
	 * @param ctx the parse tree
	 */
	void enterReversestep(XPath31Parser.ReversestepContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#reversestep}.
	 * @param ctx the parse tree
	 */
	void exitReversestep(XPath31Parser.ReversestepContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#reverseaxis}.
	 * @param ctx the parse tree
	 */
	void enterReverseaxis(XPath31Parser.ReverseaxisContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#reverseaxis}.
	 * @param ctx the parse tree
	 */
	void exitReverseaxis(XPath31Parser.ReverseaxisContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#abbrevreversestep}.
	 * @param ctx the parse tree
	 */
	void enterAbbrevreversestep(XPath31Parser.AbbrevreversestepContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#abbrevreversestep}.
	 * @param ctx the parse tree
	 */
	void exitAbbrevreversestep(XPath31Parser.AbbrevreversestepContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#nodetest}.
	 * @param ctx the parse tree
	 */
	void enterNodetest(XPath31Parser.NodetestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#nodetest}.
	 * @param ctx the parse tree
	 */
	void exitNodetest(XPath31Parser.NodetestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#nametest}.
	 * @param ctx the parse tree
	 */
	void enterNametest(XPath31Parser.NametestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#nametest}.
	 * @param ctx the parse tree
	 */
	void exitNametest(XPath31Parser.NametestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(XPath31Parser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(XPath31Parser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#postfixexpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixexpr(XPath31Parser.PostfixexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#postfixexpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixexpr(XPath31Parser.PostfixexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#argumentlist}.
	 * @param ctx the parse tree
	 */
	void enterArgumentlist(XPath31Parser.ArgumentlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#argumentlist}.
	 * @param ctx the parse tree
	 */
	void exitArgumentlist(XPath31Parser.ArgumentlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#predicatelist}.
	 * @param ctx the parse tree
	 */
	void enterPredicatelist(XPath31Parser.PredicatelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#predicatelist}.
	 * @param ctx the parse tree
	 */
	void exitPredicatelist(XPath31Parser.PredicatelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(XPath31Parser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(XPath31Parser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#lookup}.
	 * @param ctx the parse tree
	 */
	void enterLookup(XPath31Parser.LookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#lookup}.
	 * @param ctx the parse tree
	 */
	void exitLookup(XPath31Parser.LookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#keyspecifier}.
	 * @param ctx the parse tree
	 */
	void enterKeyspecifier(XPath31Parser.KeyspecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#keyspecifier}.
	 * @param ctx the parse tree
	 */
	void exitKeyspecifier(XPath31Parser.KeyspecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#arrowfunctionspecifier}.
	 * @param ctx the parse tree
	 */
	void enterArrowfunctionspecifier(XPath31Parser.ArrowfunctionspecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#arrowfunctionspecifier}.
	 * @param ctx the parse tree
	 */
	void exitArrowfunctionspecifier(XPath31Parser.ArrowfunctionspecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#primaryexpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryexpr(XPath31Parser.PrimaryexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#primaryexpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryexpr(XPath31Parser.PrimaryexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(XPath31Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(XPath31Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#numericliteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericliteral(XPath31Parser.NumericliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#numericliteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericliteral(XPath31Parser.NumericliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#varref}.
	 * @param ctx the parse tree
	 */
	void enterVarref(XPath31Parser.VarrefContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#varref}.
	 * @param ctx the parse tree
	 */
	void exitVarref(XPath31Parser.VarrefContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#varname}.
	 * @param ctx the parse tree
	 */
	void enterVarname(XPath31Parser.VarnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#varname}.
	 * @param ctx the parse tree
	 */
	void exitVarname(XPath31Parser.VarnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#parenthesizedexpr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedexpr(XPath31Parser.ParenthesizedexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#parenthesizedexpr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedexpr(XPath31Parser.ParenthesizedexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#contextitemexpr}.
	 * @param ctx the parse tree
	 */
	void enterContextitemexpr(XPath31Parser.ContextitemexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#contextitemexpr}.
	 * @param ctx the parse tree
	 */
	void exitContextitemexpr(XPath31Parser.ContextitemexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(XPath31Parser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(XPath31Parser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(XPath31Parser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(XPath31Parser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#argumentplaceholder}.
	 * @param ctx the parse tree
	 */
	void enterArgumentplaceholder(XPath31Parser.ArgumentplaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#argumentplaceholder}.
	 * @param ctx the parse tree
	 */
	void exitArgumentplaceholder(XPath31Parser.ArgumentplaceholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#functionitemexpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionitemexpr(XPath31Parser.FunctionitemexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#functionitemexpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionitemexpr(XPath31Parser.FunctionitemexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#namedfunctionref}.
	 * @param ctx the parse tree
	 */
	void enterNamedfunctionref(XPath31Parser.NamedfunctionrefContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#namedfunctionref}.
	 * @param ctx the parse tree
	 */
	void exitNamedfunctionref(XPath31Parser.NamedfunctionrefContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#inlinefunctionexpr}.
	 * @param ctx the parse tree
	 */
	void enterInlinefunctionexpr(XPath31Parser.InlinefunctionexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#inlinefunctionexpr}.
	 * @param ctx the parse tree
	 */
	void exitInlinefunctionexpr(XPath31Parser.InlinefunctionexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#mapconstructor}.
	 * @param ctx the parse tree
	 */
	void enterMapconstructor(XPath31Parser.MapconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#mapconstructor}.
	 * @param ctx the parse tree
	 */
	void exitMapconstructor(XPath31Parser.MapconstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#mapconstructorentry}.
	 * @param ctx the parse tree
	 */
	void enterMapconstructorentry(XPath31Parser.MapconstructorentryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#mapconstructorentry}.
	 * @param ctx the parse tree
	 */
	void exitMapconstructorentry(XPath31Parser.MapconstructorentryContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#mapkeyexpr}.
	 * @param ctx the parse tree
	 */
	void enterMapkeyexpr(XPath31Parser.MapkeyexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#mapkeyexpr}.
	 * @param ctx the parse tree
	 */
	void exitMapkeyexpr(XPath31Parser.MapkeyexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#mapvalueexpr}.
	 * @param ctx the parse tree
	 */
	void enterMapvalueexpr(XPath31Parser.MapvalueexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#mapvalueexpr}.
	 * @param ctx the parse tree
	 */
	void exitMapvalueexpr(XPath31Parser.MapvalueexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#arrayconstructor}.
	 * @param ctx the parse tree
	 */
	void enterArrayconstructor(XPath31Parser.ArrayconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#arrayconstructor}.
	 * @param ctx the parse tree
	 */
	void exitArrayconstructor(XPath31Parser.ArrayconstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#squarearrayconstructor}.
	 * @param ctx the parse tree
	 */
	void enterSquarearrayconstructor(XPath31Parser.SquarearrayconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#squarearrayconstructor}.
	 * @param ctx the parse tree
	 */
	void exitSquarearrayconstructor(XPath31Parser.SquarearrayconstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#curlyarrayconstructor}.
	 * @param ctx the parse tree
	 */
	void enterCurlyarrayconstructor(XPath31Parser.CurlyarrayconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#curlyarrayconstructor}.
	 * @param ctx the parse tree
	 */
	void exitCurlyarrayconstructor(XPath31Parser.CurlyarrayconstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#unarylookup}.
	 * @param ctx the parse tree
	 */
	void enterUnarylookup(XPath31Parser.UnarylookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#unarylookup}.
	 * @param ctx the parse tree
	 */
	void exitUnarylookup(XPath31Parser.UnarylookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#singletype}.
	 * @param ctx the parse tree
	 */
	void enterSingletype(XPath31Parser.SingletypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#singletype}.
	 * @param ctx the parse tree
	 */
	void exitSingletype(XPath31Parser.SingletypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#typedeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypedeclaration(XPath31Parser.TypedeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#typedeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypedeclaration(XPath31Parser.TypedeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#sequencetype}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype(XPath31Parser.SequencetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#sequencetype}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype(XPath31Parser.SequencetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#occurrenceindicator}.
	 * @param ctx the parse tree
	 */
	void enterOccurrenceindicator(XPath31Parser.OccurrenceindicatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#occurrenceindicator}.
	 * @param ctx the parse tree
	 */
	void exitOccurrenceindicator(XPath31Parser.OccurrenceindicatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#itemtype}.
	 * @param ctx the parse tree
	 */
	void enterItemtype(XPath31Parser.ItemtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#itemtype}.
	 * @param ctx the parse tree
	 */
	void exitItemtype(XPath31Parser.ItemtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#atomicoruniontype}.
	 * @param ctx the parse tree
	 */
	void enterAtomicoruniontype(XPath31Parser.AtomicoruniontypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#atomicoruniontype}.
	 * @param ctx the parse tree
	 */
	void exitAtomicoruniontype(XPath31Parser.AtomicoruniontypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#kindtest}.
	 * @param ctx the parse tree
	 */
	void enterKindtest(XPath31Parser.KindtestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#kindtest}.
	 * @param ctx the parse tree
	 */
	void exitKindtest(XPath31Parser.KindtestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#anykindtest}.
	 * @param ctx the parse tree
	 */
	void enterAnykindtest(XPath31Parser.AnykindtestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#anykindtest}.
	 * @param ctx the parse tree
	 */
	void exitAnykindtest(XPath31Parser.AnykindtestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#documenttest}.
	 * @param ctx the parse tree
	 */
	void enterDocumenttest(XPath31Parser.DocumenttestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#documenttest}.
	 * @param ctx the parse tree
	 */
	void exitDocumenttest(XPath31Parser.DocumenttestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#texttest}.
	 * @param ctx the parse tree
	 */
	void enterTexttest(XPath31Parser.TexttestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#texttest}.
	 * @param ctx the parse tree
	 */
	void exitTexttest(XPath31Parser.TexttestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#commenttest}.
	 * @param ctx the parse tree
	 */
	void enterCommenttest(XPath31Parser.CommenttestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#commenttest}.
	 * @param ctx the parse tree
	 */
	void exitCommenttest(XPath31Parser.CommenttestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#namespacenodetest}.
	 * @param ctx the parse tree
	 */
	void enterNamespacenodetest(XPath31Parser.NamespacenodetestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#namespacenodetest}.
	 * @param ctx the parse tree
	 */
	void exitNamespacenodetest(XPath31Parser.NamespacenodetestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#pitest}.
	 * @param ctx the parse tree
	 */
	void enterPitest(XPath31Parser.PitestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#pitest}.
	 * @param ctx the parse tree
	 */
	void exitPitest(XPath31Parser.PitestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#attributetest}.
	 * @param ctx the parse tree
	 */
	void enterAttributetest(XPath31Parser.AttributetestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#attributetest}.
	 * @param ctx the parse tree
	 */
	void exitAttributetest(XPath31Parser.AttributetestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#attribnameorwildcard}.
	 * @param ctx the parse tree
	 */
	void enterAttribnameorwildcard(XPath31Parser.AttribnameorwildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#attribnameorwildcard}.
	 * @param ctx the parse tree
	 */
	void exitAttribnameorwildcard(XPath31Parser.AttribnameorwildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#schemaattributetest}.
	 * @param ctx the parse tree
	 */
	void enterSchemaattributetest(XPath31Parser.SchemaattributetestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#schemaattributetest}.
	 * @param ctx the parse tree
	 */
	void exitSchemaattributetest(XPath31Parser.SchemaattributetestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#attributedeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAttributedeclaration(XPath31Parser.AttributedeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#attributedeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAttributedeclaration(XPath31Parser.AttributedeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#elementtest}.
	 * @param ctx the parse tree
	 */
	void enterElementtest(XPath31Parser.ElementtestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#elementtest}.
	 * @param ctx the parse tree
	 */
	void exitElementtest(XPath31Parser.ElementtestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#elementnameorwildcard}.
	 * @param ctx the parse tree
	 */
	void enterElementnameorwildcard(XPath31Parser.ElementnameorwildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#elementnameorwildcard}.
	 * @param ctx the parse tree
	 */
	void exitElementnameorwildcard(XPath31Parser.ElementnameorwildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#schemaelementtest}.
	 * @param ctx the parse tree
	 */
	void enterSchemaelementtest(XPath31Parser.SchemaelementtestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#schemaelementtest}.
	 * @param ctx the parse tree
	 */
	void exitSchemaelementtest(XPath31Parser.SchemaelementtestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#elementdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterElementdeclaration(XPath31Parser.ElementdeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#elementdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitElementdeclaration(XPath31Parser.ElementdeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#attributename}.
	 * @param ctx the parse tree
	 */
	void enterAttributename(XPath31Parser.AttributenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#attributename}.
	 * @param ctx the parse tree
	 */
	void exitAttributename(XPath31Parser.AttributenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#elementname}.
	 * @param ctx the parse tree
	 */
	void enterElementname(XPath31Parser.ElementnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#elementname}.
	 * @param ctx the parse tree
	 */
	void exitElementname(XPath31Parser.ElementnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#simpletypename}.
	 * @param ctx the parse tree
	 */
	void enterSimpletypename(XPath31Parser.SimpletypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#simpletypename}.
	 * @param ctx the parse tree
	 */
	void exitSimpletypename(XPath31Parser.SimpletypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#typename_}.
	 * @param ctx the parse tree
	 */
	void enterTypename_(XPath31Parser.Typename_Context ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#typename_}.
	 * @param ctx the parse tree
	 */
	void exitTypename_(XPath31Parser.Typename_Context ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#functiontest}.
	 * @param ctx the parse tree
	 */
	void enterFunctiontest(XPath31Parser.FunctiontestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#functiontest}.
	 * @param ctx the parse tree
	 */
	void exitFunctiontest(XPath31Parser.FunctiontestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#anyfunctiontest}.
	 * @param ctx the parse tree
	 */
	void enterAnyfunctiontest(XPath31Parser.AnyfunctiontestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#anyfunctiontest}.
	 * @param ctx the parse tree
	 */
	void exitAnyfunctiontest(XPath31Parser.AnyfunctiontestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#typedfunctiontest}.
	 * @param ctx the parse tree
	 */
	void enterTypedfunctiontest(XPath31Parser.TypedfunctiontestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#typedfunctiontest}.
	 * @param ctx the parse tree
	 */
	void exitTypedfunctiontest(XPath31Parser.TypedfunctiontestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#maptest}.
	 * @param ctx the parse tree
	 */
	void enterMaptest(XPath31Parser.MaptestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#maptest}.
	 * @param ctx the parse tree
	 */
	void exitMaptest(XPath31Parser.MaptestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#anymaptest}.
	 * @param ctx the parse tree
	 */
	void enterAnymaptest(XPath31Parser.AnymaptestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#anymaptest}.
	 * @param ctx the parse tree
	 */
	void exitAnymaptest(XPath31Parser.AnymaptestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#typedmaptest}.
	 * @param ctx the parse tree
	 */
	void enterTypedmaptest(XPath31Parser.TypedmaptestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#typedmaptest}.
	 * @param ctx the parse tree
	 */
	void exitTypedmaptest(XPath31Parser.TypedmaptestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#arraytest}.
	 * @param ctx the parse tree
	 */
	void enterArraytest(XPath31Parser.ArraytestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#arraytest}.
	 * @param ctx the parse tree
	 */
	void exitArraytest(XPath31Parser.ArraytestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#anyarraytest}.
	 * @param ctx the parse tree
	 */
	void enterAnyarraytest(XPath31Parser.AnyarraytestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#anyarraytest}.
	 * @param ctx the parse tree
	 */
	void exitAnyarraytest(XPath31Parser.AnyarraytestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#typedarraytest}.
	 * @param ctx the parse tree
	 */
	void enterTypedarraytest(XPath31Parser.TypedarraytestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#typedarraytest}.
	 * @param ctx the parse tree
	 */
	void exitTypedarraytest(XPath31Parser.TypedarraytestContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#parenthesizeditemtype}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizeditemtype(XPath31Parser.ParenthesizeditemtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#parenthesizeditemtype}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizeditemtype(XPath31Parser.ParenthesizeditemtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#eqname}.
	 * @param ctx the parse tree
	 */
	void enterEqname(XPath31Parser.EqnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#eqname}.
	 * @param ctx the parse tree
	 */
	void exitEqname(XPath31Parser.EqnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPath31Parser#auxilary}.
	 * @param ctx the parse tree
	 */
	void enterAuxilary(XPath31Parser.AuxilaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPath31Parser#auxilary}.
	 * @param ctx the parse tree
	 */
	void exitAuxilary(XPath31Parser.AuxilaryContext ctx);
}