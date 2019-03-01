/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	castExpression:expression -> type:type  expression:expression

public class CastExpression extends AbstractExpression {

	public CastExpression(Type type, Expression expression) {
		this.type = type;
		this.expression = expression;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type, expression);
	}

	public CastExpression(Object type, Object expression) {
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);
		this.expression = (Expression) ((expression instanceof ParserRuleContext) ? getAST(expression) : expression);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type, expression);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	private Type type;
	private Expression expression;

	public String toString() {
		return "{type:" + getType() + ", expression:" + getExpression() + "}";
	}
}
