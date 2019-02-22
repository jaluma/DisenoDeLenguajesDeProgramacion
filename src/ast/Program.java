/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

import java.util.List;

//	program -> instruccions:instruccion*

public class Program extends AbstractAST  {

	public Program(List<Instruccion> instruccions) {
		this.instruccions = instruccions;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(instruccions);
	}

	@SuppressWarnings("unchecked")
	public Program(Object instruccions) {
		this.instruccions = (List<Instruccion>) instruccions;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(instruccions);
	}

	public List<Instruccion> getInstruccions() {
		return instruccions;
	}
	public void setInstruccions(List<Instruccion> instruccions) {
		this.instruccions = instruccions;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Instruccion> instruccions;

	public String toString() {
       return "{instruccions:" + getInstruccions() + "}";
   }
}
