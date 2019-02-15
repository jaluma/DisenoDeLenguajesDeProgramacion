lexer grammar Lexicon
	;

INT_CONSTANT
	: [0-9]+;
REAL_CONSTANT
	: [0-9]+ '.' [0-9]+;
	
INT
	:'int';
FLOAT
	:'float';
CHAR
	:'char';

CAST
	:'cast';

PTO_COMA
	: ';';

IDENT
	: [a-zA-Z0-9]+;

LINE_COMMENT:		'//' .*? '\n'	-> skip;
MULTILINE_COMMENT:	'/*' .*? '*/'	-> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
