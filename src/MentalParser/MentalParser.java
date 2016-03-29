// Generated from /Users/Songyu/Projects/Mental/src/MentalParser/Mental.g4 by ANTLR 4.5.1
package MentalParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MentalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, COMMENT=26, WS=27, INT=28, Identifier=29, STRING=30, PLUS=31, 
		MINUS=32, MUL=33, DIV=34, MOD=35, INC=36, DEC=37, BIT_NOT=38, LOGICAL_NOT=39, 
		BIT_AND=40, BIT_XOR=41, BIT_OR=42, LOGICAL_AND=43, LOGICAL_OR=44, ASSIGN=45, 
		EQUAL=46, INEQUAL=47, LESS=48, GREATER=49, LESS_EQUAL=50, GREATER_EQUAL=51, 
		LEFT_SHIFT=52, RIGHT_SHIFT=53, PERIOD=54, COMMA=55, LBRACKET=56, RBRACKET=57;
	public static final int
		RULE_originalType = 0, RULE_array = 1, RULE_type = 2, RULE_paramtersList = 3, 
		RULE_program = 4, RULE_declaration = 5, RULE_classDeclaration = 6, RULE_functionDeclaration = 7, 
		RULE_definition = 8, RULE_variableDefinition = 9, RULE_functionDefinition = 10, 
		RULE_compoundStatement = 11, RULE_statement = 12, RULE_callPrint = 13, 
		RULE_callPrintln = 14, RULE_callGetString = 15, RULE_callGetInt = 16, 
		RULE_callToString = 17, RULE_emptyStatement = 18, RULE_ifStatement = 19, 
		RULE_ifElseStatement = 20, RULE_forStatement = 21, RULE_whileStatement = 22, 
		RULE_jumpStatement = 23, RULE_expressionStatement = 24, RULE_expression = 25, 
		RULE_expressionList = 26;
	public static final String[] ruleNames = {
		"originalType", "array", "type", "paramtersList", "program", "declaration", 
		"classDeclaration", "functionDeclaration", "definition", "variableDefinition", 
		"functionDefinition", "compoundStatement", "statement", "callPrint", "callPrintln", 
		"callGetString", "callGetInt", "callToString", "emptyStatement", "ifStatement", 
		"ifElseStatement", "forStatement", "whileStatement", "jumpStatement", 
		"expressionStatement", "expression", "expressionList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'string'", "'class'", "'{'", "'}'", "'void'", "'('", "')'", 
		"';'", "'print'", "'println'", "'getString'", "'getInt'", "'toString'", 
		"'if'", "'else'", "'for'", "'while'", "'return'", "'continue'", "'break'", 
		"'new'", "'true'", "'false'", "'null'", null, null, null, null, null, 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'~'", "'!'", "'&'", 
		"'^'", "'|'", "'&&'", "'||'", "'='", "'=='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'<<'", "'>>'", "'.'", "','", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "COMMENT", "WS", "INT", "Identifier", "STRING", "PLUS", "MINUS", 
		"MUL", "DIV", "MOD", "INC", "DEC", "BIT_NOT", "LOGICAL_NOT", "BIT_AND", 
		"BIT_XOR", "BIT_OR", "LOGICAL_AND", "LOGICAL_OR", "ASSIGN", "EQUAL", "INEQUAL", 
		"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "LEFT_SHIFT", "RIGHT_SHIFT", 
		"PERIOD", "COMMA", "LBRACKET", "RBRACKET"
	};
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
	public String getGrammarFileName() { return "Mental.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MentalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class OriginalTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public OriginalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterOriginalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitOriginalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitOriginalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OriginalTypeContext originalType() throws RecognitionException {
		OriginalTypeContext _localctx = new OriginalTypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_originalType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ArrayContext extends ParserRuleContext {
		public OriginalTypeContext originalType() {
			return getRuleContext(OriginalTypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		return array(0);
	}

	private ArrayContext array(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayContext _localctx = new ArrayContext(_ctx, _parentState);
		ArrayContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_array, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(57);
			originalType();
			setState(58);
			match(LBRACKET);
			setState(59);
			match(RBRACKET);
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_array);
					setState(61);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(62);
					match(LBRACKET);
					setState(63);
					match(RBRACKET);
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public OriginalTypeContext originalType() {
			return getRuleContext(OriginalTypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(71);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				originalType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				array(0);
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

	public static class ParamtersListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MentalParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MentalParser.Identifier, i);
		}
		public ParamtersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramtersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterParamtersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitParamtersList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitParamtersList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamtersListContext paramtersList() throws RecognitionException {
		ParamtersListContext _localctx = new ParamtersListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramtersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(73);
			type();
			setState(74);
			match(Identifier);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(76);
				match(COMMA);
				setState(77);
				type();
				setState(78);
				match(Identifier);
				}
				}
				setState(84);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__5) | (1L << Identifier))) != 0)) {
				{
				setState(87);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(85);
					declaration();
					}
					break;
				case 2:
					{
					setState(86);
					definition();
					}
					break;
				}
				}
				setState(91);
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

	public static class DeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			setState(94);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				classDeclaration();
				}
				break;
			case T__0:
			case T__1:
			case T__5:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				functionDeclaration();
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__2);
			setState(98);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(97);
				match(Identifier);
				}
			}

			setState(100);
			match(T__3);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << Identifier))) != 0)) {
				{
				{
				setState(101);
				variableDefinition();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(T__4);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamtersListContext paramtersList() {
			return getRuleContext(ParamtersListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case Identifier:
				{
				setState(109);
				type();
				}
				break;
			case T__5:
				{
				setState(110);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(113);
			match(Identifier);
			setState(114);
			match(T__6);
			setState(116);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << Identifier))) != 0)) {
				{
				setState(115);
				paramtersList();
				}
			}

			setState(118);
			match(T__7);
			setState(119);
			match(T__8);
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

	public static class DefinitionContext extends ParserRuleContext {
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_definition);
		try {
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				functionDefinition();
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

	public static class VariableDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(MentalParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MentalParser.Identifier, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			type();
			setState(126);
			match(Identifier);
			setState(129);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(127);
				match(ASSIGN);
				setState(128);
				expression(0);
				}
			}

			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(131);
				match(COMMA);
				setState(132);
				match(Identifier);
				setState(135);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(133);
					match(ASSIGN);
					setState(134);
					expression(0);
					}
				}

				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__8);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamtersListContext paramtersList() {
			return getRuleContext(ParamtersListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case Identifier:
				{
				setState(144);
				type();
				}
				break;
			case T__5:
				{
				setState(145);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
			match(Identifier);
			setState(149);
			match(T__6);
			setState(151);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << Identifier))) != 0)) {
				{
				setState(150);
				paramtersList();
				}
			}

			setState(153);
			match(T__7);
			setState(154);
			compoundStatement();
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

	public static class CompoundStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__3);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT) | (1L << BIT_AND))) != 0)) {
				{
				{
				setState(157);
				statement();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			match(T__4);
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

	public static class StatementContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public CallPrintContext callPrint() {
			return getRuleContext(CallPrintContext.class,0);
		}
		public CallPrintlnContext callPrintln() {
			return getRuleContext(CallPrintlnContext.class,0);
		}
		public CallGetStringContext callGetString() {
			return getRuleContext(CallGetStringContext.class,0);
		}
		public CallGetIntContext callGetInt() {
			return getRuleContext(CallGetIntContext.class,0);
		}
		public CallToStringContext callToString() {
			return getRuleContext(CallToStringContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				ifElseStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				expressionStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				jumpStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(172);
				emptyStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(173);
				variableDefinition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(174);
				callPrint();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(175);
				callPrintln();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(176);
				callGetString();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(177);
				callGetInt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(178);
				callToString();
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

	public static class CallPrintContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallPrintContext callPrint() throws RecognitionException {
		CallPrintContext _localctx = new CallPrintContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__9);
			setState(182);
			match(T__6);
			setState(183);
			expression(0);
			setState(184);
			match(T__7);
			setState(185);
			match(T__8);
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

	public static class CallPrintlnContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallPrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callPrintln; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallPrintln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallPrintln(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallPrintln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallPrintlnContext callPrintln() throws RecognitionException {
		CallPrintlnContext _localctx = new CallPrintlnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callPrintln);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__10);
			setState(188);
			match(T__6);
			setState(189);
			expression(0);
			setState(190);
			match(T__7);
			setState(191);
			match(T__8);
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

	public static class CallGetStringContext extends ParserRuleContext {
		public CallGetStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callGetString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallGetString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallGetString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallGetString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallGetStringContext callGetString() throws RecognitionException {
		CallGetStringContext _localctx = new CallGetStringContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_callGetString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__11);
			setState(194);
			match(T__6);
			setState(195);
			match(T__7);
			setState(196);
			match(T__8);
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

	public static class CallGetIntContext extends ParserRuleContext {
		public CallGetIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callGetInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallGetInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallGetInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallGetInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallGetIntContext callGetInt() throws RecognitionException {
		CallGetIntContext _localctx = new CallGetIntContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_callGetInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__12);
			setState(199);
			match(T__6);
			setState(200);
			match(T__7);
			setState(201);
			match(T__8);
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

	public static class CallToStringContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallToStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callToString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallToString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallToString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallToString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallToStringContext callToString() throws RecognitionException {
		CallToStringContext _localctx = new CallToStringContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_callToString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__13);
			setState(204);
			match(T__6);
			setState(205);
			expression(0);
			setState(206);
			match(T__7);
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

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__8);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__14);
			setState(211);
			match(T__6);
			setState(212);
			expression(0);
			setState(213);
			match(T__7);
			setState(214);
			statement();
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

	public static class IfElseStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__14);
			setState(217);
			match(T__6);
			setState(218);
			expression(0);
			setState(219);
			match(T__7);
			setState(220);
			statement();
			setState(221);
			match(T__15);
			setState(222);
			statement();
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

	public static class ForStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__16);
			setState(225);
			match(T__6);
			setState(227);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT) | (1L << BIT_AND))) != 0)) {
				{
				setState(226);
				expression(0);
				}
			}

			setState(229);
			match(T__8);
			setState(231);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT) | (1L << BIT_AND))) != 0)) {
				{
				setState(230);
				expression(0);
				}
			}

			setState(233);
			match(T__8);
			setState(235);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT) | (1L << BIT_AND))) != 0)) {
				{
				setState(234);
				expression(0);
				}
			}

			setState(237);
			match(T__7);
			setState(238);
			statement();
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

	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__17);
			setState(241);
			match(T__6);
			setState(242);
			expression(0);
			setState(243);
			match(T__7);
			setState(244);
			statement();
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

	public static class JumpStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_jumpStatement);
		try {
			setState(254);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(T__18);
				setState(247);
				expression(0);
				setState(248);
				match(T__8);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				match(T__19);
				setState(251);
				match(T__8);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				match(T__20);
				setState(253);
				match(T__8);
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			expression(0);
			setState(257);
			match(T__8);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BIT_XOR_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BIT_XOR_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterBIT_XOR_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitBIT_XOR_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitBIT_XOR_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LOGICAL_NOT_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LOGICAL_NOT_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterLOGICAL_NOT_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitLOGICAL_NOT_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitLOGICAL_NOT_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MEMBER_ACCESS_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MEMBER_ACCESS_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterMEMBER_ACCESS_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitMEMBER_ACCESS_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitMEMBER_ACCESS_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FUNCTION_CALLContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FUNCTION_CALLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterFUNCTION_CALL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitFUNCTION_CALL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitFUNCTION_CALL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ADDITIVE_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ADDITIVE_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterADDITIVE_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitADDITIVE_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitADDITIVE_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CREATION_EXPRESSIONContext extends ExpressionContext {
		public OriginalTypeContext originalType() {
			return getRuleContext(OriginalTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public CREATION_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCREATION_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCREATION_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCREATION_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BIT_NOT_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BIT_NOT_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterBIT_NOT_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitBIT_NOT_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitBIT_NOT_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RELATION_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RELATION_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterRELATION_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitRELATION_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitRELATION_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EQUALITY_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EQUALITY_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterEQUALITY_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitEQUALITY_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitEQUALITY_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class INT_LITERALContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(MentalParser.INT, 0); }
		public INT_LITERALContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterINT_LITERAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitINT_LITERAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitINT_LITERAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDENTIFIERContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public IDENTIFIERContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterIDENTIFIER(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitIDENTIFIER(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitIDENTIFIER(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SUFFIX_INC_DEC_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SUFFIX_INC_DEC_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterSUFFIX_INC_DEC_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitSUFFIX_INC_DEC_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitSUFFIX_INC_DEC_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MULTIPLY_DIVIDE_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MULTIPLY_DIVIDE_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterMULTIPLY_DIVIDE_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitMULTIPLY_DIVIDE_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitMULTIPLY_DIVIDE_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LOGICAL_OR_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LOGICAL_OR_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterLOGICAL_OR_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitLOGICAL_OR_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitLOGICAL_OR_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ASSIGN_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ASSIGN_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterASSIGN_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitASSIGN_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitASSIGN_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class REFERENCE_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public REFERENCE_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterREFERENCE_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitREFERENCE_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitREFERENCE_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NULLContext extends ExpressionContext {
		public NULLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterNULL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitNULL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitNULL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TRUEContext extends ExpressionContext {
		public TRUEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterTRUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitTRUE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitTRUE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BIT_OR_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BIT_OR_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterBIT_OR_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitBIT_OR_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitBIT_OR_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LOGICAL_AND_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LOGICAL_AND_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterLOGICAL_AND_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitLOGICAL_AND_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitLOGICAL_AND_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BIT_SHIFT_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BIT_SHIFT_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterBIT_SHIFT_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitBIT_SHIFT_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitBIT_SHIFT_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PREFIX_INC_DEC_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PREFIX_INC_DEC_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterPREFIX_INC_DEC_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitPREFIX_INC_DEC_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitPREFIX_INC_DEC_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ARRAY_SUBSCRIPTING_EXPRESSIONContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ARRAY_SUBSCRIPTING_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterARRAY_SUBSCRIPTING_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitARRAY_SUBSCRIPTING_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitARRAY_SUBSCRIPTING_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SUBGROUP_EXPRESSIONContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SUBGROUP_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterSUBGROUP_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitSUBGROUP_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitSUBGROUP_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BIT_AND_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BIT_AND_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterBIT_AND_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitBIT_AND_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitBIT_AND_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class STRING_LITERALContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(MentalParser.STRING, 0); }
		public STRING_LITERALContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterSTRING_LITERAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitSTRING_LITERAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitSTRING_LITERAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FALSEContext extends ExpressionContext {
		public FALSEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterFALSE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitFALSE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitFALSE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UNRAY_PLUS_MINUS_EXPRESSIONContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UNRAY_PLUS_MINUS_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterUNRAY_PLUS_MINUS_EXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitUNRAY_PLUS_MINUS_EXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitUNRAY_PLUS_MINUS_EXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new PREFIX_INC_DEC_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(260);
				((PREFIX_INC_DEC_EXPRESSIONContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PREFIX_INC_DEC_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(261);
				expression(23);
				}
				break;
			case 2:
				{
				_localctx = new UNRAY_PLUS_MINUS_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				((UNRAY_PLUS_MINUS_EXPRESSIONContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UNRAY_PLUS_MINUS_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(263);
				expression(22);
				}
				break;
			case 3:
				{
				_localctx = new BIT_NOT_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				((BIT_NOT_EXPRESSIONContext)_localctx).op = match(BIT_NOT);
				setState(265);
				expression(21);
				}
				break;
			case 4:
				{
				_localctx = new LOGICAL_NOT_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				((LOGICAL_NOT_EXPRESSIONContext)_localctx).op = match(LOGICAL_NOT);
				setState(267);
				expression(20);
				}
				break;
			case 5:
				{
				_localctx = new REFERENCE_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				((REFERENCE_EXPRESSIONContext)_localctx).op = match(BIT_AND);
				setState(269);
				expression(19);
				}
				break;
			case 6:
				{
				_localctx = new CREATION_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(T__21);
				setState(271);
				originalType();
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(272);
						match(LBRACKET);
						setState(273);
						expression(0);
						setState(274);
						match(RBRACKET);
						}
						} 
					}
					setState(280);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				}
				break;
			case 7:
				{
				_localctx = new CREATION_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				match(T__21);
				setState(282);
				match(Identifier);
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(283);
						match(T__6);
						setState(284);
						expressionList();
						setState(285);
						match(T__7);
						}
						} 
					}
					setState(291);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 8:
				{
				_localctx = new SUBGROUP_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				match(T__6);
				setState(293);
				expression(0);
				setState(294);
				match(T__7);
				}
				break;
			case 9:
				{
				_localctx = new FUNCTION_CALLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296);
				match(Identifier);
				setState(297);
				match(T__6);
				setState(299);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT) | (1L << BIT_AND))) != 0)) {
					{
					setState(298);
					expressionList();
					}
				}

				setState(301);
				match(T__7);
				}
				break;
			case 10:
				{
				_localctx = new IDENTIFIERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				match(Identifier);
				}
				break;
			case 11:
				{
				_localctx = new INT_LITERALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(INT);
				}
				break;
			case 12:
				{
				_localctx = new STRING_LITERALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(304);
				match(STRING);
				}
				break;
			case 13:
				{
				_localctx = new TRUEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				match(T__22);
				}
				break;
			case 14:
				{
				_localctx = new FALSEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(306);
				match(T__23);
				}
				break;
			case 15:
				{
				_localctx = new NULLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				match(T__24);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(355);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(353);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new MEMBER_ACCESS_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(311);
						((MEMBER_ACCESS_EXPRESSIONContext)_localctx).op = match(PERIOD);
						setState(312);
						expression(26);
						}
						break;
					case 2:
						{
						_localctx = new MULTIPLY_DIVIDE_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(313);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(314);
						((MULTIPLY_DIVIDE_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MULTIPLY_DIVIDE_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(315);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new ADDITIVE_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(317);
						((ADDITIVE_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ADDITIVE_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(318);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new BIT_SHIFT_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(319);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(320);
						((BIT_SHIFT_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT || _la==RIGHT_SHIFT) ) {
							((BIT_SHIFT_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(321);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new RELATION_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(323);
						((RELATION_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
							((RELATION_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(324);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new EQUALITY_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(326);
						((EQUALITY_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==INEQUAL) ) {
							((EQUALITY_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(327);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new BIT_AND_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(329);
						((BIT_AND_EXPRESSIONContext)_localctx).op = match(BIT_AND);
						setState(330);
						expression(14);
						}
						break;
					case 8:
						{
						_localctx = new BIT_XOR_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(332);
						((BIT_XOR_EXPRESSIONContext)_localctx).op = match(BIT_XOR);
						setState(333);
						expression(13);
						}
						break;
					case 9:
						{
						_localctx = new BIT_OR_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(334);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(335);
						((BIT_OR_EXPRESSIONContext)_localctx).op = match(BIT_OR);
						setState(336);
						expression(12);
						}
						break;
					case 10:
						{
						_localctx = new LOGICAL_AND_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(337);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(338);
						((LOGICAL_AND_EXPRESSIONContext)_localctx).op = match(LOGICAL_AND);
						setState(339);
						expression(11);
						}
						break;
					case 11:
						{
						_localctx = new LOGICAL_OR_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(341);
						((LOGICAL_OR_EXPRESSIONContext)_localctx).op = match(LOGICAL_OR);
						setState(342);
						expression(10);
						}
						break;
					case 12:
						{
						_localctx = new ASSIGN_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(343);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(344);
						((ASSIGN_EXPRESSIONContext)_localctx).op = match(ASSIGN);
						setState(345);
						expression(8);
						}
						break;
					case 13:
						{
						_localctx = new ARRAY_SUBSCRIPTING_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(346);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(347);
						match(LBRACKET);
						setState(348);
						expression(0);
						setState(349);
						match(RBRACKET);
						}
						break;
					case 14:
						{
						_localctx = new SUFFIX_INC_DEC_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(351);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(352);
						((SUFFIX_INC_DEC_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((SUFFIX_INC_DEC_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			expression(0);
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(359);
				match(COMMA);
				setState(360);
				expression(0);
				}
				}
				setState(365);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return array_sempred((ArrayContext)_localctx, predIndex);
		case 25:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean array_sempred(ArrayContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 25);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		case 10:
			return precpred(_ctx, 10);
		case 11:
			return precpred(_ctx, 9);
		case 12:
			return precpred(_ctx, 8);
		case 13:
			return precpred(_ctx, 26);
		case 14:
			return precpred(_ctx, 24);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3;\u0171\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3C\n\3\f\3\16\3F\13\3\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5S\n\5\f\5\16\5V\13\5\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\7\3\7\5\7a"+
		"\n\7\3\b\3\b\5\be\n\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\3\b\3\t\3\t"+
		"\5\tr\n\t\3\t\3\t\3\t\5\tw\n\t\3\t\3\t\3\t\3\n\3\n\5\n~\n\n\3\13\3\13"+
		"\3\13\3\13\5\13\u0084\n\13\3\13\3\13\3\13\3\13\5\13\u008a\n\13\7\13\u008c"+
		"\n\13\f\13\16\13\u008f\13\13\3\13\3\13\3\f\3\f\5\f\u0095\n\f\3\f\3\f\3"+
		"\f\5\f\u009a\n\f\3\f\3\f\3\f\3\r\3\r\7\r\u00a1\n\r\f\r\16\r\u00a4\13\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00b6\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u00e6\n\27\3\27\3\27"+
		"\5\27\u00ea\n\27\3\27\3\27\5\27\u00ee\n\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0101"+
		"\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0117\n\33\f\33\16\33\u011a\13"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0122\n\33\f\33\16\33\u0125\13"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u012e\n\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u0137\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0164\n\33\f\33\16\33\u0167"+
		"\13\33\3\34\3\34\3\34\7\34\u016c\n\34\f\34\16\34\u016f\13\34\3\34\2\4"+
		"\4\64\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2"+
		"\t\4\2\3\4\37\37\3\2&\'\3\2!\"\3\2#%\3\2\66\67\3\2\62\65\3\2\60\61\u0198"+
		"\28\3\2\2\2\4:\3\2\2\2\6I\3\2\2\2\bK\3\2\2\2\n[\3\2\2\2\f`\3\2\2\2\16"+
		"b\3\2\2\2\20q\3\2\2\2\22}\3\2\2\2\24\177\3\2\2\2\26\u0094\3\2\2\2\30\u009e"+
		"\3\2\2\2\32\u00b5\3\2\2\2\34\u00b7\3\2\2\2\36\u00bd\3\2\2\2 \u00c3\3\2"+
		"\2\2\"\u00c8\3\2\2\2$\u00cd\3\2\2\2&\u00d2\3\2\2\2(\u00d4\3\2\2\2*\u00da"+
		"\3\2\2\2,\u00e2\3\2\2\2.\u00f2\3\2\2\2\60\u0100\3\2\2\2\62\u0102\3\2\2"+
		"\2\64\u0136\3\2\2\2\66\u0168\3\2\2\289\t\2\2\29\3\3\2\2\2:;\b\3\1\2;<"+
		"\5\2\2\2<=\7:\2\2=>\7;\2\2>D\3\2\2\2?@\f\3\2\2@A\7:\2\2AC\7;\2\2B?\3\2"+
		"\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\5\3\2\2\2FD\3\2\2\2GJ\5\2\2\2HJ\5"+
		"\4\3\2IG\3\2\2\2IH\3\2\2\2J\7\3\2\2\2KL\5\6\4\2LM\7\37\2\2MT\3\2\2\2N"+
		"O\79\2\2OP\5\6\4\2PQ\7\37\2\2QS\3\2\2\2RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2"+
		"TU\3\2\2\2U\t\3\2\2\2VT\3\2\2\2WZ\5\f\7\2XZ\5\22\n\2YW\3\2\2\2YX\3\2\2"+
		"\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\13\3\2\2\2][\3\2\2\2^a\5\16\b\2_a"+
		"\5\20\t\2`^\3\2\2\2`_\3\2\2\2a\r\3\2\2\2bd\7\5\2\2ce\7\37\2\2dc\3\2\2"+
		"\2de\3\2\2\2ef\3\2\2\2fj\7\6\2\2gi\5\24\13\2hg\3\2\2\2il\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\7\2\2n\17\3\2\2\2or\5\6\4\2pr\7"+
		"\b\2\2qo\3\2\2\2qp\3\2\2\2rs\3\2\2\2st\7\37\2\2tv\7\t\2\2uw\5\b\5\2vu"+
		"\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\n\2\2yz\7\13\2\2z\21\3\2\2\2{~\5\24\13"+
		"\2|~\5\26\f\2}{\3\2\2\2}|\3\2\2\2~\23\3\2\2\2\177\u0080\5\6\4\2\u0080"+
		"\u0083\7\37\2\2\u0081\u0082\7/\2\2\u0082\u0084\5\64\33\2\u0083\u0081\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u008d\3\2\2\2\u0085\u0086\79\2\2\u0086"+
		"\u0089\7\37\2\2\u0087\u0088\7/\2\2\u0088\u008a\5\64\33\2\u0089\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0085\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\13\2\2\u0091\25\3\2\2\2\u0092\u0095"+
		"\5\6\4\2\u0093\u0095\7\b\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\7\37\2\2\u0097\u0099\7\t\2\2\u0098\u009a\5"+
		"\b\5\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\7\n\2\2\u009c\u009d\5\30\r\2\u009d\27\3\2\2\2\u009e\u00a2\7\6\2"+
		"\2\u009f\u00a1\5\32\16\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a5\u00a6\7\7\2\2\u00a6\31\3\2\2\2\u00a7\u00b6\5\30\r\2\u00a8\u00b6"+
		"\5(\25\2\u00a9\u00b6\5*\26\2\u00aa\u00b6\5,\27\2\u00ab\u00b6\5.\30\2\u00ac"+
		"\u00b6\5\62\32\2\u00ad\u00b6\5\60\31\2\u00ae\u00b6\5&\24\2\u00af\u00b6"+
		"\5\24\13\2\u00b0\u00b6\5\34\17\2\u00b1\u00b6\5\36\20\2\u00b2\u00b6\5 "+
		"\21\2\u00b3\u00b6\5\"\22\2\u00b4\u00b6\5$\23\2\u00b5\u00a7\3\2\2\2\u00b5"+
		"\u00a8\3\2\2\2\u00b5\u00a9\3\2\2\2\u00b5\u00aa\3\2\2\2\u00b5\u00ab\3\2"+
		"\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00ad\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b5"+
		"\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b2\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\33\3\2\2\2\u00b7\u00b8"+
		"\7\f\2\2\u00b8\u00b9\7\t\2\2\u00b9\u00ba\5\64\33\2\u00ba\u00bb\7\n\2\2"+
		"\u00bb\u00bc\7\13\2\2\u00bc\35\3\2\2\2\u00bd\u00be\7\r\2\2\u00be\u00bf"+
		"\7\t\2\2\u00bf\u00c0\5\64\33\2\u00c0\u00c1\7\n\2\2\u00c1\u00c2\7\13\2"+
		"\2\u00c2\37\3\2\2\2\u00c3\u00c4\7\16\2\2\u00c4\u00c5\7\t\2\2\u00c5\u00c6"+
		"\7\n\2\2\u00c6\u00c7\7\13\2\2\u00c7!\3\2\2\2\u00c8\u00c9\7\17\2\2\u00c9"+
		"\u00ca\7\t\2\2\u00ca\u00cb\7\n\2\2\u00cb\u00cc\7\13\2\2\u00cc#\3\2\2\2"+
		"\u00cd\u00ce\7\20\2\2\u00ce\u00cf\7\t\2\2\u00cf\u00d0\5\64\33\2\u00d0"+
		"\u00d1\7\n\2\2\u00d1%\3\2\2\2\u00d2\u00d3\7\13\2\2\u00d3\'\3\2\2\2\u00d4"+
		"\u00d5\7\21\2\2\u00d5\u00d6\7\t\2\2\u00d6\u00d7\5\64\33\2\u00d7\u00d8"+
		"\7\n\2\2\u00d8\u00d9\5\32\16\2\u00d9)\3\2\2\2\u00da\u00db\7\21\2\2\u00db"+
		"\u00dc\7\t\2\2\u00dc\u00dd\5\64\33\2\u00dd\u00de\7\n\2\2\u00de\u00df\5"+
		"\32\16\2\u00df\u00e0\7\22\2\2\u00e0\u00e1\5\32\16\2\u00e1+\3\2\2\2\u00e2"+
		"\u00e3\7\23\2\2\u00e3\u00e5\7\t\2\2\u00e4\u00e6\5\64\33\2\u00e5\u00e4"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\7\13\2\2"+
		"\u00e8\u00ea\5\64\33\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ed\7\13\2\2\u00ec\u00ee\5\64\33\2\u00ed\u00ec\3\2\2"+
		"\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\7\n\2\2\u00f0\u00f1"+
		"\5\32\16\2\u00f1-\3\2\2\2\u00f2\u00f3\7\24\2\2\u00f3\u00f4\7\t\2\2\u00f4"+
		"\u00f5\5\64\33\2\u00f5\u00f6\7\n\2\2\u00f6\u00f7\5\32\16\2\u00f7/\3\2"+
		"\2\2\u00f8\u00f9\7\25\2\2\u00f9\u00fa\5\64\33\2\u00fa\u00fb\7\13\2\2\u00fb"+
		"\u0101\3\2\2\2\u00fc\u00fd\7\26\2\2\u00fd\u0101\7\13\2\2\u00fe\u00ff\7"+
		"\27\2\2\u00ff\u0101\7\13\2\2\u0100\u00f8\3\2\2\2\u0100\u00fc\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\61\3\2\2\2\u0102\u0103\5\64\33\2\u0103\u0104\7\13"+
		"\2\2\u0104\63\3\2\2\2\u0105\u0106\b\33\1\2\u0106\u0107\t\3\2\2\u0107\u0137"+
		"\5\64\33\31\u0108\u0109\t\4\2\2\u0109\u0137\5\64\33\30\u010a\u010b\7("+
		"\2\2\u010b\u0137\5\64\33\27\u010c\u010d\7)\2\2\u010d\u0137\5\64\33\26"+
		"\u010e\u010f\7*\2\2\u010f\u0137\5\64\33\25\u0110\u0111\7\30\2\2\u0111"+
		"\u0118\5\2\2\2\u0112\u0113\7:\2\2\u0113\u0114\5\64\33\2\u0114\u0115\7"+
		";\2\2\u0115\u0117\3\2\2\2\u0116\u0112\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0137\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011b\u011c\7\30\2\2\u011c\u0123\7\37\2\2\u011d\u011e\7\t\2\2\u011e"+
		"\u011f\5\66\34\2\u011f\u0120\7\n\2\2\u0120\u0122\3\2\2\2\u0121\u011d\3"+
		"\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0137\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7\t\2\2\u0127\u0128\5\64"+
		"\33\2\u0128\u0129\7\n\2\2\u0129\u0137\3\2\2\2\u012a\u012b\7\37\2\2\u012b"+
		"\u012d\7\t\2\2\u012c\u012e\5\66\34\2\u012d\u012c\3\2\2\2\u012d\u012e\3"+
		"\2\2\2\u012e\u012f\3\2\2\2\u012f\u0137\7\n\2\2\u0130\u0137\7\37\2\2\u0131"+
		"\u0137\7\36\2\2\u0132\u0137\7 \2\2\u0133\u0137\7\31\2\2\u0134\u0137\7"+
		"\32\2\2\u0135\u0137\7\33\2\2\u0136\u0105\3\2\2\2\u0136\u0108\3\2\2\2\u0136"+
		"\u010a\3\2\2\2\u0136\u010c\3\2\2\2\u0136\u010e\3\2\2\2\u0136\u0110\3\2"+
		"\2\2\u0136\u011b\3\2\2\2\u0136\u0126\3\2\2\2\u0136\u012a\3\2\2\2\u0136"+
		"\u0130\3\2\2\2\u0136\u0131\3\2\2\2\u0136\u0132\3\2\2\2\u0136\u0133\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137\u0165\3\2\2\2\u0138"+
		"\u0139\f\33\2\2\u0139\u013a\78\2\2\u013a\u0164\5\64\33\34\u013b\u013c"+
		"\f\24\2\2\u013c\u013d\t\5\2\2\u013d\u0164\5\64\33\25\u013e\u013f\f\23"+
		"\2\2\u013f\u0140\t\4\2\2\u0140\u0164\5\64\33\24\u0141\u0142\f\22\2\2\u0142"+
		"\u0143\t\6\2\2\u0143\u0164\5\64\33\23\u0144\u0145\f\21\2\2\u0145\u0146"+
		"\t\7\2\2\u0146\u0164\5\64\33\22\u0147\u0148\f\20\2\2\u0148\u0149\t\b\2"+
		"\2\u0149\u0164\5\64\33\21\u014a\u014b\f\17\2\2\u014b\u014c\7*\2\2\u014c"+
		"\u0164\5\64\33\20\u014d\u014e\f\16\2\2\u014e\u014f\7+\2\2\u014f\u0164"+
		"\5\64\33\17\u0150\u0151\f\r\2\2\u0151\u0152\7,\2\2\u0152\u0164\5\64\33"+
		"\16\u0153\u0154\f\f\2\2\u0154\u0155\7-\2\2\u0155\u0164\5\64\33\r\u0156"+
		"\u0157\f\13\2\2\u0157\u0158\7.\2\2\u0158\u0164\5\64\33\f\u0159\u015a\f"+
		"\n\2\2\u015a\u015b\7/\2\2\u015b\u0164\5\64\33\n\u015c\u015d\f\34\2\2\u015d"+
		"\u015e\7:\2\2\u015e\u015f\5\64\33\2\u015f\u0160\7;\2\2\u0160\u0164\3\2"+
		"\2\2\u0161\u0162\f\32\2\2\u0162\u0164\t\3\2\2\u0163\u0138\3\2\2\2\u0163"+
		"\u013b\3\2\2\2\u0163\u013e\3\2\2\2\u0163\u0141\3\2\2\2\u0163\u0144\3\2"+
		"\2\2\u0163\u0147\3\2\2\2\u0163\u014a\3\2\2\2\u0163\u014d\3\2\2\2\u0163"+
		"\u0150\3\2\2\2\u0163\u0153\3\2\2\2\u0163\u0156\3\2\2\2\u0163\u0159\3\2"+
		"\2\2\u0163\u015c\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\65\3\2\2\2\u0167\u0165\3\2\2"+
		"\2\u0168\u016d\5\64\33\2\u0169\u016a\79\2\2\u016a\u016c\5\64\33\2\u016b"+
		"\u0169\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2"+
		"\2\2\u016e\67\3\2\2\2\u016f\u016d\3\2\2\2\37DITY[`djqv}\u0083\u0089\u008d"+
		"\u0094\u0099\u00a2\u00b5\u00e5\u00e9\u00ed\u0100\u0118\u0123\u012d\u0136"+
		"\u0163\u0165\u016d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}