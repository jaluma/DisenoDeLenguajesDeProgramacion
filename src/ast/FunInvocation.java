/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

import java.util.List;

//	funInvocation:sentence -> name:String  params:expression*  expressions:expression

public class FunInvocation extends AbstractSentence {

	public FunInvocation(String name, List<Expression> params, Expression expressions) {
		this.name = name;
		this.params = params;
		this.expressions = expressions;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(params, expressions);
	}

	@SuppressWarnings("unchecked")
	public FunInvocation(Object name, Object params, Object expressions) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.params = (List<Expression>) params;
		this.expressions = (Expression) ((expressions instanceof ParserRuleContext) ? getAST(expressions) : expressions);

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

	public Expression getExpressions() {
		return expressions;
	}
	public void setExpressions(Expression expressions) {
		this.expressions = expressions;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Expression> params;
	private Expression expressions;

	public String toString() {
		return "{name:" + getName() + ", params:" + getParams() + ", expressions:" + getExpressions() + "}";
	}
}
