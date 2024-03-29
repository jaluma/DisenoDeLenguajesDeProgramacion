/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	structField -> name:String  type:type

public class StructField extends AbstractAST implements Definition {

	private String name;
	private Type type;
	private Definition definition;
	private int address;

	public StructField(String name, Type type) {
		this.name = name;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public StructField(Object name, Object type) {
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

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public int getAddress() {
		return address;
	}

	@Override
	public void setAddress(int offset) {
		this.address = offset;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{name:" + getName() + ", type:" + getType() + "}";
	}
}
