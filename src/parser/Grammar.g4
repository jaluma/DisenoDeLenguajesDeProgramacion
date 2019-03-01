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
    : 'var' def                                                          { $ast = new Instruction($def.ast); }
    | 'struct' IDENT '{' defs '}' PTO_COMA                               { $ast = new Instruction(new StructDefinition($IDENT, $defs.list)); }
    | IDENT '(' paramsDef ')' '{' funcionDef funcionSen '}'              { $ast = new Instruction(new FunDefinition($IDENT, $paramsDef.list, new VoidType(), $funcionDef.list, $funcionSen.list)); }
    | IDENT '(' paramsDef ')' ':' tipo '{' funcionDef funcionSen '}'     { $ast = new Instruction(new FunDefinition($IDENT, $paramsDef.list, $tipo.ast, $funcionDef.list, $funcionSen.list)); }
	;

sentence returns [Sentence ast]
	: 'print' expr PTO_COMA                                         { $ast = new Print($expr.ast, ""); }
	| 'printsp' expr PTO_COMA                                       { $ast = new Print($expr.ast, " "); }
    | 'println' expr PTO_COMA                                       { $ast = new Print($expr.ast, System.getProperty("line.separator")); }
	| expr '=' expr PTO_COMA                                        { $ast = new Assignment($ctx.expr(0), $ctx.expr(1)); }
	| 'return' PTO_COMA                                             { $ast = new Return(new VoidConstant()); }
	| 'return' expr PTO_COMA                                        { $ast = new Return($ctx.expr(0)); }
	| 'read' expr PTO_COMA                                          { $ast = new Read($ctx.expr(0)); }
	| IDENT '(' params ')' PTO_COMA                                 { $ast = new FunInvocation($IDENT, $params.list, null); }        // dudo que este bn
	| 'if' '(' expr ')' '{' sentences '}'                           { $ast = new IfElse($expr.ast, $ctx.sentences(0).list, null); }
	| 'if' '(' expr ')' '{' sentences '}' 'else' '{' sentences '}'  { $ast = new IfElse($expr.ast, $ctx.sentences(0).list, $ctx.sentences(1).list); }
	| 'while' '(' expr ')' '{' sentences '}'                        { $ast = new While($expr.ast, $sentences.list); }
	;

expr returns [Expression ast]
	: INT_CONSTANT                              { $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT                             { $ast = new RealConstant($REAL_CONSTANT); }
	| CHAR_CONSTANT                             { $ast = new CharConstant($CHAR_CONSTANT.getText().replace("'", "")); }        // temporal
	| IDENT                                     { $ast = new Variable($IDENT); }
	| '(' expr ')'                              { $ast = $expr.ast; }
	| expr '[' expr ']'                         { $ast = new IndexExpression($ctx.expr(0), $ctx.expr(1)); }
    | expr '.' IDENT                            { $ast = new FunFieldAccessExpression($ctx.expr(0), $IDENT); }
	| 'cast' '<' tipo '>' '(' expr ')'          { $ast = new CastExpression($tipo.ast, $expr.ast); }
	| op='!' expr                               { $ast = new UnaryExpression($ctx.expr(0), $op); }
	| expr op=('*' | '/') expr                  { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('+' | '-') expr                  { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('>' | '>=' | '<' | '<=') expr    { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('==' | '!=') expr                { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='&&' expr                         { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='||' expr                         { $ast = new BinaryExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| IDENT '(' params ')'                      { $ast = new FunInvocationExpression($IDENT, $params.list); }
	;
	
tipo returns [Type ast]
    : INT       { $ast = new IntType(); }
    | FLOAT     { $ast = new RealType(); }
    | CHAR      { $ast = new CharType(); }
    | IDENT     { $ast = new VarType($IDENT); }
	;



/* <----------------- AUXILIARES -----------------> */

// para defenir funciones
paramsDef returns [List<Definition> list = new ArrayList<Definition>()]
    : ( IDENT ':' tipo { $list.add(new ParamDefinition($IDENT, $ctx.tipo(0).ast)); } ( ',' IDENT ':' tipo { $list.add(new ParamDefinition($IDENT, $ctx.tipo(1).ast)); } )*  )?
    ;

funcionDef returns [List<Definition> list = new ArrayList<Definition>()]
    : ( 'var' def  { $list.add($def.ast); } )*
    ;

funcionSen returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentence    { $list.add($sentence.ast); } )*
    ;

// para defenir variables
defs returns [List<Definition> list = new ArrayList<Definition>()]
    : ( def         { $list.add($def.ast); } )*
    ;

def returns [VarDefinition ast]
    : IDENT ':' defVarArray tipo PTO_COMA { $ast = new VarDefinition($IDENT, $tipo.ast, $defVarArray.ast); }
    | IDENT ':' tipo PTO_COMA             { $ast = new VarDefinition($IDENT, $tipo.ast, null); }
    ;

defVarArray returns [ArraySize ast]
    : '[' INT_CONSTANT ']'                  { $ast = new ArraySize(new IntConstant($INT_CONSTANT), null); }
    | defVarArray '[' INT_CONSTANT ']'      { $ast = new ArraySize(new IntConstant($INT_CONSTANT), $ctx.defVarArray().ast); }
    ;

// lista de sentences
sentences returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentence { $list.add($sentence.ast); } )*
    ;

// lista para llamar a funciones
params returns [List<Expression> list = new ArrayList<Expression>()]
    : ( expr { $list.add($expr.ast); } (',' expr { $list.add($expr.ast); } )* )?
    ;