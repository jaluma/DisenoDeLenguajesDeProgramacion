/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	paramDefinition:definition -> name:String  type:type

public class ParamDefinition extends AbstractDefinition {

	private String name;
	private Type type;

	public ParamDefinition(String name, Type type) {
		this.name = name;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public ParamDefinition(Object name, Object type) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{name:" + getName() + ", type:" + getType() + "}";
	}
}
