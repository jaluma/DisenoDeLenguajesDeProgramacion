/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public interface Expression extends AST {

	Type getType();

	void setType(Type type);

	boolean isModificable();

	void setModificable(boolean modificable);
}
