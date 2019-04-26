package codegeneration;

import ast.*;
import visitor.DefaultVisitor;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

	private int currentAddress = 0;
	private int bp = 1024;

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
		int bpLocal = bp + 4;
		for(int i = node.getParams().size() - 1; i >= 0; i--) {
			VarDefinition paramFunction = node.getParams().get(i);
			paramFunction.setAddress(bpLocal);
			bpLocal += paramFunction.getType().getSizeMemory();
		}

		bpLocal = bp;
		for(VarDefinition definition : node.getDefinitions()) {
			definition.setAddress(bpLocal - definition.getType().getSizeMemory());
			bpLocal -= definition.getType().getSizeMemory();
		}

		return null;
	}

	public Object visit(StructDefinition node, Object param) {
		if(node.getName() != null)
			node.getName().accept(this, param);

		int size = 0;
		for(AST child : node.getDefinitions()) {
			size = (int) child.accept(this, size);
		}

		return null;
	}

	public Object visit(StructField node, Object param) {
		super.visit(node, param);

		int currentAddress = 0;
		if(param instanceof Integer)
			currentAddress = (int) param;

		node.setAddress(currentAddress);

		return node.getType().getSizeMemory() + currentAddress;
	}

	private <T> T casting(Object obj, Class<T> type) {
		return obj.getClass().equals(type) ? type.cast(obj) : null;
	}

}
