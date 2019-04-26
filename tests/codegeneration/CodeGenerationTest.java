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
		filename = "memory.txt";
		test();
	}

	@Test
	public void basicGenerationCode() {
		filename = "basic_code_generation.txt";
		test();
	}

	@Test
	public void generation_1() {
		filename = "generation_1.txt";
		test();
	}

	@Test
	public void generation_2() {
		filename = "generation_2.txt";
		test();
	}

	@Test
	public void generation_3() {
		filename = "generation_3.txt";
		test();
	}

	@Test
	public void generation_4() {
		filename = "generation_4.txt";
		test();
	}

	@Test
	public void hipoteca() {
		filename = "Hipoteca.txt";
		test();
	}

	@Test
	public void pruebaFinal() {
		filename = "Prueba final.txt";
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
			String path = "tests/codegeneration/files/" + filename;

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
			Writer out = new FileWriter(new File(sourceFile.getParent(), "output_" + filename));

			CodeGeneration generator = new CodeGeneration();
			generator.generate(sourceFile.getName(), ast, out);
			out.close();

		} catch(IOException e) {
			fail(e.getMessage());
		}

	}
}
