/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

import java.util.List;

//	funInvocation:sentence -> name:String  params:expression*  expressions:expression

public class FunInvocation extends AbstractSentence {

	private String name;
	private List<Expression> params;
	private Definition definition;

	public FunInvocation(String name, List<Expression> params) {
		this.name = name;
		this.params = params;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(params);
	}

	@SuppressWarnings("unchecked")
	public FunInvocation(Object name, Object params, Object expressions) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.params = (List<Expression>) params;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, params, expressions);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getParams() {
		return params;
	}

	public void setParams(List<Expression> params) {
		this.params = params;
	}

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{name:" + getName() + ", params:" + getParams() + "}";
	}

}