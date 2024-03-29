/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Visitor;

//	arrayType:type -> size:intConstant  type:type

public class ArrayType extends AbstractType {

	private IntConstant size;
	private Type type;

	public ArrayType(IntConstant size, Type type) {
		this.size = size;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(size, type);
	}

	public ArrayType(Object size, Object type) {
		this.size = (IntConstant) ((size instanceof ParserRuleContext) ? getAST(size) : size);
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(size, type);
	}

	public IntConstant getSize() {
		return size;
	}

	public void setSize(IntConstant size) {
		this.size = size;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int getSizeMemory() {
		return Integer.parseInt(size.getValue()) * type.getSizeMemory();
	}

	@Override
	public String getMAPLName() {
		return size.getValue() + " * " + type.getMAPLName();
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{size:" + getSize() + ", type:" + getType() + "}";
	}
}
