package codegeneration;

import ast.*;
import visitor.DefaultVisitor;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

	private int currentAddress = 0;

	// class Programa { List<DefVariable> definiciones; List<Sentencia> sentencias; }
	public Object visit(Program node, Object param) {
		super.visit(node, param);

		return null;
	}

	public Object visit(VarDefinition node, Object param) {
		super.visit(node, param);

		if(node.getScope() == ScopeEnum.GLOBAL) {
			node.setAddress(currentAddress);
			currentAddress += node.getType().getSizeMemory();
		}

		return null;
	}

	public Object visit(FunDefinition node, Object param) {
		if(node.getReturn_t() != null)
			node.getReturn_t().accept(this, param);
		visitChildren(node.getSentences(), param);

		// visitaamos los parametros y las definiciones
		int bp = 4;
		for(int i = node.getParams().size() - 1; i >= 0; i--) {
			VarDefinition paramFunction = node.getParams().get(i);
			paramFunction.setAddress(bp);
			bp += paramFunction.getType().getSizeMemory();
		}

		bp = 0;
		for(VarDefinition definition : node.getDefinitions()) {
			bp -= definition.getType().getSizeMemory();
			definition.setAddress(bp);
		}

		return null;
	}

	public Object visit(StructDefinition node, Object param) {
		if(node.getName() != null)
			node.getName().accept(this, param);

		int offset = 0;
		for(AST child : node.getDefinitions()) {
			offset += (int) child.accept(this, offset);
		}

		return null;
	}

	public Object visit(StructField node, Object param) {
		super.visit(node, param);

		int offset = 0;
		if(param instanceof Integer)
			offset = (int) param;

		node.setAddress(offset);

		return node.getType().getSizeMemory();
	}

}
