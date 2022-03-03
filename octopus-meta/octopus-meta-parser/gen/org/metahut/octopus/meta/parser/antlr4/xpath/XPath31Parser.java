// Generated from /Users/xuyang/JavaProject/octopus/octopus-meta/octopus-meta-parser/src/main/java/org/metahut/octopus/meta/parser/antlr4/xpath/XPath31.g4 by ANTLR 4.9.1
package org.metahut.octopus.meta.parser.antlr4.xpath;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPath31Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AT=1, BANG=2, CB=3, CC=4, CEQ=5, COLON=6, COLONCOLON=7, COMMA=8, CP=9, 
		CS=10, D=11, DD=12, DOLLAR=13, EG=14, EQ=15, GE=16, GG=17, GT=18, LE=19, 
		LL=20, LT=21, MINUS=22, NE=23, OB=24, OC=25, OP=26, P=27, PLUS=28, POUND=29, 
		PP=30, QM=31, SC=32, SLASH=33, SS=34, STAR=35, KW_ANCESTOR=36, KW_ANCESTOR_OR_SELF=37, 
		KW_AND=38, KW_ARRAY=39, KW_AS=40, KW_ATTRIBUTE=41, KW_CAST=42, KW_CASTABLE=43, 
		KW_CHILD=44, KW_COMMENT=45, KW_DESCENDANT=46, KW_DESCENDANT_OR_SELF=47, 
		KW_DIV=48, KW_DOCUMENT_NODE=49, KW_ELEMENT=50, KW_ELSE=51, KW_EMPTY_SEQUENCE=52, 
		KW_EQ=53, KW_EVERY=54, KW_EXCEPT=55, KW_FOLLOWING=56, KW_FOLLOWING_SIBLING=57, 
		KW_FOR=58, KW_FUNCTION=59, KW_GE=60, KW_GT=61, KW_IDIV=62, KW_IF=63, KW_IN=64, 
		KW_INSTANCE=65, KW_INTERSECT=66, KW_IS=67, KW_ITEM=68, KW_LE=69, KW_LET=70, 
		KW_LT=71, KW_MAP=72, KW_MOD=73, KW_NAMESPACE=74, KW_NAMESPACE_NODE=75, 
		KW_NE=76, KW_NODE=77, KW_OF=78, KW_OR=79, KW_PARENT=80, KW_PRECEDING=81, 
		KW_PRECEDING_SIBLING=82, KW_PROCESSING_INSTRUCTION=83, KW_RETURN=84, KW_SATISFIES=85, 
		KW_SCHEMA_ATTRIBUTE=86, KW_SCHEMA_ELEMENT=87, KW_SELF=88, KW_SOME=89, 
		KW_TEXT=90, KW_THEN=91, KW_TO=92, KW_TREAT=93, KW_UNION=94, IntegerLiteral=95, 
		DecimalLiteral=96, DoubleLiteral=97, StringLiteral=98, URIQualifiedName=99, 
		BracedURILiteral=100, Comment=101, QName=102, NCName=103, Whitespace=104, 
		SEMI=105;
	public static final int
		RULE_xpath = 0, RULE_paramlist = 1, RULE_param = 2, RULE_functionbody = 3, 
		RULE_enclosedexpr = 4, RULE_expr = 5, RULE_exprsingle = 6, RULE_forexpr = 7, 
		RULE_simpleforclause = 8, RULE_simpleforbinding = 9, RULE_letexpr = 10, 
		RULE_simpleletclause = 11, RULE_simpleletbinding = 12, RULE_quantifiedexpr = 13, 
		RULE_ifexpr = 14, RULE_orexpr = 15, RULE_andexpr = 16, RULE_comparisonexpr = 17, 
		RULE_stringconcatexpr = 18, RULE_rangeexpr = 19, RULE_additiveexpr = 20, 
		RULE_multiplicativeexpr = 21, RULE_unionexpr = 22, RULE_intersectexceptexpr = 23, 
		RULE_instanceofexpr = 24, RULE_treatexpr = 25, RULE_castableexpr = 26, 
		RULE_castexpr = 27, RULE_arrowexpr = 28, RULE_unaryexpr = 29, RULE_valueexpr = 30, 
		RULE_generalcomp = 31, RULE_valuecomp = 32, RULE_nodecomp = 33, RULE_simplemapexpr = 34, 
		RULE_pathexpr = 35, RULE_relativepathexpr = 36, RULE_stepexpr = 37, RULE_axisstep = 38, 
		RULE_forwardstep = 39, RULE_forwardaxis = 40, RULE_abbrevforwardstep = 41, 
		RULE_reversestep = 42, RULE_reverseaxis = 43, RULE_abbrevreversestep = 44, 
		RULE_nodetest = 45, RULE_nametest = 46, RULE_wildcard = 47, RULE_postfixexpr = 48, 
		RULE_argumentlist = 49, RULE_predicatelist = 50, RULE_predicate = 51, 
		RULE_lookup = 52, RULE_keyspecifier = 53, RULE_arrowfunctionspecifier = 54, 
		RULE_primaryexpr = 55, RULE_literal = 56, RULE_numericliteral = 57, RULE_varref = 58, 
		RULE_varname = 59, RULE_parenthesizedexpr = 60, RULE_contextitemexpr = 61, 
		RULE_functioncall = 62, RULE_argument = 63, RULE_argumentplaceholder = 64, 
		RULE_functionitemexpr = 65, RULE_namedfunctionref = 66, RULE_inlinefunctionexpr = 67, 
		RULE_mapconstructor = 68, RULE_mapconstructorentry = 69, RULE_mapkeyexpr = 70, 
		RULE_mapvalueexpr = 71, RULE_arrayconstructor = 72, RULE_squarearrayconstructor = 73, 
		RULE_curlyarrayconstructor = 74, RULE_unarylookup = 75, RULE_singletype = 76, 
		RULE_typedeclaration = 77, RULE_sequencetype = 78, RULE_occurrenceindicator = 79, 
		RULE_itemtype = 80, RULE_atomicoruniontype = 81, RULE_kindtest = 82, RULE_anykindtest = 83, 
		RULE_documenttest = 84, RULE_texttest = 85, RULE_commenttest = 86, RULE_namespacenodetest = 87, 
		RULE_pitest = 88, RULE_attributetest = 89, RULE_attribnameorwildcard = 90, 
		RULE_schemaattributetest = 91, RULE_attributedeclaration = 92, RULE_elementtest = 93, 
		RULE_elementnameorwildcard = 94, RULE_schemaelementtest = 95, RULE_elementdeclaration = 96, 
		RULE_attributename = 97, RULE_elementname = 98, RULE_simpletypename = 99, 
		RULE_typename_ = 100, RULE_functiontest = 101, RULE_anyfunctiontest = 102, 
		RULE_typedfunctiontest = 103, RULE_maptest = 104, RULE_anymaptest = 105, 
		RULE_typedmaptest = 106, RULE_arraytest = 107, RULE_anyarraytest = 108, 
		RULE_typedarraytest = 109, RULE_parenthesizeditemtype = 110, RULE_eqname = 111, 
		RULE_auxilary = 112;
	private static String[] makeRuleNames() {
		return new String[] {
			"xpath", "paramlist", "param", "functionbody", "enclosedexpr", "expr", 
			"exprsingle", "forexpr", "simpleforclause", "simpleforbinding", "letexpr", 
			"simpleletclause", "simpleletbinding", "quantifiedexpr", "ifexpr", "orexpr", 
			"andexpr", "comparisonexpr", "stringconcatexpr", "rangeexpr", "additiveexpr", 
			"multiplicativeexpr", "unionexpr", "intersectexceptexpr", "instanceofexpr", 
			"treatexpr", "castableexpr", "castexpr", "arrowexpr", "unaryexpr", "valueexpr", 
			"generalcomp", "valuecomp", "nodecomp", "simplemapexpr", "pathexpr", 
			"relativepathexpr", "stepexpr", "axisstep", "forwardstep", "forwardaxis", 
			"abbrevforwardstep", "reversestep", "reverseaxis", "abbrevreversestep", 
			"nodetest", "nametest", "wildcard", "postfixexpr", "argumentlist", "predicatelist", 
			"predicate", "lookup", "keyspecifier", "arrowfunctionspecifier", "primaryexpr", 
			"literal", "numericliteral", "varref", "varname", "parenthesizedexpr", 
			"contextitemexpr", "functioncall", "argument", "argumentplaceholder", 
			"functionitemexpr", "namedfunctionref", "inlinefunctionexpr", "mapconstructor", 
			"mapconstructorentry", "mapkeyexpr", "mapvalueexpr", "arrayconstructor", 
			"squarearrayconstructor", "curlyarrayconstructor", "unarylookup", "singletype", 
			"typedeclaration", "sequencetype", "occurrenceindicator", "itemtype", 
			"atomicoruniontype", "kindtest", "anykindtest", "documenttest", "texttest", 
			"commenttest", "namespacenodetest", "pitest", "attributetest", "attribnameorwildcard", 
			"schemaattributetest", "attributedeclaration", "elementtest", "elementnameorwildcard", 
			"schemaelementtest", "elementdeclaration", "attributename", "elementname", 
			"simpletypename", "typename_", "functiontest", "anyfunctiontest", "typedfunctiontest", 
			"maptest", "anymaptest", "typedmaptest", "arraytest", "anyarraytest", 
			"typedarraytest", "parenthesizeditemtype", "eqname", "auxilary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'!'", "']'", "'}'", "':='", "':'", "'::'", "','", "')'", 
			"':*'", "'.'", "'..'", "'$'", "'=>'", "'='", "'>='", "'>>'", "'>'", "'<='", 
			"'<<'", "'<'", "'-'", "'!='", "'['", "'{'", "'('", "'|'", "'+'", "'#'", 
			"'||'", "'?'", "'*:'", "'/'", "'//'", "'*'", "'ancestor'", "'ancestor-or-self'", 
			"'and'", "'array'", "'as'", "'attribute'", "'cast'", "'castable'", "'child'", 
			"'comment'", "'descendant'", "'descendant-or-self'", "'div'", "'document-node'", 
			"'element'", "'else'", "'empty-sequence'", "'eq'", "'every'", "'except'", 
			"'following'", "'following-sibling'", "'for'", "'function'", "'ge'", 
			"'gt'", "'idiv'", "'if'", "'in'", "'instance'", "'intersect'", "'is'", 
			"'item'", "'le'", "'let'", "'lt'", "'map'", "'mod'", "'namespace'", "'namespace-node'", 
			"'ne'", "'node'", "'of'", "'or'", "'parent'", "'preceding'", "'preceding-sibling'", 
			"'processing-instruction'", "'return'", "'satisfies'", "'schema-attribute'", 
			"'schema-element'", "'self'", "'some'", "'text'", "'then'", "'to'", "'treat'", 
			"'union'", null, null, null, null, null, null, null, null, null, null, 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AT", "BANG", "CB", "CC", "CEQ", "COLON", "COLONCOLON", "COMMA", 
			"CP", "CS", "D", "DD", "DOLLAR", "EG", "EQ", "GE", "GG", "GT", "LE", 
			"LL", "LT", "MINUS", "NE", "OB", "OC", "OP", "P", "PLUS", "POUND", "PP", 
			"QM", "SC", "SLASH", "SS", "STAR", "KW_ANCESTOR", "KW_ANCESTOR_OR_SELF", 
			"KW_AND", "KW_ARRAY", "KW_AS", "KW_ATTRIBUTE", "KW_CAST", "KW_CASTABLE", 
			"KW_CHILD", "KW_COMMENT", "KW_DESCENDANT", "KW_DESCENDANT_OR_SELF", "KW_DIV", 
			"KW_DOCUMENT_NODE", "KW_ELEMENT", "KW_ELSE", "KW_EMPTY_SEQUENCE", "KW_EQ", 
			"KW_EVERY", "KW_EXCEPT", "KW_FOLLOWING", "KW_FOLLOWING_SIBLING", "KW_FOR", 
			"KW_FUNCTION", "KW_GE", "KW_GT", "KW_IDIV", "KW_IF", "KW_IN", "KW_INSTANCE", 
			"KW_INTERSECT", "KW_IS", "KW_ITEM", "KW_LE", "KW_LET", "KW_LT", "KW_MAP", 
			"KW_MOD", "KW_NAMESPACE", "KW_NAMESPACE_NODE", "KW_NE", "KW_NODE", "KW_OF", 
			"KW_OR", "KW_PARENT", "KW_PRECEDING", "KW_PRECEDING_SIBLING", "KW_PROCESSING_INSTRUCTION", 
			"KW_RETURN", "KW_SATISFIES", "KW_SCHEMA_ATTRIBUTE", "KW_SCHEMA_ELEMENT", 
			"KW_SELF", "KW_SOME", "KW_TEXT", "KW_THEN", "KW_TO", "KW_TREAT", "KW_UNION", 
			"IntegerLiteral", "DecimalLiteral", "DoubleLiteral", "StringLiteral", 
			"URIQualifiedName", "BracedURILiteral", "Comment", "QName", "NCName", 
			"Whitespace", "SEMI"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XPath31.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPath31Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class XpathContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(XPath31Parser.EOF, 0); }
		public XpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterXpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitXpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitXpath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XpathContext xpath() throws RecognitionException {
		XpathContext _localctx = new XpathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xpath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			expr();
			setState(227);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamlistContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public ParamlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterParamlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitParamlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitParamlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamlistContext paramlist() throws RecognitionException {
		ParamlistContext _localctx = new ParamlistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_paramlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			param();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(230);
				match(COMMA);
				setState(231);
				param();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(XPath31Parser.DOLLAR, 0); }
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public TypedeclarationContext typedeclaration() {
			return getRuleContext(TypedeclarationContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(DOLLAR);
			setState(238);
			eqname();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_AS) {
				{
				setState(239);
				typedeclaration();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionbodyContext extends ParserRuleContext {
		public EnclosedexprContext enclosedexpr() {
			return getRuleContext(EnclosedexprContext.class,0);
		}
		public FunctionbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterFunctionbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitFunctionbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitFunctionbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionbodyContext functionbody() throws RecognitionException {
		FunctionbodyContext _localctx = new FunctionbodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionbody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			enclosedexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnclosedexprContext extends ParserRuleContext {
		public TerminalNode OC() { return getToken(XPath31Parser.OC, 0); }
		public TerminalNode CC() { return getToken(XPath31Parser.CC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EnclosedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosedexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterEnclosedexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitEnclosedexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitEnclosedexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnclosedexprContext enclosedexpr() throws RecognitionException {
		EnclosedexprContext _localctx = new EnclosedexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_enclosedexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(OC);
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(245);
				expr();
				}
				break;
			}
			setState(248);
			match(CC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprsingleContext> exprsingle() {
			return getRuleContexts(ExprsingleContext.class);
		}
		public ExprsingleContext exprsingle(int i) {
			return getRuleContext(ExprsingleContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			exprsingle();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(251);
				match(COMMA);
				setState(252);
				exprsingle();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprsingleContext extends ParserRuleContext {
		public ForexprContext forexpr() {
			return getRuleContext(ForexprContext.class,0);
		}
		public LetexprContext letexpr() {
			return getRuleContext(LetexprContext.class,0);
		}
		public QuantifiedexprContext quantifiedexpr() {
			return getRuleContext(QuantifiedexprContext.class,0);
		}
		public IfexprContext ifexpr() {
			return getRuleContext(IfexprContext.class,0);
		}
		public OrexprContext orexpr() {
			return getRuleContext(OrexprContext.class,0);
		}
		public ExprsingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprsingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterExprsingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitExprsingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitExprsingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprsingleContext exprsingle() throws RecognitionException {
		ExprsingleContext _localctx = new ExprsingleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exprsingle);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				forexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				letexpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				quantifiedexpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
				ifexpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(262);
				orexpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForexprContext extends ParserRuleContext {
		public SimpleforclauseContext simpleforclause() {
			return getRuleContext(SimpleforclauseContext.class,0);
		}
		public TerminalNode KW_RETURN() { return getToken(XPath31Parser.KW_RETURN, 0); }
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public ForexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterForexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitForexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitForexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForexprContext forexpr() throws RecognitionException {
		ForexprContext _localctx = new ForexprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			simpleforclause();
			setState(266);
			match(KW_RETURN);
			setState(267);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleforclauseContext extends ParserRuleContext {
		public TerminalNode KW_FOR() { return getToken(XPath31Parser.KW_FOR, 0); }
		public List<SimpleforbindingContext> simpleforbinding() {
			return getRuleContexts(SimpleforbindingContext.class);
		}
		public SimpleforbindingContext simpleforbinding(int i) {
			return getRuleContext(SimpleforbindingContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public SimpleforclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleforclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSimpleforclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSimpleforclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSimpleforclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleforclauseContext simpleforclause() throws RecognitionException {
		SimpleforclauseContext _localctx = new SimpleforclauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simpleforclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(KW_FOR);
			setState(270);
			simpleforbinding();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(271);
				match(COMMA);
				setState(272);
				simpleforbinding();
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleforbindingContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(XPath31Parser.DOLLAR, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode KW_IN() { return getToken(XPath31Parser.KW_IN, 0); }
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public SimpleforbindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleforbinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSimpleforbinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSimpleforbinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSimpleforbinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleforbindingContext simpleforbinding() throws RecognitionException {
		SimpleforbindingContext _localctx = new SimpleforbindingContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_simpleforbinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(DOLLAR);
			setState(279);
			varname();
			setState(280);
			match(KW_IN);
			setState(281);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetexprContext extends ParserRuleContext {
		public SimpleletclauseContext simpleletclause() {
			return getRuleContext(SimpleletclauseContext.class,0);
		}
		public TerminalNode KW_RETURN() { return getToken(XPath31Parser.KW_RETURN, 0); }
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public LetexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterLetexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitLetexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitLetexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetexprContext letexpr() throws RecognitionException {
		LetexprContext _localctx = new LetexprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_letexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			simpleletclause();
			setState(284);
			match(KW_RETURN);
			setState(285);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleletclauseContext extends ParserRuleContext {
		public TerminalNode KW_LET() { return getToken(XPath31Parser.KW_LET, 0); }
		public List<SimpleletbindingContext> simpleletbinding() {
			return getRuleContexts(SimpleletbindingContext.class);
		}
		public SimpleletbindingContext simpleletbinding(int i) {
			return getRuleContext(SimpleletbindingContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public SimpleletclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleletclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSimpleletclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSimpleletclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSimpleletclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleletclauseContext simpleletclause() throws RecognitionException {
		SimpleletclauseContext _localctx = new SimpleletclauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_simpleletclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(KW_LET);
			setState(288);
			simpleletbinding();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(289);
				match(COMMA);
				setState(290);
				simpleletbinding();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleletbindingContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(XPath31Parser.DOLLAR, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode CEQ() { return getToken(XPath31Parser.CEQ, 0); }
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public SimpleletbindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleletbinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSimpleletbinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSimpleletbinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSimpleletbinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleletbindingContext simpleletbinding() throws RecognitionException {
		SimpleletbindingContext _localctx = new SimpleletbindingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleletbinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(DOLLAR);
			setState(297);
			varname();
			setState(298);
			match(CEQ);
			setState(299);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifiedexprContext extends ParserRuleContext {
		public List<TerminalNode> DOLLAR() { return getTokens(XPath31Parser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(XPath31Parser.DOLLAR, i);
		}
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public List<TerminalNode> KW_IN() { return getTokens(XPath31Parser.KW_IN); }
		public TerminalNode KW_IN(int i) {
			return getToken(XPath31Parser.KW_IN, i);
		}
		public List<ExprsingleContext> exprsingle() {
			return getRuleContexts(ExprsingleContext.class);
		}
		public ExprsingleContext exprsingle(int i) {
			return getRuleContext(ExprsingleContext.class,i);
		}
		public TerminalNode KW_SATISFIES() { return getToken(XPath31Parser.KW_SATISFIES, 0); }
		public TerminalNode KW_SOME() { return getToken(XPath31Parser.KW_SOME, 0); }
		public TerminalNode KW_EVERY() { return getToken(XPath31Parser.KW_EVERY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public QuantifiedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiedexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterQuantifiedexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitQuantifiedexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitQuantifiedexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifiedexprContext quantifiedexpr() throws RecognitionException {
		QuantifiedexprContext _localctx = new QuantifiedexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_quantifiedexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_la = _input.LA(1);
			if ( !(_la==KW_EVERY || _la==KW_SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(302);
			match(DOLLAR);
			setState(303);
			varname();
			setState(304);
			match(KW_IN);
			setState(305);
			exprsingle();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(306);
				match(COMMA);
				setState(307);
				match(DOLLAR);
				setState(308);
				varname();
				setState(309);
				match(KW_IN);
				setState(310);
				exprsingle();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(KW_SATISFIES);
			setState(318);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfexprContext extends ParserRuleContext {
		public TerminalNode KW_IF() { return getToken(XPath31Parser.KW_IF, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public TerminalNode KW_THEN() { return getToken(XPath31Parser.KW_THEN, 0); }
		public List<ExprsingleContext> exprsingle() {
			return getRuleContexts(ExprsingleContext.class);
		}
		public ExprsingleContext exprsingle(int i) {
			return getRuleContext(ExprsingleContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(XPath31Parser.KW_ELSE, 0); }
		public IfexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterIfexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitIfexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitIfexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfexprContext ifexpr() throws RecognitionException {
		IfexprContext _localctx = new IfexprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(KW_IF);
			setState(321);
			match(OP);
			setState(322);
			expr();
			setState(323);
			match(CP);
			setState(324);
			match(KW_THEN);
			setState(325);
			exprsingle();
			setState(326);
			match(KW_ELSE);
			setState(327);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrexprContext extends ParserRuleContext {
		public List<AndexprContext> andexpr() {
			return getRuleContexts(AndexprContext.class);
		}
		public AndexprContext andexpr(int i) {
			return getRuleContext(AndexprContext.class,i);
		}
		public List<TerminalNode> KW_OR() { return getTokens(XPath31Parser.KW_OR); }
		public TerminalNode KW_OR(int i) {
			return getToken(XPath31Parser.KW_OR, i);
		}
		public OrexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterOrexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitOrexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitOrexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrexprContext orexpr() throws RecognitionException {
		OrexprContext _localctx = new OrexprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_orexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			andexpr();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_OR) {
				{
				{
				setState(330);
				match(KW_OR);
				setState(331);
				andexpr();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndexprContext extends ParserRuleContext {
		public List<ComparisonexprContext> comparisonexpr() {
			return getRuleContexts(ComparisonexprContext.class);
		}
		public ComparisonexprContext comparisonexpr(int i) {
			return getRuleContext(ComparisonexprContext.class,i);
		}
		public List<TerminalNode> KW_AND() { return getTokens(XPath31Parser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(XPath31Parser.KW_AND, i);
		}
		public AndexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAndexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAndexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAndexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndexprContext andexpr() throws RecognitionException {
		AndexprContext _localctx = new AndexprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_andexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			comparisonexpr();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_AND) {
				{
				{
				setState(338);
				match(KW_AND);
				setState(339);
				comparisonexpr();
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonexprContext extends ParserRuleContext {
		public List<StringconcatexprContext> stringconcatexpr() {
			return getRuleContexts(StringconcatexprContext.class);
		}
		public StringconcatexprContext stringconcatexpr(int i) {
			return getRuleContext(StringconcatexprContext.class,i);
		}
		public ValuecompContext valuecomp() {
			return getRuleContext(ValuecompContext.class,0);
		}
		public GeneralcompContext generalcomp() {
			return getRuleContext(GeneralcompContext.class,0);
		}
		public NodecompContext nodecomp() {
			return getRuleContext(NodecompContext.class,0);
		}
		public ComparisonexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterComparisonexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitComparisonexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitComparisonexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonexprContext comparisonexpr() throws RecognitionException {
		ComparisonexprContext _localctx = new ComparisonexprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparisonexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			stringconcatexpr();
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (EQ - 15)) | (1L << (GE - 15)) | (1L << (GG - 15)) | (1L << (GT - 15)) | (1L << (LE - 15)) | (1L << (LL - 15)) | (1L << (LT - 15)) | (1L << (NE - 15)) | (1L << (KW_EQ - 15)) | (1L << (KW_GE - 15)) | (1L << (KW_GT - 15)) | (1L << (KW_IS - 15)) | (1L << (KW_LE - 15)) | (1L << (KW_LT - 15)) | (1L << (KW_NE - 15)))) != 0)) {
				{
				setState(349);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case KW_EQ:
				case KW_GE:
				case KW_GT:
				case KW_LE:
				case KW_LT:
				case KW_NE:
					{
					setState(346);
					valuecomp();
					}
					break;
				case EQ:
				case GE:
				case GT:
				case LE:
				case LT:
				case NE:
					{
					setState(347);
					generalcomp();
					}
					break;
				case GG:
				case LL:
				case KW_IS:
					{
					setState(348);
					nodecomp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(351);
				stringconcatexpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringconcatexprContext extends ParserRuleContext {
		public List<RangeexprContext> rangeexpr() {
			return getRuleContexts(RangeexprContext.class);
		}
		public RangeexprContext rangeexpr(int i) {
			return getRuleContext(RangeexprContext.class,i);
		}
		public List<TerminalNode> PP() { return getTokens(XPath31Parser.PP); }
		public TerminalNode PP(int i) {
			return getToken(XPath31Parser.PP, i);
		}
		public StringconcatexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringconcatexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterStringconcatexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitStringconcatexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitStringconcatexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringconcatexprContext stringconcatexpr() throws RecognitionException {
		StringconcatexprContext _localctx = new StringconcatexprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stringconcatexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			rangeexpr();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PP) {
				{
				{
				setState(356);
				match(PP);
				setState(357);
				rangeexpr();
				}
				}
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeexprContext extends ParserRuleContext {
		public List<AdditiveexprContext> additiveexpr() {
			return getRuleContexts(AdditiveexprContext.class);
		}
		public AdditiveexprContext additiveexpr(int i) {
			return getRuleContext(AdditiveexprContext.class,i);
		}
		public TerminalNode KW_TO() { return getToken(XPath31Parser.KW_TO, 0); }
		public RangeexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterRangeexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitRangeexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitRangeexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeexprContext rangeexpr() throws RecognitionException {
		RangeexprContext _localctx = new RangeexprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_rangeexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			additiveexpr();
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_TO) {
				{
				setState(364);
				match(KW_TO);
				setState(365);
				additiveexpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveexprContext extends ParserRuleContext {
		public List<MultiplicativeexprContext> multiplicativeexpr() {
			return getRuleContexts(MultiplicativeexprContext.class);
		}
		public MultiplicativeexprContext multiplicativeexpr(int i) {
			return getRuleContext(MultiplicativeexprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(XPath31Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(XPath31Parser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(XPath31Parser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(XPath31Parser.MINUS, i);
		}
		public AdditiveexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAdditiveexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAdditiveexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAdditiveexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveexprContext additiveexpr() throws RecognitionException {
		AdditiveexprContext _localctx = new AdditiveexprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_additiveexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			multiplicativeexpr();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MINUS || _la==PLUS) {
				{
				{
				setState(369);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==PLUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(370);
				multiplicativeexpr();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeexprContext extends ParserRuleContext {
		public List<UnionexprContext> unionexpr() {
			return getRuleContexts(UnionexprContext.class);
		}
		public UnionexprContext unionexpr(int i) {
			return getRuleContext(UnionexprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(XPath31Parser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(XPath31Parser.STAR, i);
		}
		public List<TerminalNode> KW_DIV() { return getTokens(XPath31Parser.KW_DIV); }
		public TerminalNode KW_DIV(int i) {
			return getToken(XPath31Parser.KW_DIV, i);
		}
		public List<TerminalNode> KW_IDIV() { return getTokens(XPath31Parser.KW_IDIV); }
		public TerminalNode KW_IDIV(int i) {
			return getToken(XPath31Parser.KW_IDIV, i);
		}
		public List<TerminalNode> KW_MOD() { return getTokens(XPath31Parser.KW_MOD); }
		public TerminalNode KW_MOD(int i) {
			return getToken(XPath31Parser.KW_MOD, i);
		}
		public MultiplicativeexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterMultiplicativeexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitMultiplicativeexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitMultiplicativeexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeexprContext multiplicativeexpr() throws RecognitionException {
		MultiplicativeexprContext _localctx = new MultiplicativeexprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_multiplicativeexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			unionexpr();
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (STAR - 35)) | (1L << (KW_DIV - 35)) | (1L << (KW_IDIV - 35)) | (1L << (KW_MOD - 35)))) != 0)) {
				{
				{
				setState(377);
				_la = _input.LA(1);
				if ( !(((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (STAR - 35)) | (1L << (KW_DIV - 35)) | (1L << (KW_IDIV - 35)) | (1L << (KW_MOD - 35)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(378);
				unionexpr();
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionexprContext extends ParserRuleContext {
		public List<IntersectexceptexprContext> intersectexceptexpr() {
			return getRuleContexts(IntersectexceptexprContext.class);
		}
		public IntersectexceptexprContext intersectexceptexpr(int i) {
			return getRuleContext(IntersectexceptexprContext.class,i);
		}
		public List<TerminalNode> KW_UNION() { return getTokens(XPath31Parser.KW_UNION); }
		public TerminalNode KW_UNION(int i) {
			return getToken(XPath31Parser.KW_UNION, i);
		}
		public List<TerminalNode> P() { return getTokens(XPath31Parser.P); }
		public TerminalNode P(int i) {
			return getToken(XPath31Parser.P, i);
		}
		public UnionexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterUnionexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitUnionexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitUnionexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionexprContext unionexpr() throws RecognitionException {
		UnionexprContext _localctx = new UnionexprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unionexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			intersectexceptexpr();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==P || _la==KW_UNION) {
				{
				{
				setState(385);
				_la = _input.LA(1);
				if ( !(_la==P || _la==KW_UNION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(386);
				intersectexceptexpr();
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntersectexceptexprContext extends ParserRuleContext {
		public List<InstanceofexprContext> instanceofexpr() {
			return getRuleContexts(InstanceofexprContext.class);
		}
		public InstanceofexprContext instanceofexpr(int i) {
			return getRuleContext(InstanceofexprContext.class,i);
		}
		public List<TerminalNode> KW_INTERSECT() { return getTokens(XPath31Parser.KW_INTERSECT); }
		public TerminalNode KW_INTERSECT(int i) {
			return getToken(XPath31Parser.KW_INTERSECT, i);
		}
		public List<TerminalNode> KW_EXCEPT() { return getTokens(XPath31Parser.KW_EXCEPT); }
		public TerminalNode KW_EXCEPT(int i) {
			return getToken(XPath31Parser.KW_EXCEPT, i);
		}
		public IntersectexceptexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intersectexceptexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterIntersectexceptexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitIntersectexceptexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitIntersectexceptexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntersectexceptexprContext intersectexceptexpr() throws RecognitionException {
		IntersectexceptexprContext _localctx = new IntersectexceptexprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_intersectexceptexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			instanceofexpr();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_EXCEPT || _la==KW_INTERSECT) {
				{
				{
				setState(393);
				_la = _input.LA(1);
				if ( !(_la==KW_EXCEPT || _la==KW_INTERSECT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(394);
				instanceofexpr();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceofexprContext extends ParserRuleContext {
		public TreatexprContext treatexpr() {
			return getRuleContext(TreatexprContext.class,0);
		}
		public TerminalNode KW_INSTANCE() { return getToken(XPath31Parser.KW_INSTANCE, 0); }
		public TerminalNode KW_OF() { return getToken(XPath31Parser.KW_OF, 0); }
		public SequencetypeContext sequencetype() {
			return getRuleContext(SequencetypeContext.class,0);
		}
		public InstanceofexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceofexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterInstanceofexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitInstanceofexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitInstanceofexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceofexprContext instanceofexpr() throws RecognitionException {
		InstanceofexprContext _localctx = new InstanceofexprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_instanceofexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			treatexpr();
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INSTANCE) {
				{
				setState(401);
				match(KW_INSTANCE);
				setState(402);
				match(KW_OF);
				setState(403);
				sequencetype();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TreatexprContext extends ParserRuleContext {
		public CastableexprContext castableexpr() {
			return getRuleContext(CastableexprContext.class,0);
		}
		public TerminalNode KW_TREAT() { return getToken(XPath31Parser.KW_TREAT, 0); }
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public SequencetypeContext sequencetype() {
			return getRuleContext(SequencetypeContext.class,0);
		}
		public TreatexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_treatexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTreatexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTreatexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTreatexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TreatexprContext treatexpr() throws RecognitionException {
		TreatexprContext _localctx = new TreatexprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_treatexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			castableexpr();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_TREAT) {
				{
				setState(407);
				match(KW_TREAT);
				setState(408);
				match(KW_AS);
				setState(409);
				sequencetype();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastableexprContext extends ParserRuleContext {
		public CastexprContext castexpr() {
			return getRuleContext(CastexprContext.class,0);
		}
		public TerminalNode KW_CASTABLE() { return getToken(XPath31Parser.KW_CASTABLE, 0); }
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public SingletypeContext singletype() {
			return getRuleContext(SingletypeContext.class,0);
		}
		public CastableexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castableexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterCastableexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitCastableexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitCastableexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastableexprContext castableexpr() throws RecognitionException {
		CastableexprContext _localctx = new CastableexprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_castableexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			castexpr();
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_CASTABLE) {
				{
				setState(413);
				match(KW_CASTABLE);
				setState(414);
				match(KW_AS);
				setState(415);
				singletype();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastexprContext extends ParserRuleContext {
		public ArrowexprContext arrowexpr() {
			return getRuleContext(ArrowexprContext.class,0);
		}
		public TerminalNode KW_CAST() { return getToken(XPath31Parser.KW_CAST, 0); }
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public SingletypeContext singletype() {
			return getRuleContext(SingletypeContext.class,0);
		}
		public CastexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterCastexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitCastexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitCastexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastexprContext castexpr() throws RecognitionException {
		CastexprContext _localctx = new CastexprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_castexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			arrowexpr();
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_CAST) {
				{
				setState(419);
				match(KW_CAST);
				setState(420);
				match(KW_AS);
				setState(421);
				singletype();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrowexprContext extends ParserRuleContext {
		public UnaryexprContext unaryexpr() {
			return getRuleContext(UnaryexprContext.class,0);
		}
		public List<TerminalNode> EG() { return getTokens(XPath31Parser.EG); }
		public TerminalNode EG(int i) {
			return getToken(XPath31Parser.EG, i);
		}
		public List<ArrowfunctionspecifierContext> arrowfunctionspecifier() {
			return getRuleContexts(ArrowfunctionspecifierContext.class);
		}
		public ArrowfunctionspecifierContext arrowfunctionspecifier(int i) {
			return getRuleContext(ArrowfunctionspecifierContext.class,i);
		}
		public List<ArgumentlistContext> argumentlist() {
			return getRuleContexts(ArgumentlistContext.class);
		}
		public ArgumentlistContext argumentlist(int i) {
			return getRuleContext(ArgumentlistContext.class,i);
		}
		public ArrowexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArrowexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArrowexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArrowexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowexprContext arrowexpr() throws RecognitionException {
		ArrowexprContext _localctx = new ArrowexprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrowexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			unaryexpr();
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EG) {
				{
				{
				setState(425);
				match(EG);
				setState(426);
				arrowfunctionspecifier();
				setState(427);
				argumentlist();
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryexprContext extends ParserRuleContext {
		public ValueexprContext valueexpr() {
			return getRuleContext(ValueexprContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(XPath31Parser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(XPath31Parser.MINUS, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(XPath31Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(XPath31Parser.PLUS, i);
		}
		public UnaryexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterUnaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitUnaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitUnaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexprContext unaryexpr() throws RecognitionException {
		UnaryexprContext _localctx = new UnaryexprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unaryexpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(434);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(439);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(440);
			valueexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueexprContext extends ParserRuleContext {
		public SimplemapexprContext simplemapexpr() {
			return getRuleContext(SimplemapexprContext.class,0);
		}
		public ValueexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterValueexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitValueexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitValueexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueexprContext valueexpr() throws RecognitionException {
		ValueexprContext _localctx = new ValueexprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_valueexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			simplemapexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralcompContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(XPath31Parser.EQ, 0); }
		public TerminalNode NE() { return getToken(XPath31Parser.NE, 0); }
		public TerminalNode LT() { return getToken(XPath31Parser.LT, 0); }
		public TerminalNode LE() { return getToken(XPath31Parser.LE, 0); }
		public TerminalNode GT() { return getToken(XPath31Parser.GT, 0); }
		public TerminalNode GE() { return getToken(XPath31Parser.GE, 0); }
		public GeneralcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterGeneralcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitGeneralcomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitGeneralcomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralcompContext generalcomp() throws RecognitionException {
		GeneralcompContext _localctx = new GeneralcompContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_generalcomp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GE) | (1L << GT) | (1L << LE) | (1L << LT) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuecompContext extends ParserRuleContext {
		public TerminalNode KW_EQ() { return getToken(XPath31Parser.KW_EQ, 0); }
		public TerminalNode KW_NE() { return getToken(XPath31Parser.KW_NE, 0); }
		public TerminalNode KW_LT() { return getToken(XPath31Parser.KW_LT, 0); }
		public TerminalNode KW_LE() { return getToken(XPath31Parser.KW_LE, 0); }
		public TerminalNode KW_GT() { return getToken(XPath31Parser.KW_GT, 0); }
		public TerminalNode KW_GE() { return getToken(XPath31Parser.KW_GE, 0); }
		public ValuecompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuecomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterValuecomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitValuecomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitValuecomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuecompContext valuecomp() throws RecognitionException {
		ValuecompContext _localctx = new ValuecompContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_valuecomp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			_la = _input.LA(1);
			if ( !(((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & ((1L << (KW_EQ - 53)) | (1L << (KW_GE - 53)) | (1L << (KW_GT - 53)) | (1L << (KW_LE - 53)) | (1L << (KW_LT - 53)) | (1L << (KW_NE - 53)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodecompContext extends ParserRuleContext {
		public TerminalNode KW_IS() { return getToken(XPath31Parser.KW_IS, 0); }
		public TerminalNode LL() { return getToken(XPath31Parser.LL, 0); }
		public TerminalNode GG() { return getToken(XPath31Parser.GG, 0); }
		public NodecompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodecomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterNodecomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitNodecomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitNodecomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodecompContext nodecomp() throws RecognitionException {
		NodecompContext _localctx = new NodecompContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_nodecomp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (GG - 17)) | (1L << (LL - 17)) | (1L << (KW_IS - 17)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimplemapexprContext extends ParserRuleContext {
		public List<PathexprContext> pathexpr() {
			return getRuleContexts(PathexprContext.class);
		}
		public PathexprContext pathexpr(int i) {
			return getRuleContext(PathexprContext.class,i);
		}
		public List<TerminalNode> BANG() { return getTokens(XPath31Parser.BANG); }
		public TerminalNode BANG(int i) {
			return getToken(XPath31Parser.BANG, i);
		}
		public SimplemapexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplemapexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSimplemapexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSimplemapexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSimplemapexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimplemapexprContext simplemapexpr() throws RecognitionException {
		SimplemapexprContext _localctx = new SimplemapexprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_simplemapexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			pathexpr();
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BANG) {
				{
				{
				setState(451);
				match(BANG);
				setState(452);
				pathexpr();
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathexprContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(XPath31Parser.SLASH, 0); }
		public RelativepathexprContext relativepathexpr() {
			return getRuleContext(RelativepathexprContext.class,0);
		}
		public TerminalNode SS() { return getToken(XPath31Parser.SS, 0); }
		public PathexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterPathexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitPathexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitPathexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathexprContext pathexpr() throws RecognitionException {
		PathexprContext _localctx = new PathexprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_pathexpr);
		try {
			setState(465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(458);
				match(SLASH);
				setState(460);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(459);
					relativepathexpr();
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(462);
				match(SS);
				setState(463);
				relativepathexpr();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(464);
				relativepathexpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelativepathexprContext extends ParserRuleContext {
		public List<StepexprContext> stepexpr() {
			return getRuleContexts(StepexprContext.class);
		}
		public StepexprContext stepexpr(int i) {
			return getRuleContext(StepexprContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(XPath31Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(XPath31Parser.SLASH, i);
		}
		public List<TerminalNode> SS() { return getTokens(XPath31Parser.SS); }
		public TerminalNode SS(int i) {
			return getToken(XPath31Parser.SS, i);
		}
		public RelativepathexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativepathexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterRelativepathexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitRelativepathexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitRelativepathexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelativepathexprContext relativepathexpr() throws RecognitionException {
		RelativepathexprContext _localctx = new RelativepathexprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_relativepathexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			stepexpr();
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH || _la==SS) {
				{
				{
				setState(468);
				_la = _input.LA(1);
				if ( !(_la==SLASH || _la==SS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(469);
				stepexpr();
				}
				}
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepexprContext extends ParserRuleContext {
		public PostfixexprContext postfixexpr() {
			return getRuleContext(PostfixexprContext.class,0);
		}
		public AxisstepContext axisstep() {
			return getRuleContext(AxisstepContext.class,0);
		}
		public StepexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterStepexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitStepexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitStepexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepexprContext stepexpr() throws RecognitionException {
		StepexprContext _localctx = new StepexprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_stepexpr);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				postfixexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				axisstep();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AxisstepContext extends ParserRuleContext {
		public PredicatelistContext predicatelist() {
			return getRuleContext(PredicatelistContext.class,0);
		}
		public ReversestepContext reversestep() {
			return getRuleContext(ReversestepContext.class,0);
		}
		public ForwardstepContext forwardstep() {
			return getRuleContext(ForwardstepContext.class,0);
		}
		public AxisstepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axisstep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAxisstep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAxisstep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAxisstep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AxisstepContext axisstep() throws RecognitionException {
		AxisstepContext _localctx = new AxisstepContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_axisstep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(479);
				reversestep();
				}
				break;
			case 2:
				{
				setState(480);
				forwardstep();
				}
				break;
			}
			setState(483);
			predicatelist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForwardstepContext extends ParserRuleContext {
		public ForwardaxisContext forwardaxis() {
			return getRuleContext(ForwardaxisContext.class,0);
		}
		public NodetestContext nodetest() {
			return getRuleContext(NodetestContext.class,0);
		}
		public AbbrevforwardstepContext abbrevforwardstep() {
			return getRuleContext(AbbrevforwardstepContext.class,0);
		}
		public ForwardstepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardstep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterForwardstep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitForwardstep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitForwardstep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForwardstepContext forwardstep() throws RecognitionException {
		ForwardstepContext _localctx = new ForwardstepContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_forwardstep);
		try {
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(485);
				forwardaxis();
				setState(486);
				nodetest();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				abbrevforwardstep();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForwardaxisContext extends ParserRuleContext {
		public TerminalNode KW_CHILD() { return getToken(XPath31Parser.KW_CHILD, 0); }
		public TerminalNode COLONCOLON() { return getToken(XPath31Parser.COLONCOLON, 0); }
		public TerminalNode KW_DESCENDANT() { return getToken(XPath31Parser.KW_DESCENDANT, 0); }
		public TerminalNode KW_ATTRIBUTE() { return getToken(XPath31Parser.KW_ATTRIBUTE, 0); }
		public TerminalNode KW_SELF() { return getToken(XPath31Parser.KW_SELF, 0); }
		public TerminalNode KW_DESCENDANT_OR_SELF() { return getToken(XPath31Parser.KW_DESCENDANT_OR_SELF, 0); }
		public TerminalNode KW_FOLLOWING_SIBLING() { return getToken(XPath31Parser.KW_FOLLOWING_SIBLING, 0); }
		public TerminalNode KW_FOLLOWING() { return getToken(XPath31Parser.KW_FOLLOWING, 0); }
		public TerminalNode KW_NAMESPACE() { return getToken(XPath31Parser.KW_NAMESPACE, 0); }
		public ForwardaxisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forwardaxis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterForwardaxis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitForwardaxis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitForwardaxis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForwardaxisContext forwardaxis() throws RecognitionException {
		ForwardaxisContext _localctx = new ForwardaxisContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_forwardaxis);
		try {
			setState(507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_CHILD:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(491);
				match(KW_CHILD);
				setState(492);
				match(COLONCOLON);
				}
				}
				break;
			case KW_DESCENDANT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(493);
				match(KW_DESCENDANT);
				setState(494);
				match(COLONCOLON);
				}
				}
				break;
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(495);
				match(KW_ATTRIBUTE);
				setState(496);
				match(COLONCOLON);
				}
				}
				break;
			case KW_SELF:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(497);
				match(KW_SELF);
				setState(498);
				match(COLONCOLON);
				}
				}
				break;
			case KW_DESCENDANT_OR_SELF:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(499);
				match(KW_DESCENDANT_OR_SELF);
				setState(500);
				match(COLONCOLON);
				}
				}
				break;
			case KW_FOLLOWING_SIBLING:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(501);
				match(KW_FOLLOWING_SIBLING);
				setState(502);
				match(COLONCOLON);
				}
				}
				break;
			case KW_FOLLOWING:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(503);
				match(KW_FOLLOWING);
				setState(504);
				match(COLONCOLON);
				}
				}
				break;
			case KW_NAMESPACE:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(505);
				match(KW_NAMESPACE);
				setState(506);
				match(COLONCOLON);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbbrevforwardstepContext extends ParserRuleContext {
		public NodetestContext nodetest() {
			return getRuleContext(NodetestContext.class,0);
		}
		public TerminalNode AT() { return getToken(XPath31Parser.AT, 0); }
		public AbbrevforwardstepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abbrevforwardstep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAbbrevforwardstep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAbbrevforwardstep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAbbrevforwardstep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbbrevforwardstepContext abbrevforwardstep() throws RecognitionException {
		AbbrevforwardstepContext _localctx = new AbbrevforwardstepContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_abbrevforwardstep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(509);
				match(AT);
				}
			}

			setState(512);
			nodetest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReversestepContext extends ParserRuleContext {
		public ReverseaxisContext reverseaxis() {
			return getRuleContext(ReverseaxisContext.class,0);
		}
		public NodetestContext nodetest() {
			return getRuleContext(NodetestContext.class,0);
		}
		public AbbrevreversestepContext abbrevreversestep() {
			return getRuleContext(AbbrevreversestepContext.class,0);
		}
		public ReversestepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reversestep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterReversestep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitReversestep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitReversestep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReversestepContext reversestep() throws RecognitionException {
		ReversestepContext _localctx = new ReversestepContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_reversestep);
		try {
			setState(518);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ANCESTOR:
			case KW_ANCESTOR_OR_SELF:
			case KW_PARENT:
			case KW_PRECEDING:
			case KW_PRECEDING_SIBLING:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(514);
				reverseaxis();
				setState(515);
				nodetest();
				}
				}
				break;
			case DD:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				abbrevreversestep();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReverseaxisContext extends ParserRuleContext {
		public TerminalNode KW_PARENT() { return getToken(XPath31Parser.KW_PARENT, 0); }
		public TerminalNode COLONCOLON() { return getToken(XPath31Parser.COLONCOLON, 0); }
		public TerminalNode KW_ANCESTOR() { return getToken(XPath31Parser.KW_ANCESTOR, 0); }
		public TerminalNode KW_PRECEDING_SIBLING() { return getToken(XPath31Parser.KW_PRECEDING_SIBLING, 0); }
		public TerminalNode KW_PRECEDING() { return getToken(XPath31Parser.KW_PRECEDING, 0); }
		public TerminalNode KW_ANCESTOR_OR_SELF() { return getToken(XPath31Parser.KW_ANCESTOR_OR_SELF, 0); }
		public ReverseaxisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reverseaxis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterReverseaxis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitReverseaxis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitReverseaxis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReverseaxisContext reverseaxis() throws RecognitionException {
		ReverseaxisContext _localctx = new ReverseaxisContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_reverseaxis);
		try {
			setState(530);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PARENT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(520);
				match(KW_PARENT);
				setState(521);
				match(COLONCOLON);
				}
				}
				break;
			case KW_ANCESTOR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(522);
				match(KW_ANCESTOR);
				setState(523);
				match(COLONCOLON);
				}
				}
				break;
			case KW_PRECEDING_SIBLING:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(524);
				match(KW_PRECEDING_SIBLING);
				setState(525);
				match(COLONCOLON);
				}
				}
				break;
			case KW_PRECEDING:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(526);
				match(KW_PRECEDING);
				setState(527);
				match(COLONCOLON);
				}
				}
				break;
			case KW_ANCESTOR_OR_SELF:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(528);
				match(KW_ANCESTOR_OR_SELF);
				setState(529);
				match(COLONCOLON);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbbrevreversestepContext extends ParserRuleContext {
		public TerminalNode DD() { return getToken(XPath31Parser.DD, 0); }
		public AbbrevreversestepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abbrevreversestep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAbbrevreversestep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAbbrevreversestep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAbbrevreversestep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbbrevreversestepContext abbrevreversestep() throws RecognitionException {
		AbbrevreversestepContext _localctx = new AbbrevreversestepContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_abbrevreversestep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(DD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodetestContext extends ParserRuleContext {
		public KindtestContext kindtest() {
			return getRuleContext(KindtestContext.class,0);
		}
		public NametestContext nametest() {
			return getRuleContext(NametestContext.class,0);
		}
		public NodetestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodetest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterNodetest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitNodetest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitNodetest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodetestContext nodetest() throws RecognitionException {
		NodetestContext _localctx = new NodetestContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nodetest);
		try {
			setState(536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				kindtest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				nametest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NametestContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public WildcardContext wildcard() {
			return getRuleContext(WildcardContext.class,0);
		}
		public NametestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nametest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterNametest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitNametest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitNametest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NametestContext nametest() throws RecognitionException {
		NametestContext _localctx = new NametestContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_nametest);
		try {
			setState(540);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ANCESTOR:
			case KW_ANCESTOR_OR_SELF:
			case KW_AND:
			case KW_ARRAY:
			case KW_AS:
			case KW_ATTRIBUTE:
			case KW_CAST:
			case KW_CASTABLE:
			case KW_CHILD:
			case KW_COMMENT:
			case KW_DESCENDANT:
			case KW_DESCENDANT_OR_SELF:
			case KW_DIV:
			case KW_DOCUMENT_NODE:
			case KW_ELEMENT:
			case KW_ELSE:
			case KW_EMPTY_SEQUENCE:
			case KW_EQ:
			case KW_EVERY:
			case KW_EXCEPT:
			case KW_FOLLOWING:
			case KW_FOLLOWING_SIBLING:
			case KW_FOR:
			case KW_FUNCTION:
			case KW_GE:
			case KW_GT:
			case KW_IDIV:
			case KW_IF:
			case KW_IN:
			case KW_INSTANCE:
			case KW_INTERSECT:
			case KW_IS:
			case KW_ITEM:
			case KW_LE:
			case KW_LET:
			case KW_LT:
			case KW_MAP:
			case KW_MOD:
			case KW_NAMESPACE:
			case KW_NAMESPACE_NODE:
			case KW_NE:
			case KW_NODE:
			case KW_OF:
			case KW_OR:
			case KW_PARENT:
			case KW_PRECEDING:
			case KW_PRECEDING_SIBLING:
			case KW_PROCESSING_INSTRUCTION:
			case KW_RETURN:
			case KW_SATISFIES:
			case KW_SCHEMA_ATTRIBUTE:
			case KW_SCHEMA_ELEMENT:
			case KW_SELF:
			case KW_SOME:
			case KW_TEXT:
			case KW_THEN:
			case KW_TREAT:
			case KW_UNION:
			case URIQualifiedName:
			case QName:
				enterOuterAlt(_localctx, 1);
				{
				setState(538);
				eqname();
				}
				break;
			case SC:
			case STAR:
			case BracedURILiteral:
			case NCName:
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
				wildcard();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public TerminalNode NCName() { return getToken(XPath31Parser.NCName, 0); }
		public TerminalNode CS() { return getToken(XPath31Parser.CS, 0); }
		public TerminalNode SC() { return getToken(XPath31Parser.SC, 0); }
		public TerminalNode BracedURILiteral() { return getToken(XPath31Parser.BracedURILiteral, 0); }
		public WildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardContext wildcard() throws RecognitionException {
		WildcardContext _localctx = new WildcardContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_wildcard);
		try {
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(542);
				match(STAR);
				}
				break;
			case NCName:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(543);
				match(NCName);
				setState(544);
				match(CS);
				}
				}
				break;
			case SC:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(545);
				match(SC);
				setState(546);
				match(NCName);
				}
				}
				break;
			case BracedURILiteral:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(547);
				match(BracedURILiteral);
				setState(548);
				match(STAR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixexprContext extends ParserRuleContext {
		public PrimaryexprContext primaryexpr() {
			return getRuleContext(PrimaryexprContext.class,0);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<ArgumentlistContext> argumentlist() {
			return getRuleContexts(ArgumentlistContext.class);
		}
		public ArgumentlistContext argumentlist(int i) {
			return getRuleContext(ArgumentlistContext.class,i);
		}
		public List<LookupContext> lookup() {
			return getRuleContexts(LookupContext.class);
		}
		public LookupContext lookup(int i) {
			return getRuleContext(LookupContext.class,i);
		}
		public PostfixexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterPostfixexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitPostfixexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitPostfixexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixexprContext postfixexpr() throws RecognitionException {
		PostfixexprContext _localctx = new PostfixexprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_postfixexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			primaryexpr();
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OB) | (1L << OP) | (1L << QM))) != 0)) {
				{
				setState(555);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OB:
					{
					setState(552);
					predicate();
					}
					break;
				case OP:
					{
					setState(553);
					argumentlist();
					}
					break;
				case QM:
					{
					setState(554);
					lookup();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentlistContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public ArgumentlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArgumentlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArgumentlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArgumentlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentlistContext argumentlist() throws RecognitionException {
		ArgumentlistContext _localctx = new ArgumentlistContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_argumentlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(OP);
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(561);
				argument();
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(562);
					match(COMMA);
					setState(563);
					argument();
					}
					}
					setState(568);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(571);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatelistContext extends ParserRuleContext {
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public PredicatelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterPredicatelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitPredicatelist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitPredicatelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatelistContext predicatelist() throws RecognitionException {
		PredicatelistContext _localctx = new PredicatelistContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_predicatelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OB) {
				{
				{
				setState(573);
				predicate();
				}
				}
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode OB() { return getToken(XPath31Parser.OB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CB() { return getToken(XPath31Parser.CB, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(OB);
			setState(580);
			expr();
			setState(581);
			match(CB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LookupContext extends ParserRuleContext {
		public TerminalNode QM() { return getToken(XPath31Parser.QM, 0); }
		public KeyspecifierContext keyspecifier() {
			return getRuleContext(KeyspecifierContext.class,0);
		}
		public LookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitLookup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LookupContext lookup() throws RecognitionException {
		LookupContext _localctx = new LookupContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_lookup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(QM);
			setState(584);
			keyspecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyspecifierContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(XPath31Parser.NCName, 0); }
		public TerminalNode IntegerLiteral() { return getToken(XPath31Parser.IntegerLiteral, 0); }
		public ParenthesizedexprContext parenthesizedexpr() {
			return getRuleContext(ParenthesizedexprContext.class,0);
		}
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public KeyspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterKeyspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitKeyspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitKeyspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyspecifierContext keyspecifier() throws RecognitionException {
		KeyspecifierContext _localctx = new KeyspecifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_keyspecifier);
		try {
			setState(590);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				match(NCName);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				match(IntegerLiteral);
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(588);
				parenthesizedexpr();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(589);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrowfunctionspecifierContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public VarrefContext varref() {
			return getRuleContext(VarrefContext.class,0);
		}
		public ParenthesizedexprContext parenthesizedexpr() {
			return getRuleContext(ParenthesizedexprContext.class,0);
		}
		public ArrowfunctionspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowfunctionspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArrowfunctionspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArrowfunctionspecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArrowfunctionspecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowfunctionspecifierContext arrowfunctionspecifier() throws RecognitionException {
		ArrowfunctionspecifierContext _localctx = new ArrowfunctionspecifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_arrowfunctionspecifier);
		try {
			setState(595);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ANCESTOR:
			case KW_ANCESTOR_OR_SELF:
			case KW_AND:
			case KW_ARRAY:
			case KW_AS:
			case KW_ATTRIBUTE:
			case KW_CAST:
			case KW_CASTABLE:
			case KW_CHILD:
			case KW_COMMENT:
			case KW_DESCENDANT:
			case KW_DESCENDANT_OR_SELF:
			case KW_DIV:
			case KW_DOCUMENT_NODE:
			case KW_ELEMENT:
			case KW_ELSE:
			case KW_EMPTY_SEQUENCE:
			case KW_EQ:
			case KW_EVERY:
			case KW_EXCEPT:
			case KW_FOLLOWING:
			case KW_FOLLOWING_SIBLING:
			case KW_FOR:
			case KW_FUNCTION:
			case KW_GE:
			case KW_GT:
			case KW_IDIV:
			case KW_IF:
			case KW_IN:
			case KW_INSTANCE:
			case KW_INTERSECT:
			case KW_IS:
			case KW_ITEM:
			case KW_LE:
			case KW_LET:
			case KW_LT:
			case KW_MAP:
			case KW_MOD:
			case KW_NAMESPACE:
			case KW_NAMESPACE_NODE:
			case KW_NE:
			case KW_NODE:
			case KW_OF:
			case KW_OR:
			case KW_PARENT:
			case KW_PRECEDING:
			case KW_PRECEDING_SIBLING:
			case KW_PROCESSING_INSTRUCTION:
			case KW_RETURN:
			case KW_SATISFIES:
			case KW_SCHEMA_ATTRIBUTE:
			case KW_SCHEMA_ELEMENT:
			case KW_SELF:
			case KW_SOME:
			case KW_TEXT:
			case KW_THEN:
			case KW_TREAT:
			case KW_UNION:
			case URIQualifiedName:
			case QName:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				eqname();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				varref();
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(594);
				parenthesizedexpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryexprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VarrefContext varref() {
			return getRuleContext(VarrefContext.class,0);
		}
		public ParenthesizedexprContext parenthesizedexpr() {
			return getRuleContext(ParenthesizedexprContext.class,0);
		}
		public ContextitemexprContext contextitemexpr() {
			return getRuleContext(ContextitemexprContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public FunctionitemexprContext functionitemexpr() {
			return getRuleContext(FunctionitemexprContext.class,0);
		}
		public MapconstructorContext mapconstructor() {
			return getRuleContext(MapconstructorContext.class,0);
		}
		public ArrayconstructorContext arrayconstructor() {
			return getRuleContext(ArrayconstructorContext.class,0);
		}
		public UnarylookupContext unarylookup() {
			return getRuleContext(UnarylookupContext.class,0);
		}
		public PrimaryexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterPrimaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitPrimaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitPrimaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexprContext primaryexpr() throws RecognitionException {
		PrimaryexprContext _localctx = new PrimaryexprContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_primaryexpr);
		try {
			setState(606);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(597);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(598);
				varref();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(599);
				parenthesizedexpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(600);
				contextitemexpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(601);
				functioncall();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(602);
				functionitemexpr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(603);
				mapconstructor();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(604);
				arrayconstructor();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(605);
				unarylookup();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public NumericliteralContext numericliteral() {
			return getRuleContext(NumericliteralContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(XPath31Parser.StringLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_literal);
		try {
			setState(610);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case DecimalLiteral:
			case DoubleLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				numericliteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(609);
				match(StringLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericliteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(XPath31Parser.IntegerLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(XPath31Parser.DecimalLiteral, 0); }
		public TerminalNode DoubleLiteral() { return getToken(XPath31Parser.DoubleLiteral, 0); }
		public NumericliteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericliteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterNumericliteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitNumericliteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitNumericliteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericliteralContext numericliteral() throws RecognitionException {
		NumericliteralContext _localctx = new NumericliteralContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_numericliteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			_la = _input.LA(1);
			if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (IntegerLiteral - 95)) | (1L << (DecimalLiteral - 95)) | (1L << (DoubleLiteral - 95)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarrefContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(XPath31Parser.DOLLAR, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public VarrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterVarref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitVarref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitVarref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarrefContext varref() throws RecognitionException {
		VarrefContext _localctx = new VarrefContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_varref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(DOLLAR);
			setState(615);
			varname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarnameContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterVarname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitVarname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitVarname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			eqname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenthesizedexprContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesizedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterParenthesizedexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitParenthesizedexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitParenthesizedexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedexprContext parenthesizedexpr() throws RecognitionException {
		ParenthesizedexprContext _localctx = new ParenthesizedexprContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_parenthesizedexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(OP);
			setState(621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(620);
				expr();
				}
				break;
			}
			setState(623);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextitemexprContext extends ParserRuleContext {
		public TerminalNode D() { return getToken(XPath31Parser.D, 0); }
		public ContextitemexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextitemexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterContextitemexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitContextitemexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitContextitemexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextitemexprContext contextitemexpr() throws RecognitionException {
		ContextitemexprContext _localctx = new ContextitemexprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_contextitemexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(D);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public ArgumentlistContext argumentlist() {
			return getRuleContext(ArgumentlistContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitFunctioncall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_functioncall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			if (!( !(
			                           getInputStream().LA(1)==KW_ARRAY
			                        || getInputStream().LA(1)==KW_ATTRIBUTE
			                        || getInputStream().LA(1)==KW_COMMENT
			                        || getInputStream().LA(1)==KW_DOCUMENT_NODE
			                        || getInputStream().LA(1)==KW_ELEMENT
			                        || getInputStream().LA(1)==KW_EMPTY_SEQUENCE
			                        || getInputStream().LA(1)==KW_FUNCTION
			                        || getInputStream().LA(1)==KW_IF
			                        || getInputStream().LA(1)==KW_ITEM
			                        || getInputStream().LA(1)==KW_MAP
			                        || getInputStream().LA(1)==KW_NAMESPACE_NODE
			                        || getInputStream().LA(1)==KW_NODE
			                        || getInputStream().LA(1)==KW_PROCESSING_INSTRUCTION
			                        || getInputStream().LA(1)==KW_SCHEMA_ATTRIBUTE
			                        || getInputStream().LA(1)==KW_SCHEMA_ELEMENT
			                        || getInputStream().LA(1)==KW_TEXT
			                        ) )) throw new FailedPredicateException(this, " !(\n                           getInputStream().LA(1)==KW_ARRAY\n                        || getInputStream().LA(1)==KW_ATTRIBUTE\n                        || getInputStream().LA(1)==KW_COMMENT\n                        || getInputStream().LA(1)==KW_DOCUMENT_NODE\n                        || getInputStream().LA(1)==KW_ELEMENT\n                        || getInputStream().LA(1)==KW_EMPTY_SEQUENCE\n                        || getInputStream().LA(1)==KW_FUNCTION\n                        || getInputStream().LA(1)==KW_IF\n                        || getInputStream().LA(1)==KW_ITEM\n                        || getInputStream().LA(1)==KW_MAP\n                        || getInputStream().LA(1)==KW_NAMESPACE_NODE\n                        || getInputStream().LA(1)==KW_NODE\n                        || getInputStream().LA(1)==KW_PROCESSING_INSTRUCTION\n                        || getInputStream().LA(1)==KW_SCHEMA_ATTRIBUTE\n                        || getInputStream().LA(1)==KW_SCHEMA_ELEMENT\n                        || getInputStream().LA(1)==KW_TEXT\n                        ) ");
			setState(628);
			eqname();
			setState(629);
			argumentlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public ArgumentplaceholderContext argumentplaceholder() {
			return getRuleContext(ArgumentplaceholderContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_argument);
		try {
			setState(633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				exprsingle();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				argumentplaceholder();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentplaceholderContext extends ParserRuleContext {
		public TerminalNode QM() { return getToken(XPath31Parser.QM, 0); }
		public ArgumentplaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentplaceholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArgumentplaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArgumentplaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArgumentplaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentplaceholderContext argumentplaceholder() throws RecognitionException {
		ArgumentplaceholderContext _localctx = new ArgumentplaceholderContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_argumentplaceholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			match(QM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionitemexprContext extends ParserRuleContext {
		public NamedfunctionrefContext namedfunctionref() {
			return getRuleContext(NamedfunctionrefContext.class,0);
		}
		public InlinefunctionexprContext inlinefunctionexpr() {
			return getRuleContext(InlinefunctionexprContext.class,0);
		}
		public FunctionitemexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionitemexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterFunctionitemexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitFunctionitemexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitFunctionitemexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionitemexprContext functionitemexpr() throws RecognitionException {
		FunctionitemexprContext _localctx = new FunctionitemexprContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_functionitemexpr);
		try {
			setState(639);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(637);
				namedfunctionref();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(638);
				inlinefunctionexpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedfunctionrefContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public TerminalNode POUND() { return getToken(XPath31Parser.POUND, 0); }
		public TerminalNode IntegerLiteral() { return getToken(XPath31Parser.IntegerLiteral, 0); }
		public NamedfunctionrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedfunctionref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterNamedfunctionref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitNamedfunctionref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitNamedfunctionref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedfunctionrefContext namedfunctionref() throws RecognitionException {
		NamedfunctionrefContext _localctx = new NamedfunctionrefContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_namedfunctionref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			eqname();
			setState(642);
			match(POUND);
			setState(643);
			match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlinefunctionexprContext extends ParserRuleContext {
		public TerminalNode KW_FUNCTION() { return getToken(XPath31Parser.KW_FUNCTION, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public FunctionbodyContext functionbody() {
			return getRuleContext(FunctionbodyContext.class,0);
		}
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public SequencetypeContext sequencetype() {
			return getRuleContext(SequencetypeContext.class,0);
		}
		public InlinefunctionexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlinefunctionexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterInlinefunctionexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitInlinefunctionexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitInlinefunctionexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlinefunctionexprContext inlinefunctionexpr() throws RecognitionException {
		InlinefunctionexprContext _localctx = new InlinefunctionexprContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_inlinefunctionexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			match(KW_FUNCTION);
			setState(646);
			match(OP);
			setState(648);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOLLAR) {
				{
				setState(647);
				paramlist();
				}
			}

			setState(650);
			match(CP);
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_AS) {
				{
				setState(651);
				match(KW_AS);
				setState(652);
				sequencetype();
				}
			}

			setState(655);
			functionbody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapconstructorContext extends ParserRuleContext {
		public TerminalNode KW_MAP() { return getToken(XPath31Parser.KW_MAP, 0); }
		public TerminalNode OC() { return getToken(XPath31Parser.OC, 0); }
		public TerminalNode CC() { return getToken(XPath31Parser.CC, 0); }
		public List<MapconstructorentryContext> mapconstructorentry() {
			return getRuleContexts(MapconstructorentryContext.class);
		}
		public MapconstructorentryContext mapconstructorentry(int i) {
			return getRuleContext(MapconstructorentryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public MapconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterMapconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitMapconstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitMapconstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapconstructorContext mapconstructor() throws RecognitionException {
		MapconstructorContext _localctx = new MapconstructorContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_mapconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(KW_MAP);
			setState(658);
			match(OC);
			setState(667);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(659);
				mapconstructorentry();
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(660);
					match(COMMA);
					setState(661);
					mapconstructorentry();
					}
					}
					setState(666);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(669);
			match(CC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapconstructorentryContext extends ParserRuleContext {
		public MapkeyexprContext mapkeyexpr() {
			return getRuleContext(MapkeyexprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(XPath31Parser.COLON, 0); }
		public MapvalueexprContext mapvalueexpr() {
			return getRuleContext(MapvalueexprContext.class,0);
		}
		public MapconstructorentryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapconstructorentry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterMapconstructorentry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitMapconstructorentry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitMapconstructorentry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapconstructorentryContext mapconstructorentry() throws RecognitionException {
		MapconstructorentryContext _localctx = new MapconstructorentryContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_mapconstructorentry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			mapkeyexpr();
			setState(672);
			match(COLON);
			setState(673);
			mapvalueexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapkeyexprContext extends ParserRuleContext {
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public MapkeyexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapkeyexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterMapkeyexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitMapkeyexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitMapkeyexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapkeyexprContext mapkeyexpr() throws RecognitionException {
		MapkeyexprContext _localctx = new MapkeyexprContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_mapkeyexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapvalueexprContext extends ParserRuleContext {
		public ExprsingleContext exprsingle() {
			return getRuleContext(ExprsingleContext.class,0);
		}
		public MapvalueexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapvalueexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterMapvalueexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitMapvalueexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitMapvalueexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapvalueexprContext mapvalueexpr() throws RecognitionException {
		MapvalueexprContext _localctx = new MapvalueexprContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_mapvalueexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			exprsingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayconstructorContext extends ParserRuleContext {
		public SquarearrayconstructorContext squarearrayconstructor() {
			return getRuleContext(SquarearrayconstructorContext.class,0);
		}
		public CurlyarrayconstructorContext curlyarrayconstructor() {
			return getRuleContext(CurlyarrayconstructorContext.class,0);
		}
		public ArrayconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArrayconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArrayconstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArrayconstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayconstructorContext arrayconstructor() throws RecognitionException {
		ArrayconstructorContext _localctx = new ArrayconstructorContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_arrayconstructor);
		try {
			setState(681);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OB:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				squarearrayconstructor();
				}
				break;
			case KW_ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
				curlyarrayconstructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SquarearrayconstructorContext extends ParserRuleContext {
		public TerminalNode OB() { return getToken(XPath31Parser.OB, 0); }
		public TerminalNode CB() { return getToken(XPath31Parser.CB, 0); }
		public List<ExprsingleContext> exprsingle() {
			return getRuleContexts(ExprsingleContext.class);
		}
		public ExprsingleContext exprsingle(int i) {
			return getRuleContext(ExprsingleContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public SquarearrayconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squarearrayconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSquarearrayconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSquarearrayconstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSquarearrayconstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquarearrayconstructorContext squarearrayconstructor() throws RecognitionException {
		SquarearrayconstructorContext _localctx = new SquarearrayconstructorContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_squarearrayconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			match(OB);
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(684);
				exprsingle();
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(685);
					match(COMMA);
					setState(686);
					exprsingle();
					}
					}
					setState(691);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(694);
			match(CB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CurlyarrayconstructorContext extends ParserRuleContext {
		public TerminalNode KW_ARRAY() { return getToken(XPath31Parser.KW_ARRAY, 0); }
		public EnclosedexprContext enclosedexpr() {
			return getRuleContext(EnclosedexprContext.class,0);
		}
		public CurlyarrayconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curlyarrayconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterCurlyarrayconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitCurlyarrayconstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitCurlyarrayconstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurlyarrayconstructorContext curlyarrayconstructor() throws RecognitionException {
		CurlyarrayconstructorContext _localctx = new CurlyarrayconstructorContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_curlyarrayconstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(KW_ARRAY);
			setState(697);
			enclosedexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnarylookupContext extends ParserRuleContext {
		public TerminalNode QM() { return getToken(XPath31Parser.QM, 0); }
		public KeyspecifierContext keyspecifier() {
			return getRuleContext(KeyspecifierContext.class,0);
		}
		public UnarylookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unarylookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterUnarylookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitUnarylookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitUnarylookup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnarylookupContext unarylookup() throws RecognitionException {
		UnarylookupContext _localctx = new UnarylookupContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_unarylookup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			match(QM);
			setState(700);
			keyspecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingletypeContext extends ParserRuleContext {
		public SimpletypenameContext simpletypename() {
			return getRuleContext(SimpletypenameContext.class,0);
		}
		public TerminalNode QM() { return getToken(XPath31Parser.QM, 0); }
		public SingletypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singletype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSingletype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSingletype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSingletype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingletypeContext singletype() throws RecognitionException {
		SingletypeContext _localctx = new SingletypeContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_singletype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			simpletypename();
			setState(704);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QM) {
				{
				setState(703);
				match(QM);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedeclarationContext extends ParserRuleContext {
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public SequencetypeContext sequencetype() {
			return getRuleContext(SequencetypeContext.class,0);
		}
		public TypedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTypedeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTypedeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTypedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedeclarationContext typedeclaration() throws RecognitionException {
		TypedeclarationContext _localctx = new TypedeclarationContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_typedeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(KW_AS);
			setState(707);
			sequencetype();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequencetypeContext extends ParserRuleContext {
		public TerminalNode KW_EMPTY_SEQUENCE() { return getToken(XPath31Parser.KW_EMPTY_SEQUENCE, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public ItemtypeContext itemtype() {
			return getRuleContext(ItemtypeContext.class,0);
		}
		public OccurrenceindicatorContext occurrenceindicator() {
			return getRuleContext(OccurrenceindicatorContext.class,0);
		}
		public SequencetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequencetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSequencetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSequencetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSequencetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequencetypeContext sequencetype() throws RecognitionException {
		SequencetypeContext _localctx = new SequencetypeContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_sequencetype);
		try {
			setState(716);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(709);
				match(KW_EMPTY_SEQUENCE);
				setState(710);
				match(OP);
				setState(711);
				match(CP);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(712);
				itemtype();
				setState(714);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(713);
					occurrenceindicator();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OccurrenceindicatorContext extends ParserRuleContext {
		public TerminalNode QM() { return getToken(XPath31Parser.QM, 0); }
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(XPath31Parser.PLUS, 0); }
		public OccurrenceindicatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_occurrenceindicator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterOccurrenceindicator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitOccurrenceindicator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitOccurrenceindicator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OccurrenceindicatorContext occurrenceindicator() throws RecognitionException {
		OccurrenceindicatorContext _localctx = new OccurrenceindicatorContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_occurrenceindicator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << QM) | (1L << STAR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemtypeContext extends ParserRuleContext {
		public KindtestContext kindtest() {
			return getRuleContext(KindtestContext.class,0);
		}
		public TerminalNode KW_ITEM() { return getToken(XPath31Parser.KW_ITEM, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public FunctiontestContext functiontest() {
			return getRuleContext(FunctiontestContext.class,0);
		}
		public MaptestContext maptest() {
			return getRuleContext(MaptestContext.class,0);
		}
		public ArraytestContext arraytest() {
			return getRuleContext(ArraytestContext.class,0);
		}
		public AtomicoruniontypeContext atomicoruniontype() {
			return getRuleContext(AtomicoruniontypeContext.class,0);
		}
		public ParenthesizeditemtypeContext parenthesizeditemtype() {
			return getRuleContext(ParenthesizeditemtypeContext.class,0);
		}
		public ItemtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterItemtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitItemtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitItemtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemtypeContext itemtype() throws RecognitionException {
		ItemtypeContext _localctx = new ItemtypeContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_itemtype);
		try {
			setState(729);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(720);
				kindtest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(721);
				match(KW_ITEM);
				setState(722);
				match(OP);
				setState(723);
				match(CP);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(724);
				functiontest();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(725);
				maptest();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(726);
				arraytest();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(727);
				atomicoruniontype();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(728);
				parenthesizeditemtype();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicoruniontypeContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public AtomicoruniontypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicoruniontype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAtomicoruniontype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAtomicoruniontype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAtomicoruniontype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicoruniontypeContext atomicoruniontype() throws RecognitionException {
		AtomicoruniontypeContext _localctx = new AtomicoruniontypeContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_atomicoruniontype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			eqname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KindtestContext extends ParserRuleContext {
		public DocumenttestContext documenttest() {
			return getRuleContext(DocumenttestContext.class,0);
		}
		public ElementtestContext elementtest() {
			return getRuleContext(ElementtestContext.class,0);
		}
		public AttributetestContext attributetest() {
			return getRuleContext(AttributetestContext.class,0);
		}
		public SchemaelementtestContext schemaelementtest() {
			return getRuleContext(SchemaelementtestContext.class,0);
		}
		public SchemaattributetestContext schemaattributetest() {
			return getRuleContext(SchemaattributetestContext.class,0);
		}
		public PitestContext pitest() {
			return getRuleContext(PitestContext.class,0);
		}
		public CommenttestContext commenttest() {
			return getRuleContext(CommenttestContext.class,0);
		}
		public TexttestContext texttest() {
			return getRuleContext(TexttestContext.class,0);
		}
		public NamespacenodetestContext namespacenodetest() {
			return getRuleContext(NamespacenodetestContext.class,0);
		}
		public AnykindtestContext anykindtest() {
			return getRuleContext(AnykindtestContext.class,0);
		}
		public KindtestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kindtest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterKindtest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitKindtest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitKindtest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KindtestContext kindtest() throws RecognitionException {
		KindtestContext _localctx = new KindtestContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_kindtest);
		try {
			setState(743);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_DOCUMENT_NODE:
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				documenttest();
				}
				break;
			case KW_ELEMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
				elementtest();
				}
				break;
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(735);
				attributetest();
				}
				break;
			case KW_SCHEMA_ELEMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(736);
				schemaelementtest();
				}
				break;
			case KW_SCHEMA_ATTRIBUTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(737);
				schemaattributetest();
				}
				break;
			case KW_PROCESSING_INSTRUCTION:
				enterOuterAlt(_localctx, 6);
				{
				setState(738);
				pitest();
				}
				break;
			case KW_COMMENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(739);
				commenttest();
				}
				break;
			case KW_TEXT:
				enterOuterAlt(_localctx, 8);
				{
				setState(740);
				texttest();
				}
				break;
			case KW_NAMESPACE_NODE:
				enterOuterAlt(_localctx, 9);
				{
				setState(741);
				namespacenodetest();
				}
				break;
			case KW_NODE:
				enterOuterAlt(_localctx, 10);
				{
				setState(742);
				anykindtest();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnykindtestContext extends ParserRuleContext {
		public TerminalNode KW_NODE() { return getToken(XPath31Parser.KW_NODE, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public AnykindtestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anykindtest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAnykindtest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAnykindtest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAnykindtest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnykindtestContext anykindtest() throws RecognitionException {
		AnykindtestContext _localctx = new AnykindtestContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_anykindtest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(KW_NODE);
			setState(746);
			match(OP);
			setState(747);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DocumenttestContext extends ParserRuleContext {
		public TerminalNode KW_DOCUMENT_NODE() { return getToken(XPath31Parser.KW_DOCUMENT_NODE, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public ElementtestContext elementtest() {
			return getRuleContext(ElementtestContext.class,0);
		}
		public SchemaelementtestContext schemaelementtest() {
			return getRuleContext(SchemaelementtestContext.class,0);
		}
		public DocumenttestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documenttest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterDocumenttest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitDocumenttest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitDocumenttest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumenttestContext documenttest() throws RecognitionException {
		DocumenttestContext _localctx = new DocumenttestContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_documenttest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			match(KW_DOCUMENT_NODE);
			setState(750);
			match(OP);
			setState(753);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELEMENT:
				{
				setState(751);
				elementtest();
				}
				break;
			case KW_SCHEMA_ELEMENT:
				{
				setState(752);
				schemaelementtest();
				}
				break;
			case CP:
				break;
			default:
				break;
			}
			setState(755);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TexttestContext extends ParserRuleContext {
		public TerminalNode KW_TEXT() { return getToken(XPath31Parser.KW_TEXT, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public TexttestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texttest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTexttest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTexttest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTexttest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TexttestContext texttest() throws RecognitionException {
		TexttestContext _localctx = new TexttestContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_texttest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			match(KW_TEXT);
			setState(758);
			match(OP);
			setState(759);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommenttestContext extends ParserRuleContext {
		public TerminalNode KW_COMMENT() { return getToken(XPath31Parser.KW_COMMENT, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public CommenttestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commenttest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterCommenttest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitCommenttest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitCommenttest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommenttestContext commenttest() throws RecognitionException {
		CommenttestContext _localctx = new CommenttestContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_commenttest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			match(KW_COMMENT);
			setState(762);
			match(OP);
			setState(763);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacenodetestContext extends ParserRuleContext {
		public TerminalNode KW_NAMESPACE_NODE() { return getToken(XPath31Parser.KW_NAMESPACE_NODE, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public NamespacenodetestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacenodetest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterNamespacenodetest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitNamespacenodetest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitNamespacenodetest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespacenodetestContext namespacenodetest() throws RecognitionException {
		NamespacenodetestContext _localctx = new NamespacenodetestContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_namespacenodetest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			match(KW_NAMESPACE_NODE);
			setState(766);
			match(OP);
			setState(767);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PitestContext extends ParserRuleContext {
		public TerminalNode KW_PROCESSING_INSTRUCTION() { return getToken(XPath31Parser.KW_PROCESSING_INSTRUCTION, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public TerminalNode NCName() { return getToken(XPath31Parser.NCName, 0); }
		public TerminalNode StringLiteral() { return getToken(XPath31Parser.StringLiteral, 0); }
		public PitestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pitest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterPitest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitPitest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitPitest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PitestContext pitest() throws RecognitionException {
		PitestContext _localctx = new PitestContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_pitest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			match(KW_PROCESSING_INSTRUCTION);
			setState(770);
			match(OP);
			setState(772);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==StringLiteral || _la==NCName) {
				{
				setState(771);
				_la = _input.LA(1);
				if ( !(_la==StringLiteral || _la==NCName) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(774);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributetestContext extends ParserRuleContext {
		public TerminalNode KW_ATTRIBUTE() { return getToken(XPath31Parser.KW_ATTRIBUTE, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public AttribnameorwildcardContext attribnameorwildcard() {
			return getRuleContext(AttribnameorwildcardContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(XPath31Parser.COMMA, 0); }
		public Typename_Context typename_() {
			return getRuleContext(Typename_Context.class,0);
		}
		public AttributetestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributetest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAttributetest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAttributetest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAttributetest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributetestContext attributetest() throws RecognitionException {
		AttributetestContext _localctx = new AttributetestContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_attributetest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			match(KW_ATTRIBUTE);
			setState(777);
			match(OP);
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << KW_ANCESTOR) | (1L << KW_ANCESTOR_OR_SELF) | (1L << KW_AND) | (1L << KW_ARRAY) | (1L << KW_AS) | (1L << KW_ATTRIBUTE) | (1L << KW_CAST) | (1L << KW_CASTABLE) | (1L << KW_CHILD) | (1L << KW_COMMENT) | (1L << KW_DESCENDANT) | (1L << KW_DESCENDANT_OR_SELF) | (1L << KW_DIV) | (1L << KW_DOCUMENT_NODE) | (1L << KW_ELEMENT) | (1L << KW_ELSE) | (1L << KW_EMPTY_SEQUENCE) | (1L << KW_EQ) | (1L << KW_EVERY) | (1L << KW_EXCEPT) | (1L << KW_FOLLOWING) | (1L << KW_FOLLOWING_SIBLING) | (1L << KW_FOR) | (1L << KW_FUNCTION) | (1L << KW_GE) | (1L << KW_GT) | (1L << KW_IDIV) | (1L << KW_IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_IN - 64)) | (1L << (KW_INSTANCE - 64)) | (1L << (KW_INTERSECT - 64)) | (1L << (KW_IS - 64)) | (1L << (KW_ITEM - 64)) | (1L << (KW_LE - 64)) | (1L << (KW_LET - 64)) | (1L << (KW_LT - 64)) | (1L << (KW_MAP - 64)) | (1L << (KW_MOD - 64)) | (1L << (KW_NAMESPACE - 64)) | (1L << (KW_NAMESPACE_NODE - 64)) | (1L << (KW_NE - 64)) | (1L << (KW_NODE - 64)) | (1L << (KW_OF - 64)) | (1L << (KW_OR - 64)) | (1L << (KW_PARENT - 64)) | (1L << (KW_PRECEDING - 64)) | (1L << (KW_PRECEDING_SIBLING - 64)) | (1L << (KW_PROCESSING_INSTRUCTION - 64)) | (1L << (KW_RETURN - 64)) | (1L << (KW_SATISFIES - 64)) | (1L << (KW_SCHEMA_ATTRIBUTE - 64)) | (1L << (KW_SCHEMA_ELEMENT - 64)) | (1L << (KW_SELF - 64)) | (1L << (KW_SOME - 64)) | (1L << (KW_TEXT - 64)) | (1L << (KW_THEN - 64)) | (1L << (KW_TREAT - 64)) | (1L << (KW_UNION - 64)) | (1L << (URIQualifiedName - 64)) | (1L << (QName - 64)))) != 0)) {
				{
				setState(778);
				attribnameorwildcard();
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(779);
					match(COMMA);
					setState(780);
					typename_();
					}
				}

				}
			}

			setState(785);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttribnameorwildcardContext extends ParserRuleContext {
		public AttributenameContext attributename() {
			return getRuleContext(AttributenameContext.class,0);
		}
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public AttribnameorwildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribnameorwildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAttribnameorwildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAttribnameorwildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAttribnameorwildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttribnameorwildcardContext attribnameorwildcard() throws RecognitionException {
		AttribnameorwildcardContext _localctx = new AttribnameorwildcardContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_attribnameorwildcard);
		try {
			setState(789);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ANCESTOR:
			case KW_ANCESTOR_OR_SELF:
			case KW_AND:
			case KW_ARRAY:
			case KW_AS:
			case KW_ATTRIBUTE:
			case KW_CAST:
			case KW_CASTABLE:
			case KW_CHILD:
			case KW_COMMENT:
			case KW_DESCENDANT:
			case KW_DESCENDANT_OR_SELF:
			case KW_DIV:
			case KW_DOCUMENT_NODE:
			case KW_ELEMENT:
			case KW_ELSE:
			case KW_EMPTY_SEQUENCE:
			case KW_EQ:
			case KW_EVERY:
			case KW_EXCEPT:
			case KW_FOLLOWING:
			case KW_FOLLOWING_SIBLING:
			case KW_FOR:
			case KW_FUNCTION:
			case KW_GE:
			case KW_GT:
			case KW_IDIV:
			case KW_IF:
			case KW_IN:
			case KW_INSTANCE:
			case KW_INTERSECT:
			case KW_IS:
			case KW_ITEM:
			case KW_LE:
			case KW_LET:
			case KW_LT:
			case KW_MAP:
			case KW_MOD:
			case KW_NAMESPACE:
			case KW_NAMESPACE_NODE:
			case KW_NE:
			case KW_NODE:
			case KW_OF:
			case KW_OR:
			case KW_PARENT:
			case KW_PRECEDING:
			case KW_PRECEDING_SIBLING:
			case KW_PROCESSING_INSTRUCTION:
			case KW_RETURN:
			case KW_SATISFIES:
			case KW_SCHEMA_ATTRIBUTE:
			case KW_SCHEMA_ELEMENT:
			case KW_SELF:
			case KW_SOME:
			case KW_TEXT:
			case KW_THEN:
			case KW_TREAT:
			case KW_UNION:
			case URIQualifiedName:
			case QName:
				enterOuterAlt(_localctx, 1);
				{
				setState(787);
				attributename();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(788);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SchemaattributetestContext extends ParserRuleContext {
		public TerminalNode KW_SCHEMA_ATTRIBUTE() { return getToken(XPath31Parser.KW_SCHEMA_ATTRIBUTE, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public AttributedeclarationContext attributedeclaration() {
			return getRuleContext(AttributedeclarationContext.class,0);
		}
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public SchemaattributetestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaattributetest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSchemaattributetest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSchemaattributetest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSchemaattributetest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaattributetestContext schemaattributetest() throws RecognitionException {
		SchemaattributetestContext _localctx = new SchemaattributetestContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_schemaattributetest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(KW_SCHEMA_ATTRIBUTE);
			setState(792);
			match(OP);
			setState(793);
			attributedeclaration();
			setState(794);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributedeclarationContext extends ParserRuleContext {
		public AttributenameContext attributename() {
			return getRuleContext(AttributenameContext.class,0);
		}
		public AttributedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributedeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAttributedeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAttributedeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAttributedeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributedeclarationContext attributedeclaration() throws RecognitionException {
		AttributedeclarationContext _localctx = new AttributedeclarationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_attributedeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			attributename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementtestContext extends ParserRuleContext {
		public TerminalNode KW_ELEMENT() { return getToken(XPath31Parser.KW_ELEMENT, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public ElementnameorwildcardContext elementnameorwildcard() {
			return getRuleContext(ElementnameorwildcardContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(XPath31Parser.COMMA, 0); }
		public Typename_Context typename_() {
			return getRuleContext(Typename_Context.class,0);
		}
		public TerminalNode QM() { return getToken(XPath31Parser.QM, 0); }
		public ElementtestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementtest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterElementtest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitElementtest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitElementtest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementtestContext elementtest() throws RecognitionException {
		ElementtestContext _localctx = new ElementtestContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_elementtest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			match(KW_ELEMENT);
			setState(799);
			match(OP);
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << KW_ANCESTOR) | (1L << KW_ANCESTOR_OR_SELF) | (1L << KW_AND) | (1L << KW_ARRAY) | (1L << KW_AS) | (1L << KW_ATTRIBUTE) | (1L << KW_CAST) | (1L << KW_CASTABLE) | (1L << KW_CHILD) | (1L << KW_COMMENT) | (1L << KW_DESCENDANT) | (1L << KW_DESCENDANT_OR_SELF) | (1L << KW_DIV) | (1L << KW_DOCUMENT_NODE) | (1L << KW_ELEMENT) | (1L << KW_ELSE) | (1L << KW_EMPTY_SEQUENCE) | (1L << KW_EQ) | (1L << KW_EVERY) | (1L << KW_EXCEPT) | (1L << KW_FOLLOWING) | (1L << KW_FOLLOWING_SIBLING) | (1L << KW_FOR) | (1L << KW_FUNCTION) | (1L << KW_GE) | (1L << KW_GT) | (1L << KW_IDIV) | (1L << KW_IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_IN - 64)) | (1L << (KW_INSTANCE - 64)) | (1L << (KW_INTERSECT - 64)) | (1L << (KW_IS - 64)) | (1L << (KW_ITEM - 64)) | (1L << (KW_LE - 64)) | (1L << (KW_LET - 64)) | (1L << (KW_LT - 64)) | (1L << (KW_MAP - 64)) | (1L << (KW_MOD - 64)) | (1L << (KW_NAMESPACE - 64)) | (1L << (KW_NAMESPACE_NODE - 64)) | (1L << (KW_NE - 64)) | (1L << (KW_NODE - 64)) | (1L << (KW_OF - 64)) | (1L << (KW_OR - 64)) | (1L << (KW_PARENT - 64)) | (1L << (KW_PRECEDING - 64)) | (1L << (KW_PRECEDING_SIBLING - 64)) | (1L << (KW_PROCESSING_INSTRUCTION - 64)) | (1L << (KW_RETURN - 64)) | (1L << (KW_SATISFIES - 64)) | (1L << (KW_SCHEMA_ATTRIBUTE - 64)) | (1L << (KW_SCHEMA_ELEMENT - 64)) | (1L << (KW_SELF - 64)) | (1L << (KW_SOME - 64)) | (1L << (KW_TEXT - 64)) | (1L << (KW_THEN - 64)) | (1L << (KW_TREAT - 64)) | (1L << (KW_UNION - 64)) | (1L << (URIQualifiedName - 64)) | (1L << (QName - 64)))) != 0)) {
				{
				setState(800);
				elementnameorwildcard();
				setState(806);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(801);
					match(COMMA);
					setState(802);
					typename_();
					setState(804);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==QM) {
						{
						setState(803);
						match(QM);
						}
					}

					}
				}

				}
			}

			setState(810);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementnameorwildcardContext extends ParserRuleContext {
		public ElementnameContext elementname() {
			return getRuleContext(ElementnameContext.class,0);
		}
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public ElementnameorwildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementnameorwildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterElementnameorwildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitElementnameorwildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitElementnameorwildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementnameorwildcardContext elementnameorwildcard() throws RecognitionException {
		ElementnameorwildcardContext _localctx = new ElementnameorwildcardContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_elementnameorwildcard);
		try {
			setState(814);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ANCESTOR:
			case KW_ANCESTOR_OR_SELF:
			case KW_AND:
			case KW_ARRAY:
			case KW_AS:
			case KW_ATTRIBUTE:
			case KW_CAST:
			case KW_CASTABLE:
			case KW_CHILD:
			case KW_COMMENT:
			case KW_DESCENDANT:
			case KW_DESCENDANT_OR_SELF:
			case KW_DIV:
			case KW_DOCUMENT_NODE:
			case KW_ELEMENT:
			case KW_ELSE:
			case KW_EMPTY_SEQUENCE:
			case KW_EQ:
			case KW_EVERY:
			case KW_EXCEPT:
			case KW_FOLLOWING:
			case KW_FOLLOWING_SIBLING:
			case KW_FOR:
			case KW_FUNCTION:
			case KW_GE:
			case KW_GT:
			case KW_IDIV:
			case KW_IF:
			case KW_IN:
			case KW_INSTANCE:
			case KW_INTERSECT:
			case KW_IS:
			case KW_ITEM:
			case KW_LE:
			case KW_LET:
			case KW_LT:
			case KW_MAP:
			case KW_MOD:
			case KW_NAMESPACE:
			case KW_NAMESPACE_NODE:
			case KW_NE:
			case KW_NODE:
			case KW_OF:
			case KW_OR:
			case KW_PARENT:
			case KW_PRECEDING:
			case KW_PRECEDING_SIBLING:
			case KW_PROCESSING_INSTRUCTION:
			case KW_RETURN:
			case KW_SATISFIES:
			case KW_SCHEMA_ATTRIBUTE:
			case KW_SCHEMA_ELEMENT:
			case KW_SELF:
			case KW_SOME:
			case KW_TEXT:
			case KW_THEN:
			case KW_TREAT:
			case KW_UNION:
			case URIQualifiedName:
			case QName:
				enterOuterAlt(_localctx, 1);
				{
				setState(812);
				elementname();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(813);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SchemaelementtestContext extends ParserRuleContext {
		public TerminalNode KW_SCHEMA_ELEMENT() { return getToken(XPath31Parser.KW_SCHEMA_ELEMENT, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public ElementdeclarationContext elementdeclaration() {
			return getRuleContext(ElementdeclarationContext.class,0);
		}
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public SchemaelementtestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaelementtest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSchemaelementtest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSchemaelementtest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSchemaelementtest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaelementtestContext schemaelementtest() throws RecognitionException {
		SchemaelementtestContext _localctx = new SchemaelementtestContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_schemaelementtest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			match(KW_SCHEMA_ELEMENT);
			setState(817);
			match(OP);
			setState(818);
			elementdeclaration();
			setState(819);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementdeclarationContext extends ParserRuleContext {
		public ElementnameContext elementname() {
			return getRuleContext(ElementnameContext.class,0);
		}
		public ElementdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterElementdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitElementdeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitElementdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementdeclarationContext elementdeclaration() throws RecognitionException {
		ElementdeclarationContext _localctx = new ElementdeclarationContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_elementdeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			elementname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributenameContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public AttributenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAttributename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAttributename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAttributename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenameContext attributename() throws RecognitionException {
		AttributenameContext _localctx = new AttributenameContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_attributename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			eqname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementnameContext extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public ElementnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterElementname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitElementname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitElementname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementnameContext elementname() throws RecognitionException {
		ElementnameContext _localctx = new ElementnameContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_elementname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			eqname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpletypenameContext extends ParserRuleContext {
		public Typename_Context typename_() {
			return getRuleContext(Typename_Context.class,0);
		}
		public SimpletypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpletypename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterSimpletypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitSimpletypename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitSimpletypename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpletypenameContext simpletypename() throws RecognitionException {
		SimpletypenameContext _localctx = new SimpletypenameContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_simpletypename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			typename_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Typename_Context extends ParserRuleContext {
		public EqnameContext eqname() {
			return getRuleContext(EqnameContext.class,0);
		}
		public Typename_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTypename_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTypename_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTypename_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typename_Context typename_() throws RecognitionException {
		Typename_Context _localctx = new Typename_Context(_ctx, getState());
		enterRule(_localctx, 200, RULE_typename_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			eqname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiontestContext extends ParserRuleContext {
		public AnyfunctiontestContext anyfunctiontest() {
			return getRuleContext(AnyfunctiontestContext.class,0);
		}
		public TypedfunctiontestContext typedfunctiontest() {
			return getRuleContext(TypedfunctiontestContext.class,0);
		}
		public FunctiontestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiontest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterFunctiontest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitFunctiontest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitFunctiontest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiontestContext functiontest() throws RecognitionException {
		FunctiontestContext _localctx = new FunctiontestContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_functiontest);
		try {
			setState(833);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(831);
				anyfunctiontest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(832);
				typedfunctiontest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyfunctiontestContext extends ParserRuleContext {
		public TerminalNode KW_FUNCTION() { return getToken(XPath31Parser.KW_FUNCTION, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public AnyfunctiontestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyfunctiontest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAnyfunctiontest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAnyfunctiontest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAnyfunctiontest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyfunctiontestContext anyfunctiontest() throws RecognitionException {
		AnyfunctiontestContext _localctx = new AnyfunctiontestContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_anyfunctiontest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			match(KW_FUNCTION);
			setState(836);
			match(OP);
			setState(837);
			match(STAR);
			setState(838);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedfunctiontestContext extends ParserRuleContext {
		public TerminalNode KW_FUNCTION() { return getToken(XPath31Parser.KW_FUNCTION, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public List<SequencetypeContext> sequencetype() {
			return getRuleContexts(SequencetypeContext.class);
		}
		public SequencetypeContext sequencetype(int i) {
			return getRuleContext(SequencetypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XPath31Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XPath31Parser.COMMA, i);
		}
		public TypedfunctiontestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedfunctiontest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTypedfunctiontest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTypedfunctiontest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTypedfunctiontest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedfunctiontestContext typedfunctiontest() throws RecognitionException {
		TypedfunctiontestContext _localctx = new TypedfunctiontestContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_typedfunctiontest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			match(KW_FUNCTION);
			setState(841);
			match(OP);
			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP) | (1L << KW_ANCESTOR) | (1L << KW_ANCESTOR_OR_SELF) | (1L << KW_AND) | (1L << KW_ARRAY) | (1L << KW_AS) | (1L << KW_ATTRIBUTE) | (1L << KW_CAST) | (1L << KW_CASTABLE) | (1L << KW_CHILD) | (1L << KW_COMMENT) | (1L << KW_DESCENDANT) | (1L << KW_DESCENDANT_OR_SELF) | (1L << KW_DIV) | (1L << KW_DOCUMENT_NODE) | (1L << KW_ELEMENT) | (1L << KW_ELSE) | (1L << KW_EMPTY_SEQUENCE) | (1L << KW_EQ) | (1L << KW_EVERY) | (1L << KW_EXCEPT) | (1L << KW_FOLLOWING) | (1L << KW_FOLLOWING_SIBLING) | (1L << KW_FOR) | (1L << KW_FUNCTION) | (1L << KW_GE) | (1L << KW_GT) | (1L << KW_IDIV) | (1L << KW_IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_IN - 64)) | (1L << (KW_INSTANCE - 64)) | (1L << (KW_INTERSECT - 64)) | (1L << (KW_IS - 64)) | (1L << (KW_ITEM - 64)) | (1L << (KW_LE - 64)) | (1L << (KW_LET - 64)) | (1L << (KW_LT - 64)) | (1L << (KW_MAP - 64)) | (1L << (KW_MOD - 64)) | (1L << (KW_NAMESPACE - 64)) | (1L << (KW_NAMESPACE_NODE - 64)) | (1L << (KW_NE - 64)) | (1L << (KW_NODE - 64)) | (1L << (KW_OF - 64)) | (1L << (KW_OR - 64)) | (1L << (KW_PARENT - 64)) | (1L << (KW_PRECEDING - 64)) | (1L << (KW_PRECEDING_SIBLING - 64)) | (1L << (KW_PROCESSING_INSTRUCTION - 64)) | (1L << (KW_RETURN - 64)) | (1L << (KW_SATISFIES - 64)) | (1L << (KW_SCHEMA_ATTRIBUTE - 64)) | (1L << (KW_SCHEMA_ELEMENT - 64)) | (1L << (KW_SELF - 64)) | (1L << (KW_SOME - 64)) | (1L << (KW_TEXT - 64)) | (1L << (KW_THEN - 64)) | (1L << (KW_TREAT - 64)) | (1L << (KW_UNION - 64)) | (1L << (URIQualifiedName - 64)) | (1L << (QName - 64)))) != 0)) {
				{
				setState(842);
				sequencetype();
				setState(847);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(843);
					match(COMMA);
					setState(844);
					sequencetype();
					}
					}
					setState(849);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(852);
			match(CP);
			setState(853);
			match(KW_AS);
			setState(854);
			sequencetype();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaptestContext extends ParserRuleContext {
		public AnymaptestContext anymaptest() {
			return getRuleContext(AnymaptestContext.class,0);
		}
		public TypedmaptestContext typedmaptest() {
			return getRuleContext(TypedmaptestContext.class,0);
		}
		public MaptestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maptest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterMaptest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitMaptest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitMaptest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaptestContext maptest() throws RecognitionException {
		MaptestContext _localctx = new MaptestContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_maptest);
		try {
			setState(858);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(856);
				anymaptest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(857);
				typedmaptest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnymaptestContext extends ParserRuleContext {
		public TerminalNode KW_MAP() { return getToken(XPath31Parser.KW_MAP, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public AnymaptestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anymaptest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAnymaptest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAnymaptest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAnymaptest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnymaptestContext anymaptest() throws RecognitionException {
		AnymaptestContext _localctx = new AnymaptestContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_anymaptest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			match(KW_MAP);
			setState(861);
			match(OP);
			setState(862);
			match(STAR);
			setState(863);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedmaptestContext extends ParserRuleContext {
		public TerminalNode KW_MAP() { return getToken(XPath31Parser.KW_MAP, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public AtomicoruniontypeContext atomicoruniontype() {
			return getRuleContext(AtomicoruniontypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(XPath31Parser.COMMA, 0); }
		public SequencetypeContext sequencetype() {
			return getRuleContext(SequencetypeContext.class,0);
		}
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public TypedmaptestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedmaptest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTypedmaptest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTypedmaptest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTypedmaptest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedmaptestContext typedmaptest() throws RecognitionException {
		TypedmaptestContext _localctx = new TypedmaptestContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_typedmaptest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(865);
			match(KW_MAP);
			setState(866);
			match(OP);
			setState(867);
			atomicoruniontype();
			setState(868);
			match(COMMA);
			setState(869);
			sequencetype();
			setState(870);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArraytestContext extends ParserRuleContext {
		public AnyarraytestContext anyarraytest() {
			return getRuleContext(AnyarraytestContext.class,0);
		}
		public TypedarraytestContext typedarraytest() {
			return getRuleContext(TypedarraytestContext.class,0);
		}
		public ArraytestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterArraytest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitArraytest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitArraytest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraytestContext arraytest() throws RecognitionException {
		ArraytestContext _localctx = new ArraytestContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_arraytest);
		try {
			setState(874);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(872);
				anyarraytest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(873);
				typedarraytest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyarraytestContext extends ParserRuleContext {
		public TerminalNode KW_ARRAY() { return getToken(XPath31Parser.KW_ARRAY, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public TerminalNode STAR() { return getToken(XPath31Parser.STAR, 0); }
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public AnyarraytestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyarraytest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAnyarraytest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAnyarraytest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAnyarraytest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyarraytestContext anyarraytest() throws RecognitionException {
		AnyarraytestContext _localctx = new AnyarraytestContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_anyarraytest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			match(KW_ARRAY);
			setState(877);
			match(OP);
			setState(878);
			match(STAR);
			setState(879);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedarraytestContext extends ParserRuleContext {
		public TerminalNode KW_ARRAY() { return getToken(XPath31Parser.KW_ARRAY, 0); }
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public SequencetypeContext sequencetype() {
			return getRuleContext(SequencetypeContext.class,0);
		}
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public TypedarraytestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedarraytest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterTypedarraytest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitTypedarraytest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitTypedarraytest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedarraytestContext typedarraytest() throws RecognitionException {
		TypedarraytestContext _localctx = new TypedarraytestContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_typedarraytest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			match(KW_ARRAY);
			setState(882);
			match(OP);
			setState(883);
			sequencetype();
			setState(884);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenthesizeditemtypeContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(XPath31Parser.OP, 0); }
		public ItemtypeContext itemtype() {
			return getRuleContext(ItemtypeContext.class,0);
		}
		public TerminalNode CP() { return getToken(XPath31Parser.CP, 0); }
		public ParenthesizeditemtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizeditemtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterParenthesizeditemtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitParenthesizeditemtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitParenthesizeditemtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizeditemtypeContext parenthesizeditemtype() throws RecognitionException {
		ParenthesizeditemtypeContext _localctx = new ParenthesizeditemtypeContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_parenthesizeditemtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			match(OP);
			setState(887);
			itemtype();
			setState(888);
			match(CP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqnameContext extends ParserRuleContext {
		public TerminalNode QName() { return getToken(XPath31Parser.QName, 0); }
		public TerminalNode URIQualifiedName() { return getToken(XPath31Parser.URIQualifiedName, 0); }
		public TerminalNode KW_ANCESTOR() { return getToken(XPath31Parser.KW_ANCESTOR, 0); }
		public TerminalNode KW_ANCESTOR_OR_SELF() { return getToken(XPath31Parser.KW_ANCESTOR_OR_SELF, 0); }
		public TerminalNode KW_AND() { return getToken(XPath31Parser.KW_AND, 0); }
		public TerminalNode KW_ARRAY() { return getToken(XPath31Parser.KW_ARRAY, 0); }
		public TerminalNode KW_AS() { return getToken(XPath31Parser.KW_AS, 0); }
		public TerminalNode KW_ATTRIBUTE() { return getToken(XPath31Parser.KW_ATTRIBUTE, 0); }
		public TerminalNode KW_CAST() { return getToken(XPath31Parser.KW_CAST, 0); }
		public TerminalNode KW_CASTABLE() { return getToken(XPath31Parser.KW_CASTABLE, 0); }
		public TerminalNode KW_CHILD() { return getToken(XPath31Parser.KW_CHILD, 0); }
		public TerminalNode KW_COMMENT() { return getToken(XPath31Parser.KW_COMMENT, 0); }
		public TerminalNode KW_DESCENDANT() { return getToken(XPath31Parser.KW_DESCENDANT, 0); }
		public TerminalNode KW_DESCENDANT_OR_SELF() { return getToken(XPath31Parser.KW_DESCENDANT_OR_SELF, 0); }
		public TerminalNode KW_DIV() { return getToken(XPath31Parser.KW_DIV, 0); }
		public TerminalNode KW_DOCUMENT_NODE() { return getToken(XPath31Parser.KW_DOCUMENT_NODE, 0); }
		public TerminalNode KW_ELEMENT() { return getToken(XPath31Parser.KW_ELEMENT, 0); }
		public TerminalNode KW_ELSE() { return getToken(XPath31Parser.KW_ELSE, 0); }
		public TerminalNode KW_EMPTY_SEQUENCE() { return getToken(XPath31Parser.KW_EMPTY_SEQUENCE, 0); }
		public TerminalNode KW_EQ() { return getToken(XPath31Parser.KW_EQ, 0); }
		public TerminalNode KW_EVERY() { return getToken(XPath31Parser.KW_EVERY, 0); }
		public TerminalNode KW_EXCEPT() { return getToken(XPath31Parser.KW_EXCEPT, 0); }
		public TerminalNode KW_FOLLOWING() { return getToken(XPath31Parser.KW_FOLLOWING, 0); }
		public TerminalNode KW_FOLLOWING_SIBLING() { return getToken(XPath31Parser.KW_FOLLOWING_SIBLING, 0); }
		public TerminalNode KW_FOR() { return getToken(XPath31Parser.KW_FOR, 0); }
		public TerminalNode KW_FUNCTION() { return getToken(XPath31Parser.KW_FUNCTION, 0); }
		public TerminalNode KW_GE() { return getToken(XPath31Parser.KW_GE, 0); }
		public TerminalNode KW_GT() { return getToken(XPath31Parser.KW_GT, 0); }
		public TerminalNode KW_IDIV() { return getToken(XPath31Parser.KW_IDIV, 0); }
		public TerminalNode KW_IF() { return getToken(XPath31Parser.KW_IF, 0); }
		public TerminalNode KW_IN() { return getToken(XPath31Parser.KW_IN, 0); }
		public TerminalNode KW_INSTANCE() { return getToken(XPath31Parser.KW_INSTANCE, 0); }
		public TerminalNode KW_INTERSECT() { return getToken(XPath31Parser.KW_INTERSECT, 0); }
		public TerminalNode KW_IS() { return getToken(XPath31Parser.KW_IS, 0); }
		public TerminalNode KW_ITEM() { return getToken(XPath31Parser.KW_ITEM, 0); }
		public TerminalNode KW_LE() { return getToken(XPath31Parser.KW_LE, 0); }
		public TerminalNode KW_LET() { return getToken(XPath31Parser.KW_LET, 0); }
		public TerminalNode KW_LT() { return getToken(XPath31Parser.KW_LT, 0); }
		public TerminalNode KW_MAP() { return getToken(XPath31Parser.KW_MAP, 0); }
		public TerminalNode KW_MOD() { return getToken(XPath31Parser.KW_MOD, 0); }
		public TerminalNode KW_NAMESPACE() { return getToken(XPath31Parser.KW_NAMESPACE, 0); }
		public TerminalNode KW_NAMESPACE_NODE() { return getToken(XPath31Parser.KW_NAMESPACE_NODE, 0); }
		public TerminalNode KW_NE() { return getToken(XPath31Parser.KW_NE, 0); }
		public TerminalNode KW_NODE() { return getToken(XPath31Parser.KW_NODE, 0); }
		public TerminalNode KW_OF() { return getToken(XPath31Parser.KW_OF, 0); }
		public TerminalNode KW_OR() { return getToken(XPath31Parser.KW_OR, 0); }
		public TerminalNode KW_PARENT() { return getToken(XPath31Parser.KW_PARENT, 0); }
		public TerminalNode KW_PRECEDING() { return getToken(XPath31Parser.KW_PRECEDING, 0); }
		public TerminalNode KW_PRECEDING_SIBLING() { return getToken(XPath31Parser.KW_PRECEDING_SIBLING, 0); }
		public TerminalNode KW_PROCESSING_INSTRUCTION() { return getToken(XPath31Parser.KW_PROCESSING_INSTRUCTION, 0); }
		public TerminalNode KW_RETURN() { return getToken(XPath31Parser.KW_RETURN, 0); }
		public TerminalNode KW_SATISFIES() { return getToken(XPath31Parser.KW_SATISFIES, 0); }
		public TerminalNode KW_SCHEMA_ATTRIBUTE() { return getToken(XPath31Parser.KW_SCHEMA_ATTRIBUTE, 0); }
		public TerminalNode KW_SCHEMA_ELEMENT() { return getToken(XPath31Parser.KW_SCHEMA_ELEMENT, 0); }
		public TerminalNode KW_SELF() { return getToken(XPath31Parser.KW_SELF, 0); }
		public TerminalNode KW_SOME() { return getToken(XPath31Parser.KW_SOME, 0); }
		public TerminalNode KW_TEXT() { return getToken(XPath31Parser.KW_TEXT, 0); }
		public TerminalNode KW_THEN() { return getToken(XPath31Parser.KW_THEN, 0); }
		public TerminalNode KW_TREAT() { return getToken(XPath31Parser.KW_TREAT, 0); }
		public TerminalNode KW_UNION() { return getToken(XPath31Parser.KW_UNION, 0); }
		public EqnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterEqname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitEqname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitEqname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqnameContext eqname() throws RecognitionException {
		EqnameContext _localctx = new EqnameContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_eqname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ANCESTOR) | (1L << KW_ANCESTOR_OR_SELF) | (1L << KW_AND) | (1L << KW_ARRAY) | (1L << KW_AS) | (1L << KW_ATTRIBUTE) | (1L << KW_CAST) | (1L << KW_CASTABLE) | (1L << KW_CHILD) | (1L << KW_COMMENT) | (1L << KW_DESCENDANT) | (1L << KW_DESCENDANT_OR_SELF) | (1L << KW_DIV) | (1L << KW_DOCUMENT_NODE) | (1L << KW_ELEMENT) | (1L << KW_ELSE) | (1L << KW_EMPTY_SEQUENCE) | (1L << KW_EQ) | (1L << KW_EVERY) | (1L << KW_EXCEPT) | (1L << KW_FOLLOWING) | (1L << KW_FOLLOWING_SIBLING) | (1L << KW_FOR) | (1L << KW_FUNCTION) | (1L << KW_GE) | (1L << KW_GT) | (1L << KW_IDIV) | (1L << KW_IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_IN - 64)) | (1L << (KW_INSTANCE - 64)) | (1L << (KW_INTERSECT - 64)) | (1L << (KW_IS - 64)) | (1L << (KW_ITEM - 64)) | (1L << (KW_LE - 64)) | (1L << (KW_LET - 64)) | (1L << (KW_LT - 64)) | (1L << (KW_MAP - 64)) | (1L << (KW_MOD - 64)) | (1L << (KW_NAMESPACE - 64)) | (1L << (KW_NAMESPACE_NODE - 64)) | (1L << (KW_NE - 64)) | (1L << (KW_NODE - 64)) | (1L << (KW_OF - 64)) | (1L << (KW_OR - 64)) | (1L << (KW_PARENT - 64)) | (1L << (KW_PRECEDING - 64)) | (1L << (KW_PRECEDING_SIBLING - 64)) | (1L << (KW_PROCESSING_INSTRUCTION - 64)) | (1L << (KW_RETURN - 64)) | (1L << (KW_SATISFIES - 64)) | (1L << (KW_SCHEMA_ATTRIBUTE - 64)) | (1L << (KW_SCHEMA_ELEMENT - 64)) | (1L << (KW_SELF - 64)) | (1L << (KW_SOME - 64)) | (1L << (KW_TEXT - 64)) | (1L << (KW_THEN - 64)) | (1L << (KW_TREAT - 64)) | (1L << (KW_UNION - 64)) | (1L << (URIQualifiedName - 64)) | (1L << (QName - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuxilaryContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(XPath31Parser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(XPath31Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(XPath31Parser.SEMI, i);
		}
		public AuxilaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auxilary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).enterAuxilary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPath31Listener ) ((XPath31Listener)listener).exitAuxilary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPath31Visitor ) return ((XPath31Visitor<? extends T>)visitor).visitAuxilary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AuxilaryContext auxilary() throws RecognitionException {
		AuxilaryContext _localctx = new AuxilaryContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_auxilary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(895); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(892);
					expr();
					setState(893);
					match(SEMI);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(897); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(899);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 62:
			return functioncall_sempred((FunctioncallContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean functioncall_sempred(FunctioncallContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  !(
		                           getInputStream().LA(1)==KW_ARRAY
		                        || getInputStream().LA(1)==KW_ATTRIBUTE
		                        || getInputStream().LA(1)==KW_COMMENT
		                        || getInputStream().LA(1)==KW_DOCUMENT_NODE
		                        || getInputStream().LA(1)==KW_ELEMENT
		                        || getInputStream().LA(1)==KW_EMPTY_SEQUENCE
		                        || getInputStream().LA(1)==KW_FUNCTION
		                        || getInputStream().LA(1)==KW_IF
		                        || getInputStream().LA(1)==KW_ITEM
		                        || getInputStream().LA(1)==KW_MAP
		                        || getInputStream().LA(1)==KW_NAMESPACE_NODE
		                        || getInputStream().LA(1)==KW_NODE
		                        || getInputStream().LA(1)==KW_PROCESSING_INSTRUCTION
		                        || getInputStream().LA(1)==KW_SCHEMA_ATTRIBUTE
		                        || getInputStream().LA(1)==KW_SCHEMA_ELEMENT
		                        || getInputStream().LA(1)==KW_TEXT
		                        ) ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3k\u0388\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\3\2\3\2\3\2\3\3\3\3\3\3\7"+
		"\3\u00eb\n\3\f\3\16\3\u00ee\13\3\3\4\3\4\3\4\5\4\u00f3\n\4\3\5\3\5\3\6"+
		"\3\6\5\6\u00f9\n\6\3\6\3\6\3\7\3\7\3\7\7\7\u0100\n\7\f\7\16\7\u0103\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\5\b\u010a\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7"+
		"\n\u0114\n\n\f\n\16\n\u0117\13\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\7\r\u0126\n\r\f\r\16\r\u0129\13\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u013b\n\17\f\17\16\17\u013e\13\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u014f\n\21\f\21\16\21\u0152"+
		"\13\21\3\22\3\22\3\22\7\22\u0157\n\22\f\22\16\22\u015a\13\22\3\23\3\23"+
		"\3\23\3\23\5\23\u0160\n\23\3\23\3\23\5\23\u0164\n\23\3\24\3\24\3\24\7"+
		"\24\u0169\n\24\f\24\16\24\u016c\13\24\3\25\3\25\3\25\5\25\u0171\n\25\3"+
		"\26\3\26\3\26\7\26\u0176\n\26\f\26\16\26\u0179\13\26\3\27\3\27\3\27\7"+
		"\27\u017e\n\27\f\27\16\27\u0181\13\27\3\30\3\30\3\30\7\30\u0186\n\30\f"+
		"\30\16\30\u0189\13\30\3\31\3\31\3\31\7\31\u018e\n\31\f\31\16\31\u0191"+
		"\13\31\3\32\3\32\3\32\3\32\5\32\u0197\n\32\3\33\3\33\3\33\3\33\5\33\u019d"+
		"\n\33\3\34\3\34\3\34\3\34\5\34\u01a3\n\34\3\35\3\35\3\35\3\35\5\35\u01a9"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\7\36\u01b0\n\36\f\36\16\36\u01b3\13\36"+
		"\3\37\7\37\u01b6\n\37\f\37\16\37\u01b9\13\37\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3$\7$\u01c8\n$\f$\16$\u01cb\13$\3%\3%\5%\u01cf\n%\3%"+
		"\3%\3%\5%\u01d4\n%\3&\3&\3&\7&\u01d9\n&\f&\16&\u01dc\13&\3\'\3\'\5\'\u01e0"+
		"\n\'\3(\3(\5(\u01e4\n(\3(\3(\3)\3)\3)\3)\5)\u01ec\n)\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01fe\n*\3+\5+\u0201\n+\3+\3+\3,\3"+
		",\3,\3,\5,\u0209\n,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0215\n-\3.\3.\3"+
		"/\3/\5/\u021b\n/\3\60\3\60\5\60\u021f\n\60\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\5\61\u0228\n\61\3\62\3\62\3\62\3\62\7\62\u022e\n\62\f\62\16\62"+
		"\u0231\13\62\3\63\3\63\3\63\3\63\7\63\u0237\n\63\f\63\16\63\u023a\13\63"+
		"\5\63\u023c\n\63\3\63\3\63\3\64\7\64\u0241\n\64\f\64\16\64\u0244\13\64"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\5\67\u0251\n\67"+
		"\38\38\38\58\u0256\n8\39\39\39\39\39\39\39\39\39\59\u0261\n9\3:\3:\5:"+
		"\u0265\n:\3;\3;\3<\3<\3<\3=\3=\3>\3>\5>\u0270\n>\3>\3>\3?\3?\3@\3@\3@"+
		"\3@\3A\3A\5A\u027c\nA\3B\3B\3C\3C\5C\u0282\nC\3D\3D\3D\3D\3E\3E\3E\5E"+
		"\u028b\nE\3E\3E\3E\5E\u0290\nE\3E\3E\3F\3F\3F\3F\3F\7F\u0299\nF\fF\16"+
		"F\u029c\13F\5F\u029e\nF\3F\3F\3G\3G\3G\3G\3H\3H\3I\3I\3J\3J\5J\u02ac\n"+
		"J\3K\3K\3K\3K\7K\u02b2\nK\fK\16K\u02b5\13K\5K\u02b7\nK\3K\3K\3L\3L\3L"+
		"\3M\3M\3M\3N\3N\5N\u02c3\nN\3O\3O\3O\3P\3P\3P\3P\3P\5P\u02cd\nP\5P\u02cf"+
		"\nP\3Q\3Q\3R\3R\3R\3R\3R\3R\3R\3R\3R\5R\u02dc\nR\3S\3S\3T\3T\3T\3T\3T"+
		"\3T\3T\3T\3T\3T\5T\u02ea\nT\3U\3U\3U\3U\3V\3V\3V\3V\5V\u02f4\nV\3V\3V"+
		"\3W\3W\3W\3W\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Z\3Z\3Z\5Z\u0307\nZ\3Z\3Z\3[\3["+
		"\3[\3[\3[\5[\u0310\n[\5[\u0312\n[\3[\3[\3\\\3\\\5\\\u0318\n\\\3]\3]\3"+
		"]\3]\3]\3^\3^\3_\3_\3_\3_\3_\3_\5_\u0327\n_\5_\u0329\n_\5_\u032b\n_\3"+
		"_\3_\3`\3`\5`\u0331\n`\3a\3a\3a\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3"+
		"g\3g\5g\u0344\ng\3h\3h\3h\3h\3h\3i\3i\3i\3i\3i\7i\u0350\ni\fi\16i\u0353"+
		"\13i\5i\u0355\ni\3i\3i\3i\3i\3j\3j\5j\u035d\nj\3k\3k\3k\3k\3k\3l\3l\3"+
		"l\3l\3l\3l\3l\3m\3m\5m\u036d\nm\3n\3n\3n\3n\3n\3o\3o\3o\3o\3o\3p\3p\3"+
		"p\3p\3q\3q\3r\3r\3r\6r\u0382\nr\rr\16r\u0383\3r\3r\3r\2\2s\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^"+
		"`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0"+
		"\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8"+
		"\u00da\u00dc\u00de\u00e0\u00e2\2\17\4\288[[\4\2\30\30\36\36\6\2%%\62\62"+
		"@@KK\4\2\35\35``\4\299DD\6\2\21\22\24\25\27\27\31\31\7\2\67\67>?GGIIN"+
		"N\5\2\23\23\26\26EE\3\2#$\3\2ac\5\2\36\36!!%%\4\2ddii\6\2&]_`eehh\2\u038c"+
		"\2\u00e4\3\2\2\2\4\u00e7\3\2\2\2\6\u00ef\3\2\2\2\b\u00f4\3\2\2\2\n\u00f6"+
		"\3\2\2\2\f\u00fc\3\2\2\2\16\u0109\3\2\2\2\20\u010b\3\2\2\2\22\u010f\3"+
		"\2\2\2\24\u0118\3\2\2\2\26\u011d\3\2\2\2\30\u0121\3\2\2\2\32\u012a\3\2"+
		"\2\2\34\u012f\3\2\2\2\36\u0142\3\2\2\2 \u014b\3\2\2\2\"\u0153\3\2\2\2"+
		"$\u015b\3\2\2\2&\u0165\3\2\2\2(\u016d\3\2\2\2*\u0172\3\2\2\2,\u017a\3"+
		"\2\2\2.\u0182\3\2\2\2\60\u018a\3\2\2\2\62\u0192\3\2\2\2\64\u0198\3\2\2"+
		"\2\66\u019e\3\2\2\28\u01a4\3\2\2\2:\u01aa\3\2\2\2<\u01b7\3\2\2\2>\u01bc"+
		"\3\2\2\2@\u01be\3\2\2\2B\u01c0\3\2\2\2D\u01c2\3\2\2\2F\u01c4\3\2\2\2H"+
		"\u01d3\3\2\2\2J\u01d5\3\2\2\2L\u01df\3\2\2\2N\u01e3\3\2\2\2P\u01eb\3\2"+
		"\2\2R\u01fd\3\2\2\2T\u0200\3\2\2\2V\u0208\3\2\2\2X\u0214\3\2\2\2Z\u0216"+
		"\3\2\2\2\\\u021a\3\2\2\2^\u021e\3\2\2\2`\u0227\3\2\2\2b\u0229\3\2\2\2"+
		"d\u0232\3\2\2\2f\u0242\3\2\2\2h\u0245\3\2\2\2j\u0249\3\2\2\2l\u0250\3"+
		"\2\2\2n\u0255\3\2\2\2p\u0260\3\2\2\2r\u0264\3\2\2\2t\u0266\3\2\2\2v\u0268"+
		"\3\2\2\2x\u026b\3\2\2\2z\u026d\3\2\2\2|\u0273\3\2\2\2~\u0275\3\2\2\2\u0080"+
		"\u027b\3\2\2\2\u0082\u027d\3\2\2\2\u0084\u0281\3\2\2\2\u0086\u0283\3\2"+
		"\2\2\u0088\u0287\3\2\2\2\u008a\u0293\3\2\2\2\u008c\u02a1\3\2\2\2\u008e"+
		"\u02a5\3\2\2\2\u0090\u02a7\3\2\2\2\u0092\u02ab\3\2\2\2\u0094\u02ad\3\2"+
		"\2\2\u0096\u02ba\3\2\2\2\u0098\u02bd\3\2\2\2\u009a\u02c0\3\2\2\2\u009c"+
		"\u02c4\3\2\2\2\u009e\u02ce\3\2\2\2\u00a0\u02d0\3\2\2\2\u00a2\u02db\3\2"+
		"\2\2\u00a4\u02dd\3\2\2\2\u00a6\u02e9\3\2\2\2\u00a8\u02eb\3\2\2\2\u00aa"+
		"\u02ef\3\2\2\2\u00ac\u02f7\3\2\2\2\u00ae\u02fb\3\2\2\2\u00b0\u02ff\3\2"+
		"\2\2\u00b2\u0303\3\2\2\2\u00b4\u030a\3\2\2\2\u00b6\u0317\3\2\2\2\u00b8"+
		"\u0319\3\2\2\2\u00ba\u031e\3\2\2\2\u00bc\u0320\3\2\2\2\u00be\u0330\3\2"+
		"\2\2\u00c0\u0332\3\2\2\2\u00c2\u0337\3\2\2\2\u00c4\u0339\3\2\2\2\u00c6"+
		"\u033b\3\2\2\2\u00c8\u033d\3\2\2\2\u00ca\u033f\3\2\2\2\u00cc\u0343\3\2"+
		"\2\2\u00ce\u0345\3\2\2\2\u00d0\u034a\3\2\2\2\u00d2\u035c\3\2\2\2\u00d4"+
		"\u035e\3\2\2\2\u00d6\u0363\3\2\2\2\u00d8\u036c\3\2\2\2\u00da\u036e\3\2"+
		"\2\2\u00dc\u0373\3\2\2\2\u00de\u0378\3\2\2\2\u00e0\u037c\3\2\2\2\u00e2"+
		"\u0381\3\2\2\2\u00e4\u00e5\5\f\7\2\u00e5\u00e6\7\2\2\3\u00e6\3\3\2\2\2"+
		"\u00e7\u00ec\5\6\4\2\u00e8\u00e9\7\n\2\2\u00e9\u00eb\5\6\4\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\5\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7\17\2\2\u00f0\u00f2\5\u00e0"+
		"q\2\u00f1\u00f3\5\u009cO\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\7\3\2\2\2\u00f4\u00f5\5\n\6\2\u00f5\t\3\2\2\2\u00f6\u00f8\7\33\2\2\u00f7"+
		"\u00f9\5\f\7\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\7\6\2\2\u00fb\13\3\2\2\2\u00fc\u0101\5\16\b\2\u00fd\u00fe"+
		"\7\n\2\2\u00fe\u0100\5\16\b\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2\2\2"+
		"\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\r\3\2\2\2\u0103\u0101\3"+
		"\2\2\2\u0104\u010a\5\20\t\2\u0105\u010a\5\26\f\2\u0106\u010a\5\34\17\2"+
		"\u0107\u010a\5\36\20\2\u0108\u010a\5 \21\2\u0109\u0104\3\2\2\2\u0109\u0105"+
		"\3\2\2\2\u0109\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\17\3\2\2\2\u010b\u010c\5\22\n\2\u010c\u010d\7V\2\2\u010d\u010e\5\16\b"+
		"\2\u010e\21\3\2\2\2\u010f\u0110\7<\2\2\u0110\u0115\5\24\13\2\u0111\u0112"+
		"\7\n\2\2\u0112\u0114\5\24\13\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2"+
		"\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\23\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0118\u0119\7\17\2\2\u0119\u011a\5x=\2\u011a\u011b\7B\2\2\u011b"+
		"\u011c\5\16\b\2\u011c\25\3\2\2\2\u011d\u011e\5\30\r\2\u011e\u011f\7V\2"+
		"\2\u011f\u0120\5\16\b\2\u0120\27\3\2\2\2\u0121\u0122\7H\2\2\u0122\u0127"+
		"\5\32\16\2\u0123\u0124\7\n\2\2\u0124\u0126\5\32\16\2\u0125\u0123\3\2\2"+
		"\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\31"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7\17\2\2\u012b\u012c\5x=\2\u012c"+
		"\u012d\7\7\2\2\u012d\u012e\5\16\b\2\u012e\33\3\2\2\2\u012f\u0130\t\2\2"+
		"\2\u0130\u0131\7\17\2\2\u0131\u0132\5x=\2\u0132\u0133\7B\2\2\u0133\u013c"+
		"\5\16\b\2\u0134\u0135\7\n\2\2\u0135\u0136\7\17\2\2\u0136\u0137\5x=\2\u0137"+
		"\u0138\7B\2\2\u0138\u0139\5\16\b\2\u0139\u013b\3\2\2\2\u013a\u0134\3\2"+
		"\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7W\2\2\u0140\u0141\5\16"+
		"\b\2\u0141\35\3\2\2\2\u0142\u0143\7A\2\2\u0143\u0144\7\34\2\2\u0144\u0145"+
		"\5\f\7\2\u0145\u0146\7\13\2\2\u0146\u0147\7]\2\2\u0147\u0148\5\16\b\2"+
		"\u0148\u0149\7\65\2\2\u0149\u014a\5\16\b\2\u014a\37\3\2\2\2\u014b\u0150"+
		"\5\"\22\2\u014c\u014d\7Q\2\2\u014d\u014f\5\"\22\2\u014e\u014c\3\2\2\2"+
		"\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151!\3"+
		"\2\2\2\u0152\u0150\3\2\2\2\u0153\u0158\5$\23\2\u0154\u0155\7(\2\2\u0155"+
		"\u0157\5$\23\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2"+
		"\2\2\u0158\u0159\3\2\2\2\u0159#\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u0163"+
		"\5&\24\2\u015c\u0160\5B\"\2\u015d\u0160\5@!\2\u015e\u0160\5D#\2\u015f"+
		"\u015c\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161\u0162\5&\24\2\u0162\u0164\3\2\2\2\u0163\u015f\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164%\3\2\2\2\u0165\u016a\5(\25\2\u0166\u0167\7 \2\2\u0167"+
		"\u0169\5(\25\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\'\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u0170"+
		"\5*\26\2\u016e\u016f\7^\2\2\u016f\u0171\5*\26\2\u0170\u016e\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171)\3\2\2\2\u0172\u0177\5,\27\2\u0173\u0174\t\3\2\2"+
		"\u0174\u0176\5,\27\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178+\3\2\2\2\u0179\u0177\3\2\2\2\u017a"+
		"\u017f\5.\30\2\u017b\u017c\t\4\2\2\u017c\u017e\5.\30\2\u017d\u017b\3\2"+
		"\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"-\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0187\5\60\31\2\u0183\u0184\t\5\2"+
		"\2\u0184\u0186\5\60\31\2\u0185\u0183\3\2\2\2\u0186\u0189\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188/\3\2\2\2\u0189\u0187\3\2\2\2"+
		"\u018a\u018f\5\62\32\2\u018b\u018c\t\6\2\2\u018c\u018e\5\62\32\2\u018d"+
		"\u018b\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\61\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0196\5\64\33\2\u0193"+
		"\u0194\7C\2\2\u0194\u0195\7P\2\2\u0195\u0197\5\u009eP\2\u0196\u0193\3"+
		"\2\2\2\u0196\u0197\3\2\2\2\u0197\63\3\2\2\2\u0198\u019c\5\66\34\2\u0199"+
		"\u019a\7_\2\2\u019a\u019b\7*\2\2\u019b\u019d\5\u009eP\2\u019c\u0199\3"+
		"\2\2\2\u019c\u019d\3\2\2\2\u019d\65\3\2\2\2\u019e\u01a2\58\35\2\u019f"+
		"\u01a0\7-\2\2\u01a0\u01a1\7*\2\2\u01a1\u01a3\5\u009aN\2\u01a2\u019f\3"+
		"\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\67\3\2\2\2\u01a4\u01a8\5:\36\2\u01a5"+
		"\u01a6\7,\2\2\u01a6\u01a7\7*\2\2\u01a7\u01a9\5\u009aN\2\u01a8\u01a5\3"+
		"\2\2\2\u01a8\u01a9\3\2\2\2\u01a99\3\2\2\2\u01aa\u01b1\5<\37\2\u01ab\u01ac"+
		"\7\20\2\2\u01ac\u01ad\5n8\2\u01ad\u01ae\5d\63\2\u01ae\u01b0\3\2\2\2\u01af"+
		"\u01ab\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2"+
		"\2\2\u01b2;\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b6\t\3\2\2\u01b5\u01b4"+
		"\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"\u01ba\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bb\5> \2\u01bb=\3\2\2\2\u01bc"+
		"\u01bd\5F$\2\u01bd?\3\2\2\2\u01be\u01bf\t\7\2\2\u01bfA\3\2\2\2\u01c0\u01c1"+
		"\t\b\2\2\u01c1C\3\2\2\2\u01c2\u01c3\t\t\2\2\u01c3E\3\2\2\2\u01c4\u01c9"+
		"\5H%\2\u01c5\u01c6\7\4\2\2\u01c6\u01c8\5H%\2\u01c7\u01c5\3\2\2\2\u01c8"+
		"\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01caG\3\2\2\2"+
		"\u01cb\u01c9\3\2\2\2\u01cc\u01ce\7#\2\2\u01cd\u01cf\5J&\2\u01ce\u01cd"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d4\3\2\2\2\u01d0\u01d1\7$\2\2\u01d1"+
		"\u01d4\5J&\2\u01d2\u01d4\5J&\2\u01d3\u01cc\3\2\2\2\u01d3\u01d0\3\2\2\2"+
		"\u01d3\u01d2\3\2\2\2\u01d4I\3\2\2\2\u01d5\u01da\5L\'\2\u01d6\u01d7\t\n"+
		"\2\2\u01d7\u01d9\5L\'\2\u01d8\u01d6\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da"+
		"\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01dbK\3\2\2\2\u01dc\u01da\3\2\2\2"+
		"\u01dd\u01e0\5b\62\2\u01de\u01e0\5N(\2\u01df\u01dd\3\2\2\2\u01df\u01de"+
		"\3\2\2\2\u01e0M\3\2\2\2\u01e1\u01e4\5V,\2\u01e2\u01e4\5P)\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\5f\64\2\u01e6"+
		"O\3\2\2\2\u01e7\u01e8\5R*\2\u01e8\u01e9\5\\/\2\u01e9\u01ec\3\2\2\2\u01ea"+
		"\u01ec\5T+\2\u01eb\u01e7\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ecQ\3\2\2\2\u01ed"+
		"\u01ee\7.\2\2\u01ee\u01fe\7\t\2\2\u01ef\u01f0\7\60\2\2\u01f0\u01fe\7\t"+
		"\2\2\u01f1\u01f2\7+\2\2\u01f2\u01fe\7\t\2\2\u01f3\u01f4\7Z\2\2\u01f4\u01fe"+
		"\7\t\2\2\u01f5\u01f6\7\61\2\2\u01f6\u01fe\7\t\2\2\u01f7\u01f8\7;\2\2\u01f8"+
		"\u01fe\7\t\2\2\u01f9\u01fa\7:\2\2\u01fa\u01fe\7\t\2\2\u01fb\u01fc\7L\2"+
		"\2\u01fc\u01fe\7\t\2\2\u01fd\u01ed\3\2\2\2\u01fd\u01ef\3\2\2\2\u01fd\u01f1"+
		"\3\2\2\2\u01fd\u01f3\3\2\2\2\u01fd\u01f5\3\2\2\2\u01fd\u01f7\3\2\2\2\u01fd"+
		"\u01f9\3\2\2\2\u01fd\u01fb\3\2\2\2\u01feS\3\2\2\2\u01ff\u0201\7\3\2\2"+
		"\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203"+
		"\5\\/\2\u0203U\3\2\2\2\u0204\u0205\5X-\2\u0205\u0206\5\\/\2\u0206\u0209"+
		"\3\2\2\2\u0207\u0209\5Z.\2\u0208\u0204\3\2\2\2\u0208\u0207\3\2\2\2\u0209"+
		"W\3\2\2\2\u020a\u020b\7R\2\2\u020b\u0215\7\t\2\2\u020c\u020d\7&\2\2\u020d"+
		"\u0215\7\t\2\2\u020e\u020f\7T\2\2\u020f\u0215\7\t\2\2\u0210\u0211\7S\2"+
		"\2\u0211\u0215\7\t\2\2\u0212\u0213\7\'\2\2\u0213\u0215\7\t\2\2\u0214\u020a"+
		"\3\2\2\2\u0214\u020c\3\2\2\2\u0214\u020e\3\2\2\2\u0214\u0210\3\2\2\2\u0214"+
		"\u0212\3\2\2\2\u0215Y\3\2\2\2\u0216\u0217\7\16\2\2\u0217[\3\2\2\2\u0218"+
		"\u021b\5\u00a6T\2\u0219\u021b\5^\60\2\u021a\u0218\3\2\2\2\u021a\u0219"+
		"\3\2\2\2\u021b]\3\2\2\2\u021c\u021f\5\u00e0q\2\u021d\u021f\5`\61\2\u021e"+
		"\u021c\3\2\2\2\u021e\u021d\3\2\2\2\u021f_\3\2\2\2\u0220\u0228\7%\2\2\u0221"+
		"\u0222\7i\2\2\u0222\u0228\7\f\2\2\u0223\u0224\7\"\2\2\u0224\u0228\7i\2"+
		"\2\u0225\u0226\7f\2\2\u0226\u0228\7%\2\2\u0227\u0220\3\2\2\2\u0227\u0221"+
		"\3\2\2\2\u0227\u0223\3\2\2\2\u0227\u0225\3\2\2\2\u0228a\3\2\2\2\u0229"+
		"\u022f\5p9\2\u022a\u022e\5h\65\2\u022b\u022e\5d\63\2\u022c\u022e\5j\66"+
		"\2\u022d\u022a\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022c\3\2\2\2\u022e\u0231"+
		"\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230c\3\2\2\2\u0231"+
		"\u022f\3\2\2\2\u0232\u023b\7\34\2\2\u0233\u0238\5\u0080A\2\u0234\u0235"+
		"\7\n\2\2\u0235\u0237\5\u0080A\2\u0236\u0234\3\2\2\2\u0237\u023a\3\2\2"+
		"\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238"+
		"\3\2\2\2\u023b\u0233\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023e\7\13\2\2\u023ee\3\2\2\2\u023f\u0241\5h\65\2\u0240\u023f\3\2\2\2"+
		"\u0241\u0244\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243g\3"+
		"\2\2\2\u0244\u0242\3\2\2\2\u0245\u0246\7\32\2\2\u0246\u0247\5\f\7\2\u0247"+
		"\u0248\7\5\2\2\u0248i\3\2\2\2\u0249\u024a\7!\2\2\u024a\u024b\5l\67\2\u024b"+
		"k\3\2\2\2\u024c\u0251\7i\2\2\u024d\u0251\7a\2\2\u024e\u0251\5z>\2\u024f"+
		"\u0251\7%\2\2\u0250\u024c\3\2\2\2\u0250\u024d\3\2\2\2\u0250\u024e\3\2"+
		"\2\2\u0250\u024f\3\2\2\2\u0251m\3\2\2\2\u0252\u0256\5\u00e0q\2\u0253\u0256"+
		"\5v<\2\u0254\u0256\5z>\2\u0255\u0252\3\2\2\2\u0255\u0253\3\2\2\2\u0255"+
		"\u0254\3\2\2\2\u0256o\3\2\2\2\u0257\u0261\5r:\2\u0258\u0261\5v<\2\u0259"+
		"\u0261\5z>\2\u025a\u0261\5|?\2\u025b\u0261\5~@\2\u025c\u0261\5\u0084C"+
		"\2\u025d\u0261\5\u008aF\2\u025e\u0261\5\u0092J\2\u025f\u0261\5\u0098M"+
		"\2\u0260\u0257\3\2\2\2\u0260\u0258\3\2\2\2\u0260\u0259\3\2\2\2\u0260\u025a"+
		"\3\2\2\2\u0260\u025b\3\2\2\2\u0260\u025c\3\2\2\2\u0260\u025d\3\2\2\2\u0260"+
		"\u025e\3\2\2\2\u0260\u025f\3\2\2\2\u0261q\3\2\2\2\u0262\u0265\5t;\2\u0263"+
		"\u0265\7d\2\2\u0264\u0262\3\2\2\2\u0264\u0263\3\2\2\2\u0265s\3\2\2\2\u0266"+
		"\u0267\t\13\2\2\u0267u\3\2\2\2\u0268\u0269\7\17\2\2\u0269\u026a\5x=\2"+
		"\u026aw\3\2\2\2\u026b\u026c\5\u00e0q\2\u026cy\3\2\2\2\u026d\u026f\7\34"+
		"\2\2\u026e\u0270\5\f\7\2\u026f\u026e\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u0271\3\2\2\2\u0271\u0272\7\13\2\2\u0272{\3\2\2\2\u0273\u0274\7\r\2\2"+
		"\u0274}\3\2\2\2\u0275\u0276\6@\2\2\u0276\u0277\5\u00e0q\2\u0277\u0278"+
		"\5d\63\2\u0278\177\3\2\2\2\u0279\u027c\5\16\b\2\u027a\u027c\5\u0082B\2"+
		"\u027b\u0279\3\2\2\2\u027b\u027a\3\2\2\2\u027c\u0081\3\2\2\2\u027d\u027e"+
		"\7!\2\2\u027e\u0083\3\2\2\2\u027f\u0282\5\u0086D\2\u0280\u0282\5\u0088"+
		"E\2\u0281\u027f\3\2\2\2\u0281\u0280\3\2\2\2\u0282\u0085\3\2\2\2\u0283"+
		"\u0284\5\u00e0q\2\u0284\u0285\7\37\2\2\u0285\u0286\7a\2\2\u0286\u0087"+
		"\3\2\2\2\u0287\u0288\7=\2\2\u0288\u028a\7\34\2\2\u0289\u028b\5\4\3\2\u028a"+
		"\u0289\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028f\7\13"+
		"\2\2\u028d\u028e\7*\2\2\u028e\u0290\5\u009eP\2\u028f\u028d\3\2\2\2\u028f"+
		"\u0290\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\5\b\5\2\u0292\u0089\3\2"+
		"\2\2\u0293\u0294\7J\2\2\u0294\u029d\7\33\2\2\u0295\u029a\5\u008cG\2\u0296"+
		"\u0297\7\n\2\2\u0297\u0299\5\u008cG\2\u0298\u0296\3\2\2\2\u0299\u029c"+
		"\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029e\3\2\2\2\u029c"+
		"\u029a\3\2\2\2\u029d\u0295\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f\3\2"+
		"\2\2\u029f\u02a0\7\6\2\2\u02a0\u008b\3\2\2\2\u02a1\u02a2\5\u008eH\2\u02a2"+
		"\u02a3\7\b\2\2\u02a3\u02a4\5\u0090I\2\u02a4\u008d\3\2\2\2\u02a5\u02a6"+
		"\5\16\b\2\u02a6\u008f\3\2\2\2\u02a7\u02a8\5\16\b\2\u02a8\u0091\3\2\2\2"+
		"\u02a9\u02ac\5\u0094K\2\u02aa\u02ac\5\u0096L\2\u02ab\u02a9\3\2\2\2\u02ab"+
		"\u02aa\3\2\2\2\u02ac\u0093\3\2\2\2\u02ad\u02b6\7\32\2\2\u02ae\u02b3\5"+
		"\16\b\2\u02af\u02b0\7\n\2\2\u02b0\u02b2\5\16\b\2\u02b1\u02af\3\2\2\2\u02b2"+
		"\u02b5\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b7\3\2"+
		"\2\2\u02b5\u02b3\3\2\2\2\u02b6\u02ae\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7"+
		"\u02b8\3\2\2\2\u02b8\u02b9\7\5\2\2\u02b9\u0095\3\2\2\2\u02ba\u02bb\7)"+
		"\2\2\u02bb\u02bc\5\n\6\2\u02bc\u0097\3\2\2\2\u02bd\u02be\7!\2\2\u02be"+
		"\u02bf\5l\67\2\u02bf\u0099\3\2\2\2\u02c0\u02c2\5\u00c8e\2\u02c1\u02c3"+
		"\7!\2\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u009b\3\2\2\2\u02c4"+
		"\u02c5\7*\2\2\u02c5\u02c6\5\u009eP\2\u02c6\u009d\3\2\2\2\u02c7\u02c8\7"+
		"\66\2\2\u02c8\u02c9\7\34\2\2\u02c9\u02cf\7\13\2\2\u02ca\u02cc\5\u00a2"+
		"R\2\u02cb\u02cd\5\u00a0Q\2\u02cc\u02cb\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd"+
		"\u02cf\3\2\2\2\u02ce\u02c7\3\2\2\2\u02ce\u02ca\3\2\2\2\u02cf\u009f\3\2"+
		"\2\2\u02d0\u02d1\t\f\2\2\u02d1\u00a1\3\2\2\2\u02d2\u02dc\5\u00a6T\2\u02d3"+
		"\u02d4\7F\2\2\u02d4\u02d5\7\34\2\2\u02d5\u02dc\7\13\2\2\u02d6\u02dc\5"+
		"\u00ccg\2\u02d7\u02dc\5\u00d2j\2\u02d8\u02dc\5\u00d8m\2\u02d9\u02dc\5"+
		"\u00a4S\2\u02da\u02dc\5\u00dep\2\u02db\u02d2\3\2\2\2\u02db\u02d3\3\2\2"+
		"\2\u02db\u02d6\3\2\2\2\u02db\u02d7\3\2\2\2\u02db\u02d8\3\2\2\2\u02db\u02d9"+
		"\3\2\2\2\u02db\u02da\3\2\2\2\u02dc\u00a3\3\2\2\2\u02dd\u02de\5\u00e0q"+
		"\2\u02de\u00a5\3\2\2\2\u02df\u02ea\5\u00aaV\2\u02e0\u02ea\5\u00bc_\2\u02e1"+
		"\u02ea\5\u00b4[\2\u02e2\u02ea\5\u00c0a\2\u02e3\u02ea\5\u00b8]\2\u02e4"+
		"\u02ea\5\u00b2Z\2\u02e5\u02ea\5\u00aeX\2\u02e6\u02ea\5\u00acW\2\u02e7"+
		"\u02ea\5\u00b0Y\2\u02e8\u02ea\5\u00a8U\2\u02e9\u02df\3\2\2\2\u02e9\u02e0"+
		"\3\2\2\2\u02e9\u02e1\3\2\2\2\u02e9\u02e2\3\2\2\2\u02e9\u02e3\3\2\2\2\u02e9"+
		"\u02e4\3\2\2\2\u02e9\u02e5\3\2\2\2\u02e9\u02e6\3\2\2\2\u02e9\u02e7\3\2"+
		"\2\2\u02e9\u02e8\3\2\2\2\u02ea\u00a7\3\2\2\2\u02eb\u02ec\7O\2\2\u02ec"+
		"\u02ed\7\34\2\2\u02ed\u02ee\7\13\2\2\u02ee\u00a9\3\2\2\2\u02ef\u02f0\7"+
		"\63\2\2\u02f0\u02f3\7\34\2\2\u02f1\u02f4\5\u00bc_\2\u02f2\u02f4\5\u00c0"+
		"a\2\u02f3\u02f1\3\2\2\2\u02f3\u02f2\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u02f6\7\13\2\2\u02f6\u00ab\3\2\2\2\u02f7\u02f8\7"+
		"\\\2\2\u02f8\u02f9\7\34\2\2\u02f9\u02fa\7\13\2\2\u02fa\u00ad\3\2\2\2\u02fb"+
		"\u02fc\7/\2\2\u02fc\u02fd\7\34\2\2\u02fd\u02fe\7\13\2\2\u02fe\u00af\3"+
		"\2\2\2\u02ff\u0300\7M\2\2\u0300\u0301\7\34\2\2\u0301\u0302\7\13\2\2\u0302"+
		"\u00b1\3\2\2\2\u0303\u0304\7U\2\2\u0304\u0306\7\34\2\2\u0305\u0307\t\r"+
		"\2\2\u0306\u0305\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u0308\3\2\2\2\u0308"+
		"\u0309\7\13\2\2\u0309\u00b3\3\2\2\2\u030a\u030b\7+\2\2\u030b\u0311\7\34"+
		"\2\2\u030c\u030f\5\u00b6\\\2\u030d\u030e\7\n\2\2\u030e\u0310\5\u00caf"+
		"\2\u030f\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0312\3\2\2\2\u0311\u030c"+
		"\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314\7\13\2\2"+
		"\u0314\u00b5\3\2\2\2\u0315\u0318\5\u00c4c\2\u0316\u0318\7%\2\2\u0317\u0315"+
		"\3\2\2\2\u0317\u0316\3\2\2\2\u0318\u00b7\3\2\2\2\u0319\u031a\7X\2\2\u031a"+
		"\u031b\7\34\2\2\u031b\u031c\5\u00ba^\2\u031c\u031d\7\13\2\2\u031d\u00b9"+
		"\3\2\2\2\u031e\u031f\5\u00c4c\2\u031f\u00bb\3\2\2\2\u0320\u0321\7\64\2"+
		"\2\u0321\u032a\7\34\2\2\u0322\u0328\5\u00be`\2\u0323\u0324\7\n\2\2\u0324"+
		"\u0326\5\u00caf\2\u0325\u0327\7!\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3"+
		"\2\2\2\u0327\u0329\3\2\2\2\u0328\u0323\3\2\2\2\u0328\u0329\3\2\2\2\u0329"+
		"\u032b\3\2\2\2\u032a\u0322\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c\3\2"+
		"\2\2\u032c\u032d\7\13\2\2\u032d\u00bd\3\2\2\2\u032e\u0331\5\u00c6d\2\u032f"+
		"\u0331\7%\2\2\u0330\u032e\3\2\2\2\u0330\u032f\3\2\2\2\u0331\u00bf\3\2"+
		"\2\2\u0332\u0333\7Y\2\2\u0333\u0334\7\34\2\2\u0334\u0335\5\u00c2b\2\u0335"+
		"\u0336\7\13\2\2\u0336\u00c1\3\2\2\2\u0337\u0338\5\u00c6d\2\u0338\u00c3"+
		"\3\2\2\2\u0339\u033a\5\u00e0q\2\u033a\u00c5\3\2\2\2\u033b\u033c\5\u00e0"+
		"q\2\u033c\u00c7\3\2\2\2\u033d\u033e\5\u00caf\2\u033e\u00c9\3\2\2\2\u033f"+
		"\u0340\5\u00e0q\2\u0340\u00cb\3\2\2\2\u0341\u0344\5\u00ceh\2\u0342\u0344"+
		"\5\u00d0i\2\u0343\u0341\3\2\2\2\u0343\u0342\3\2\2\2\u0344\u00cd\3\2\2"+
		"\2\u0345\u0346\7=\2\2\u0346\u0347\7\34\2\2\u0347\u0348\7%\2\2\u0348\u0349"+
		"\7\13\2\2\u0349\u00cf\3\2\2\2\u034a\u034b\7=\2\2\u034b\u0354\7\34\2\2"+
		"\u034c\u0351\5\u009eP\2\u034d\u034e\7\n\2\2\u034e\u0350\5\u009eP\2\u034f"+
		"\u034d\3\2\2\2\u0350\u0353\3\2\2\2\u0351\u034f\3\2\2\2\u0351\u0352\3\2"+
		"\2\2\u0352\u0355\3\2\2\2\u0353\u0351\3\2\2\2\u0354\u034c\3\2\2\2\u0354"+
		"\u0355\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0357\7\13\2\2\u0357\u0358\7"+
		"*\2\2\u0358\u0359\5\u009eP\2\u0359\u00d1\3\2\2\2\u035a\u035d\5\u00d4k"+
		"\2\u035b\u035d\5\u00d6l\2\u035c\u035a\3\2\2\2\u035c\u035b\3\2\2\2\u035d"+
		"\u00d3\3\2\2\2\u035e\u035f\7J\2\2\u035f\u0360\7\34\2\2\u0360\u0361\7%"+
		"\2\2\u0361\u0362\7\13\2\2\u0362\u00d5\3\2\2\2\u0363\u0364\7J\2\2\u0364"+
		"\u0365\7\34\2\2\u0365\u0366\5\u00a4S\2\u0366\u0367\7\n\2\2\u0367\u0368"+
		"\5\u009eP\2\u0368\u0369\7\13\2\2\u0369\u00d7\3\2\2\2\u036a\u036d\5\u00da"+
		"n\2\u036b\u036d\5\u00dco\2\u036c\u036a\3\2\2\2\u036c\u036b\3\2\2\2\u036d"+
		"\u00d9\3\2\2\2\u036e\u036f\7)\2\2\u036f\u0370\7\34\2\2\u0370\u0371\7%"+
		"\2\2\u0371\u0372\7\13\2\2\u0372\u00db\3\2\2\2\u0373\u0374\7)\2\2\u0374"+
		"\u0375\7\34\2\2\u0375\u0376\5\u009eP\2\u0376\u0377\7\13\2\2\u0377\u00dd"+
		"\3\2\2\2\u0378\u0379\7\34\2\2\u0379\u037a\5\u00a2R\2\u037a\u037b\7\13"+
		"\2\2\u037b\u00df\3\2\2\2\u037c\u037d\t\16\2\2\u037d\u00e1\3\2\2\2\u037e"+
		"\u037f\5\f\7\2\u037f\u0380\7k\2\2\u0380\u0382\3\2\2\2\u0381\u037e\3\2"+
		"\2\2\u0382\u0383\3\2\2\2\u0383\u0381\3\2\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u0385\3\2\2\2\u0385\u0386\7\2\2\3\u0386\u00e3\3\2\2\2O\u00ec\u00f2\u00f8"+
		"\u0101\u0109\u0115\u0127\u013c\u0150\u0158\u015f\u0163\u016a\u0170\u0177"+
		"\u017f\u0187\u018f\u0196\u019c\u01a2\u01a8\u01b1\u01b7\u01c9\u01ce\u01d3"+
		"\u01da\u01df\u01e3\u01eb\u01fd\u0200\u0208\u0214\u021a\u021e\u0227\u022d"+
		"\u022f\u0238\u023b\u0242\u0250\u0255\u0260\u0264\u026f\u027b\u0281\u028a"+
		"\u028f\u029a\u029d\u02ab\u02b3\u02b6\u02c2\u02cc\u02ce\u02db\u02e9\u02f3"+
		"\u0306\u030f\u0311\u0317\u0326\u0328\u032a\u0330\u0343\u0351\u0354\u035c"+
		"\u036c\u0383";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}