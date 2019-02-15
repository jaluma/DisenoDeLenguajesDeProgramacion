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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31, T__31 = 32, INT_CONSTANT = 33, REAL_CONSTANT = 34, INT = 35, FLOAT = 36, CHAR = 37, CAST = 38, PTO_COMA = 39, IDENT = 40, LINE_COMMENT = 41, MULTILINE_COMMENT = 42, WHITESPACE = 43;
	public static final int RULE_start = 0, RULE_main = 1, RULE_instruccion = 2, RULE_definicion = 3, RULE_def = 4, RULE_funcion = 5, RULE_sentencia = 6, RULE_expr = 7, RULE_tipo = 8;
	private static String[] makeRuleNames() {
		return new String[]{"start", "main", "instruccion", "definicion", "def", "funcion", "sentencia", "expr", "tipo"};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[]{null, "'main'", "'('", "')'", "'{'", "'}'", "'var'", "':'", "'['", "']'", "'struct'", "','", "'print'", "'printsp'", "'println'", "'='", "'return'", "'if'", "'else'", "'while'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'.'", null, null, "'int'", "'float'", "'char'", "'cast'", "';'"};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "INT", "FLOAT", "CHAR", "CAST", "PTO_COMA", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"};
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
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while(_la == T__5 || _la == IDENT) {
					{
						{
							setState(18);
							instruccion();
						}
					}
					setState(23);
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

	public static class MainContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}

		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class, i);
		}

		public List<DefinicionContext> definicion() {
			return getRuleContexts(DefinicionContext.class);
		}

		public DefinicionContext definicion(int i) {
			return getRuleContext(DefinicionContext.class, i);
		}

		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_main;
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(24);
				match(T__0);
				setState(25);
				match(T__1);
				setState(26);
				match(T__2);
				setState(27);
				match(T__3);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
					{
						{
							setState(31);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while(_la == T__5) {
								{
									{
										setState(28);
										definicion();
									}
								}
								setState(33);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(34);
							sentencia();
						}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(40);
				match(T__4);
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
		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class, 0);
		}
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class, 0);
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
				setState(44);
				_errHandler.sync(this);
				switch(_input.LA(1)) {
					case T__5: {
						setState(42);
						definicion();
					}
					break;
					case IDENT: {
						setState(43);
						funcion();
					}
					break;
					default:
						throw new NoViableAltException(this);
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

	public static class DefinicionContext extends ParserRuleContext {
		public DefContext def() {
			return getRuleContext(DefContext.class, 0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(46);
				match(T__5);
				setState(47);
				def();
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

	public static class DefContext extends ParserRuleContext {
		public TerminalNode IDENT() {
			return getToken(GrammarParser.IDENT, 0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class, 0);
		}

		public TerminalNode PTO_COMA() {
			return getToken(GrammarParser.PTO_COMA, 0);
		}

		public List<TerminalNode> INT_CONSTANT() {
			return getTokens(GrammarParser.INT_CONSTANT);
		}

		public TerminalNode INT_CONSTANT(int i) {
			return getToken(GrammarParser.INT_CONSTANT, i);
		}

		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}

		public DefContext def(int i) {
			return getRuleContext(DefContext.class, i);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_def;
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_def);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch(_input.LA(1)) {
				case IDENT:
					enterOuterAlt(_localctx, 1);
				{
					setState(49);
				match(IDENT);
					setState(50);
					match(T__6);
					setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
					while(_la == T__7) {
					{
						{
							setState(51);
							match(T__7);
							setState(52);
							match(INT_CONSTANT);
							setState(53);
							match(T__8);
						}
					}
						setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
					setState(59);
				tipo();
					setState(60);
				match(PTO_COMA);
				}
				break;
				case T__9:
					enterOuterAlt(_localctx, 2);
				{
					setState(62);
					match(T__9);
					setState(63);
					match(IDENT);
					setState(64);
					match(T__3);
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while(_la == T__9 || _la == IDENT) {
						{
							{
								setState(65);
								def();
							}
						}
						setState(70);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(71);
					match(T__4);
					setState(72);
					match(PTO_COMA);
				}
				break;
				default:
					throw new NoViableAltException(this);
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

	public static class FuncionContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() {
			return getTokens(GrammarParser.IDENT);
		}
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class, i);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class, i);
		}
		public List<DefinicionContext> definicion() {
			return getRuleContexts(DefinicionContext.class);
		}
		public DefinicionContext definicion(int i) {
			return getRuleContext(DefinicionContext.class, i);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_funcion;
		}
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(75);
				match(IDENT);
				setState(76);
				match(T__1);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if(_la == IDENT) {
					{
						setState(77);
						match(IDENT);
						setState(78);
						match(T__6);
						setState(79);
						tipo();
						setState(86);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while(_la == T__10) {
							{
								{
									setState(80);
									match(T__10);
									setState(81);
									match(IDENT);
									setState(82);
									match(T__6);
									setState(83);
									tipo();
								}
							}
							setState(88);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
					}
				}

				setState(91);
				match(T__2);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while(_la == T__6) {
					{
						{
							setState(92);
							match(T__6);
							setState(93);
							tipo();
						}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(T__3);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
					{
						{
							setState(103);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while(_la == T__5) {
								{
									{
										setState(100);
										definicion();
									}
								}
								setState(105);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(106);
							sentencia();
						}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(T__4);
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

	public static class SentenciaContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public TerminalNode PTO_COMA() {
			return getToken(GrammarParser.PTO_COMA, 0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class, i);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_sentencia;
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentencia);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch(getInterpreter().adaptivePredict(_input, 17, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(114);
					match(T__11);
					setState(115);
					expr(0);
					setState(116);
					match(PTO_COMA);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(118);
					match(T__12);
					setState(119);
					expr(0);
					setState(120);
					match(PTO_COMA);
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(122);
					match(T__13);
					setState(123);
					expr(0);
					setState(124);
					match(PTO_COMA);
				}
				break;
				case 4:
					enterOuterAlt(_localctx, 4);
				{
					setState(126);
					expr(0);
					setState(127);
					match(T__14);
					setState(128);
					expr(0);
					setState(129);
					match(PTO_COMA);
				}
				break;
				case 5:
					enterOuterAlt(_localctx, 5);
				{
					setState(131);
					match(T__15);
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							setState(132);
							expr(0);
						}
					}

					setState(135);
					match(PTO_COMA);
				}
				break;
				case 6:
					enterOuterAlt(_localctx, 6);
				{
					setState(136);
					match(T__16);
					setState(137);
					match(T__1);
					setState(138);
					expr(0);
					setState(139);
					match(T__2);
					setState(140);
					match(T__3);
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(141);
								sentencia();
							}
						}
						setState(146);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(147);
					match(T__4);
				}
				break;
				case 7:
					enterOuterAlt(_localctx, 7);
				{
					setState(149);
					match(T__16);
					setState(150);
					match(T__1);
					setState(151);
					expr(0);
					setState(152);
					match(T__2);
					setState(153);
					match(T__3);
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(154);
								sentencia();
							}
						}
						setState(159);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(160);
					match(T__4);
					setState(161);
					match(T__17);
					setState(162);
					match(T__3);
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(163);
								sentencia();
							}
						}
						setState(168);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(169);
					match(T__4);
				}
				break;
				case 8:
					enterOuterAlt(_localctx, 8);
				{
					setState(171);
					match(T__18);
					setState(172);
					match(T__1);
					setState(173);
					expr(0);
					setState(174);
					match(T__2);
					setState(175);
					match(T__3);
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(176);
								sentencia();
							}
						}
						setState(181);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(182);
					match(T__4);
				}
				break;
				case 9:
					enterOuterAlt(_localctx, 9);
				{
					setState(184);
					expr(0);
					setState(185);
					match(PTO_COMA);
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode INT_CONSTANT() {
			return getToken(GrammarParser.INT_CONSTANT, 0);
		}

		public TerminalNode REAL_CONSTANT() {
			return getToken(GrammarParser.REAL_CONSTANT, 0);
		}

		public TerminalNode IDENT() {
			return getToken(GrammarParser.IDENT, 0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
		}

		public TerminalNode CAST() {
			return getToken(GrammarParser.CAST, 0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class, 0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expr;
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(218);
				_errHandler.sync(this);
				switch(getInterpreter().adaptivePredict(_input, 20, _ctx)) {
					case 1: {
						setState(190);
						match(INT_CONSTANT);
					}
					break;
					case 2: {
						setState(191);
						match(REAL_CONSTANT);
					}
					break;
					case 3: {
						setState(192);
						match(IDENT);
					}
					break;
					case 4: {
						setState(193);
						match(IDENT);
						setState(194);
						match(T__1);
						setState(203);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
							{
								setState(195);
								expr(0);
								setState(200);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while(_la == T__10) {
									{
										{
											setState(196);
											match(T__10);
						setState(197);
											expr(0);
										}
									}
									setState(202);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
							}
						}

						setState(205);
						match(T__2);
					}
					break;
					case 5: {
						setState(206);
						match(T__1);
						setState(207);
						expr(0);
						setState(208);
						match(T__2);
					}
					break;
					case 6: {
						setState(210);
						match(CAST);
						setState(211);
						match(T__19);
						setState(212);
						tipo();
						setState(213);
						match(T__20);
						setState(214);
						match(T__1);
						setState(215);
						expr(0);
						setState(216);
						match(T__2);
					}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
				while(_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if(_alt == 1) {
						if(_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(246);
							_errHandler.sync(this);
							switch(getInterpreter().adaptivePredict(_input, 21, _ctx)) {
								case 1: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(220);
									if(!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(221);
									_la = _input.LA(1);
									if(!(_la == T__21 || _la == T__22)) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(222);
									expr(9);
								}
								break;
								case 2: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(223);
									if(!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(224);
									_la = _input.LA(1);
									if(!(_la == T__23 || _la == T__24)) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(225);
									expr(8);
								}
								break;
								case 3: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(226);
									if(!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(227);
									_la = _input.LA(1);
									if(!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0))) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(228);
									expr(7);
								}
								break;
								case 4: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(229);
									if(!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(230);
									_la = _input.LA(1);
									if(!(_la == T__27 || _la == T__28)) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(231);
									expr(6);
								}
								break;
								case 5: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(232);
									if(!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(233);
									match(T__29);
									setState(234);
									expr(5);
								}
								break;
								case 6: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(235);
									if(!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(236);
									match(T__30);
									setState(237);
									expr(4);
								}
								break;
								case 7: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(238);
									if(!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(239);
									match(T__7);
									setState(240);
									expr(0);
									setState(241);
									match(T__8);
								}
								break;
								case 8: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(243);
									if(!(precpred(_ctx, 1)))
										throw new FailedPredicateException(this, "precpred(_ctx, 1)");
									setState(244);
									match(T__31);
									setState(245);
									match(IDENT);
								}
								break;
							}
						}
					}
					setState(250);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
				}
			}
		} catch(RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() {
			return getToken(GrammarParser.INT, 0);
		}

		public TerminalNode FLOAT() {
			return getToken(GrammarParser.FLOAT, 0);
		}

		public TerminalNode CHAR() {
			return getToken(GrammarParser.CHAR, 0);
		}

		public TerminalNode IDENT() {
			return getToken(GrammarParser.IDENT, 0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_tipo;
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(251);
				_la = _input.LA(1);
				if(!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << CHAR) | (1L << IDENT))) != 0))) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch(ruleIndex) {
			case 7:
				return expr_sempred((ExprContext) _localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch(predIndex) {
			case 0:
				return precpred(_ctx, 8);
			case 1:
				return precpred(_ctx, 7);
			case 2:
				return precpred(_ctx, 6);
			case 3:
				return precpred(_ctx, 5);
			case 4:
				return precpred(_ctx, 4);
			case 5:
				return precpred(_ctx, 3);
			case 6:
				return precpred(_ctx, 2);
			case 7:
				return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0100\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2" + "\26\n\2\f\2\16\2\31\13\2\3\3\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3" + "\3\7\3&\n\3\f\3\16\3)\13\3\3\3\3\3\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\6\3" + "\6\3\6\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6" + "E\n\6\f\6\16\6H\13\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7" + "\3\7\7\7W\n\7\f\7\16\7Z\13\7\5\7\\\n\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d" + "\13\7\3\7\3\7\7\7h\n\7\f\7\16\7k\13\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7" + "\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3" + "\b\3\b\3\b\5\b\u0088\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0091\n\b\f\b" + "\16\b\u0094\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u009e\n\b\f\b\16" + "\b\u00a1\13\b\3\b\3\b\3\b\3\b\7\b\u00a7\n\b\f\b\16\b\u00aa\13\b\3\b\3" + "\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b4\n\b\f\b\16\b\u00b7\13\b\3\b\3\b\3" + "\b\3\b\3\b\5\b\u00be\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00c9" + "\n\t\f\t\16\t\u00cc\13\t\5\t\u00ce\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t" + "\3\t\3\t\3\t\3\t\3\t\5\t\u00dd\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t" + "\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7" + "\t\u00f9\n\t\f\t\16\t\u00fc\13\t\3\n\3\n\3\n\2\3\20\13\2\4\6\b\n\f\16" + "\20\22\2\7\3\2\30\31\3\2\32\33\4\2\26\27\34\35\3\2\36\37\4\2%\'**\2\u011e" + "\2\27\3\2\2\2\4\32\3\2\2\2\6.\3\2\2\2\b\60\3\2\2\2\nK\3\2\2\2\fM\3\2\2" + "\2\16\u00bd\3\2\2\2\20\u00dc\3\2\2\2\22\u00fd\3\2\2\2\24\26\5\6\4\2\25" + "\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31" + "\27\3\2\2\2\32\33\7\3\2\2\33\34\7\4\2\2\34\35\7\5\2\2\35\'\7\6\2\2\36" + " \5\b\5\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!" + "\3\2\2\2$&\5\16\b\2%!\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2" + "\2)\'\3\2\2\2*+\7\7\2\2+\5\3\2\2\2,/\5\b\5\2-/\5\f\7\2.,\3\2\2\2.-\3\2" + "\2\2/\7\3\2\2\2\60\61\7\b\2\2\61\62\5\n\6\2\62\t\3\2\2\2\63\64\7*\2\2" + "\64:\7\t\2\2\65\66\7\n\2\2\66\67\7#\2\2\679\7\13\2\28\65\3\2\2\29<\3\2" + "\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\5\22\n\2>?\7)\2\2?L\3\2" + "\2\2@A\7\f\2\2AB\7*\2\2BF\7\6\2\2CE\5\n\6\2DC\3\2\2\2EH\3\2\2\2FD\3\2" + "\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\7\2\2JL\7)\2\2K\63\3\2\2\2K@\3" + "\2\2\2L\13\3\2\2\2MN\7*\2\2N[\7\4\2\2OP\7*\2\2PQ\7\t\2\2QX\5\22\n\2RS" + "\7\r\2\2ST\7*\2\2TU\7\t\2\2UW\5\22\n\2VR\3\2\2\2WZ\3\2\2\2XV\3\2\2\2X" + "Y\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2[O\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]b\7\5\2" + "\2^_\7\t\2\2_a\5\22\n\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2" + "\2\2db\3\2\2\2eo\7\6\2\2fh\5\b\5\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2" + "\2\2jl\3\2\2\2ki\3\2\2\2ln\5\16\b\2mi\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3" + "\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\7\2\2s\r\3\2\2\2tu\7\16\2\2uv\5\20\t\2" + "vw\7)\2\2w\u00be\3\2\2\2xy\7\17\2\2yz\5\20\t\2z{\7)\2\2{\u00be\3\2\2\2" + "|}\7\20\2\2}~\5\20\t\2~\177\7)\2\2\177\u00be\3\2\2\2\u0080\u0081\5\20" + "\t\2\u0081\u0082\7\21\2\2\u0082\u0083\5\20\t\2\u0083\u0084\7)\2\2\u0084" + "\u00be\3\2\2\2\u0085\u0087\7\22\2\2\u0086\u0088\5\20\t\2\u0087\u0086\3" + "\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u00be\7)\2\2\u008a" + "\u008b\7\23\2\2\u008b\u008c\7\4\2\2\u008c\u008d\5\20\t\2\u008d\u008e\7" + "\5\2\2\u008e\u0092\7\6\2\2\u008f\u0091\5\16\b\2\u0090\u008f\3\2\2\2\u0091" + "\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2" + "\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\7\2\2\u0096\u00be\3\2\2\2\u0097" + "\u0098\7\23\2\2\u0098\u0099\7\4\2\2\u0099\u009a\5\20\t\2\u009a\u009b\7" + "\5\2\2\u009b\u009f\7\6\2\2\u009c\u009e\5\16\b\2\u009d\u009c\3\2\2\2\u009e" + "\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2" + "\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\7\2\2\u00a3\u00a4\7\24\2\2\u00a4" + "\u00a8\7\6\2\2\u00a5\u00a7\5\16\b\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3" + "\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa" + "\u00a8\3\2\2\2\u00ab\u00ac\7\7\2\2\u00ac\u00be\3\2\2\2\u00ad\u00ae\7\25" + "\2\2\u00ae\u00af\7\4\2\2\u00af\u00b0\5\20\t\2\u00b0\u00b1\7\5\2\2\u00b1" + "\u00b5\7\6\2\2\u00b2\u00b4\5\16\b\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3" + "\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7" + "\u00b5\3\2\2\2\u00b8\u00b9\7\7\2\2\u00b9\u00be\3\2\2\2\u00ba\u00bb\5\20" + "\t\2\u00bb\u00bc\7)\2\2\u00bc\u00be\3\2\2\2\u00bdt\3\2\2\2\u00bdx\3\2" + "\2\2\u00bd|\3\2\2\2\u00bd\u0080\3\2\2\2\u00bd\u0085\3\2\2\2\u00bd\u008a" + "\3\2\2\2\u00bd\u0097\3\2\2\2\u00bd\u00ad\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be" + "\17\3\2\2\2\u00bf\u00c0\b\t\1\2\u00c0\u00dd\7#\2\2\u00c1\u00dd\7$\2\2" + "\u00c2\u00dd\7*\2\2\u00c3\u00c4\7*\2\2\u00c4\u00cd\7\4\2\2\u00c5\u00ca" + "\5\20\t\2\u00c6\u00c7\7\r\2\2\u00c7\u00c9\5\20\t\2\u00c8\u00c6\3\2\2\2" + "\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce" + "\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce" + "\u00cf\3\2\2\2\u00cf\u00dd\7\5\2\2\u00d0\u00d1\7\4\2\2\u00d1\u00d2\5\20" + "\t\2\u00d2\u00d3\7\5\2\2\u00d3\u00dd\3\2\2\2\u00d4\u00d5\7(\2\2\u00d5" + "\u00d6\7\26\2\2\u00d6\u00d7\5\22\n\2\u00d7\u00d8\7\27\2\2\u00d8\u00d9" + "\7\4\2\2\u00d9\u00da\5\20\t\2\u00da\u00db\7\5\2\2\u00db\u00dd\3\2\2\2" + "\u00dc\u00bf\3\2\2\2\u00dc\u00c1\3\2\2\2\u00dc\u00c2\3\2\2\2\u00dc\u00c3" + "\3\2\2\2\u00dc\u00d0\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dd\u00fa\3\2\2\2\u00de" + "\u00df\f\n\2\2\u00df\u00e0\t\2\2\2\u00e0\u00f9\5\20\t\13\u00e1\u00e2\f" + "\t\2\2\u00e2\u00e3\t\3\2\2\u00e3\u00f9\5\20\t\n\u00e4\u00e5\f\b\2\2\u00e5" + "\u00e6\t\4\2\2\u00e6\u00f9\5\20\t\t\u00e7\u00e8\f\7\2\2\u00e8\u00e9\t" + "\5\2\2\u00e9\u00f9\5\20\t\b\u00ea\u00eb\f\6\2\2\u00eb\u00ec\7 \2\2\u00ec" + "\u00f9\5\20\t\7\u00ed\u00ee\f\5\2\2\u00ee\u00ef\7!\2\2\u00ef\u00f9\5\20" + "\t\6\u00f0\u00f1\f\4\2\2\u00f1\u00f2\7\n\2\2\u00f2\u00f3\5\20\t\2\u00f3" + "\u00f4\7\13\2\2\u00f4\u00f9\3\2\2\2\u00f5\u00f6\f\3\2\2\u00f6\u00f7\7" + "\"\2\2\u00f7\u00f9\7*\2\2\u00f8\u00de\3\2\2\2\u00f8\u00e1\3\2\2\2\u00f8" + "\u00e4\3\2\2\2\u00f8\u00e7\3\2\2\2\u00f8\u00ea\3\2\2\2\u00f8\u00ed\3\2" + "\2\2\u00f8\u00f0\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa" + "\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\21\3\2\2\2\u00fc\u00fa\3\2\2" + "\2\u00fd\u00fe\t\6\2\2\u00fe\23\3\2\2\2\31\27!\'.:FKX[bio\u0087\u0092" + "\u009f\u00a8\u00b5\u00bd\u00ca\u00cd\u00dc\u00f8\u00fa";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for(int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}