/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	funInvocationExpression:expression, sentence -> name:String  params:expression*

public class FunInvocationExpression extends AbstractAST implements Expression, Sentence {

	public FunInvocationExpression(String name, List<Expression> params) {
		this.name = name;
		this.params = params;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params);
	}

	@SuppressWarnings("unchecked")
	public FunInvocationExpression(Object name, Object params) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
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

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Expression> params;

	public String toString() {
       return "{name:" + getName() + ", params:" + getParams() + "}";
   }
}
