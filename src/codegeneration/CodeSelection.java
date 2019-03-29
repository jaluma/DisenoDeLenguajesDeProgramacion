package codegeneration;

import visitor.DefaultVisitor;

import java.io.PrintWriter;
import java.io.Writer;

public class CodeSelection extends DefaultVisitor {

	private PrintWriter writer;

	/*
	 * Poner aquí los visit necesarios. Si se ha usado VGen, solo hay que copiarlos
	 * de la clase 'visitor/_PlantillaParaVisitors.txt'.
	 */

	// Ejemplo:
	//
	// public Object visit(Programa node, Object param) {
	//      out("#source \"" + sourceFile + "\"");
	//      out("call main");
	//      out("halt");
	//
	//      super.visit(node, param); // Recorrer los hijos
	//      return null;
	// }
	private String sourceFile;

	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;
	}

	// Método auxiliar recomendado (opcional) -------------
	private void out(String instruction) {
		writer.println(instruction);
	}
}
