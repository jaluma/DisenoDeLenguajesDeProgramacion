/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

//	charType:type -> 

public class CharType extends AbstractType {

	@Override
	public int getSizeMemory() {
		return 1;       // 8 bits (1Bytes)
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}


	public String toString() {
		return "{CharType}";
	}
}
