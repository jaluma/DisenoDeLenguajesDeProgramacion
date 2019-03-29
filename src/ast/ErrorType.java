/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

//	errorType:type -> 

public class ErrorType extends AbstractType {

	@Override
	public int getSizeMemory() {
		return 0;       // error
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}


	public String toString() {
		return "{ErrorType}";
	}
}
