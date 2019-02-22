/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	arrayCall:expression -> call:expression  index:expression

public class ArrayCall extends AbstractExpression {

	public ArrayCall(Expression call, Expression index) {
		this.call = call;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(call, index);
	}

	public ArrayCall(Object call, Object index) {
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

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression call;
	private Expression index;

	public String toString() {
       return "{call:" + getCall() + ", index:" + getIndex() + "}";
   }
}
