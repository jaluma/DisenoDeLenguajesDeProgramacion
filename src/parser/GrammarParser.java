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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31, INT_CONSTANT = 32, REAL_CONSTANT = 33, INT = 34, FLOAT = 35, CHAR = 36, CAST = 37, PTO_COMA = 38, IDENT = 39, LINE_COMMENT = 40, MULTILINE_COMMENT = 41, WHITESPACE = 42;
	public static final int RULE_start = 0, RULE_instruccion = 1, RULE_definicion = 2, RULE_def = 3, RULE_estructura = 4, RULE_funcion = 5, RULE_sentencia = 6, RULE_expr = 7, RULE_tipo = 8;
	private static String[] makeRuleNames() {
		return new String[]{"start", "instruccion", "definicion", "def", "estructura", "funcion", "sentencia", "expr", "tipo"};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[]{null, "'var'", "':'", "'['", "']'", "'struct'", "'{'", "'}'", "'('", "','", "')'", "'return'", "'print'", "'printsp'", "'println'", "'='", "'if'", "'else'", "'while'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'.'", null, null, "'int'", "'float'", "'char'", "'cast'", "';'"};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "INT", "FLOAT", "CHAR", "CAST", "PTO_COMA", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"};
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
				while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << IDENT))) != 0)) {
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

	public static class InstruccionContext extends ParserRuleContext {
		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class, 0);
		}

		public EstructuraContext estructura() {
			return getRuleContext(EstructuraContext.class, 0);
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
		enterRule(_localctx, 2, RULE_instruccion);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(27);
				_errHandler.sync(this);
				switch(_input.LA(1)) {
					case T__0: {
						setState(24);
						definicion();
					}
					break;
					case T__4: {
						setState(25);
						estructura();
					}
					break;
					case IDENT: {
						setState(26);
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
		enterRule(_localctx, 4, RULE_definicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(29);
				match(T__0);
				setState(30);
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

		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class, i);
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
		enterRule(_localctx, 6, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(32);
				match(IDENT);
				setState(33);
				match(T__1);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while(_la == T__2) {
					{
						{
							setState(34);
							match(T__2);
							setState(35);
							expr(0);
							setState(36);
							match(T__3);
						}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(43);
				tipo();
				setState(44);
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

	public static class EstructuraContext extends ParserRuleContext {
		public TerminalNode IDENT() {
			return getToken(GrammarParser.IDENT, 0);
		}

		public TerminalNode PTO_COMA() {
			return getToken(GrammarParser.PTO_COMA, 0);
		}

		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}

		public DefContext def(int i) {
			return getRuleContext(DefContext.class, i);
		}

		public EstructuraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_estructura;
		}
	}

	public final EstructuraContext estructura() throws RecognitionException {
		EstructuraContext _localctx = new EstructuraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_estructura);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(46);
				match(T__4);
				setState(47);
				match(IDENT);
				setState(48);
				match(T__5);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while(_la == IDENT) {
					{
						{
							setState(49);
							def();
						}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(T__6);
				setState(56);
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

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TerminalNode PTO_COMA() {
			return getToken(GrammarParser.PTO_COMA, 0);
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
			setState(126);
			_errHandler.sync(this);
			switch(getInterpreter().adaptivePredict(_input, 12, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(58);
					match(IDENT);
					setState(59);
					match(T__7);
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if(_la == IDENT) {
						{
							setState(60);
							match(IDENT);
							setState(61);
							match(T__1);
							setState(62);
							tipo();
							setState(69);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while(_la == T__8) {
								{
									{
										setState(63);
										match(T__8);
										setState(64);
										match(IDENT);
										setState(65);
										match(T__1);
										setState(66);
										tipo();
									}
								}
								setState(71);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
						}
					}

					setState(74);
					match(T__9);
					setState(75);
					match(T__5);
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(79);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while(_la == T__0) {
									{
										{
											setState(76);
											definicion();
										}
									}
									setState(81);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(82);
								sentencia();
							}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(88);
					match(T__6);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(89);
					match(IDENT);
					setState(90);
					match(T__7);
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if(_la == IDENT) {
						{
							setState(91);
							match(IDENT);
							setState(92);
							match(T__1);
							setState(93);
							tipo();
							setState(100);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while(_la == T__8) {
								{
									{
										setState(94);
										match(T__8);
										setState(95);
										match(IDENT);
										setState(96);
										match(T__1);
										setState(97);
										tipo();
									}
								}
								setState(102);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
						}
					}

					setState(105);
					match(T__9);
					setState(106);
					match(T__1);
					setState(107);
					tipo();
					setState(108);
					match(T__5);
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(112);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while(_la == T__0) {
									{
										{
											setState(109);
											definicion();
										}
									}
									setState(114);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(115);
								sentencia();
							}
						}
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(121);
					match(T__10);
					setState(122);
					expr(0);
					setState(123);
					match(PTO_COMA);
					setState(124);
					match(T__6);
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
			int _alt;
			setState(191);
			_errHandler.sync(this);
			switch(getInterpreter().adaptivePredict(_input, 17, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(128);
					match(T__11);
					setState(129);
					expr(0);
					setState(130);
					match(PTO_COMA);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(132);
					match(T__12);
					setState(133);
					expr(0);
					setState(134);
					match(PTO_COMA);
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(136);
					match(T__13);
					setState(137);
					expr(0);
					setState(138);
					match(PTO_COMA);
				}
				break;
				case 4:
					enterOuterAlt(_localctx, 4);
				{
					setState(140);
					expr(0);
					setState(141);
					match(T__14);
					setState(142);
					expr(0);
					setState(143);
					match(PTO_COMA);
				}
				break;
				case 5:
					enterOuterAlt(_localctx, 5);
				{
					setState(145);
					match(T__15);
					setState(146);
					match(T__7);
					setState(147);
					expr(0);
					setState(148);
					match(T__9);
					setState(149);
					match(T__5);
					setState(153);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
					while(_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
						if(_alt == 1) {
							{
								{
									setState(150);
									sentencia();
								}
							}
						}
						setState(155);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
					}
				}
				break;
				case 6:
					enterOuterAlt(_localctx, 6);
				{
					setState(156);
					match(T__15);
					setState(157);
					match(T__7);
					setState(158);
					expr(0);
					setState(159);
					match(T__9);
					setState(160);
					match(T__5);
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(161);
								sentencia();
							}
						}
						setState(166);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(167);
					match(T__6);
					setState(168);
					match(T__16);
					setState(169);
					match(T__5);
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(170);
								sentencia();
							}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(176);
					match(T__6);
				}
				break;
				case 7:
					enterOuterAlt(_localctx, 7);
				{
					setState(178);
					match(T__17);
					setState(179);
					match(T__7);
					setState(180);
					expr(0);
					setState(181);
					match(T__9);
					setState(182);
					match(T__5);
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CAST) | (1L << IDENT))) != 0)) {
						{
							{
								setState(183);
								sentencia();
							}
						}
						setState(188);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(189);
					match(T__6);
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
				setState(209);
				_errHandler.sync(this);
				switch(_input.LA(1)) {
					case INT_CONSTANT: {
						setState(194);
						match(INT_CONSTANT);
					}
					break;
					case REAL_CONSTANT: {
						setState(195);
						match(REAL_CONSTANT);
					}
					break;
					case IDENT: {
						setState(196);
						match(IDENT);
					}
					break;
					case T__7: {
						setState(197);
						match(T__7);
						setState(198);
						expr(0);
						setState(199);
						match(T__9);
					}
					break;
					case CAST: {
						setState(201);
						match(CAST);
						setState(202);
						match(T__18);
						setState(203);
						tipo();
						setState(204);
						match(T__19);
						setState(205);
						match(T__7);
						setState(206);
						expr(0);
						setState(207);
						match(T__9);
					}
					break;
					default:
						throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
				while(_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if(_alt == 1) {
						if(_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(237);
							_errHandler.sync(this);
							switch(getInterpreter().adaptivePredict(_input, 19, _ctx)) {
								case 1: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(211);
									if(!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(212);
									_la = _input.LA(1);
									if(!(_la == T__20 || _la == T__21)) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(213);
									expr(9);
								}
								break;
								case 2: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(214);
									if(!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(215);
									_la = _input.LA(1);
									if(!(_la == T__22 || _la == T__23)) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(216);
									expr(8);
								}
								break;
								case 3: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(217);
									if(!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(218);
									_la = _input.LA(1);
									if(!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__25))) != 0))) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(219);
									expr(7);
								}
								break;
								case 4: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(220);
									if(!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(221);
									_la = _input.LA(1);
									if(!(_la == T__26 || _la == T__27)) {
										_errHandler.recoverInline(this);
									} else {
										if(_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(222);
									expr(6);
								}
								break;
								case 5: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(223);
									if(!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(224);
									match(T__28);
									setState(225);
									expr(5);
								}
								break;
								case 6: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(226);
									if(!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(227);
									match(T__29);
									setState(228);
									expr(4);
								}
								break;
								case 7: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(229);
									if(!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(230);
									match(T__2);
									setState(231);
									expr(0);
									setState(232);
									match(T__3);
								}
								break;
								case 8: {
									_localctx = new ExprContext(_parentctx, _parentState);
									pushNewRecursionContext(_localctx, _startState, RULE_expr);
									setState(234);
									if(!(precpred(_ctx, 1)))
										throw new FailedPredicateException(this, "precpred(_ctx, 1)");
									setState(235);
									match(T__30);
									setState(236);
									match(IDENT);
								}
								break;
							}
						}
					}
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
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
				setState(242);
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

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00f7\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2" + "\26\n\2\f\2\16\2\31\13\2\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\5\3\5\3" + "\5\3\5\3\5\3\5\7\5)\n\5\f\5\16\5,\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6" + "\65\n\6\f\6\16\68\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7" + "\7\7F\n\7\f\7\16\7I\13\7\5\7K\n\7\3\7\3\7\3\7\7\7P\n\7\f\7\16\7S\13\7" + "\3\7\7\7V\n\7\f\7\16\7Y\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7" + "\7e\n\7\f\7\16\7h\13\7\5\7j\n\7\3\7\3\7\3\7\3\7\3\7\7\7q\n\7\f\7\16\7" + "t\13\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\7\3\7\3\7\5\7\u0081\n\7\3" + "\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b" + "\3\b\3\b\3\b\3\b\3\b\7\b\u009a\n\b\f\b\16\b\u009d\13\b\3\b\3\b\3\b\3\b" + "\3\b\3\b\7\b\u00a5\n\b\f\b\16\b\u00a8\13\b\3\b\3\b\3\b\3\b\7\b\u00ae\n" + "\b\f\b\16\b\u00b1\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00bb\n\b\f" + "\b\16\b\u00be\13\b\3\b\3\b\5\b\u00c2\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3" + "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d4\n\t\3\t\3\t\3\t\3\t\3\t\3" + "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t" + "\3\t\3\t\3\t\7\t\u00f0\n\t\f\t\16\t\u00f3\13\t\3\n\3\n\3\n\2\3\20\13\2" + "\4\6\b\n\f\16\20\22\2\7\3\2\27\30\3\2\31\32\4\2\25\26\33\34\3\2\35\36" + "\4\2$&))\2\u0111\2\27\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b\"\3\2\2\2\n" + "\60\3\2\2\2\f\u0080\3\2\2\2\16\u00c1\3\2\2\2\20\u00d3\3\2\2\2\22\u00f4" + "\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30" + "\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32\36\5\6\4\2\33\36\5\n\6\2\34\36" + "\5\f\7\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7" + "\3\2\2 !\5\b\5\2!\7\3\2\2\2\"#\7)\2\2#*\7\4\2\2$%\7\5\2\2%&\5\20\t\2&" + "\'\7\6\2\2\')\3\2\2\2($\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2" + "\2,*\3\2\2\2-.\5\22\n\2./\7(\2\2/\t\3\2\2\2\60\61\7\7\2\2\61\62\7)\2\2" + "\62\66\7\b\2\2\63\65\5\b\5\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66" + "\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\t\2\2:;\7(\2\2;\13\3\2\2\2<=\7" + ")\2\2=J\7\n\2\2>?\7)\2\2?@\7\4\2\2@G\5\22\n\2AB\7\13\2\2BC\7)\2\2CD\7" + "\4\2\2DF\5\22\n\2EA\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG" + "\3\2\2\2J>\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\f\2\2MW\7\b\2\2NP\5\6\4\2O" + "N\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TV\5\16\b\2" + "UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z\u0081\7" + "\t\2\2[\\\7)\2\2\\i\7\n\2\2]^\7)\2\2^_\7\4\2\2_f\5\22\n\2`a\7\13\2\2a" + "b\7)\2\2bc\7\4\2\2ce\5\22\n\2d`\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2" + "gj\3\2\2\2hf\3\2\2\2i]\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\f\2\2lm\7\4\2\2" + "mn\5\22\n\2nx\7\b\2\2oq\5\6\4\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2" + "\2su\3\2\2\2tr\3\2\2\2uw\5\16\b\2vr\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2" + "\2\2y{\3\2\2\2zx\3\2\2\2{|\7\r\2\2|}\5\20\t\2}~\7(\2\2~\177\7\t\2\2\177" + "\u0081\3\2\2\2\u0080<\3\2\2\2\u0080[\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083" + "\7\16\2\2\u0083\u0084\5\20\t\2\u0084\u0085\7(\2\2\u0085\u00c2\3\2\2\2" + "\u0086\u0087\7\17\2\2\u0087\u0088\5\20\t\2\u0088\u0089\7(\2\2\u0089\u00c2" + "\3\2\2\2\u008a\u008b\7\20\2\2\u008b\u008c\5\20\t\2\u008c\u008d\7(\2\2" + "\u008d\u00c2\3\2\2\2\u008e\u008f\5\20\t\2\u008f\u0090\7\21\2\2\u0090\u0091" + "\5\20\t\2\u0091\u0092\7(\2\2\u0092\u00c2\3\2\2\2\u0093\u0094\7\22\2\2" + "\u0094\u0095\7\n\2\2\u0095\u0096\5\20\t\2\u0096\u0097\7\f\2\2\u0097\u009b" + "\7\b\2\2\u0098\u009a\5\16\b\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2" + "\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00c2\3\2\2\2\u009d\u009b" + "\3\2\2\2\u009e\u009f\7\22\2\2\u009f\u00a0\7\n\2\2\u00a0\u00a1\5\20\t\2" + "\u00a1\u00a2\7\f\2\2\u00a2\u00a6\7\b\2\2\u00a3\u00a5\5\16\b\2\u00a4\u00a3" + "\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7" + "\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7\t\2\2\u00aa\u00ab\7\23" + "\2\2\u00ab\u00af\7\b\2\2\u00ac\u00ae\5\16\b\2\u00ad\u00ac\3\2\2\2\u00ae" + "\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2" + "\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\t\2\2\u00b3\u00c2\3\2\2\2\u00b4" + "\u00b5\7\24\2\2\u00b5\u00b6\7\n\2\2\u00b6\u00b7\5\20\t\2\u00b7\u00b8\7" + "\f\2\2\u00b8\u00bc\7\b\2\2\u00b9\u00bb\5\16\b\2\u00ba\u00b9\3\2\2\2\u00bb" + "\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2" + "\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\t\2\2\u00c0\u00c2\3\2\2\2\u00c1" + "\u0082\3\2\2\2\u00c1\u0086\3\2\2\2\u00c1\u008a\3\2\2\2\u00c1\u008e\3\2" + "\2\2\u00c1\u0093\3\2\2\2\u00c1\u009e\3\2\2\2\u00c1\u00b4\3\2\2\2\u00c2" + "\17\3\2\2\2\u00c3\u00c4\b\t\1\2\u00c4\u00d4\7\"\2\2\u00c5\u00d4\7#\2\2" + "\u00c6\u00d4\7)\2\2\u00c7\u00c8\7\n\2\2\u00c8\u00c9\5\20\t\2\u00c9\u00ca" + "\7\f\2\2\u00ca\u00d4\3\2\2\2\u00cb\u00cc\7\'\2\2\u00cc\u00cd\7\25\2\2" + "\u00cd\u00ce\5\22\n\2\u00ce\u00cf\7\26\2\2\u00cf\u00d0\7\n\2\2\u00d0\u00d1" + "\5\20\t\2\u00d1\u00d2\7\f\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00c3\3\2\2\2" + "\u00d3\u00c5\3\2\2\2\u00d3\u00c6\3\2\2\2\u00d3\u00c7\3\2\2\2\u00d3\u00cb" + "\3\2\2\2\u00d4\u00f1\3\2\2\2\u00d5\u00d6\f\n\2\2\u00d6\u00d7\t\2\2\2\u00d7" + "\u00f0\5\20\t\13\u00d8\u00d9\f\t\2\2\u00d9\u00da\t\3\2\2\u00da\u00f0\5" + "\20\t\n\u00db\u00dc\f\b\2\2\u00dc\u00dd\t\4\2\2\u00dd\u00f0\5\20\t\t\u00de" + "\u00df\f\7\2\2\u00df\u00e0\t\5\2\2\u00e0\u00f0\5\20\t\b\u00e1\u00e2\f" + "\6\2\2\u00e2\u00e3\7\37\2\2\u00e3\u00f0\5\20\t\7\u00e4\u00e5\f\5\2\2\u00e5" + "\u00e6\7 \2\2\u00e6\u00f0\5\20\t\6\u00e7\u00e8\f\4\2\2\u00e8\u00e9\7\5" + "\2\2\u00e9\u00ea\5\20\t\2\u00ea\u00eb\7\6\2\2\u00eb\u00f0\3\2\2\2\u00ec" + "\u00ed\f\3\2\2\u00ed\u00ee\7!\2\2\u00ee\u00f0\7)\2\2\u00ef\u00d5\3\2\2" + "\2\u00ef\u00d8\3\2\2\2\u00ef\u00db\3\2\2\2\u00ef\u00de\3\2\2\2\u00ef\u00e1" + "\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0" + "\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\21\3\2\2" + "\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\t\6\2\2\u00f5\23\3\2\2\2\27\27\35*" + "\66GJQWfirx\u0080\u009b\u00a6\u00af\u00bc\u00c1\u00d3\u00ef\u00f1";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for(int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}