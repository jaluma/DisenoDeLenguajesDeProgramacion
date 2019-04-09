/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

//	intType:type -> 

public class IntType extends AbstractType {

	@Override
	public int getSizeMemory() {
		return 2;   // 32 bits
	}

	@Override
	public String getMAPLName() {
		return "int";
	}

	@Override
	public char getSuffix() {
		return 'i';
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}


	public String toString() {
		return "{IntType}";
	}
}
