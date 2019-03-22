/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public abstract class AbstractExpression extends AbstractAST implements Expression {

	protected Type type;
	protected boolean modificable;

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setModificable(boolean modificable) {
		this.modificable = modificable;
	}

	@Override
	public boolean isModificable() {
		return modificable;
	}

}
