package semantic;

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

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SematicTest {
	private String filename;
	private GrammarParser parser;
	private ErrorManager errorManager = new ErrorManager();

	@Test
	public void funciones() {
		filename = "1.Funciones.txt";
		test(3);
	}

	@Test
	public void estructuras() {
		filename = "2.Estructuras.txt";
		test(3);
	}

	@Test
	public void variables() {
		filename = "3.Variables.txt";
		test(7);
	}

	@Test
	public void prog1() {
		filename = "prog1.txt";
		test(7);
	}

	@Test
	public void prog2() {
		filename = "prog2.txt";
		test(14);        // 0 identificacion / 13 tipos
	}

	@Test
	public void comprobacionDeTipos() {
		filename = "Test Comprobación de Tipos.txt";
		test(46);
	}

	private void test(int expected) {
		run();
		// comprobamos que no hay erroes del sintáctico
		Assert.assertEquals(parser.getNumberOfSyntaxErrors(), 0);
		// comprobamos el semantico
		assertEquals(expected, errorManager.errorsCount());
	}

	@SuppressWarnings("Duplicates")
	private void run() {
		// 1. Fases de Análisis Léxico y Sintáctico
		try {
			GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName("tests/semantic/files/" + filename));
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
		} catch(IOException e) {
			fail(e.getMessage());
		}

	}
}
