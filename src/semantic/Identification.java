package semantic;

import ast.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

import java.util.HashMap;
import java.util.Map;

public class Identification extends DefaultVisitor {

	private ErrorManager errorManager;
	private Map<String, FunDefinition> functions;
	private Map<String, StructDefinition> symbols;
	private ContextMap<String, Definition> variables;

	/*
	 * Poner aquí los visit necesarios.
	 * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
	 */

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
		this.variables = new ContextMap<>();
		this.functions = new HashMap<>();
		this.symbols = new HashMap<>();
	}

	public Object visit(FunDefinition node, Object param) {
		predicado(functions.get(node.getName()) == null, "Función ya definida " + node.getName(), node);
		functions.put(node.getName(), node);

		variables.set();
		node.getParams().forEach(x -> x.accept(this, ScopeEnum.PARAM));
		node.getDefinitions().forEach(x -> x.accept(this, ScopeEnum.LOCAL));
		node.getSentences().forEach(x -> x.accept(this, node));

		node.getReturn_t().accept(this, param);

		variables.reset();

		return null;
	}

	public Object visit(FunInvocation node, Object param) {
		super.visit(node, param);

		FunDefinition definition = functions.get(node.getName());
		predicado(functions.get(node.getName()) != null, "Función no definida: " + node.getName(), node);
		node.setFunDefinition(definition);

		return null;
	}

	public Object visit(FunInvocationExpression node, Object param) {
		super.visit(node, param);

		FunDefinition definition = functions.get(node.getName());
		predicado(functions.get(node.getName()) != null, "Función no definida: " + node.getName(), node);
		node.setDefinition(definition);

		return null;
	}

	public Object visit(Read node, Object param) {
		super.visit(node, param);

		if(param instanceof FunDefinition) {
			node.setFunDefinition((FunDefinition) param);
		}

		if(node.getExpression() instanceof Variable) {
			Variable var = ((Variable) node.getExpression());
			Definition definition = variables.getFromAny(var.getName());
			predicado(definition != null, "Variable no definida: " + var.getName(), node);
			node.setDefinition((VarDefinition) definition);
		}

		return null;
	}

	//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {
		super.visit(node, param);

		if(param instanceof FunDefinition) {
			node.setFunDefinition((FunDefinition) param);
		}

		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		super.visit(node, param);

		if(param instanceof FunDefinition) {
			node.setFunDefinition((FunDefinition) param);
		}

		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {
		super.visit(node, param);

		if(param instanceof FunDefinition) {
			node.setFunDefinition((FunDefinition) param);
		}

		return null;
	}

	//	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
	public Object visit(IfElse node, Object param) {
		super.visit(node, param);

		if(param instanceof FunDefinition) {
			node.setFunDefinition((FunDefinition) param);
		}

		return null;
	}

	//	class While { Expression expression;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {
		super.visit(node, param);

		if(param instanceof FunDefinition) {
			node.setFunDefinition((FunDefinition) param);
		}

		return null;
	}


	public Object visit(VarDefinition node, Object param) {
		super.visit(node, param);

		predicado(variables.getFromTop(node.getName()) == null, "Variable ya definida: " + node.getName(), node);

		node.setScope(param instanceof ScopeEnum ? (ScopeEnum) param : ScopeEnum.GLOBAL);

		variables.put(node.getName(), node);

		return null;
	}

	public Object visit(Variable node, Object param) {
		Definition definition = variables.getFromAny(node.getName());
		predicado(definition != null, "Variable no definida: " + node.getName(), node);

		node.setDefinition((VarDefinition) definition);

		return null;
	}

	public Object visit(StructDefinition node, Object param) {
		predicado(variables.getFromAny(node.getName().getType()) == null, "Estructura ya definida: " + node.getName().getType(), node);

		variables.put(node.getName().getType(), node);
		symbols.put(node.getName().getType(), node);

		variables.set();
		node.getDefinitions().forEach(x -> x.accept(this, node));
		variables.reset();

		return null;
	}

	public Object visit(StructField node, Object param) {
		super.visit(node, param);

		Definition definition = variables.getFromTop(node.getName());

		predicado(definition == null, "Atributo " + node.getName() + " repetido en la estructura", node);

		node.setDefinition((StructDefinition) param);
		variables.put(node.getName(), node);

		return null;
	}

	public Object visit(VarType node, Object param) {
		super.visit(node, param);

		StructDefinition definition = symbols.get(node.getType());
		predicado(definition != null, "Tipo de dato no definido: " + node.getType(), node);

		node.setDefinition(definition);

		return null;
	}

	/**
	 * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
	 * <p>
	 * Ejemplos de uso (suponiendo que existe un método "esPrimitivo"):
	 * <p>
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo pimitivo", expr.getStart());
	 * 2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo pimitivo", expr);
	 * 3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
	 * <p>
	 * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
	 * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
	 * habrá sido generado en todos los nodos del AST.
	 * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
	 * posición.
	 * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
	 *
	 * @param condicion     Debe cumplirse para que no se produzca un error
	 * @param mensajeError  Se imprime si no se cumple la condición
	 * @param posicionError Fila y columna del fichero donde se ha producido el error.
	 */
	private void predicado(boolean condicion, String mensajeError, Position posicionError) {
		if(!condicion)
			errorManager.notify("Identificación", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}
}
