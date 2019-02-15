package parser;

import ast.AST;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.fail;

public class ParserTest {
	private String filename;
	private GrammarParser parser;

	@Test
	public void minimo() {
		filename = "minimo.txt";
		test();
	}

	@Test
	public void defVariables() {
		filename = "definicion_variables.txt";
		test();
	}

	@Test
	public void defFunciones() {
		filename = "definicion_funciones.txt";
		test();
	}

	@Test
	public void flujos() {
		filename = "flujos.txt";
		test();
	}

	@Test
	public void Hipoteca() {
		filename = "Hipoteca.txt";
		test();
	}

	@Test
	public void errores() {
		HashMap<String, Integer> map = new HashMap<>();
		// fichero, errores esperados
		map.put("error1.txt", 1);
		map.put("error2.txt", 1);
		map.put("error3.txt", 1);
		map.put("error4.txt", 1);
		map.put("error5.txt", 1);

		int errores = 0;
		int contador = 0;

		for(String filename : map.keySet()) {
			this.filename = "errors/" + filename;
			run();
			errores += map.get(filename);
			contador += parser.getNumberOfSyntaxErrors();
		}

		Assert.assertEquals(errores, contador);
	}

	private void test() {
		run();
		Assert.assertEquals(parser.getNumberOfSyntaxErrors(), 0);
	}

	@SuppressWarnings("Duplicates")
	private void run() {
		// 1. Fases de Análisis Léxico y Sintáctico
		try {
			GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName("tests/parser/files/" + filename));
			parser = new GrammarParser(new CommonTokenStream(lexer));

			// Las dos siguientes líneas son opcionales. Realizan una detección más precisa
			// (y lenta) de si la entrada se puede reconocer de más de una manera.
			parser.addErrorListener(new DiagnosticErrorListener()); // Notificar entradas ambiguas
			parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

			AST ast = null;
			// IMPORTANTE: Cuando se genere el AST, INTERCAMBIAR las dos líneas siguientes:
			parser.start();
			// ast = parser.start().ast;
		} catch(IOException e) {
			fail(e.getMessage());
		}

	}
}
