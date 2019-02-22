grammar Grammar
	;
import Lexicon
	;

@parser::header {
    import ast.*;
    import java.util.*;
}

start returns[Program ast]
    : instructions                 { $ast = new Program($instructions.list); }
	;

instructions returns[List<Instruction> list = new ArrayList<Instruction>()]
    : (instruction { $list.add($instruction.ast); })*
    ;
	
instruction returns[Instruction ast]
    : 'var' def                                                             { $ast = new Instruction($def.ast); }
    | 'struct' IDENT '{' defs '}' PTO_COMA                                  { $ast = new Instruction(new StructDefinition($IDENT, $defs.list)); }
    | IDENT '(' paramDefList ')' '{' funcionDef funcionSen '}'              { $ast = new Instruction(new FunDefinition($IDENT, $paramDefList.list, null, $funcionDef.list, $funcionSen.list)); }
    | IDENT '(' paramDefList ')' ':' tipo '{' funcionDef funcionSen '}'     { $ast = new Instruction(new FunDefinition($IDENT, $paramDefList.list, $tipo.ast, $funcionDef.list, $funcionSen.list)); }
	;

sentence returns [Sentence ast]
	: 'print' expr PTO_COMA                                                                     { $ast = new Print($expr.ast, ""); }
	| 'printsp' expr PTO_COMA                                                                   { $ast = new Print($expr.ast, " "); }
    | 'println' expr PTO_COMA                                                                   { $ast = new Print($expr.ast, System.getProperty("line.separator")); }
	| expr '=' expr PTO_COMA                                                                    { $ast = new Assignment($ctx.expr(0), $ctx.expr(1)); }
	| 'return' expr PTO_COMA                                                                    { $ast = new Return($ctx.expr(0)); }
	| 'if' '(' expr ')' '{' sentences '}'                                                       { $ast = new IfElse($expr.ast, $ctx.sentences(0).list, null); }
	| 'if' '(' expr ')' '{' sentences '}' 'else' '{' sentences '}'                              { $ast = new IfElse($expr.ast, $ctx.sentences(0).list, $ctx.sentences(1).list); }
	| 'while' '(' expr ')' '{' sentences '}'                                                    { $ast = new While($expr.ast, $sentences.list); }
	;

expr returns [Expression ast]
	: INT_CONSTANT                              { $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT                             { $ast = new RealConstant($REAL_CONSTANT); }
	| IDENT                                     { $ast = new Variable($IDENT); }
	| IDENT '(' params ')'                      { $ast = new FunInvocationExpression($IDENT, $params.list); }
	| expr '[' expr ']'                         { $ast = new IndexExpression($ctx.expr(0), $ctx.expr(1)); }
    | expr '.' IDENT                            { $ast = new FunFieldAccessExpression($ctx.expr(0), $IDENT); }
	| '(' expr ')'                              { $ast = $expr.ast; }
	| CAST '<' tipo '>' '(' expr ')'            { $ast = new CastExpression($tipo.ast, $expr.ast); }
	| op='!' expr                               { $ast = new UnaryExpression($ctx.expr(0), $op); }
	| expr op=('*' | '/') expr                  { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('+' | '-') expr                  { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('>' | '>=' | '<' | '<=') expr    { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('==' | '!=') expr                { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='&&' expr                         { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='||' expr                         { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	;
	
tipo returns [Type ast]
    : INT       { $ast = new IntType(); }
    | FLOAT     { $ast = new RealType(); }
    | CHAR      { $ast = new CharType(); }
    | IDENT     { $ast = new VarType($IDENT); }
	;



/* <----------------- AUXILIARES -----------------> */

// para defenir funciones
paramDefList returns [List<Definition> list]
    : ( paramDef  { $list = $paramDef.list; } )*
    ;

paramDef returns [List<Definition> list = new ArrayList<Definition>()]
    : IDENT ':' tipo                { $list.add(new ParamDefinition($IDENT, $tipo.ast)); }
    | IDENT ':' tipo ',' paramDef   { $list.add(new ParamDefinition($IDENT, $tipo.ast)); }
    ;

funcionDef returns [List<Definition> list = new ArrayList<Definition>()]
    : ( 'var' defs  { $list = $defs.list; } )*
    ;

funcionSen returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentence    { $list.add($sentence.ast); } )*
    ;

// para defenir variables
defs returns [List<Definition> list = new ArrayList<Definition>()]
    : ( def         { $list.add($def.ast); } )*
    ;

def returns [VarDefinition ast]
    : IDENT ':' defVarArray tipo PTO_COMA { $ast = new VarDefinition($IDENT, $tipo.ast, $defVarArray.list); }
    ;

defVarArray returns [List<IntConstant> list = new ArrayList<IntConstant>()]
    : ( '[' INT_CONSTANT ']' { $list.add(new IntConstant($INT_CONSTANT)); } )*
    ;

// lista de sentences
sentences returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentence { $list.add($sentence.ast); } )*
    ;

// lista para llamar a funciones
params returns [List<Expression> list]
    : (param { $list = $param.list; }) *
    ;

param returns [List<Expression> list = new ArrayList<Expression>()]
    : expr              { $list.add($expr.ast); }
    | expr ',' param    { $list.add($expr.ast); }
    ;