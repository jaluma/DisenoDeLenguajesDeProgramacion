/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	structDefinition:definition -> name:String  definitions:structField*

public class StructDefinition extends AbstractDefinition {

	public StructDefinition(String name, List<StructField> definitions) {
		this.name = name;
		this.definitions = definitions;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definitions);
	}

	@SuppressWarnings("unchecked")
	public StructDefinition(Object name, Object definitions) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.definitions = (List<StructField>) definitions;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, definitions);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<StructField> getDefinitions() {
		return definitions;
	}
	public void setDefinitions(List<StructField> definitions) {
		this.definitions = definitions;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<StructField> definitions;

	public String toString() {
       return "{name:" + getName() + ", definitions:" + getDefinitions() + "}";
   }
}
