// Generated from /Users/xuyang/JavaProject/octopus/octopus-meta/octopus-meta-parser/src/main/java/org/metahut/octopus/meta/parser/antlr4/xpath/XPath31.g4 by ANTLR 4.9.1
package org.metahut.octopus.meta.parser.antlr4.xpath;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPath31Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPath31Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath(XPath31Parser.XpathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(XPath31Parser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(XPath31Parser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#functionbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionbody(XPath31Parser.FunctionbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#enclosedexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedexpr(XPath31Parser.EnclosedexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(XPath31Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#exprsingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprsingle(XPath31Parser.ExprsingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#forexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForexpr(XPath31Parser.ForexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#simpleforclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleforclause(XPath31Parser.SimpleforclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#simpleforbinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleforbinding(XPath31Parser.SimpleforbindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#letexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetexpr(XPath31Parser.LetexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#simpleletclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleletclause(XPath31Parser.SimpleletclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#simpleletbinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleletbinding(XPath31Parser.SimpleletbindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#quantifiedexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedexpr(XPath31Parser.QuantifiedexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#ifexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfexpr(XPath31Parser.IfexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#orexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexpr(XPath31Parser.OrexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#andexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(XPath31Parser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#comparisonexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonexpr(XPath31Parser.ComparisonexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#stringconcatexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringconcatexpr(XPath31Parser.StringconcatexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#rangeexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeexpr(XPath31Parser.RangeexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#additiveexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveexpr(XPath31Parser.AdditiveexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#multiplicativeexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeexpr(XPath31Parser.MultiplicativeexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#unionexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionexpr(XPath31Parser.UnionexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#intersectexceptexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntersectexceptexpr(XPath31Parser.IntersectexceptexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#instanceofexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceofexpr(XPath31Parser.InstanceofexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#treatexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatexpr(XPath31Parser.TreatexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#castableexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastableexpr(XPath31Parser.CastableexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#castexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastexpr(XPath31Parser.CastexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#arrowexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowexpr(XPath31Parser.ArrowexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#unaryexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexpr(XPath31Parser.UnaryexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#valueexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueexpr(XPath31Parser.ValueexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#generalcomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralcomp(XPath31Parser.GeneralcompContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#valuecomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuecomp(XPath31Parser.ValuecompContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#nodecomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodecomp(XPath31Parser.NodecompContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#simplemapexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplemapexpr(XPath31Parser.SimplemapexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#pathexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathexpr(XPath31Parser.PathexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#relativepathexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativepathexpr(XPath31Parser.RelativepathexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#stepexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepexpr(XPath31Parser.StepexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#axisstep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxisstep(XPath31Parser.AxisstepContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#forwardstep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForwardstep(XPath31Parser.ForwardstepContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#forwardaxis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForwardaxis(XPath31Parser.ForwardaxisContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#abbrevforwardstep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbbrevforwardstep(XPath31Parser.AbbrevforwardstepContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#reversestep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReversestep(XPath31Parser.ReversestepContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#reverseaxis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverseaxis(XPath31Parser.ReverseaxisContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#abbrevreversestep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbbrevreversestep(XPath31Parser.AbbrevreversestepContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#nodetest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodetest(XPath31Parser.NodetestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#nametest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNametest(XPath31Parser.NametestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(XPath31Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#postfixexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixexpr(XPath31Parser.PostfixexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#argumentlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentlist(XPath31Parser.ArgumentlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#predicatelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatelist(XPath31Parser.PredicatelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(XPath31Parser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#lookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookup(XPath31Parser.LookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#keyspecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyspecifier(XPath31Parser.KeyspecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#arrowfunctionspecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowfunctionspecifier(XPath31Parser.ArrowfunctionspecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#primaryexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryexpr(XPath31Parser.PrimaryexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(XPath31Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#numericliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericliteral(XPath31Parser.NumericliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#varref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarref(XPath31Parser.VarrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#varname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarname(XPath31Parser.VarnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#parenthesizedexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedexpr(XPath31Parser.ParenthesizedexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#contextitemexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextitemexpr(XPath31Parser.ContextitemexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(XPath31Parser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(XPath31Parser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#argumentplaceholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentplaceholder(XPath31Parser.ArgumentplaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#functionitemexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionitemexpr(XPath31Parser.FunctionitemexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#namedfunctionref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedfunctionref(XPath31Parser.NamedfunctionrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#inlinefunctionexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlinefunctionexpr(XPath31Parser.InlinefunctionexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#mapconstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapconstructor(XPath31Parser.MapconstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#mapconstructorentry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapconstructorentry(XPath31Parser.MapconstructorentryContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#mapkeyexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapkeyexpr(XPath31Parser.MapkeyexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#mapvalueexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapvalueexpr(XPath31Parser.MapvalueexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#arrayconstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayconstructor(XPath31Parser.ArrayconstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#squarearrayconstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquarearrayconstructor(XPath31Parser.SquarearrayconstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#curlyarrayconstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurlyarrayconstructor(XPath31Parser.CurlyarrayconstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#unarylookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnarylookup(XPath31Parser.UnarylookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#singletype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingletype(XPath31Parser.SingletypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#typedeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedeclaration(XPath31Parser.TypedeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#sequencetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequencetype(XPath31Parser.SequencetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#occurrenceindicator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOccurrenceindicator(XPath31Parser.OccurrenceindicatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#itemtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemtype(XPath31Parser.ItemtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#atomicoruniontype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicoruniontype(XPath31Parser.AtomicoruniontypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#kindtest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKindtest(XPath31Parser.KindtestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#anykindtest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnykindtest(XPath31Parser.AnykindtestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#documenttest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumenttest(XPath31Parser.DocumenttestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#texttest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTexttest(XPath31Parser.TexttestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#commenttest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommenttest(XPath31Parser.CommenttestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#namespacenodetest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespacenodetest(XPath31Parser.NamespacenodetestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#pitest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPitest(XPath31Parser.PitestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#attributetest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributetest(XPath31Parser.AttributetestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#attribnameorwildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribnameorwildcard(XPath31Parser.AttribnameorwildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#schemaattributetest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaattributetest(XPath31Parser.SchemaattributetestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#attributedeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributedeclaration(XPath31Parser.AttributedeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#elementtest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementtest(XPath31Parser.ElementtestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#elementnameorwildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementnameorwildcard(XPath31Parser.ElementnameorwildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#schemaelementtest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaelementtest(XPath31Parser.SchemaelementtestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#elementdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementdeclaration(XPath31Parser.ElementdeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#attributename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributename(XPath31Parser.AttributenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#elementname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementname(XPath31Parser.ElementnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#simpletypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpletypename(XPath31Parser.SimpletypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#typename_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename_(XPath31Parser.Typename_Context ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#functiontest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiontest(XPath31Parser.FunctiontestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#anyfunctiontest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyfunctiontest(XPath31Parser.AnyfunctiontestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#typedfunctiontest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedfunctiontest(XPath31Parser.TypedfunctiontestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#maptest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaptest(XPath31Parser.MaptestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#anymaptest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnymaptest(XPath31Parser.AnymaptestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#typedmaptest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedmaptest(XPath31Parser.TypedmaptestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#arraytest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytest(XPath31Parser.ArraytestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#anyarraytest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyarraytest(XPath31Parser.AnyarraytestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#typedarraytest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedarraytest(XPath31Parser.TypedarraytestContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#parenthesizeditemtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizeditemtype(XPath31Parser.ParenthesizeditemtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#eqname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqname(XPath31Parser.EqnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPath31Parser#auxilary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuxilary(XPath31Parser.AuxilaryContext ctx);
}