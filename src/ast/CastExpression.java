/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	castExpression:expression -> type:type  expression:expression

public class CastExpression extends AbstractExpression {

	private Type typeChange;
	private Expression expression;

	public CastExpression(Type typeChange, Expression expression) {
		this.typeChange = typeChange;
		this.expression = expression;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(typeChange, expression);
	}

	public CastExpression(Object typeChange, Object expression) {
		this.typeChange = (Type) ((typeChange instanceof ParserRuleContext) ? getAST(type) : type);
		this.expression = (Expression) ((expression instanceof ParserRuleContext) ? getAST(expression) : expression);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type, expression);
	}

	public Type getTypeChange() {
		return typeChange;
	}

	public void setTypeChange(Type typeChange) {
		this.typeChange = typeChange;
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
		return "{type:" + getType() + ", expression:" + getExpression() + "}";
	}
}
