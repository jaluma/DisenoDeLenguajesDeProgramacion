/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	varDefinition:definition -> type:type  name:String  size:expression*

public class VarDefinition extends AbstractDefinition {

	public VarDefinition(Type type, String name, List<Expression> size) {
		this.type = type;
		this.name = name;
		this.size = size;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type, size);
	}

	@SuppressWarnings("unchecked")
	public VarDefinition(Object type, Object name, Object size) {
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.size = (List<Expression>) size;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type, name, size);
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getSize() {
		return size;
	}
	public void setSize(List<Expression> size) {
		this.size = size;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Type type;
	private String name;
	private List<Expression> size;

	public String toString() {
       return "{type:" + getType() + ", name:" + getName() + ", size:" + getSize() + "}";
   }
}
