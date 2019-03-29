/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	return:sentence -> expression:expression

public class Return extends AbstractSentence {

	private Expression expression;

	public Return(Expression expression) {
		this.expression = expression;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression);
	}

	public Return(Object expression) {
		this.expression = (Expression) ((expression instanceof ParserRuleContext) ? getAST(expression) : expression);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{expression:" + getExpression() + "}";
	}
}
