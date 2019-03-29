/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

import java.util.List;

//	structType:type -> fields:structField*

public class StructType extends AbstractType {

	private List<StructField> fields;

	public StructType(List<StructField> fields) {
		this.fields = fields;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(fields);
	}

	@SuppressWarnings("unchecked")
	public StructType(Object fields) {
		this.fields = (List<StructField>) fields;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(fields);
	}

	public List<StructField> getFields() {
		return fields;
	}

	public void setFields(List<StructField> fields) {
		this.fields = fields;
	}

	@Override
	public int getSizeMemory() {
		int size = 0;
		for(StructField field : fields) {
			size += field.getType().getSizeMemory();
		}

		return size;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{fields:" + getFields() + "}";
	}
}
