/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

//	voidConstant:expression -> 

public class VoidConstant extends AbstractExpression {

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}


	public String toString() {
		return "{VoidConstant}";
	}
}
