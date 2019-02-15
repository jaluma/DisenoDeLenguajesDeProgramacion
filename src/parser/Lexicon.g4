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
	

MAS
	: '+';
MENOS
	: '-';
MUL
	: '*';
DIV
	: '/';
	
IGUAL
	: '=';
PTO_COMA
	: ';';

READ
	: 'read';
WRITE
	: 'write';

IDENT
	: [a-zA-Z0-9]+;

LINE_COMMENT:		'//' .*? '\n'	-> skip;
MULTILINE_COMMENT:	'/*' .*? '*/'	-> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
