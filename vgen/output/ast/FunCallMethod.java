/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	funCallMethod:expression -> expression:expression  name:String

public class FunCallMethod extends AbstractExpression {

	public FunCallMethod(Expression expression, String name) {
		this.expression = expression;
		this.name = name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public FunCallMethod(Object expression, Object name) {
		this.expression = (Expression) ((expression instanceof ParserRuleContext) ? getAST(expression) : expression);
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, name);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;
	private String name;

	public String toString() {
       return "{expression:" + getExpression() + ", name:" + getName() + "}";
   }
}
