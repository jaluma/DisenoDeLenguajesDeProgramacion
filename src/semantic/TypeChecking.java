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

	TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	//	class FunDefinition { String name;  List<Definition> params;  Type return_t;  List<Definition> definitions;  List<Sentence> sentences; }
	public Object visit(FunDefinition node, Object param) {
		super.visit(node, param);

		if(!(node.getReturn_t() instanceof VoidType)) {
			predicado(node.isExistRet(), "No hay sentencia return y es necesaria", node);
		}

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

		if(node.getLex().equals(PrintSeparatorEnum.LINE_BREAK.getValue())) {
			predicado(node.getExpression() == null || isSimple(node.getExpression().getType()),
					"La expresión de tipo " + node.getExpression() + " no es compatible con el Print.", node);
		} else {
			predicado(isSimple(node.getExpression().getType()),
					"El tipo de la expresión " + node.getExpression() + " no es compatible con el Print. No es de un tipo simple.", node);
		}

		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		super.visit(node, param);

		predicado(sameType(node.getLeft().getType(), node.getRight().getType()),
				"La asignación es incompatible. Tipos diferentes: " + node.getLeft().getType() + ", " + node.getRight().getType(), node);
		predicado(isSimple(node.getLeft().getType()),
				"El tipo de la izquierda " + node.getLeft().getType() + " no es compatible con la asignación. No es un tipo simple.", node);
		predicado(node.getLeft().isModificable(), "La asignación es incompatible. Término de solo lectura.", node);

		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {
		super.visit(node, param);

		predicado(isReturnable(node.getExpression().getType()),
				"El tipo de la expresión no es compatible con el Return de la función.", node);
		predicado(sameType(node.getFunDefinition().getReturn_t(), node.getExpression().getType()),
				"La expresión no es del tipo de retorno", node);

		node.getFunDefinition().setExistRet(true);

		return true;

	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		super.visit(node, param);

		predicado(isSimple(node.getExpression().getType()),
				"El tipo del parametro de la función " + node.getExpression() + " no es simple.", node);
		predicado(node.getExpression().isModificable(),
				"La expresión " + node.getExpression() + " no es modificable.", node);

		return null;
	}

	//	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
	public Object visit(IfElse node, Object param) {
		boolean oldReturnStatus = node.getFunDefinition().isExistRet();

		super.visit(node, param);

		predicado(sameType(node.getExpression().getType(), IntType.class),
				"El tipo de la expresión " + node.getExpression() + " no es un número entero.", node);

		if (!oldReturnStatus)
			node.getFunDefinition().setExistRet(existReturn(node.getIf_s(), node.getElse_s()));

		return null;
	}

	//	class While { Expression expression;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {
		super.visit(node, param);

		predicado(sameType(node.getExpression().getType(), IntType.class),
				"El tipo de la expresión " + node.getExpression() + " no es un número entero.", node);

		return null;
	}

	//	class FunInvocation { String name;  List<Expression> params; }
	public Object visit(FunInvocation node, Object param) {
		super.visit(node, param);

		predicado(node.getParams().size() == node.getFunDefinition().getParams().size(),
				"El número de parametros de la función " + node.getName() + " no se corresponde con la definición.", node);

		node.getFunDefinition()
				.getParams()
				.forEach(p -> predicado(paramsEquals(node.getFunDefinition().getParams(), p),
						"El tipo del parametro " + p.getName() + " no se corresponde con la definición.", node));

		return null;
	}

	//	class FunInvocationExpression { String name;  List<Expression> params; }
	public Object visit(FunInvocationExpression node, Object param) {
		super.visit(node, param);

		boolean condition = node.getParams().size() == node.getDefinition().getParams().size();
		predicado(condition, "El número de parametros de la función " + node.getName() + " no se corresponde con la definición.", node);
		if(isErrorType(node, condition)) {
			return null;
		}
		node.getDefinition()
				.getParams()
				.forEach(p -> predicado(paramsEquals(node.getDefinition().getParams(), p),
						"El tipo del parametro " + p.getName() + " no se corresponde con la definición.", node));

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

		boolean condicion1 = sameType(node.getLeft().getType(), node.getRight().getType());
		predicado(condicion1, "Las dos expresiones no tienen el mismo tipo " + node.getLeft().getType() + ", " + node.getRight().getType(), node);

		boolean condicion2 = sameType(node.getLeft().getType(), IntType.class, RealType.class);
		predicado(condicion2, "Se esperaba un número pero el tipo ha sido " + node.getLeft().getType(), node);

		if(isErrorType(node, condicion1, condicion2)) {
			return null;
		}

		node.setType(node.getLeft().getType());
		node.setModificable(false);

		return null;
	}

	//	class ComparableExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ComparableExpression node, Object param) {
		super.visit(node, param);

		boolean condicion1 = sameType(node.getLeft().getType(), node.getRight().getType());
		predicado(condicion1, "Las dos expresiones no tienen el mismo tipo " + node.getLeft().getType() + ", " + node.getRight().getType(), node);

		boolean condicion2 = sameType(node.getLeft().getType(), IntType.class, RealType.class);
		predicado(condicion2, "Se esperaba un número pero el tipo ha sido " + node.getLeft().getType(), node);

		if(isErrorType(node, condicion1, condicion2)) {
			return null;
		}

		node.setType(new IntType());
		node.setModificable(false);

		return null;
	}

	//	class LogicalExpression { Expression left;  String operator;  Expression right; }
	public Object visit(LogicalExpression node, Object param) {
		super.visit(node, param);

		boolean condicion1 = sameType(node.getLeft().getType(), node.getRight().getType());
		predicado(condicion1, "Las dos expresiones no tienen el mismo tipo " + node.getLeft().getType() + ", " + node.getRight().getType(), node);

		boolean condicion2 = sameType(node.getLeft().getType(), IntType.class);
		predicado(sameType(node.getLeft().getType(), IntType.class), "Se esperaba un entero pero el tipo ha sido " + node.getLeft().getType(), node);

		if(isErrorType(node, condicion1, condicion2)) {
			return null;
		}

		node.setType(new IntType());
		node.setModificable(false);

		return null;
	}

	//	class UnaryExpression { Expression expr;  String operator; }
	public Object visit(UnaryExpression node, Object param) {
		super.visit(node, param);

		boolean condicion = sameType(node.getExpr().getType(), IntType.class);
		predicado(condicion, "Se esperaba un número pero el tipo ha sido " + node.getExpr().getType(), node);

		if(isErrorType(node, condicion)) {
			return null;
		}

		node.setType(node.getExpr().getType());
		node.setModificable(false);

		return null;
	}

	//	class CastExpression { Type type;  Expression expression; }
	public Object visit(CastExpression node, Object param) {
		super.visit(node, param);

		boolean condicion1 = !sameType(node.getExpression().getType(), node.getTypeChange());
		predicado(condicion1, "No se puede cambiar al mismo tipo de datos", node);

		boolean condicion2 = isSimple(node.getExpression().getType());
		predicado(condicion2, "El tipo de la expresión " + node.getExpression() + " no es compatible con el casteo. No es un tipo simple.", node);

		boolean condicion3 = isSimple(node.getTypeChange());
		predicado(condicion3, "El tipo de la expresión " + node.getTypeChange() + " no es compatible con el casteo. No es un tipo simple.", node);

		if(isErrorType(node, condicion1, condicion2, condicion3)) {
			return null;
		}

		node.setType(node.getTypeChange());
		node.setModificable(false);

		return null;
	}

	//	class FieldAccessExpression { Expression expression;  String name; }
	public Object visit(FieldAccessExpression node, Object param) {

		super.visit(node, param);


		boolean condicion = sameType(node.getExpression().getType(), VarType.class);
		predicado(condicion, "Se esperaba una variable", node);
		if(isErrorType(node, condicion)) {
			return null;
		}

		StructField field = ((VarType) node.getExpression().getType()).getField(node.getName());

		condicion = field != null;
		predicado(condicion, "La definición no tiene el siguiente parametro " + node.getName(), node);
		if(isErrorType(node, condicion)) {
			return null;
		}

		node.setType(field.getType());
		node.setModificable(true);

		return null;
	}

	//	class IndexExpression { Expression call;  Expression index; }
	public Object visit(IndexExpression node, Object param) {
		super.visit(node, param);

		boolean condicion1 = node.getIndex() != null && sameType(node.getIndex().getType(), IntType.class);
		predicado(condicion1, "Se esperaba un indice de tipo entero pero el tipo", node);

		boolean condicion2 = sameType(node.getCall().getType(), ArrayType.class);
		predicado(condicion2, "Se esperaba un vector pero el tipo ha sido " + node.getIndex().getType(), node);

		if(isErrorType(node, condicion1, condicion2)) {
			return null;
		}

		node.setType(((ArrayType) node.getCall().getType()).getType());
		node.setModificable(true);

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

	private boolean paramsEquals(List<VarDefinition> paramsDefinition, VarDefinition p) {
		int index = paramsDefinition.indexOf(p);
		return index >= 0 && index < paramsDefinition.size() && sameType(p.getType(), paramsDefinition.get(index).getType());
	}

	private boolean existReturn(List<Sentence> ifSentences, List<Sentence> elseSentences) {
		boolean returnIf = false;
		boolean returnElse = false;

		if (ifSentences != null) {
			for(Sentence child : ifSentences) {
				if(child instanceof Return) {
					returnIf = true;
				}
			}
		}

		if(elseSentences != null) {
			for(Sentence child : elseSentences) {
				if(child instanceof Return) {
					returnElse = true;
				}
			}
		}

		return returnIf && returnElse;
	}

	private boolean isErrorType(Expression node, boolean... conditions) {
		// OR
		for(boolean cond : conditions) {
			if(!cond) {
				node.setType(new ErrorType());
				node.setModificable(false);
				return true;
			}
		}

		return false;
	}
}
