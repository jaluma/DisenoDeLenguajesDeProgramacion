/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public abstract class AbstractSentence extends AbstractAST implements Sentence {

	private FunDefinition funDefinition;

	public FunDefinition getFunDefinition() {
		return funDefinition;
	}

	public void setFunDefinition(FunDefinition funDefinition) {
		this.funDefinition = funDefinition;
	}
}
