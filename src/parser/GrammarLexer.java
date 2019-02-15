// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static {
		RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, INT_CONSTANT = 5, REAL_CONSTANT = 6, INT = 7, FLOAT = 8, CHAR = 9, MAS = 10, MENOS = 11, MUL = 12, DIV = 13, IGUAL = 14, PTO_COMA = 15, READ = 16, WRITE = 17, IDENT = 18, LINE_COMMENT = 19, MULTILINE_COMMENT = 20, WHITESPACE = 21;
	public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

	public static String[] modeNames = {"DEFAULT_MODE"};

	private static String[] makeRuleNames() {
		return new String[]{"T__0", "T__1", "T__2", "T__3", "INT_CONSTANT", "REAL_CONSTANT", "INT", "FLOAT", "CHAR", "MAS", "MENOS", "MUL", "DIV", "IGUAL", "PTO_COMA", "READ", "WRITE", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[]{null, "'var'", "':'", "'['", "']'", null, null, "'int'", "'float'", "'char'", "'+'", "'-'", "'*'", "'/'", "'='", "';'", "'read'", "'write'"};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[]{null, null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "INT", "FLOAT", "CHAR", "MAS", "MENOS", "MUL", "DIV", "IGUAL", "PTO_COMA", "READ", "WRITE", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"};
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
		for(int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if(tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if(tokenNames[i] == null) {
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String getGrammarFileName() {
		return "Grammar.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public String[] getChannelNames() {
		return channelNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0094\b\1\4\2" + "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" + "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" + "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\3\3\3" + "\3\4\3\4\3\5\3\5\3\6\6\69\n\6\r\6\16\6:\3\7\6\7>\n\7\r\7\16\7?\3\7\3\7" + "\6\7D\n\7\r\7\16\7E\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3" + "\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21" + "\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\6\23o\n\23\r\23" + "\16\23p\3\24\3\24\3\24\3\24\7\24w\n\24\f\24\16\24z\13\24\3\24\3\24\3\24" + "\3\24\3\25\3\25\3\25\3\25\7\25\u0084\n\25\f\25\16\25\u0087\13\25\3\25" + "\3\25\3\25\3\25\3\25\3\26\6\26\u008f\n\26\r\26\16\26\u0090\3\26\3\26\4" + "x\u0085\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16" + "\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\5\3\2\62;\5\2\62;C\\c" + "|\5\2\13\f\17\17\"\"\2\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3" + "\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2" + "\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37" + "\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3" + "\2\2\2\3-\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\138\3\2\2\2\r" + "=\3\2\2\2\17G\3\2\2\2\21K\3\2\2\2\23Q\3\2\2\2\25V\3\2\2\2\27X\3\2\2\2" + "\31Z\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37`\3\2\2\2!b\3\2\2\2#g\3\2\2\2" + "%n\3\2\2\2\'r\3\2\2\2)\177\3\2\2\2+\u008e\3\2\2\2-.\7x\2\2./\7c\2\2/\60" + "\7t\2\2\60\4\3\2\2\2\61\62\7<\2\2\62\6\3\2\2\2\63\64\7]\2\2\64\b\3\2\2" + "\2\65\66\7_\2\2\66\n\3\2\2\2\679\t\2\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2" + "\2:;\3\2\2\2;\f\3\2\2\2<>\t\2\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2" + "\2\2@A\3\2\2\2AC\7\60\2\2BD\t\2\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3" + "\2\2\2F\16\3\2\2\2GH\7k\2\2HI\7p\2\2IJ\7v\2\2J\20\3\2\2\2KL\7h\2\2LM\7" + "n\2\2MN\7q\2\2NO\7c\2\2OP\7v\2\2P\22\3\2\2\2QR\7e\2\2RS\7j\2\2ST\7c\2" + "\2TU\7t\2\2U\24\3\2\2\2VW\7-\2\2W\26\3\2\2\2XY\7/\2\2Y\30\3\2\2\2Z[\7" + ",\2\2[\32\3\2\2\2\\]\7\61\2\2]\34\3\2\2\2^_\7?\2\2_\36\3\2\2\2`a\7=\2" + "\2a \3\2\2\2bc\7t\2\2cd\7g\2\2de\7c\2\2ef\7f\2\2f\"\3\2\2\2gh\7y\2\2h" + "i\7t\2\2ij\7k\2\2jk\7v\2\2kl\7g\2\2l$\3\2\2\2mo\t\3\2\2nm\3\2\2\2op\3" + "\2\2\2pn\3\2\2\2pq\3\2\2\2q&\3\2\2\2rs\7\61\2\2st\7\61\2\2tx\3\2\2\2u" + "w\13\2\2\2vu\3\2\2\2wz\3\2\2\2xy\3\2\2\2xv\3\2\2\2y{\3\2\2\2zx\3\2\2\2" + "{|\7\f\2\2|}\3\2\2\2}~\b\24\2\2~(\3\2\2\2\177\u0080\7\61\2\2\u0080\u0081" + "\7,\2\2\u0081\u0085\3\2\2\2\u0082\u0084\13\2\2\2\u0083\u0082\3\2\2\2\u0084" + "\u0087\3\2\2\2\u0085\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0088\3\2" + "\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7,\2\2\u0089\u008a\7\61\2\2\u008a" + "\u008b\3\2\2\2\u008b\u008c\b\25\2\2\u008c*\3\2\2\2\u008d\u008f\t\4\2\2" + "\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091" + "\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\26\2\2\u0093,\3\2\2\2\n\2:" + "?Epx\u0085\u0090\3\b\2\2";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for(int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}