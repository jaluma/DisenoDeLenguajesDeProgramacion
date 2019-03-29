package codegeneration;

import ast.AST;
import main.ErrorManager;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.Assert;
import org.junit.Test;
import parser.GrammarLexer;
import parser.GrammarParser;
import semantic.SemanticAnalisys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static org.junit.Assert.fail;

public class CodeGenerationTest {
	private String filename;
	private GrammarParser parser;
	private ErrorManager errorManager = new ErrorManager();

	@Test
	public void gestionMemoria() {
		filename = "Test Gestion de Memoria.txt";
		test();
	}

	private void test() {
		run();
		Assert.assertEquals(parser.getNumberOfSyntaxErrors(), 0);
	}

	@SuppressWarnings("Duplicates")
	private void run() {
		// 1. Fases de Análisis Léxico y Sintáctico
		try {
			String path = "tests/semantic/files/" + filename;

			GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(path));
			parser = new GrammarParser(new CommonTokenStream(lexer));

			// Las dos siguientes líneas son opcionales. Realizan una detección más precisa
			// (y lenta) de si la entrada se puede reconocer de más de una manera.
			parser.addErrorListener(new DiagnosticErrorListener()); // Notificar entradas ambiguas
			parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

			AST ast = parser.start().ast;

			if(parser.getNumberOfSyntaxErrors() > 0) {
				fail("Error sintáctico");
			}

			// 2. Fase de Análisis Semántico
			SemanticAnalisys analyzer = new SemanticAnalisys(errorManager);
			analyzer.analize(ast);

			// 3. Fase de Generación de Código
			File sourceFile = new File(path);
			Writer out = new FileWriter(new File(sourceFile.getParent(), "output.txt"));

			CodeGeneration generator = new CodeGeneration();
			generator.generate(sourceFile.getName(), ast, out);
			out.close();

		} catch(IOException e) {
			fail(e.getMessage());
		}

	}
}
