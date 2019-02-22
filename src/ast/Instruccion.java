/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	instruccion -> definitions:definition

public class Instruccion extends AbstractAST  {

	public Instruccion(Definition definitions) {
		this.definitions = definitions;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definitions);
	}

	public Instruccion(Object definitions) {
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
