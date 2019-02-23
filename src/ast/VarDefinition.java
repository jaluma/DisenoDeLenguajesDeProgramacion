/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

import java.util.List;

//	varDefinition:definition -> name:String  type:type  arraySizes:expression*

public class VarDefinition extends AbstractDefinition {

	public VarDefinition(String name, Type type, List<Expression> arraySizes) {
		this.name = name;
		this.type = type;
		this.arraySizes = arraySizes;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type, arraySizes);
	}

	@SuppressWarnings("unchecked")
	public VarDefinition(Object name, Object type, Object arraySizes) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);
		this.arraySizes = (List<Expression>) arraySizes;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, type, arraySizes);
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

	public List<Expression> getArraySizes() {
		return arraySizes;
	}
	public void setArraySizes(List<Expression> arraySizes) {
		this.arraySizes = arraySizes;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private Type type;
	private List<Expression> arraySizes;

	public String toString() {
		return "{name:" + getName() + ", type:" + getType() + ", arraySizes:" + getArraySizes() + "}";
   }
}
