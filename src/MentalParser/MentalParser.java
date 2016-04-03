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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		COMMENT=32, WS=33, INT=34, Identifier=35, STRING=36, PLUS=37, MINUS=38, 
		MUL=39, DIV=40, MOD=41, INC=42, DEC=43, BIT_NOT=44, LOGICAL_NOT=45, BIT_AND=46, 
		BIT_XOR=47, BIT_OR=48, LOGICAL_AND=49, LOGICAL_OR=50, ASSIGN=51, EQUAL=52, 
		INEQUAL=53, LESS=54, GREATER=55, LESS_EQUAL=56, GREATER_EQUAL=57, LEFT_SHIFT=58, 
		RIGHT_SHIFT=59, PERIOD=60, COMMA=61, LBRACKET=62, RBRACKET=63;
	public static final int
		RULE_className = 0, RULE_typeName = 1, RULE_array = 2, RULE_type = 3, 
		RULE_parameter = 4, RULE_parametersList = 5, RULE_program = 6, RULE_declaration = 7, 
		RULE_classDeclaration = 8, RULE_functionDeclaration = 9, RULE_definition = 10, 
		RULE_singleVariable = 11, RULE_variableDefinition = 12, RULE_functionDefinition = 13, 
		RULE_compoundStatement = 14, RULE_statement = 15, RULE_callPrint = 16, 
		RULE_callPrintln = 17, RULE_callGetString = 18, RULE_callGetInt = 19, 
		RULE_callToString = 20, RULE_callSubString = 21, RULE_callLength = 22, 
		RULE_callParseInt = 23, RULE_callOrd = 24, RULE_callSize = 25, RULE_emptyStatement = 26, 
		RULE_ifStatement = 27, RULE_ifElseStatement = 28, RULE_forStatement = 29, 
		RULE_whileStatement = 30, RULE_jumpStatement = 31, RULE_expressionStatement = 32, 
		RULE_expression = 33, RULE_expressionList = 34;
	public static final String[] ruleNames = {
		"className", "typeName", "array", "type", "parameter", "parametersList", 
		"program", "declaration", "classDeclaration", "functionDeclaration", "definition", 
		"singleVariable", "variableDefinition", "functionDefinition", "compoundStatement", 
		"statement", "callPrint", "callPrintln", "callGetString", "callGetInt", 
		"callToString", "callSubString", "callLength", "callParseInt", "callOrd", 
		"callSize", "emptyStatement", "ifStatement", "ifElseStatement", "forStatement", 
		"whileStatement", "jumpStatement", "expressionStatement", "expression", 
		"expressionList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'string'", "'bool'", "'class'", "'{'", "'}'", "'void'", 
		"'('", "')'", "';'", "'print'", "'println'", "'getString'", "'getInt'", 
		"'toString'", "'substring'", "'length'", "'parseInt'", "'ord'", "'size'", 
		"'if'", "'else'", "'for'", "'while'", "'return'", "'continue'", "'break'", 
		"'new'", "'true'", "'false'", "'null'", null, null, null, null, null, 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'~'", "'!'", "'&'", 
		"'^'", "'|'", "'&&'", "'||'", "'='", "'=='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'<<'", "'>>'", "'.'", "','", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "COMMENT", "WS", "INT", 
		"Identifier", "STRING", "PLUS", "MINUS", "MUL", "DIV", "MOD", "INC", "DEC", 
		"BIT_NOT", "LOGICAL_NOT", "BIT_AND", "BIT_XOR", "BIT_OR", "LOGICAL_AND", 
		"LOGICAL_OR", "ASSIGN", "EQUAL", "INEQUAL", "LESS", "GREATER", "LESS_EQUAL", 
		"GREATER_EQUAL", "LEFT_SHIFT", "RIGHT_SHIFT", "PERIOD", "COMMA", "LBRACKET", 
		"RBRACKET"
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
	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(Identifier);
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

	public static class TypeNameContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeName);
		try {
			setState(76);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__2);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				className();
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

	public static class ArrayContext extends ParserRuleContext {
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
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(LBRACKET);
			setState(79);
			match(RBRACKET);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
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
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			typeName();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(82);
				array();
				}
				}
				setState(87);
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

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			type();
			setState(89);
			match(Identifier);
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

	public static class ParametersListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterParametersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitParametersList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitParametersList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersListContext parametersList() throws RecognitionException {
		ParametersListContext _localctx = new ParametersListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parametersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			parameter();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(92);
				match(COMMA);
				setState(93);
				parameter();
				}
				}
				setState(98);
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
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
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
		enterRule(_localctx, 12, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__9) | (1L << Identifier))) != 0)) {
				{
				setState(102);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(99);
					declaration();
					}
					break;
				case 2:
					{
					setState(100);
					definition();
					}
					break;
				case 3:
					{
					setState(101);
					emptyStatement();
					}
					break;
				}
				}
				setState(106);
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
		enterRule(_localctx, 14, RULE_declaration);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				classDeclaration();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__6:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
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
		public ClassNameContext name;
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
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
		enterRule(_localctx, 16, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__3);
			setState(113);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(112);
				((ClassDeclarationContext)_localctx).name = className();
				}
			}

			setState(115);
			match(T__4);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << Identifier))) != 0)) {
				{
				setState(118);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(116);
					variableDefinition();
					}
					break;
				case 2:
					{
					setState(117);
					functionDefinition();
					}
					break;
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(T__5);
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
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
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
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case Identifier:
				{
				setState(125);
				type();
				}
				break;
			case T__6:
				{
				setState(126);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(129);
			match(Identifier);
			setState(130);
			match(T__7);
			setState(132);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Identifier))) != 0)) {
				{
				setState(131);
				parametersList();
				}
			}

			setState(134);
			match(T__8);
			setState(135);
			match(T__9);
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
		enterRule(_localctx, 20, RULE_definition);
		try {
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
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

	public static class SingleVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SingleVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterSingleVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitSingleVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitSingleVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleVariableContext singleVariable() throws RecognitionException {
		SingleVariableContext _localctx = new SingleVariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_singleVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(Identifier);
			setState(144);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(142);
				match(ASSIGN);
				setState(143);
				expression(0);
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

	public static class VariableDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<SingleVariableContext> singleVariable() {
			return getRuleContexts(SingleVariableContext.class);
		}
		public SingleVariableContext singleVariable(int i) {
			return getRuleContext(SingleVariableContext.class,i);
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
		enterRule(_localctx, 24, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			type();
			setState(147);
			singleVariable();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(148);
				match(COMMA);
				setState(149);
				singleVariable();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(T__9);
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
		public Token functionName;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
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
		enterRule(_localctx, 26, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case Identifier:
				{
				setState(157);
				type();
				}
				break;
			case T__6:
				{
				setState(158);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(161);
			((FunctionDefinitionContext)_localctx).functionName = match(Identifier);
			setState(162);
			match(T__7);
			setState(164);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Identifier))) != 0)) {
				{
				setState(163);
				parametersList();
				}
			}

			setState(166);
			match(T__8);
			setState(167);
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
		enterRule(_localctx, 28, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__4);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT))) != 0)) {
				{
				{
				setState(170);
				statement();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(T__5);
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
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				ifElseStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				expressionStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
				jumpStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(185);
				emptyStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(186);
				variableDefinition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(187);
				callPrint();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(188);
				callPrintln();
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
		enterRule(_localctx, 32, RULE_callPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__10);
			setState(192);
			match(T__7);
			setState(193);
			expression(0);
			setState(194);
			match(T__8);
			setState(195);
			match(T__9);
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
		enterRule(_localctx, 34, RULE_callPrintln);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__11);
			setState(198);
			match(T__7);
			setState(199);
			expression(0);
			setState(200);
			match(T__8);
			setState(201);
			match(T__9);
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
		enterRule(_localctx, 36, RULE_callGetString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__12);
			setState(204);
			match(T__7);
			setState(205);
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
		enterRule(_localctx, 38, RULE_callGetInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__13);
			setState(208);
			match(T__7);
			setState(209);
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
		enterRule(_localctx, 40, RULE_callToString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__14);
			setState(212);
			match(T__7);
			setState(213);
			expression(0);
			setState(214);
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

	public static class CallSubStringContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallSubStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callSubString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallSubString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallSubString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallSubString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallSubStringContext callSubString() throws RecognitionException {
		CallSubStringContext _localctx = new CallSubStringContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_callSubString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__15);
			setState(217);
			match(T__7);
			setState(218);
			expression(0);
			setState(219);
			match(COMMA);
			setState(220);
			expression(0);
			setState(221);
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

	public static class CallLengthContext extends ParserRuleContext {
		public CallLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callLength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallLengthContext callLength() throws RecognitionException {
		CallLengthContext _localctx = new CallLengthContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_callLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__16);
			setState(224);
			match(T__7);
			setState(225);
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

	public static class CallParseIntContext extends ParserRuleContext {
		public CallParseIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callParseInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallParseInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallParseInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallParseInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallParseIntContext callParseInt() throws RecognitionException {
		CallParseIntContext _localctx = new CallParseIntContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_callParseInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__17);
			setState(228);
			match(T__7);
			setState(229);
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

	public static class CallOrdContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallOrdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callOrd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallOrd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallOrd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallOrd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallOrdContext callOrd() throws RecognitionException {
		CallOrdContext _localctx = new CallOrdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_callOrd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__18);
			setState(232);
			match(T__7);
			setState(233);
			expression(0);
			setState(234);
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

	public static class CallSizeContext extends ParserRuleContext {
		public CallSizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callSize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterCallSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitCallSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitCallSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallSizeContext callSize() throws RecognitionException {
		CallSizeContext _localctx = new CallSizeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_callSize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__19);
			setState(237);
			match(T__7);
			setState(238);
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
		enterRule(_localctx, 52, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__9);
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
		public StatementContext thenStatement;
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
		enterRule(_localctx, 54, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__20);
			setState(243);
			match(T__7);
			setState(244);
			expression(0);
			setState(245);
			match(T__8);
			setState(246);
			((IfStatementContext)_localctx).thenStatement = statement();
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
		public StatementContext thenStatement;
		public StatementContext elseStatment;
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
		enterRule(_localctx, 56, RULE_ifElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__20);
			setState(249);
			match(T__7);
			setState(250);
			expression(0);
			setState(251);
			match(T__8);
			setState(252);
			((IfElseStatementContext)_localctx).thenStatement = statement();
			setState(253);
			match(T__21);
			setState(254);
			((IfElseStatementContext)_localctx).elseStatment = statement();
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
		public ExpressionContext start;
		public ExpressionContext cond;
		public ExpressionContext loop;
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
		enterRule(_localctx, 58, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(T__22);
			setState(257);
			match(T__7);
			setState(259);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT))) != 0)) {
				{
				setState(258);
				((ForStatementContext)_localctx).start = expression(0);
				}
			}

			setState(261);
			match(T__9);
			setState(263);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT))) != 0)) {
				{
				setState(262);
				((ForStatementContext)_localctx).cond = expression(0);
				}
			}

			setState(265);
			match(T__9);
			setState(267);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT))) != 0)) {
				{
				setState(266);
				((ForStatementContext)_localctx).loop = expression(0);
				}
			}

			setState(269);
			match(T__8);
			setState(270);
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
		public ExpressionContext cond;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 60, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__23);
			setState(273);
			match(T__7);
			setState(274);
			((WhileStatementContext)_localctx).cond = expression(0);
			setState(275);
			match(T__8);
			setState(276);
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
		enterRule(_localctx, 62, RULE_jumpStatement);
		try {
			setState(286);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				match(T__24);
				setState(279);
				expression(0);
				setState(280);
				match(T__9);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(T__25);
				setState(283);
				match(T__9);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(T__26);
				setState(285);
				match(T__9);
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
		enterRule(_localctx, 64, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			expression(0);
			setState(289);
			match(T__9);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MentalParser.Identifier, 0); }
		public CallSubStringContext callSubString() {
			return getRuleContext(CallSubStringContext.class,0);
		}
		public CallLengthContext callLength() {
			return getRuleContext(CallLengthContext.class,0);
		}
		public CallParseIntContext callParseInt() {
			return getRuleContext(CallParseIntContext.class,0);
		}
		public CallOrdContext callOrd() {
			return getRuleContext(CallOrdContext.class,0);
		}
		public CallSizeContext callSize() {
			return getRuleContext(CallSizeContext.class,0);
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
		public Token functionName;
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
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
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
	public static class INTERNAL_FUNCTION_CALLContext extends ExpressionContext {
		public CallGetIntContext callGetInt() {
			return getRuleContext(CallGetIntContext.class,0);
		}
		public CallGetStringContext callGetString() {
			return getRuleContext(CallGetStringContext.class,0);
		}
		public CallToStringContext callToString() {
			return getRuleContext(CallToStringContext.class,0);
		}
		public INTERNAL_FUNCTION_CALLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).enterINTERNAL_FUNCTION_CALL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MentalListener ) ((MentalListener)listener).exitINTERNAL_FUNCTION_CALL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MentalVisitor ) return ((MentalVisitor<? extends T>)visitor).visitINTERNAL_FUNCTION_CALL(this);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new PREFIX_INC_DEC_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(292);
				((PREFIX_INC_DEC_EXPRESSIONContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PREFIX_INC_DEC_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(293);
				expression(23);
				}
				break;
			case 2:
				{
				_localctx = new UNRAY_PLUS_MINUS_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				((UNRAY_PLUS_MINUS_EXPRESSIONContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UNRAY_PLUS_MINUS_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(295);
				expression(22);
				}
				break;
			case 3:
				{
				_localctx = new BIT_NOT_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296);
				((BIT_NOT_EXPRESSIONContext)_localctx).op = match(BIT_NOT);
				setState(297);
				expression(21);
				}
				break;
			case 4:
				{
				_localctx = new LOGICAL_NOT_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				((LOGICAL_NOT_EXPRESSIONContext)_localctx).op = match(LOGICAL_NOT);
				setState(299);
				expression(20);
				}
				break;
			case 5:
				{
				_localctx = new SUBGROUP_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				match(T__7);
				setState(301);
				expression(0);
				setState(302);
				match(T__8);
				}
				break;
			case 6:
				{
				_localctx = new CREATION_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(304);
				match(T__27);
				setState(305);
				typeName();
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(306);
						match(LBRACKET);
						setState(307);
						expression(0);
						setState(308);
						match(RBRACKET);
						}
						} 
					}
					setState(314);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(315);
						array();
						}
						} 
					}
					setState(320);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 7:
				{
				_localctx = new FUNCTION_CALLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321);
				((FUNCTION_CALLContext)_localctx).functionName = match(Identifier);
				setState(322);
				match(T__7);
				setState(324);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << INT) | (1L << Identifier) | (1L << STRING) | (1L << PLUS) | (1L << MINUS) | (1L << INC) | (1L << DEC) | (1L << BIT_NOT) | (1L << LOGICAL_NOT))) != 0)) {
					{
					setState(323);
					expressionList();
					}
				}

				setState(326);
				match(T__8);
				}
				break;
			case 8:
				{
				_localctx = new INTERNAL_FUNCTION_CALLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(327);
					callGetInt();
					}
					break;
				case T__12:
					{
					setState(328);
					callGetString();
					}
					break;
				case T__14:
					{
					setState(329);
					callToString();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 9:
				{
				_localctx = new IDENTIFIERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				match(Identifier);
				}
				break;
			case 10:
				{
				_localctx = new INT_LITERALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(INT);
				}
				break;
			case 11:
				{
				_localctx = new STRING_LITERALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				match(STRING);
				}
				break;
			case 12:
				{
				_localctx = new TRUEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335);
				match(T__28);
				}
				break;
			case 13:
				{
				_localctx = new FALSEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(336);
				match(T__29);
				}
				break;
			case 14:
				{
				_localctx = new NULLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337);
				match(T__30);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(390);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new MULTIPLY_DIVIDE_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(341);
						((MULTIPLY_DIVIDE_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MULTIPLY_DIVIDE_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(342);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new ADDITIVE_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(343);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(344);
						((ADDITIVE_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ADDITIVE_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(345);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new BIT_SHIFT_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(346);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(347);
						((BIT_SHIFT_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT || _la==RIGHT_SHIFT) ) {
							((BIT_SHIFT_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(348);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new RELATION_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(349);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(350);
						((RELATION_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
							((RELATION_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(351);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new EQUALITY_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(352);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(353);
						((EQUALITY_EXPRESSIONContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==INEQUAL) ) {
							((EQUALITY_EXPRESSIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(354);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BIT_AND_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(355);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(356);
						((BIT_AND_EXPRESSIONContext)_localctx).op = match(BIT_AND);
						setState(357);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new BIT_XOR_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(358);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(359);
						((BIT_XOR_EXPRESSIONContext)_localctx).op = match(BIT_XOR);
						setState(360);
						expression(14);
						}
						break;
					case 8:
						{
						_localctx = new BIT_OR_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(361);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(362);
						((BIT_OR_EXPRESSIONContext)_localctx).op = match(BIT_OR);
						setState(363);
						expression(13);
						}
						break;
					case 9:
						{
						_localctx = new LOGICAL_AND_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(364);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(365);
						((LOGICAL_AND_EXPRESSIONContext)_localctx).op = match(LOGICAL_AND);
						setState(366);
						expression(12);
						}
						break;
					case 10:
						{
						_localctx = new LOGICAL_OR_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(367);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(368);
						((LOGICAL_OR_EXPRESSIONContext)_localctx).op = match(LOGICAL_OR);
						setState(369);
						expression(11);
						}
						break;
					case 11:
						{
						_localctx = new ASSIGN_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(370);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(371);
						((ASSIGN_EXPRESSIONContext)_localctx).op = match(ASSIGN);
						setState(372);
						expression(9);
						}
						break;
					case 12:
						{
						_localctx = new ARRAY_SUBSCRIPTING_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(373);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(374);
						match(LBRACKET);
						setState(375);
						expression(0);
						setState(376);
						match(RBRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MEMBER_ACCESS_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(378);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(379);
						((MEMBER_ACCESS_EXPRESSIONContext)_localctx).op = match(PERIOD);
						setState(386);
						switch (_input.LA(1)) {
						case Identifier:
							{
							setState(380);
							match(Identifier);
							}
							break;
						case T__15:
							{
							setState(381);
							callSubString();
							}
							break;
						case T__16:
							{
							setState(382);
							callLength();
							}
							break;
						case T__17:
							{
							setState(383);
							callParseInt();
							}
							break;
						case T__18:
							{
							setState(384);
							callOrd();
							}
							break;
						case T__19:
							{
							setState(385);
							callSize();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new SUFFIX_INC_DEC_EXPRESSIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(388);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(389);
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
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 68, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			expression(0);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(396);
				match(COMMA);
				setState(397);
				expression(0);
				}
				}
				setState(402);
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
		case 33:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 26);
		case 12:
			return precpred(_ctx, 25);
		case 13:
			return precpred(_ctx, 24);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3A\u0196\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\3\3\3\5\3O\n\3\3\4\3\4\3\4\3"+
		"\5\3\5\7\5V\n\5\f\5\16\5Y\13\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7a\n\7\f\7\16"+
		"\7d\13\7\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\t\3\t\5\tp\n\t\3\n\3\n"+
		"\5\nt\n\n\3\n\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\n\3\n\3\13\3\13\5\13\u0082"+
		"\n\13\3\13\3\13\3\13\5\13\u0087\n\13\3\13\3\13\3\13\3\f\3\f\5\f\u008e"+
		"\n\f\3\r\3\r\3\r\5\r\u0093\n\r\3\16\3\16\3\16\3\16\7\16\u0099\n\16\f\16"+
		"\16\16\u009c\13\16\3\16\3\16\3\17\3\17\5\17\u00a2\n\17\3\17\3\17\3\17"+
		"\5\17\u00a7\n\17\3\17\3\17\3\17\3\20\3\20\7\20\u00ae\n\20\f\20\16\20\u00b1"+
		"\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00c0\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\5\37\u0106\n\37\3\37\3\37\5\37\u010a\n\37\3\37\3\37\5\37\u010e\n"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\5!\u0121"+
		"\n!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\7#\u0139\n#\f#\16#\u013c\13#\3#\7#\u013f\n#\f#\16#\u0142\13#\3#\3"+
		"#\3#\5#\u0147\n#\3#\3#\3#\3#\5#\u014d\n#\3#\3#\3#\3#\3#\3#\5#\u0155\n"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\5#\u0185\n#\3#\3#\7#\u0189\n#\f#\16#\u018c\13#\3$\3$\3$\7$\u0191\n$"+
		"\f$\16$\u0194\13$\3$\2\3D%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDF\2\b\3\2,-\3\2\'(\3\2)+\3\2<=\3\28;\3\2\66\67"+
		"\u01bb\2H\3\2\2\2\4N\3\2\2\2\6P\3\2\2\2\bS\3\2\2\2\nZ\3\2\2\2\f]\3\2\2"+
		"\2\16j\3\2\2\2\20o\3\2\2\2\22q\3\2\2\2\24\u0081\3\2\2\2\26\u008d\3\2\2"+
		"\2\30\u008f\3\2\2\2\32\u0094\3\2\2\2\34\u00a1\3\2\2\2\36\u00ab\3\2\2\2"+
		" \u00bf\3\2\2\2\"\u00c1\3\2\2\2$\u00c7\3\2\2\2&\u00cd\3\2\2\2(\u00d1\3"+
		"\2\2\2*\u00d5\3\2\2\2,\u00da\3\2\2\2.\u00e1\3\2\2\2\60\u00e5\3\2\2\2\62"+
		"\u00e9\3\2\2\2\64\u00ee\3\2\2\2\66\u00f2\3\2\2\28\u00f4\3\2\2\2:\u00fa"+
		"\3\2\2\2<\u0102\3\2\2\2>\u0112\3\2\2\2@\u0120\3\2\2\2B\u0122\3\2\2\2D"+
		"\u0154\3\2\2\2F\u018d\3\2\2\2HI\7%\2\2I\3\3\2\2\2JO\7\3\2\2KO\7\4\2\2"+
		"LO\7\5\2\2MO\5\2\2\2NJ\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\5\3\2\2"+
		"\2PQ\7@\2\2QR\7A\2\2R\7\3\2\2\2SW\5\4\3\2TV\5\6\4\2UT\3\2\2\2VY\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2X\t\3\2\2\2YW\3\2\2\2Z[\5\b\5\2[\\\7%\2\2\\\13\3"+
		"\2\2\2]b\5\n\6\2^_\7?\2\2_a\5\n\6\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3"+
		"\2\2\2c\r\3\2\2\2db\3\2\2\2ei\5\20\t\2fi\5\26\f\2gi\5\66\34\2he\3\2\2"+
		"\2hf\3\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\17\3\2\2\2lj\3\2"+
		"\2\2mp\5\22\n\2np\5\24\13\2om\3\2\2\2on\3\2\2\2p\21\3\2\2\2qs\7\6\2\2"+
		"rt\5\2\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uz\7\7\2\2vy\5\32\16\2wy\5\34"+
		"\17\2xv\3\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3"+
		"\2\2\2}~\7\b\2\2~\23\3\2\2\2\177\u0082\5\b\5\2\u0080\u0082\7\t\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7%\2"+
		"\2\u0084\u0086\7\n\2\2\u0085\u0087\5\f\7\2\u0086\u0085\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\13\2\2\u0089\u008a\7\f\2\2"+
		"\u008a\25\3\2\2\2\u008b\u008e\5\32\16\2\u008c\u008e\5\34\17\2\u008d\u008b"+
		"\3\2\2\2\u008d\u008c\3\2\2\2\u008e\27\3\2\2\2\u008f\u0092\7%\2\2\u0090"+
		"\u0091\7\65\2\2\u0091\u0093\5D#\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\31\3\2\2\2\u0094\u0095\5\b\5\2\u0095\u009a\5\30\r\2\u0096\u0097"+
		"\7?\2\2\u0097\u0099\5\30\r\2\u0098\u0096\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009e\7\f\2\2\u009e\33\3\2\2\2\u009f\u00a2\5\b\5\2\u00a0\u00a2"+
		"\7\t\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\7%\2\2\u00a4\u00a6\7\n\2\2\u00a5\u00a7\5\f\7\2\u00a6\u00a5\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7\13\2\2\u00a9"+
		"\u00aa\5\36\20\2\u00aa\35\3\2\2\2\u00ab\u00af\7\7\2\2\u00ac\u00ae\5 \21"+
		"\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\b\2\2\u00b3"+
		"\37\3\2\2\2\u00b4\u00c0\5\36\20\2\u00b5\u00c0\58\35\2\u00b6\u00c0\5:\36"+
		"\2\u00b7\u00c0\5<\37\2\u00b8\u00c0\5> \2\u00b9\u00c0\5B\"\2\u00ba\u00c0"+
		"\5@!\2\u00bb\u00c0\5\66\34\2\u00bc\u00c0\5\32\16\2\u00bd\u00c0\5\"\22"+
		"\2\u00be\u00c0\5$\23\2\u00bf\u00b4\3\2\2\2\u00bf\u00b5\3\2\2\2\u00bf\u00b6"+
		"\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00b8\3\2\2\2\u00bf\u00b9\3\2\2\2\u00bf"+
		"\u00ba\3\2\2\2\u00bf\u00bb\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00be\3\2\2\2\u00c0!\3\2\2\2\u00c1\u00c2\7\r\2\2\u00c2\u00c3"+
		"\7\n\2\2\u00c3\u00c4\5D#\2\u00c4\u00c5\7\13\2\2\u00c5\u00c6\7\f\2\2\u00c6"+
		"#\3\2\2\2\u00c7\u00c8\7\16\2\2\u00c8\u00c9\7\n\2\2\u00c9\u00ca\5D#\2\u00ca"+
		"\u00cb\7\13\2\2\u00cb\u00cc\7\f\2\2\u00cc%\3\2\2\2\u00cd\u00ce\7\17\2"+
		"\2\u00ce\u00cf\7\n\2\2\u00cf\u00d0\7\13\2\2\u00d0\'\3\2\2\2\u00d1\u00d2"+
		"\7\20\2\2\u00d2\u00d3\7\n\2\2\u00d3\u00d4\7\13\2\2\u00d4)\3\2\2\2\u00d5"+
		"\u00d6\7\21\2\2\u00d6\u00d7\7\n\2\2\u00d7\u00d8\5D#\2\u00d8\u00d9\7\13"+
		"\2\2\u00d9+\3\2\2\2\u00da\u00db\7\22\2\2\u00db\u00dc\7\n\2\2\u00dc\u00dd"+
		"\5D#\2\u00dd\u00de\7?\2\2\u00de\u00df\5D#\2\u00df\u00e0\7\13\2\2\u00e0"+
		"-\3\2\2\2\u00e1\u00e2\7\23\2\2\u00e2\u00e3\7\n\2\2\u00e3\u00e4\7\13\2"+
		"\2\u00e4/\3\2\2\2\u00e5\u00e6\7\24\2\2\u00e6\u00e7\7\n\2\2\u00e7\u00e8"+
		"\7\13\2\2\u00e8\61\3\2\2\2\u00e9\u00ea\7\25\2\2\u00ea\u00eb\7\n\2\2\u00eb"+
		"\u00ec\5D#\2\u00ec\u00ed\7\13\2\2\u00ed\63\3\2\2\2\u00ee\u00ef\7\26\2"+
		"\2\u00ef\u00f0\7\n\2\2\u00f0\u00f1\7\13\2\2\u00f1\65\3\2\2\2\u00f2\u00f3"+
		"\7\f\2\2\u00f3\67\3\2\2\2\u00f4\u00f5\7\27\2\2\u00f5\u00f6\7\n\2\2\u00f6"+
		"\u00f7\5D#\2\u00f7\u00f8\7\13\2\2\u00f8\u00f9\5 \21\2\u00f99\3\2\2\2\u00fa"+
		"\u00fb\7\27\2\2\u00fb\u00fc\7\n\2\2\u00fc\u00fd\5D#\2\u00fd\u00fe\7\13"+
		"\2\2\u00fe\u00ff\5 \21\2\u00ff\u0100\7\30\2\2\u0100\u0101\5 \21\2\u0101"+
		";\3\2\2\2\u0102\u0103\7\31\2\2\u0103\u0105\7\n\2\2\u0104\u0106\5D#\2\u0105"+
		"\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\7\f"+
		"\2\2\u0108\u010a\5D#\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010d\7\f\2\2\u010c\u010e\5D#\2\u010d\u010c\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\7\13\2\2\u0110\u0111\5"+
		" \21\2\u0111=\3\2\2\2\u0112\u0113\7\32\2\2\u0113\u0114\7\n\2\2\u0114\u0115"+
		"\5D#\2\u0115\u0116\7\13\2\2\u0116\u0117\5 \21\2\u0117?\3\2\2\2\u0118\u0119"+
		"\7\33\2\2\u0119\u011a\5D#\2\u011a\u011b\7\f\2\2\u011b\u0121\3\2\2\2\u011c"+
		"\u011d\7\34\2\2\u011d\u0121\7\f\2\2\u011e\u011f\7\35\2\2\u011f\u0121\7"+
		"\f\2\2\u0120\u0118\3\2\2\2\u0120\u011c\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"A\3\2\2\2\u0122\u0123\5D#\2\u0123\u0124\7\f\2\2\u0124C\3\2\2\2\u0125\u0126"+
		"\b#\1\2\u0126\u0127\t\2\2\2\u0127\u0155\5D#\31\u0128\u0129\t\3\2\2\u0129"+
		"\u0155\5D#\30\u012a\u012b\7.\2\2\u012b\u0155\5D#\27\u012c\u012d\7/\2\2"+
		"\u012d\u0155\5D#\26\u012e\u012f\7\n\2\2\u012f\u0130\5D#\2\u0130\u0131"+
		"\7\13\2\2\u0131\u0155\3\2\2\2\u0132\u0133\7\36\2\2\u0133\u013a\5\4\3\2"+
		"\u0134\u0135\7@\2\2\u0135\u0136\5D#\2\u0136\u0137\7A\2\2\u0137\u0139\3"+
		"\2\2\2\u0138\u0134\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u0140\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013f\5\6"+
		"\4\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0155\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\7%"+
		"\2\2\u0144\u0146\7\n\2\2\u0145\u0147\5F$\2\u0146\u0145\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0155\7\13\2\2\u0149\u014d\5(\25\2"+
		"\u014a\u014d\5&\24\2\u014b\u014d\5*\26\2\u014c\u0149\3\2\2\2\u014c\u014a"+
		"\3\2\2\2\u014c\u014b\3\2\2\2\u014d\u0155\3\2\2\2\u014e\u0155\7%\2\2\u014f"+
		"\u0155\7$\2\2\u0150\u0155\7&\2\2\u0151\u0155\7\37\2\2\u0152\u0155\7 \2"+
		"\2\u0153\u0155\7!\2\2\u0154\u0125\3\2\2\2\u0154\u0128\3\2\2\2\u0154\u012a"+
		"\3\2\2\2\u0154\u012c\3\2\2\2\u0154\u012e\3\2\2\2\u0154\u0132\3\2\2\2\u0154"+
		"\u0143\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3\2"+
		"\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0153\3\2\2\2\u0155\u018a\3\2\2\2\u0156\u0157\f\25\2\2\u0157\u0158\t"+
		"\4\2\2\u0158\u0189\5D#\26\u0159\u015a\f\24\2\2\u015a\u015b\t\3\2\2\u015b"+
		"\u0189\5D#\25\u015c\u015d\f\23\2\2\u015d\u015e\t\5\2\2\u015e\u0189\5D"+
		"#\24\u015f\u0160\f\22\2\2\u0160\u0161\t\6\2\2\u0161\u0189\5D#\23\u0162"+
		"\u0163\f\21\2\2\u0163\u0164\t\7\2\2\u0164\u0189\5D#\22\u0165\u0166\f\20"+
		"\2\2\u0166\u0167\7\60\2\2\u0167\u0189\5D#\21\u0168\u0169\f\17\2\2\u0169"+
		"\u016a\7\61\2\2\u016a\u0189\5D#\20\u016b\u016c\f\16\2\2\u016c\u016d\7"+
		"\62\2\2\u016d\u0189\5D#\17\u016e\u016f\f\r\2\2\u016f\u0170\7\63\2\2\u0170"+
		"\u0189\5D#\16\u0171\u0172\f\f\2\2\u0172\u0173\7\64\2\2\u0173\u0189\5D"+
		"#\r\u0174\u0175\f\13\2\2\u0175\u0176\7\65\2\2\u0176\u0189\5D#\13\u0177"+
		"\u0178\f\34\2\2\u0178\u0179\7@\2\2\u0179\u017a\5D#\2\u017a\u017b\7A\2"+
		"\2\u017b\u0189\3\2\2\2\u017c\u017d\f\33\2\2\u017d\u0184\7>\2\2\u017e\u0185"+
		"\7%\2\2\u017f\u0185\5,\27\2\u0180\u0185\5.\30\2\u0181\u0185\5\60\31\2"+
		"\u0182\u0185\5\62\32\2\u0183\u0185\5\64\33\2\u0184\u017e\3\2\2\2\u0184"+
		"\u017f\3\2\2\2\u0184\u0180\3\2\2\2\u0184\u0181\3\2\2\2\u0184\u0182\3\2"+
		"\2\2\u0184\u0183\3\2\2\2\u0185\u0189\3\2\2\2\u0186\u0187\f\32\2\2\u0187"+
		"\u0189\t\2\2\2\u0188\u0156\3\2\2\2\u0188\u0159\3\2\2\2\u0188\u015c\3\2"+
		"\2\2\u0188\u015f\3\2\2\2\u0188\u0162\3\2\2\2\u0188\u0165\3\2\2\2\u0188"+
		"\u0168\3\2\2\2\u0188\u016b\3\2\2\2\u0188\u016e\3\2\2\2\u0188\u0171\3\2"+
		"\2\2\u0188\u0174\3\2\2\2\u0188\u0177\3\2\2\2\u0188\u017c\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018bE\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u0192\5D#\2\u018e\u018f"+
		"\7?\2\2\u018f\u0191\5D#\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193G\3\2\2\2\u0194\u0192\3\2\2\2"+
		"!NWbhjosxz\u0081\u0086\u008d\u0092\u009a\u00a1\u00a6\u00af\u00bf\u0105"+
		"\u0109\u010d\u0120\u013a\u0140\u0146\u014c\u0154\u0184\u0188\u018a\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}