grammar Grammar
	;
import Lexicon
	;

start: instrucciones
	;

instrucciones: instruccion*
	;
	
instruccion: (definicion) PTO_COMA
	;
	
definicion: 'var' IDENT ':' ('[' INT_CONSTANT ']')* type
	;	
	
type: (INT | FLOAT | CHAR)
	;
