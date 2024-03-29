/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

import java.util.List;

//	while:sentence -> expression:expression  sentence:sentence*

public class While extends AbstractSentence {

	private Expression expression;
	private List<Sentence> sentence;

	public While(Expression expression, List<Sentence> sentence) {
		this.expression = expression;
		this.sentence = sentence;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression, sentence);
	}

	@SuppressWarnings("unchecked")
	public While(Object expression, Object sentence) {
		this.expression = (Expression) ((expression instanceof ParserRuleContext) ? getAST(expression) : expression);
		this.sentence = (List<Sentence>) sentence;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression, sentence);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<Sentence> getSentence() {
		return sentence;
	}

	public void setSentence(List<Sentence> sentence) {
		this.sentence = sentence;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{expression:" + getExpression() + ", sentence:" + getSentence() + "}";
	}
}
