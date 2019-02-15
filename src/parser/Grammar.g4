grammar Grammar
	;
import Lexicon
	;

start
    : instruccion*
	;

main
    : 'main' '(' ')' '{' ((definicion)* sentencia)* '}'
    ;
	
instruccion
    : (definicion | funcion)
	;
	
definicion
    : 'var' def
	;

def
    : IDENT ':' ('[' INT_CONSTANT ']')* tipo PTO_COMA
    | 'struct' IDENT '{' def* '}' PTO_COMA
    ;

funcion
    : IDENT '(' ( IDENT ':' tipo (',' IDENT ':' tipo )* )? ')' (':' tipo)*
        '{' ((definicion)* sentencia)* '}'
    ;

sentencia
	: 'print' expr PTO_COMA
	| 'printsp' expr PTO_COMA
    | 'println' expr PTO_COMA
	| expr '=' expr PTO_COMA
	| 'return' expr? PTO_COMA
	| 'if' '(' expr ')' '{' sentencia* '}'
	| 'if' '(' expr ')' '{' sentencia* '}' 'else' '{' sentencia* '}'
	| 'while' '(' expr ')' '{' sentencia* '}'
	| expr PTO_COMA
	;

expr
	: INT_CONSTANT
	| REAL_CONSTANT
	| IDENT
	| IDENT '(' ( expr (',' expr )* )? ')'
	| '(' expr ')'
	| CAST '<' tipo '>' '(' expr ')'
	| expr ('*' | '/') expr
	| expr ('+' | '-') expr
	| expr ('>' | '>=' | '<' | '<=') expr
	| expr ('==' | '!=') expr
	| expr '&&' expr
	| expr '||' expr
	| expr '[' expr ']'
	| expr '.' IDENT
	;
	
tipo
    : (INT | FLOAT | CHAR | IDENT)
	;


