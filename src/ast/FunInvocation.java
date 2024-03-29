/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

import java.util.List;

//	funInvocation:sentence -> name:String  params:expression*

public class FunInvocation extends AbstractSentence {

	private String name;
	private List<Expression> params;
	private FunDefinition definition;

	public FunInvocation(String name, List<Expression> params) {
		this.name = name;
		this.params = params;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(params);
	}

	@SuppressWarnings("unchecked")
	public FunInvocation(Object name, Object params) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.params = (List<Expression>) params;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, params);
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

	public FunDefinition getFunDefinition() {
		return definition;
	}

	public void setFunDefinition(FunDefinition definition) {
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
