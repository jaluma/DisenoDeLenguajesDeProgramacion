/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	indexExpression:expression -> call:expression  index:expression

public class IndexExpression extends AbstractExpression {

	private Expression call;
	private Expression index;
	private Type typeVector;

	public IndexExpression(Expression call, Expression index) {
		this.call = call;
		this.index = index;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(call, index);
	}

	public IndexExpression(Object call, Object index) {
		this.call = (Expression) ((call instanceof ParserRuleContext) ? getAST(call) : call);
		this.index = (Expression) ((index instanceof ParserRuleContext) ? getAST(index) : index);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(call, index);
	}

	public Expression getCall() {
		return call;
	}

	public void setCall(Expression call) {
		this.call = call;
	}

	public Expression getIndex() {
		return index;
	}

	public void setIndex(Expression index) {
		this.index = index;
	}

	public Type getTypeVector() {
		return typeVector;
	}

	public void setTypeVector(Type typeVector) {
		this.typeVector = typeVector;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{call:" + getCall() + ", index:" + getIndex() + "}";
	}
}
