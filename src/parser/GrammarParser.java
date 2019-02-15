// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static {
		RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, INT_CONSTANT = 5, REAL_CONSTANT = 6, INT = 7, FLOAT = 8, CHAR = 9, MAS = 10, MENOS = 11, MUL = 12, DIV = 13, IGUAL = 14, PTO_COMA = 15, READ = 16, WRITE = 17, IDENT = 18, LINE_COMMENT = 19, MULTILINE_COMMENT = 20, WHITESPACE = 21;
	public static final int RULE_start = 0, RULE_instrucciones = 1, RULE_instruccion = 2, RULE_definicion = 3, RULE_type = 4;

	private static String[] makeRuleNames() {
		return new String[]{"start", "instrucciones", "instruccion", "definicion", "type"};
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
	public ATN getATN() {
		return _ATN;
	}

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class, 0);
		}

		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_start;
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(10);
				instrucciones();
			}
		} catch(RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstruccionesContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}

		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class, i);
		}

		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_instrucciones;
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while(_la == T__0) {
					{
						{
							setState(12);
							instruccion();
						}
					}
					setState(17);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch(RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstruccionContext extends ParserRuleContext {
		public TerminalNode PTO_COMA() {
			return getToken(GrammarParser.PTO_COMA, 0);
		}

		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class, 0);
		}

		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_instruccion;
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			enterOuterAlt(_localctx, 1);
			{
				{
					setState(18);
					definicion();
				}
				setState(19);
				match(PTO_COMA);
			}
		} catch(RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinicionContext extends ParserRuleContext {
		public TerminalNode IDENT() {
			return getToken(GrammarParser.IDENT, 0);
		}

		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public List<TerminalNode> INT_CONSTANT() {
			return getTokens(GrammarParser.INT_CONSTANT);
		}

		public TerminalNode INT_CONSTANT(int i) {
			return getToken(GrammarParser.INT_CONSTANT, i);
		}

		public DefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_definicion;
		}
	}

	public final DefinicionContext definicion() throws RecognitionException {
		DefinicionContext _localctx = new DefinicionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definicion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(21);
				match(T__0);
				setState(22);
				match(IDENT);
				setState(23);
				match(T__1);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while(_la == T__2) {
					{
						{
							setState(24);
							match(T__2);
							setState(25);
							match(INT_CONSTANT);
							setState(26);
							match(T__3);
						}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				type();
			}
		} catch(RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() {
			return getToken(GrammarParser.INT, 0);
		}

		public TerminalNode FLOAT() {
			return getToken(GrammarParser.FLOAT, 0);
		}

		public TerminalNode CHAR() {
			return getToken(GrammarParser.CHAR, 0);
		}

		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_type;
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(34);
				_la = _input.LA(1);
				if(!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << CHAR))) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if(_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch(RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\'\4\2\t\2\4\3" + "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\7\3\20\n\3\f\3\16\3\23\13\3\3" + "\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\36\n\5\f\5\16\5!\13\5\3\5\3\5\3" + "\6\3\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2\t\13\2#\2\f\3\2\2\2\4\21\3\2\2\2\6" + "\24\3\2\2\2\b\27\3\2\2\2\n$\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\20\5\6" + "\4\2\17\16\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\5\3\2" + "\2\2\23\21\3\2\2\2\24\25\5\b\5\2\25\26\7\21\2\2\26\7\3\2\2\2\27\30\7\3" + "\2\2\30\31\7\24\2\2\31\37\7\4\2\2\32\33\7\5\2\2\33\34\7\7\2\2\34\36\7" + "\6\2\2\35\32\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2" + "!\37\3\2\2\2\"#\5\n\6\2#\t\3\2\2\2$%\t\2\2\2%\13\3\2\2\2\4\21\37";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for(int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}