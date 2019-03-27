package semantic;

import ast.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TypeChecking extends DefaultVisitor {

	private Collection<Class> simpleTypes = Arrays.asList(new Class[]{IntType.class, RealType.class, CharType.class});
	private Collection<Class> returnableType = Arrays.asList(new Class[]{IntType.class, RealType.class, CharType.class, VoidType.class});
	private ErrorManager errorManager;

	/*
	 * Poner aquí los visit necesarios.
	 * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
	 */

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	//	class StructDefinition { VarType name;  List<StructField> definitions; }
	public Object visit(StructDefinition node, Object param) {

		super.visit(node, param);

		return null;
	}

	//	class FunDefinition { String name;  List<Definition> params;  Type return_t;  List<Definition> definitions;  List<Sentence> sentences; }
	public Object visit(FunDefinition node, Object param) {

		super.visit(node, node);        //pasamos referencia de la definición de la funcion para el return

		predicado(isReturnable(node.getReturn_t()), "El tipo de retorno de la función " + node.getName() + " no es compatible.", node);

		return null;
	}

	public Object visit(VarDefinition node, Object param) {

		super.visit(node, param);

		if(node.getScope().equals(ScopeEnum.PARAM)) {
			predicado(isSimple(node.getType()), "El tipo del parametro de la función " + node.getName() + " no es simple.", node);
		}

		return null;
	}

	//	class Print { Expression expression;  String lex; }
	public Object visit(Print node, Object param) {

		super.visit(node, param);

		if(node.getLex().equals(PrintSeparatorEnum.LINE_BREAK.getValue()))
			predicado(node.getExpression() == null || isSimple(node.getExpression()
					.getType()), "La expresión de tipo " + node.getExpression() + " no es compatible con el Print.", node);
		else
			predicado(isSimple(node.getExpression()
					.getType()), "El tipo de la expresión " + node.getExpression() + " no es compatible con el Print. No es de un tipo simple.", node);

		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {

		super.visit(node, param);
		predicado(sameType(node.getLeft().getType(), node.getRight().getType()), "La asignación es incompatible. Tipos diferentes: " + node.getLeft()
				.getType() + ", " + node.getRight().getType(), node);
		predicado(isSimple(node.getLeft().getType()), "El tipo de la izquierda " + node.getLeft()
				.getType() + " no es compatible con la asignación. No es un tipo simple.", node);
		predicado(node.getLeft().isModificable(), "La asignación es incompatible. Término de solo lectura.", node);

		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {

		super.visit(node, param);

		predicado(isReturnable(node.getExpression().getType()), "El tipo de la expresión no es compatible con el Return de la función.", node);
		if(param instanceof FunDefinition) {
			predicado(sameType(((FunDefinition) param).getReturn_t(), node.getExpression()
					.getType()), "La expresión no es del tipo de retorno", node);
		}

		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {

		super.visit(node, param);

		predicado(isSimple(node.getExpression().getType()), "El tipo del parametro de la función " + node.getExpression() + " no es simple.", node);
		predicado(node.getExpression().isModificable(), "La expresión " + node.getExpression() + " no es modificable.", node);

		return null;
	}

	//	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
	public Object visit(IfElse node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getExpression()
				.getType(), IntType.class), "El tipo de la expresión " + node.getExpression() + " no es un número entero.", node);

		return null;
	}

	//	class While { Expression expression;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getExpression()
				.getType(), IntType.class), "El tipo de la expresión " + node.getExpression() + " no es un número entero.", node);

		return null;
	}

	//	class FunInvocation { String name;  List<Expression> params; }
	public Object visit(FunInvocation node, Object param) {

		super.visit(node, param);
		predicado(node.getParams().size() == node.getDefinition()
				.getParams()
				.size(), "El número de parametros de la función " + node.getName() + " no se corresponde con la definición.", node);
		node.getDefinition().getParams().forEach(p -> {
			int index = node.getDefinition().getParams().indexOf(p);
			List<Expression> definition = node.getParams();
			predicado(index >= 0 && index < definition.size() && sameType(p.getType(), definition.get(index)
					.getType()), "El tipo del parametro " + p.getName() + " no se corresponde con la definición.", node);
		});

		return null;
	}

	//	class FunInvocationExpression { String name;  List<Expression> params; }
	public Object visit(FunInvocationExpression node, Object param) {

		super.visit(node, param);
		predicado(node.getParams().size() == node.getDefinition()
				.getParams()
				.size(), "El número de parametros de la función " + node.getName() + " no se corresponde con la definición.", node);
		node.getDefinition().getParams().forEach(p -> {
			int index = node.getDefinition().getParams().indexOf(p);
			List<Expression> definition = node.getParams();
			predicado(index >= 0 && index < definition.size() && sameType(p.getType(), definition.get(index)
					.getType()), "El tipo del parametro " + p.getName() + " no se corresponde con la definición.", node);
		});

		node.setType(node.getDefinition().getReturn_t());
		node.setModificable(false);

		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		node.setType(new IntType());
		node.setModificable(false);

		return null;
	}

	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		node.setType(new RealType());
		node.setModificable(false);

		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		node.setType(new CharType());
		node.setModificable(false);

		return null;
	}

	//	class VoidConstant {  }
	public Object visit(VoidConstant node, Object param) {
		node.setType(new VoidType());
		node.setModificable(false);

		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		node.setType(node.getDefinition().getType());
		node.setModificable(true);

		return null;
	}

	//	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getLeft().getType(), node.getRight().getType()), "Las dos expresiones no tienen el mismo tipo " + node.getLeft()
				.getType() + ", " + node.getRight().getType(), node);
		predicado(sameType(node.getLeft().getType(), IntType.class, RealType.class), "Se esperaba un número pero el tipo ha sido " + node.getLeft()
				.getType(), node);

		node.setType(node.getLeft().getType());
		node.setModificable(false);

		return null;
	}

	//	class ComparableExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ComparableExpression node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getLeft().getType(), node.getRight().getType()), "Las dos expresiones no tienen el mismo tipo " + node.getLeft()
				.getType() + ", " + node.getRight().getType(), node);
		predicado(sameType(node.getLeft().getType(), IntType.class, RealType.class), "Se esperaba un número pero el tipo ha sido " + node.getLeft()
				.getType(), node);

		node.setType(node.getLeft().getType());
		node.setModificable(false);

		return null;
	}

	//	class LogicalExpression { Expression left;  String operator;  Expression right; }
	public Object visit(LogicalExpression node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getLeft().getType(), node.getRight().getType()), "Las dos expresiones no tienen el mismo tipo " + node.getLeft()
				.getType() + ", " + node.getRight().getType(), node);
		predicado(sameType(node.getLeft().getType(), IntType.class), "Se esperaba un entero pero el tipo ha sido " + node.getLeft().getType(), node);

		node.setType(node.getLeft().getType());
		node.setModificable(false);

		return null;
	}

	//	class UnaryExpression { Expression expr;  String operator; }
	public Object visit(UnaryExpression node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getExpr().getType(), IntType.class), "Se esperaba un número pero el tipo ha sido " + node.getExpr().getType(), node);

		node.setType(node.getExpr().getType());
		node.setModificable(false);

		return null;
	}

	//	class CastExpression { Type type;  Expression expression; }
	public Object visit(CastExpression node, Object param) {

		super.visit(node, param);

		predicado(!sameType(node.getExpression().getType(), node.getTypeChange()), "No se puede cambiar al mismo tipo de datos", node);
		predicado(isSimple(node.getExpression()
				.getType()), "El tipo de la expresión " + node.getExpression() + " no es compatible con el casteo. No es un tipo simple.", node);
		predicado(isSimple(node.getTypeChange()), "El tipo de la expresión " + node.getTypeChange() + " no es compatible con el casteo. No es un tipo simple.", node);

		node.setType(node.getTypeChange());
		node.setModificable(false);

		return null;
	}

	//	class FieldAccessExpression { Expression expression;  String name; }
	public Object visit(FieldAccessExpression node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getExpression().getType(), VarType.class), "Se esperaba una variable pero el tipo ha sido " + node.getExpression()
				.getType(), node);

		node.setType(node.getType());
		node.setModificable(true);

		return null;
	}

	//	class IndexExpression { Expression call;  Expression index; }
	public Object visit(IndexExpression node, Object param) {

		super.visit(node, param);

		predicado(sameType(node.getCall().getType(), ArrayType.class), "Se esperaba un vector pero el tipo ha sido " + node.getIndex()
				.getType(), node);
		predicado(sameType(node.getIndex().getType(), IntType.class), "Se esperaba un indice de tipo entero pero el tipo ha sido " + node.getIndex()
				.getType(), node);

		node.setType(node.getDefinition().getType());
		node.setModificable(false);

		return null;
	}

	public Object visit(ArrayType node, Object param) {
		super.visit(node, param);

		node.setType(node.getType());

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
			errorManager.notify("Comprobación de tipos", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private boolean isSimple(Type type) {
		return type != null && simpleTypes.contains(type.getClass());
	}

	private boolean isReturnable(Type type) {
		return returnableType.contains(type.getClass());
	}

	private boolean sameType(Type typeA, Type typeB) {
		return sameType(typeA, typeB.getClass());
	}

	private boolean sameType(Type typeA, Class... typesB) {
		for(Class type : typesB) {
			if(typeA.getClass().equals(type)) {
				return true;
			}
		}

		return false;
	}
}
