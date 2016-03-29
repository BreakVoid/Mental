// Generated from /Users/Songyu/Projects/Mental/src/MentalParser/Mental.g4 by ANTLR 4.5.1
package MentalParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MentalLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"COMMENT", "WS", "INT", "Identifier", "Hexquad", "Universalcharactername", 
		"Identifiernondigit", "NONDIGIT", "DIGIT", "STRING", "ESC", "UNICODE", 
		"HEX", "PLUS", "MINUS", "MUL", "DIV", "MOD", "INC", "DEC", "BIT_NOT", 
		"LOGICAL_NOT", "BIT_AND", "BIT_XOR", "BIT_OR", "LOGICAL_AND", "LOGICAL_OR", 
		"ASSIGN", "EQUAL", "INEQUAL", "LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", 
		"LEFT_SHIFT", "RIGHT_SHIFT", "PERIOD", "COMMA", "LBRACKET", "RBRACKET"
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


	public MentalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mental.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u019e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u010e\n\33\f\33\16\33\u0111\13\33"+
		"\3\33\5\33\u0114\n\33\3\33\5\33\u0117\n\33\3\33\3\33\3\34\6\34\u011c\n"+
		"\34\r\34\16\34\u011d\3\34\3\34\3\35\6\35\u0123\n\35\r\35\16\35\u0124\3"+
		"\36\3\36\3\36\7\36\u012a\n\36\f\36\16\36\u012d\13\36\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u013e\n \3!\3!\5!\u0142\n!\3"+
		"\"\3\"\3#\3#\3$\3$\3$\7$\u014b\n$\f$\16$\u014e\13$\3$\3$\3%\3%\3%\5%\u0155"+
		"\n%\3&\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3"+
		".\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3;\3"+
		"<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3\u014c\2C\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37=\2?\2A\2"+
		"C\2E\2G I\2K\2M\2O!Q\"S#U$W%Y&[\'](_)a*c+e,g-i.k/m\60o\61q\62s\63u\64"+
		"w\65y\66{\67}8\1779\u0081:\u0083;\3\2\t\4\2\f\f\17\17\3\3\f\f\5\2\13\f"+
		"\17\17\"\"\5\2C\\aac|\3\2\62;\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\u01a0"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2G\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2"+
		"\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0085\3\2\2\2\5\u0089"+
		"\3\2\2\2\7\u0090\3\2\2\2\t\u0096\3\2\2\2\13\u0098\3\2\2\2\r\u009a\3\2"+
		"\2\2\17\u009f\3\2\2\2\21\u00a1\3\2\2\2\23\u00a3\3\2\2\2\25\u00a5\3\2\2"+
		"\2\27\u00ab\3\2\2\2\31\u00b3\3\2\2\2\33\u00bd\3\2\2\2\35\u00c4\3\2\2\2"+
		"\37\u00cd\3\2\2\2!\u00d0\3\2\2\2#\u00d5\3\2\2\2%\u00d9\3\2\2\2\'\u00df"+
		"\3\2\2\2)\u00e6\3\2\2\2+\u00ef\3\2\2\2-\u00f5\3\2\2\2/\u00f9\3\2\2\2\61"+
		"\u00fe\3\2\2\2\63\u0104\3\2\2\2\65\u0109\3\2\2\2\67\u011b\3\2\2\29\u0122"+
		"\3\2\2\2;\u0126\3\2\2\2=\u012e\3\2\2\2?\u013d\3\2\2\2A\u0141\3\2\2\2C"+
		"\u0143\3\2\2\2E\u0145\3\2\2\2G\u0147\3\2\2\2I\u0151\3\2\2\2K\u0156\3\2"+
		"\2\2M\u015c\3\2\2\2O\u015e\3\2\2\2Q\u0160\3\2\2\2S\u0162\3\2\2\2U\u0164"+
		"\3\2\2\2W\u0166\3\2\2\2Y\u0168\3\2\2\2[\u016b\3\2\2\2]\u016e\3\2\2\2_"+
		"\u0170\3\2\2\2a\u0172\3\2\2\2c\u0174\3\2\2\2e\u0176\3\2\2\2g\u0178\3\2"+
		"\2\2i\u017b\3\2\2\2k\u017e\3\2\2\2m\u0180\3\2\2\2o\u0183\3\2\2\2q\u0186"+
		"\3\2\2\2s\u0188\3\2\2\2u\u018a\3\2\2\2w\u018d\3\2\2\2y\u0190\3\2\2\2{"+
		"\u0193\3\2\2\2}\u0196\3\2\2\2\177\u0198\3\2\2\2\u0081\u019a\3\2\2\2\u0083"+
		"\u019c\3\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7v\2"+
		"\2\u0088\4\3\2\2\2\u0089\u008a\7u\2\2\u008a\u008b\7v\2\2\u008b\u008c\7"+
		"t\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7i\2\2\u008f\6"+
		"\3\2\2\2\u0090\u0091\7e\2\2\u0091\u0092\7n\2\2\u0092\u0093\7c\2\2\u0093"+
		"\u0094\7u\2\2\u0094\u0095\7u\2\2\u0095\b\3\2\2\2\u0096\u0097\7}\2\2\u0097"+
		"\n\3\2\2\2\u0098\u0099\7\177\2\2\u0099\f\3\2\2\2\u009a\u009b\7x\2\2\u009b"+
		"\u009c\7q\2\2\u009c\u009d\7k\2\2\u009d\u009e\7f\2\2\u009e\16\3\2\2\2\u009f"+
		"\u00a0\7*\2\2\u00a0\20\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2\22\3\2\2\2\u00a3"+
		"\u00a4\7=\2\2\u00a4\24\3\2\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7t\2\2\u00a7"+
		"\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa\26\3\2\2\2\u00ab"+
		"\u00ac\7r\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7p\2\2"+
		"\u00af\u00b0\7v\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7p\2\2\u00b2\30\3\2"+
		"\2\2\u00b3\u00b4\7i\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7"+
		"\7U\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7k\2\2\u00ba"+
		"\u00bb\7p\2\2\u00bb\u00bc\7i\2\2\u00bc\32\3\2\2\2\u00bd\u00be\7i\2\2\u00be"+
		"\u00bf\7g\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7K\2\2\u00c1\u00c2\7p\2\2"+
		"\u00c2\u00c3\7v\2\2\u00c3\34\3\2\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7"+
		"q\2\2\u00c6\u00c7\7U\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca"+
		"\7k\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7i\2\2\u00cc\36\3\2\2\2\u00cd\u00ce"+
		"\7k\2\2\u00ce\u00cf\7h\2\2\u00cf \3\2\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2"+
		"\7n\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7g\2\2\u00d4\"\3\2\2\2\u00d5\u00d6"+
		"\7h\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7t\2\2\u00d8$\3\2\2\2\u00d9\u00da"+
		"\7y\2\2\u00da\u00db\7j\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7n\2\2\u00dd"+
		"\u00de\7g\2\2\u00de&\3\2\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"\u00e2\7v\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7p\2\2"+
		"\u00e5(\3\2\2\2\u00e6\u00e7\7e\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7p\2"+
		"\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed"+
		"\7w\2\2\u00ed\u00ee\7g\2\2\u00ee*\3\2\2\2\u00ef\u00f0\7d\2\2\u00f0\u00f1"+
		"\7t\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7m\2\2\u00f4"+
		",\3\2\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7y\2\2\u00f8"+
		".\3\2\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7w\2\2\u00fc"+
		"\u00fd\7g\2\2\u00fd\60\3\2\2\2\u00fe\u00ff\7h\2\2\u00ff\u0100\7c\2\2\u0100"+
		"\u0101\7n\2\2\u0101\u0102\7u\2\2\u0102\u0103\7g\2\2\u0103\62\3\2\2\2\u0104"+
		"\u0105\7p\2\2\u0105\u0106\7w\2\2\u0106\u0107\7n\2\2\u0107\u0108\7n\2\2"+
		"\u0108\64\3\2\2\2\u0109\u010a\7\61\2\2\u010a\u010b\7\61\2\2\u010b\u010f"+
		"\3\2\2\2\u010c\u010e\n\2\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0112\u0114\7\17\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u0117\t\3\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\b\33\2\2\u0119\66\3\2\2\2\u011a\u011c\t\4\2\2\u011b\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\b\34\2\2\u01208\3\2\2\2\u0121\u0123\5E#\2\u0122"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125:\3\2\2\2\u0126\u012b\5A!\2\u0127\u012a\5A!\2\u0128\u012a\5"+
		"E#\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c<\3\2\2\2\u012d\u012b\3\2\2\2"+
		"\u012e\u012f\5M\'\2\u012f\u0130\5M\'\2\u0130\u0131\5M\'\2\u0131\u0132"+
		"\5M\'\2\u0132>\3\2\2\2\u0133\u0134\7^\2\2\u0134\u0135\7w\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u013e\5=\37\2\u0137\u0138\7^\2\2\u0138\u0139\7W\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\5=\37\2\u013b\u013c\5=\37\2\u013c\u013e\3\2"+
		"\2\2\u013d\u0133\3\2\2\2\u013d\u0137\3\2\2\2\u013e@\3\2\2\2\u013f\u0142"+
		"\5C\"\2\u0140\u0142\5? \2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142"+
		"B\3\2\2\2\u0143\u0144\t\5\2\2\u0144D\3\2\2\2\u0145\u0146\t\6\2\2\u0146"+
		"F\3\2\2\2\u0147\u014c\7$\2\2\u0148\u014b\5I%\2\u0149\u014b\13\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0150\7$\2\2\u0150H\3\2\2\2\u0151\u0154\7^\2\2\u0152\u0155\t\7\2\2\u0153"+
		"\u0155\5K&\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155J\3\2\2\2\u0156"+
		"\u0157\7w\2\2\u0157\u0158\5M\'\2\u0158\u0159\5M\'\2\u0159\u015a\5M\'\2"+
		"\u015a\u015b\5M\'\2\u015bL\3\2\2\2\u015c\u015d\t\b\2\2\u015dN\3\2\2\2"+
		"\u015e\u015f\7-\2\2\u015fP\3\2\2\2\u0160\u0161\7/\2\2\u0161R\3\2\2\2\u0162"+
		"\u0163\7,\2\2\u0163T\3\2\2\2\u0164\u0165\7\61\2\2\u0165V\3\2\2\2\u0166"+
		"\u0167\7\'\2\2\u0167X\3\2\2\2\u0168\u0169\7-\2\2\u0169\u016a\7-\2\2\u016a"+
		"Z\3\2\2\2\u016b\u016c\7/\2\2\u016c\u016d\7/\2\2\u016d\\\3\2\2\2\u016e"+
		"\u016f\7\u0080\2\2\u016f^\3\2\2\2\u0170\u0171\7#\2\2\u0171`\3\2\2\2\u0172"+
		"\u0173\7(\2\2\u0173b\3\2\2\2\u0174\u0175\7`\2\2\u0175d\3\2\2\2\u0176\u0177"+
		"\7~\2\2\u0177f\3\2\2\2\u0178\u0179\7(\2\2\u0179\u017a\7(\2\2\u017ah\3"+
		"\2\2\2\u017b\u017c\7~\2\2\u017c\u017d\7~\2\2\u017dj\3\2\2\2\u017e\u017f"+
		"\7?\2\2\u017fl\3\2\2\2\u0180\u0181\7?\2\2\u0181\u0182\7?\2\2\u0182n\3"+
		"\2\2\2\u0183\u0184\7#\2\2\u0184\u0185\7?\2\2\u0185p\3\2\2\2\u0186\u0187"+
		"\7>\2\2\u0187r\3\2\2\2\u0188\u0189\7@\2\2\u0189t\3\2\2\2\u018a\u018b\7"+
		">\2\2\u018b\u018c\7?\2\2\u018cv\3\2\2\2\u018d\u018e\7@\2\2\u018e\u018f"+
		"\7?\2\2\u018fx\3\2\2\2\u0190\u0191\7>\2\2\u0191\u0192\7>\2\2\u0192z\3"+
		"\2\2\2\u0193\u0194\7@\2\2\u0194\u0195\7@\2\2\u0195|\3\2\2\2\u0196\u0197"+
		"\7\60\2\2\u0197~\3\2\2\2\u0198\u0199\7.\2\2\u0199\u0080\3\2\2\2\u019a"+
		"\u019b\7]\2\2\u019b\u0082\3\2\2\2\u019c\u019d\7_\2\2\u019d\u0084\3\2\2"+
		"\2\17\2\u010f\u0113\u0116\u011d\u0124\u0129\u012b\u013d\u0141\u014a\u014c"+
		"\u0154\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}