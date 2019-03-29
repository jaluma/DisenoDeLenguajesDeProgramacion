/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public abstract class AbstractDefinition extends AbstractAST implements Definition {

	private int address;

	@Override
	public int getAddress() {
		return address;
	}

	@Override
	public void setAddress(int address) {
		this.address = address;
	}
}
