lexer grammar Lexicon
	;

INT_CONSTANT
	: DIGIT+;
REAL_CONSTANT
	: DIGIT+ '.' DIGIT+;
CHAR_CONSTANT
	: QUOTE ('\\n' | . ) QUOTE;

QUOTE
	: '\'' -> skip;
	
INT
	:'int';
FLOAT
	:'float';
CHAR
	:'char';

PTO_COMA
	: ';';

IDENT
	: (DIGIT | LOWERCASE | UPPERCASE)+;

DIGIT
	: [0-9];
LOWERCASE
	: [a-z];
UPPERCASE
	: [A-Z];

LINE_COMMENT:		'//' .*? '\n'	-> skip;
MULTILINE_COMMENT:	'/*' .*? '*/'	-> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
