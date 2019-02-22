/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	instruction -> definitions:definition

public class Instruction extends AbstractAST  {

	public Instruction(Definition definitions) {
		this.definitions = definitions;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definitions);
	}

	public Instruction(Object definitions) {
		this.definitions = (Definition) ((definitions instanceof ParserRuleContext) ? getAST(definitions) : definitions);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definitions);
	}

	public Definition getDefinitions() {
		return definitions;
	}
	public void setDefinitions(Definition definitions) {
		this.definitions = definitions;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Definition definitions;

	public String toString() {
       return "{definitions:" + getDefinitions() + "}";
   }
}
