/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	arraySize -> value:intConstant  composition:arraySize

public class ArraySize extends AbstractAST {

	public ArraySize(IntConstant value, ArraySize composition) {
		this.value = value;
		this.composition = composition;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(value, composition);
	}

	public ArraySize(Object value, Object composition) {
		this.value = (IntConstant) ((value instanceof ParserRuleContext) ? getAST(value) : value);
		this.composition = (ArraySize) ((composition instanceof ParserRuleContext) ? getAST(composition) : composition);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(value, composition);
	}

	public IntConstant getValue() {
		return value;
	}

	public void setValue(IntConstant value) {
		this.value = value;
	}

	public ArraySize getComposition() {
		return composition;
	}

	public void setComposition(ArraySize composition) {
		this.composition = composition;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private IntConstant value;
	private ArraySize composition;

	public String toString() {
		return "{value:" + getValue() + ", composition:" + getComposition() + "}";
	}
}
