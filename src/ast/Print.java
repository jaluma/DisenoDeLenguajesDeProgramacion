/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	print:sentence -> expression:expression  lex:String

public class Print extends AbstractSentence {

	public Print(Expression expression, String lex) {
		this.expression = expression;
		this.lex = lex;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression);
	}

	public Print(Object expression, Object lex) {
		this.expression = (Expression) ((expression instanceof ParserRuleContext) ? getAST(expression) : expression);
		this.lex = (lex instanceof Token) ? ((Token) lex).getText() : (String) lex;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression, lex);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public String getLex() {
		return lex;
	}
	public void setLex(String lex) {
		this.lex = lex;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;
	private String lex;

	public String toString() {
		return "{expression:" + getExpression() + ", lex:" + getLex() + "}";
	}
}
