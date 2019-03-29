/*
  @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public abstract class AbstractExpression extends AbstractAST implements Expression {

	protected Type type;
	private boolean modificable;

	@Override
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public boolean isModificable() {
		return modificable;
	}

	@Override
	public void setModificable(boolean modificable) {
		this.modificable = modificable;
	}

}
