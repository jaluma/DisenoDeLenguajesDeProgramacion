/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	unaryExpression:expression -> expr:expression  operator:String

public class UnaryExpression extends AbstractExpression {

	private Expression expr;
	private String operator;

	public UnaryExpression(Expression expr, String operator) {
		this.expr = expr;
		this.operator = operator;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expr);
	}

	public UnaryExpression(Object expr, Object operator) {
		this.expr = (Expression) ((expr instanceof ParserRuleContext) ? getAST(expr) : expr);
		this.operator = (operator instanceof Token) ? ((Token) operator).getText() : (String) operator;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expr, operator);
	}

	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{expr:" + getExpr() + ", operator:" + getOperator() + "}";
	}
}
