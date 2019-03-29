/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

public interface AST {

	Object accept(Visitor visitor, Object param);

	Position getStart();

	Position getEnd();

	void setPositions(Object... children);

}
