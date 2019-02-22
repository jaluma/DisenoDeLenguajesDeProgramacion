grammar Grammar
	;
import Lexicon
	;

@parser::header {
    import ast.*;
    import java.util.*;
}

start returns[Program ast]
    : instrucciones                 { $ast = new Program($instrucciones.list);}
	;

instrucciones returns[List<Instruccion> list = new ArrayList<Instruccion>()]
    : (instruccion { $list.add($instruccion.ast); })*
    ;
	
instruccion returns[Instruccion ast]
    : 'var' def                                                             { $ast = new Instruccion($def.ast); }
    | 'struct' IDENT '{' defList '}' PTO_COMA                               { $ast = new Instruccion(new StructDefinition($IDENT, $defList.list)); }
//    | IDENT '(' paramDefList ')' (':' tipo)? '{' funcionDef funcionSen '}'  { $ast = new FunDefinition($IDENT, $tipo.ast, $funcionDef.list, $funcionSen.list); }
	;

sentencia returns [Sentence ast]
	: 'print' expr PTO_COMA                                                                     { $ast = new Print($expr.ast, ""); }
	| 'printsp' expr PTO_COMA                                                                   { $ast = new Print($expr.ast, " "); }
    | 'println' expr PTO_COMA                                                                   { $ast = new Print($expr.ast, System.getProperty("line.separator")); }
	| expr '=' expr PTO_COMA                                                                    { $ast = new Assignment($ctx.expr(0), $ctx.expr(1)); }
	| 'return' expr? PTO_COMA                                                                   { $ast = new Return($ctx.expr(0)); }
	| 'if' '(' expr ')' '{' listaSentencias '}'                                                 { $ast = new IfElseStatement($expr.ast, $ctx.listaSentencias(0).list, null); }
	| 'if' '(' expr ')' '{' listaSentencias '}' 'else' '{' listaSentencias '}'                  { $ast = new IfElseStatement($expr.ast, $ctx.listaSentencias(0).list, $ctx.listaSentencias(1).list); }
	| 'while' '(' expr ')' '{' listaSentencias '}'                                              { $ast = new WhileStatement($expr.ast, $listaSentencias.list); }
	;

expr returns [Expression ast]
	: INT_CONSTANT                              { $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT                             { $ast = new RealConstant($REAL_CONSTANT); }
	| IDENT                                     { $ast = new Variable($IDENT); }
	| IDENT '(' paramList ')'                   { $ast = new FunCall($IDENT, $paramList.list); }
	| '(' expr ')'                              { $ast = $expr.ast; }
	| CAST '<' tipo '>' '(' expr ')'            { $ast = new CastExpression($tipo.ast, $expr.ast); }
	| expr op=('*' | '/') expr                  { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('+' | '-') expr                  { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('>' | '>=' | '<' | '<=') expr    { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('==' | '!=') expr                { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='&&' expr                         { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='||' expr                         { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| defVarArray
	| expr '.' IDENT
	;

param returns [List<Expression> list = new ArrayList<Expression>()]
    : expr              { $list.add($expr.ast); }
    | expr ',' param    { $list.add($expr.ast); }
    ;
	
tipo returns [Type ast]
    : INT       { $ast = new IntType(); }
    | FLOAT     { $ast = new RealType(); }
    | CHAR      { $ast = new CharType(); }
    | IDENT     { $ast = new VarType(); }
	;

/* AUXILIARES */

// para defenir funciones
paramDefList returns [List<ParameterDefinition> list]
    : ( paramDef  { $list = $paramDef.list; } )*
    ;

paramDef returns [List<ParameterDefinition> list = new ArrayList<ParameterDefinition>()]
    : IDENT ':' tipo                { $list.add($ctx.expr); }
    | IDENT ':' tipo ',' paramDef   { $list.add($ctx.expr); }
    ;

funcionDef returns [List<Definition> list]
    : ( defList     { $list = $defList.list; } )*
    ;

funcionSen returns [List<Sentence> list = new ArrayList<Definition>()]
    : funcionSen sentencia     { $list = $ctx.sentencia; }
    |
    ;

// para defenir variables

defList returns [List<VarDefinition> list = new ArrayList<VarDefinition>()]
    : ( def { $list.add($def.ast); } )*
    ;

def returns [VarDefinition ast]
    : IDENT ':' defVarArray tipo PTO_COMA { $ast = new VarDefinition($tipo.ast, $IDENT, $defVarArray.list); }
    ;

defVarArray returns [List<Expression> list = new ArrayList<Expression>()]
    : ( '[' expr ']' { $list.add($expr.ast); } )*
    ;

// lista de sentencias
listaSentencias returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentencia { $list.add($sentencia.ast); } )*
    ;