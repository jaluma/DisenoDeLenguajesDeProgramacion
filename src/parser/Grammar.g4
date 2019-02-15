grammar Grammar
	;
import Lexicon
	;

start
    : instruccion*
	;
	
instruccion
    : (definicion | estructura | funcion)
	;
	
definicion
    : 'var' def
	;

def
    : IDENT ':' ('[' expr ']')* tipo PTO_COMA
    ;

estructura
    : 'struct' IDENT '{' def* '}' PTO_COMA
    ;

funcion
    : IDENT '(' ( IDENT ':' tipo (',' IDENT ':' tipo )* )? ')'
        '{' ((definicion)* sentencia)* '}'
    | IDENT '(' ( IDENT ':' tipo (',' IDENT ':' tipo )* )? ')' ':' tipo
        '{' ((definicion)* sentencia)* 'return' expr PTO_COMA '}'
    ;

sentencia
	: 'print' expr PTO_COMA
	| 'printsp' expr PTO_COMA
    | 'println' expr PTO_COMA
	| expr '=' expr PTO_COMA
	| 'if' '(' expr ')' '{' sentencia*
	| 'if' '(' expr ')' '{' sentencia* '}' 'else' '{' sentencia* '}'
	| 'while' '(' expr ')' '{' sentencia* '}'
	;

expr
	: INT_CONSTANT
	| REAL_CONSTANT
	| IDENT
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


