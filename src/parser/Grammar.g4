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
    | 'struct' IDENT '{' defStruct '}' PTO_COMA                          { $ast = new Instruction(new StructDefinition(new VarType($IDENT), $defStruct.list)); }
    | IDENT '(' paramsDef ')' '{' funcionDef funcionSen '}'              { $ast = new Instruction(new FunDefinition($IDENT, $paramsDef.list, new VoidType(), $funcionDef.list, $funcionSen.list)); }
    | IDENT '(' paramsDef ')' ':' tipo '{' funcionDef funcionSen '}'     { $ast = new Instruction(new FunDefinition($IDENT, $paramsDef.list, $tipo.ast, $funcionDef.list, $funcionSen.list)); }
	;

sentence returns [Sentence ast]
	: 'print' expr PTO_COMA                                         { $ast = new Print($expr.ast, ""); }
	| 'printsp' expr PTO_COMA                                       { $ast = new Print($expr.ast, " "); }
	| 'println' PTO_COMA                                            { $ast = new Print(null, System.getProperty("line.separator")); }
    | 'println' expr PTO_COMA                                       { $ast = new Print($expr.ast, System.getProperty("line.separator")); }
	| expr '=' expr PTO_COMA                                        { $ast = new Assignment($ctx.expr(0), $ctx.expr(1)); }
	| 'return' PTO_COMA                                             { $ast = new Return(new VoidConstant()); }
	| 'return' expr PTO_COMA                                        { $ast = new Return($ctx.expr(0)); }
	| 'read' expr PTO_COMA                                          { $ast = new Read($ctx.expr(0)); }
	| IDENT '(' params ')' PTO_COMA                                 { $ast = new FunInvocation($IDENT, $params.list); }
	| 'if' '(' expr ')' '{' sentences '}'                           { $ast = new IfElse($expr.ast, $ctx.sentences(0).list, null); }
	| 'if' '(' expr ')' '{' sentences '}' 'else' '{' sentences '}'  { $ast = new IfElse($expr.ast, $ctx.sentences(0).list, $ctx.sentences(1).list); }
	| 'while' '(' expr ')' '{' sentences '}'                        { $ast = new While($expr.ast, $sentences.list); }
	;

expr returns [Expression ast]
	: INT_CONSTANT                              { $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT                             { $ast = new RealConstant($REAL_CONSTANT); }
	| CHAR_CONSTANT                             { $ast = new CharConstant($CHAR_CONSTANT.getText().replace("'", "")); }
	| IDENT                                     { $ast = new Variable($IDENT); }
	| '(' expr ')'                              { $ast = $expr.ast; }
	| expr '[' expr ']'                         { $ast = new IndexExpression($ctx.expr(0), $ctx.expr(1)); }
    | expr '.' IDENT                            { $ast = new FunFieldAccessExpression($ctx.expr(0), $IDENT); }
	| 'cast' '<' tipo '>' '(' expr ')'          { $ast = new CastExpression($tipo.ast, $expr.ast); }
	| op='!' expr                               { $ast = new UnaryExpression($ctx.expr(0), $op); }
	| expr op=('*' | '/') expr                  { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('+' | '-') expr                  { $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('>' | '>=' | '<' | '<=') expr    { $ast = new ComparableExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op=('==' | '!=') expr                { $ast = new ComparableExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='&&' expr                         { $ast = new LogicalExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| expr op='||' expr                         { $ast = new LogicalExpression($ctx.expr(0), $op, $ctx.expr(1)); }
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
    : ( IDENT ':' tipo { $list.add(new VarDefinition($IDENT, $ctx.tipo(0).ast)); } ( ',' IDENT ':' tipo { $list.add(new VarDefinition($IDENT, $ctx.tipo(1).ast)); } )*  )?
    ;

funcionDef returns [List<Definition> list = new ArrayList<Definition>()]
    : ( 'var' def  { $list.add($def.ast); } )*
    ;

funcionSen returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentence    { $list.add($sentence.ast); } )*
    ;

// para defenir variables
defStruct returns [List<StructField> list = new ArrayList<StructField>()]
    : ( IDENT ':' defVarArray PTO_COMA      { $list.add(new StructField($IDENT, $defVarArray.ast)); } )*
    ;

def returns [VarDefinition ast]
    : IDENT ':' defVarArray PTO_COMA        { $ast = new VarDefinition($IDENT, $defVarArray.ast); }
    ;

defVarArray returns [Type ast]
    : tipo                                  { $ast = $tipo.ast; }
    | '[' INT_CONSTANT ']' defVarArray      { $ast = new ArrayType(new IntConstant($INT_CONSTANT), $defVarArray.ast); }
    ;

// lista de sentences
sentences returns [List<Sentence> list = new ArrayList<Sentence>()]
    : ( sentence { $list.add($sentence.ast); } )*
    ;

// lista para llamar a funciones
params returns [List<Expression> list = new ArrayList<Expression>()]
    : ( expr { $list.add($expr.ast); } (',' expr { $list.add($expr.ast); } )* )?
    ;