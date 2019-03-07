/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.Visitor;

import java.util.List;

//	program -> instructions:instruction*

public class Program extends AbstractAST {

	public Program(List<Instruction> instructions) {
		this.instructions = instructions;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(instructions);
	}

	@SuppressWarnings("unchecked")
	public Program(Object instructions) {
		this.instructions = (List<Instruction>) instructions;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(instructions);
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Instruction> instructions;

	public String toString() {
		return "{instructions:" + getInstructions() + "}";
	}
}
