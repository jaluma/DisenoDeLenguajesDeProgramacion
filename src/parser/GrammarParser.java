// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

    import ast.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		INT_CONSTANT=32, REAL_CONSTANT=33, INT=34, FLOAT=35, CHAR=36, CAST=37, 
		PTO_COMA=38, IDENT=39, LINE_COMMENT=40, MULTILINE_COMMENT=41, WHITESPACE=42;
	public static final int
		RULE_start = 0, RULE_instrucciones = 1, RULE_instruccion = 2, RULE_sentencia = 3, 
		RULE_expr = 4, RULE_paramList = 5, RULE_param = 6, RULE_tipo = 7, RULE_defList = 8, 
		RULE_def = 9, RULE_defVarArray = 10, RULE_listaSentencias = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "instrucciones", "instruccion", "sentencia", "expr", "paramList", 
			"param", "tipo", "defList", "def", "defVarArray", "listaSentencias"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'struct'", "'{'", "'}'", "'print'", "'printsp'", "'println'", 
			"'='", "'return'", "'if'", "'('", "')'", "'else'", "'while'", "'<'", 
			"'>'", "'*'", "'/'", "'+'", "'-'", "'>='", "'<='", "'=='", "'!='", "'&&'", 
			"'||'", "'.'", "','", "':'", "'['", "']'", null, null, "'int'", "'float'", 
			"'char'", "'cast'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", 
			"INT", "FLOAT", "CHAR", "CAST", "PTO_COMA", "IDENT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public InstruccionesContext instrucciones;
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((StartContext)_localctx).instrucciones = instrucciones();
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).instrucciones.list);
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

	public static class InstruccionesContext extends ParserRuleContext {
		public List<Instruccion> list = new ArrayList<Instruccion>();
		public InstruccionContext instruccion;
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				{
				setState(27);
				((InstruccionesContext)_localctx).instruccion = instruccion();
				 _localctx.list.add(((InstruccionesContext)_localctx).instruccion.ast); 
				}
				}
				setState(34);
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

	public static class InstruccionContext extends ParserRuleContext {
		public Instruccion ast;
		public DefContext def;
		public Token IDENT;
		public DefListContext defList;
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public TerminalNode PTO_COMA() { return getToken(GrammarParser.PTO_COMA, 0); }
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(T__0);
				setState(36);
				((InstruccionContext)_localctx).def = def();
				 ((InstruccionContext)_localctx).ast =  new Instruccion(((InstruccionContext)_localctx).def.ast); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__1);
				setState(40);
				((InstruccionContext)_localctx).IDENT = match(IDENT);
				setState(41);
				match(T__2);
				setState(42);
				((InstruccionContext)_localctx).defList = defList(0);
				setState(43);
				match(T__3);
				setState(44);
				match(PTO_COMA);
				 ((InstruccionContext)_localctx).ast =  new Instruccion(new StructDefinition(((InstruccionContext)_localctx).IDENT, ((InstruccionContext)_localctx).defList.list)); 
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

	public static class SentenciaContext extends ParserRuleContext {
		public Sentence ast;
		public ExprContext expr;
		public ListaSentenciasContext listaSentencias;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PTO_COMA() { return getToken(GrammarParser.PTO_COMA, 0); }
		public List<ListaSentenciasContext> listaSentencias() {
			return getRuleContexts(ListaSentenciasContext.class);
		}
		public ListaSentenciasContext listaSentencias(int i) {
			return getRuleContext(ListaSentenciasContext.class,i);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentencia);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__4);
				setState(50);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(51);
				match(PTO_COMA);
				 ((SentenciaContext)_localctx).ast =  new Print(((SentenciaContext)_localctx).expr.ast, ""); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__5);
				setState(55);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(56);
				match(PTO_COMA);
				 ((SentenciaContext)_localctx).ast =  new Print(((SentenciaContext)_localctx).expr.ast, " "); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__6);
				setState(60);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(61);
				match(PTO_COMA);
				 ((SentenciaContext)_localctx).ast =  new Print(((SentenciaContext)_localctx).expr.ast, System.getProperty("line.separator")); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				expr(0);
				setState(65);
				match(T__7);
				setState(66);
				expr(0);
				setState(67);
				match(PTO_COMA);
				 ((SentenciaContext)_localctx).ast =  new Assignment(_localctx.expr(0), _localctx.expr(1)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(T__8);
				setState(72);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(71);
					expr(0);
					}
					break;
				}
				setState(74);
				match(PTO_COMA);
				 ((SentenciaContext)_localctx).ast =  new Return(_localctx.expr(0)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				match(T__9);
				setState(77);
				match(T__10);
				setState(78);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(79);
				match(T__11);
				setState(80);
				match(T__2);
				setState(81);
				listaSentencias(0);
				setState(82);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new IfElseStatement(((SentenciaContext)_localctx).expr.ast, _localctx.listaSentencias(0).list, null); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				match(T__9);
				setState(86);
				match(T__10);
				setState(87);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(88);
				match(T__11);
				setState(89);
				match(T__2);
				setState(90);
				listaSentencias(0);
				setState(91);
				match(T__3);
				setState(92);
				match(T__12);
				setState(93);
				match(T__2);
				setState(94);
				listaSentencias(0);
				setState(95);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new IfElseStatement(((SentenciaContext)_localctx).expr.ast, _localctx.listaSentencias(0).list, _localctx.listaSentencias(1).list); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(98);
				match(T__13);
				setState(99);
				match(T__10);
				setState(100);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(101);
				match(T__11);
				setState(102);
				match(T__2);
				setState(103);
				((SentenciaContext)_localctx).listaSentencias = listaSentencias(0);
				setState(104);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new WhileStatement(((SentenciaContext)_localctx).expr.ast, ((SentenciaContext)_localctx).listaSentencias.list); 
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

	public static class ExprContext extends ParserRuleContext {
		public Expression ast;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token IDENT;
		public ParamListContext paramList;
		public ExprContext expr;
		public TipoContext tipo;
		public Token op;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CAST() { return getToken(GrammarParser.CAST, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefVarArrayContext defVarArray() {
			return getRuleContext(DefVarArrayContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(110);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new IntConstant(((ExprContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 2:
				{
				setState(112);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new RealConstant(((ExprContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 3:
				{
				setState(114);
				((ExprContext)_localctx).IDENT = match(IDENT);
				 ((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT); 
				}
				break;
			case 4:
				{
				setState(116);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(117);
				match(T__10);
				setState(118);
				((ExprContext)_localctx).paramList = paramList();
				setState(119);
				match(T__11);
				 ((ExprContext)_localctx).ast =  new FunCall(((ExprContext)_localctx).IDENT, ((ExprContext)_localctx).paramList.list); 
				}
				break;
			case 5:
				{
				setState(122);
				match(T__10);
				setState(123);
				((ExprContext)_localctx).expr = expr(0);
				setState(124);
				match(T__11);
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast; 
				}
				break;
			case 6:
				{
				setState(127);
				match(CAST);
				setState(128);
				match(T__14);
				setState(129);
				((ExprContext)_localctx).tipo = tipo();
				setState(130);
				match(T__15);
				setState(131);
				match(T__10);
				setState(132);
				((ExprContext)_localctx).expr = expr(0);
				setState(133);
				match(T__11);
				 ((ExprContext)_localctx).ast =  new CastExpression(((ExprContext)_localctx).tipo.ast, ((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 7:
				{
				setState(136);
				defVarArray(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(140);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(141);
						((ExprContext)_localctx).expr = expr(9);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1)); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(144);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(145);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(146);
						((ExprContext)_localctx).expr = expr(8);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1)); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(150);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1)); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(155);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1)); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(160);
						((ExprContext)_localctx).op = match(T__24);
						setState(161);
						((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1)); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(165);
						((ExprContext)_localctx).op = match(T__25);
						setState(166);
						((ExprContext)_localctx).expr = expr(4);
						 ((ExprContext)_localctx).ast =  new ArithmeticExpression(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1)); 
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(170);
						match(T__26);
						setState(171);
						((ExprContext)_localctx).IDENT = match(IDENT);
						}
						break;
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ParamListContext extends ParserRuleContext {
		public List<Expression> list;
		public ParamContext param;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramList);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				((ParamListContext)_localctx).param = param();
				 ((ParamListContext)_localctx).list =  ((ParamListContext)_localctx).param.list; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((ParamListContext)_localctx).list =  new ArrayList<Expression>(); 
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

	public static class ParamContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<>();
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((ParamContext)_localctx).expr = expr(0);
				 _localctx.list.add(((ParamContext)_localctx).expr.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				((ParamContext)_localctx).expr = expr(0);
				setState(187);
				match(T__27);
				setState(188);
				param();
				 _localctx.list.add(((ParamContext)_localctx).expr.ast); 
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

	public static class TipoContext extends ParserRuleContext {
		public Type ast;
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(GrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(GrammarParser.CHAR, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(INT);
				 ((TipoContext)_localctx).ast =  new IntType(); 
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(FLOAT);
				 ((TipoContext)_localctx).ast =  new RealType(); 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(CHAR);
				 ((TipoContext)_localctx).ast =  new CharType(); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				match(IDENT);
				 ((TipoContext)_localctx).ast =  new VarType(); 
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

	public static class DefListContext extends ParserRuleContext {
		public List<VarDefinition> list = new ArrayList<>();
		public DefContext def;
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public DefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defList; }
	}

	public final DefListContext defList() throws RecognitionException {
		return defList(0);
	}

	private DefListContext defList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DefListContext _localctx = new DefListContext(_ctx, _parentState);
		DefListContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_defList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DefListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_defList);
					setState(204);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(205);
					((DefListContext)_localctx).def = def();
					 _localctx.list.add(((DefListContext)_localctx).def.ast); 
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class DefContext extends ParserRuleContext {
		public VarDefinition ast;
		public Token IDENT;
		public DefVarArrayContext defVarArray;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DefVarArrayContext defVarArray() {
			return getRuleContext(DefVarArrayContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PTO_COMA() { return getToken(GrammarParser.PTO_COMA, 0); }
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((DefContext)_localctx).IDENT = match(IDENT);
			setState(214);
			match(T__28);
			setState(215);
			((DefContext)_localctx).defVarArray = defVarArray(0);
			setState(216);
			((DefContext)_localctx).tipo = tipo();
			setState(217);
			match(PTO_COMA);
			 ((DefContext)_localctx).ast =  new VarDefinition(((DefContext)_localctx).tipo.ast, ((DefContext)_localctx).IDENT, ((DefContext)_localctx).defVarArray.list); 
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

	public static class DefVarArrayContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<>();
		public ExprContext expr;
		public DefVarArrayContext defVarArray() {
			return getRuleContext(DefVarArrayContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefVarArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVarArray; }
	}

	public final DefVarArrayContext defVarArray() throws RecognitionException {
		return defVarArray(0);
	}

	private DefVarArrayContext defVarArray(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DefVarArrayContext _localctx = new DefVarArrayContext(_ctx, _parentState);
		DefVarArrayContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_defVarArray, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DefVarArrayContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_defVarArray);
					setState(221);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(222);
					match(T__29);
					setState(223);
					((DefVarArrayContext)_localctx).expr = expr(0);
					setState(224);
					match(T__30);
					 _localctx.list.add(((DefVarArrayContext)_localctx).expr.ast); 
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class ListaSentenciasContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<>();
		public SentenciaContext sentencia;
		public ListaSentenciasContext listaSentencias() {
			return getRuleContext(ListaSentenciasContext.class,0);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public ListaSentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaSentencias; }
	}

	public final ListaSentenciasContext listaSentencias() throws RecognitionException {
		return listaSentencias(0);
	}

	private ListaSentenciasContext listaSentencias(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListaSentenciasContext _localctx = new ListaSentenciasContext(_ctx, _parentState);
		ListaSentenciasContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_listaSentencias, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListaSentenciasContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_listaSentencias);
					setState(233);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(234);
					((ListaSentenciasContext)_localctx).sentencia = sentencia();
					 _localctx.list.add(((ListaSentenciasContext)_localctx).sentencia.ast); 
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 8:
			return defList_sempred((DefListContext)_localctx, predIndex);
		case 10:
			return defVarArray_sempred((DefVarArrayContext)_localctx, predIndex);
		case 11:
			return listaSentencias_sempred((ListaSentenciasContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
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
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean defList_sempred(DefListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean defVarArray_sempred(DefVarArrayContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean listaSentencias_sempred(ListaSentenciasContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5n\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008c"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"\u00af\n\6\f\6\16\6\u00b2\13\6\3\7\3\7\3\7\3\7\5\7\u00b8\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c2\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u00cc\n\t\3\n\3\n\3\n\3\n\3\n\7\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00e6\n"+
		"\f\f\f\16\f\u00e9\13\f\3\r\3\r\3\r\3\r\3\r\7\r\u00f0\n\r\f\r\16\r\u00f3"+
		"\13\r\3\r\2\6\n\22\26\30\16\2\4\6\b\n\f\16\20\22\24\26\30\2\6\3\2\23\24"+
		"\3\2\25\26\4\2\21\22\27\30\3\2\31\32\2\u0107\2\32\3\2\2\2\4\"\3\2\2\2"+
		"\6\61\3\2\2\2\bm\3\2\2\2\n\u008b\3\2\2\2\f\u00b7\3\2\2\2\16\u00c1\3\2"+
		"\2\2\20\u00cb\3\2\2\2\22\u00cd\3\2\2\2\24\u00d7\3\2\2\2\26\u00de\3\2\2"+
		"\2\30\u00ea\3\2\2\2\32\33\5\4\3\2\33\34\b\2\1\2\34\3\3\2\2\2\35\36\5\6"+
		"\4\2\36\37\b\3\1\2\37!\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2"+
		"\2\2#\5\3\2\2\2$\"\3\2\2\2%&\7\3\2\2&\'\5\24\13\2\'(\b\4\1\2(\62\3\2\2"+
		"\2)*\7\4\2\2*+\7)\2\2+,\7\5\2\2,-\5\22\n\2-.\7\6\2\2./\7(\2\2/\60\b\4"+
		"\1\2\60\62\3\2\2\2\61%\3\2\2\2\61)\3\2\2\2\62\7\3\2\2\2\63\64\7\7\2\2"+
		"\64\65\5\n\6\2\65\66\7(\2\2\66\67\b\5\1\2\67n\3\2\2\289\7\b\2\29:\5\n"+
		"\6\2:;\7(\2\2;<\b\5\1\2<n\3\2\2\2=>\7\t\2\2>?\5\n\6\2?@\7(\2\2@A\b\5\1"+
		"\2An\3\2\2\2BC\5\n\6\2CD\7\n\2\2DE\5\n\6\2EF\7(\2\2FG\b\5\1\2Gn\3\2\2"+
		"\2HJ\7\13\2\2IK\5\n\6\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7(\2\2Mn\b\5\1"+
		"\2NO\7\f\2\2OP\7\r\2\2PQ\5\n\6\2QR\7\16\2\2RS\7\5\2\2ST\5\30\r\2TU\7\6"+
		"\2\2UV\b\5\1\2Vn\3\2\2\2WX\7\f\2\2XY\7\r\2\2YZ\5\n\6\2Z[\7\16\2\2[\\\7"+
		"\5\2\2\\]\5\30\r\2]^\7\6\2\2^_\7\17\2\2_`\7\5\2\2`a\5\30\r\2ab\7\6\2\2"+
		"bc\b\5\1\2cn\3\2\2\2de\7\20\2\2ef\7\r\2\2fg\5\n\6\2gh\7\16\2\2hi\7\5\2"+
		"\2ij\5\30\r\2jk\7\6\2\2kl\b\5\1\2ln\3\2\2\2m\63\3\2\2\2m8\3\2\2\2m=\3"+
		"\2\2\2mB\3\2\2\2mH\3\2\2\2mN\3\2\2\2mW\3\2\2\2md\3\2\2\2n\t\3\2\2\2op"+
		"\b\6\1\2pq\7\"\2\2q\u008c\b\6\1\2rs\7#\2\2s\u008c\b\6\1\2tu\7)\2\2u\u008c"+
		"\b\6\1\2vw\7)\2\2wx\7\r\2\2xy\5\f\7\2yz\7\16\2\2z{\b\6\1\2{\u008c\3\2"+
		"\2\2|}\7\r\2\2}~\5\n\6\2~\177\7\16\2\2\177\u0080\b\6\1\2\u0080\u008c\3"+
		"\2\2\2\u0081\u0082\7\'\2\2\u0082\u0083\7\21\2\2\u0083\u0084\5\20\t\2\u0084"+
		"\u0085\7\22\2\2\u0085\u0086\7\r\2\2\u0086\u0087\5\n\6\2\u0087\u0088\7"+
		"\16\2\2\u0088\u0089\b\6\1\2\u0089\u008c\3\2\2\2\u008a\u008c\5\26\f\2\u008b"+
		"o\3\2\2\2\u008br\3\2\2\2\u008bt\3\2\2\2\u008bv\3\2\2\2\u008b|\3\2\2\2"+
		"\u008b\u0081\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u00b0\3\2\2\2\u008d\u008e"+
		"\f\n\2\2\u008e\u008f\t\2\2\2\u008f\u0090\5\n\6\13\u0090\u0091\b\6\1\2"+
		"\u0091\u00af\3\2\2\2\u0092\u0093\f\t\2\2\u0093\u0094\t\3\2\2\u0094\u0095"+
		"\5\n\6\n\u0095\u0096\b\6\1\2\u0096\u00af\3\2\2\2\u0097\u0098\f\b\2\2\u0098"+
		"\u0099\t\4\2\2\u0099\u009a\5\n\6\t\u009a\u009b\b\6\1\2\u009b\u00af\3\2"+
		"\2\2\u009c\u009d\f\7\2\2\u009d\u009e\t\5\2\2\u009e\u009f\5\n\6\b\u009f"+
		"\u00a0\b\6\1\2\u00a0\u00af\3\2\2\2\u00a1\u00a2\f\6\2\2\u00a2\u00a3\7\33"+
		"\2\2\u00a3\u00a4\5\n\6\7\u00a4\u00a5\b\6\1\2\u00a5\u00af\3\2\2\2\u00a6"+
		"\u00a7\f\5\2\2\u00a7\u00a8\7\34\2\2\u00a8\u00a9\5\n\6\6\u00a9\u00aa\b"+
		"\6\1\2\u00aa\u00af\3\2\2\2\u00ab\u00ac\f\3\2\2\u00ac\u00ad\7\35\2\2\u00ad"+
		"\u00af\7)\2\2\u00ae\u008d\3\2\2\2\u00ae\u0092\3\2\2\2\u00ae\u0097\3\2"+
		"\2\2\u00ae\u009c\3\2\2\2\u00ae\u00a1\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae"+
		"\u00ab\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\13\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\5\16\b\2\u00b4\u00b5"+
		"\b\7\1\2\u00b5\u00b8\3\2\2\2\u00b6\u00b8\b\7\1\2\u00b7\u00b3\3\2\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\r\3\2\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00bb\b\b\1\2"+
		"\u00bb\u00c2\3\2\2\2\u00bc\u00bd\5\n\6\2\u00bd\u00be\7\36\2\2\u00be\u00bf"+
		"\5\16\b\2\u00bf\u00c0\b\b\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00b9\3\2\2\2"+
		"\u00c1\u00bc\3\2\2\2\u00c2\17\3\2\2\2\u00c3\u00c4\7$\2\2\u00c4\u00cc\b"+
		"\t\1\2\u00c5\u00c6\7%\2\2\u00c6\u00cc\b\t\1\2\u00c7\u00c8\7&\2\2\u00c8"+
		"\u00cc\b\t\1\2\u00c9\u00ca\7)\2\2\u00ca\u00cc\b\t\1\2\u00cb\u00c3\3\2"+
		"\2\2\u00cb\u00c5\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc"+
		"\21\3\2\2\2\u00cd\u00d4\b\n\1\2\u00ce\u00cf\f\4\2\2\u00cf\u00d0\5\24\13"+
		"\2\u00d0\u00d1\b\n\1\2\u00d1\u00d3\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d3\u00d6"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\23\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00d8\7)\2\2\u00d8\u00d9\7\37\2\2\u00d9\u00da\5\26"+
		"\f\2\u00da\u00db\5\20\t\2\u00db\u00dc\7(\2\2\u00dc\u00dd\b\13\1\2\u00dd"+
		"\25\3\2\2\2\u00de\u00e7\b\f\1\2\u00df\u00e0\f\4\2\2\u00e0\u00e1\7 \2\2"+
		"\u00e1\u00e2\5\n\6\2\u00e2\u00e3\7!\2\2\u00e3\u00e4\b\f\1\2\u00e4\u00e6"+
		"\3\2\2\2\u00e5\u00df\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\27\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00f1\b\r\1"+
		"\2\u00eb\u00ec\f\4\2\2\u00ec\u00ed\5\b\5\2\u00ed\u00ee\b\r\1\2\u00ee\u00f0"+
		"\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\31\3\2\2\2\u00f3\u00f1\3\2\2\2\17\"\61Jm\u008b\u00ae"+
		"\u00b0\u00b7\u00c1\u00cb\u00d4\u00e7\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}