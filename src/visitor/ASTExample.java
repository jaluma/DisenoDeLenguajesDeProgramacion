package visitor;

import ast.*;


/*
Plantilla para Visitors.
Para crear un nuevo Visitor cortar y pegar este código y ya se tendría un visitor que compila y
que al ejecutarlo recorrería todo el árbol (sin hacer nada aún en él).
Solo quedaría añadir a cada método visit aquello adicional que se quiera realizar sobre su nodo del AST.
*/

public class ASTExample extends DefaultVisitor {

	public static void toExample(AST raiz) {
		if(raiz != null) {
			ASTExample tracer = new ASTExample();
			raiz.accept(tracer, null);
		} else
			System.out.println("raiz == null");
	}

	private ASTExample() {
	}

	// ---------------------------------------------------------
	// Tareas a realizar en cada método visit:
	//
	// Si en algún método visit NO SE QUIERE HACER NADA más que recorrer los hijos entonces se puede
	// borrar (dicho método se heredaría de DefaultVisitor con el código de recorrido).
	//
	// Lo siguiente es para cuando se quiera AÑADIR alguna funcionalidad adicional a un visit:
	//
	// - El código que aparece en cada método visit es aquel que recorre los hijos. Es el mismo código
	//		que está implementado en el padre (DefaultVisitor). Por tanto la llamada a 'super.visit' y el
	//		resto del código del método hacen lo mismo (por ello 'super.visit' está comentado).
	//
	// - Lo HABITUAL será borrar todo el código de recorrido dejando solo la llamada a 'super.visit'. De esta
	//		manera, cada método visit se puede centrar en la tarea que tiene que realizar sobre su nodo del AST
	//      (dejando que el padre se encargue del recorrido de los hijos).
	//
	// - La razón de que aparezca el código de recorrido de los hijos es por si se necesita realizar alguna
	//		tarea DURANTE el mismo (por ejemplo ir comprobando su tipo). En este caso, ya se tiene implementado
	//		dicho recorrido y solo habría que incrustar las acciones adicionales en el mismo. En este caso,
	//		es la llamada a 'super.visit' la que debería ser borrada.
	// ---------------------------------------------------------

	//	class Program { List<Instruction> instructions; }
	public Object visit(Program node, Object param) {

		printName("Program", node);

		super.visit(node, param);

		return null;
	}

	//	class Instruction { Definition definitions; }
	public Object visit(Instruction node, Object param) {

		printName("Instruction", node);

		super.visit(node, param);

		return null;
	}

	//	class VarDefinition { String name;  Type type;  List<Expression> arraySizes; }
	public Object visit(VarDefinition node, Object param) {

		printName("VarDefinition", node);

		super.visit(node, param);

		return null;
	}

	//	class StructDefinition { String name;  List<Definition> definitions; }
	public Object visit(StructDefinition node, Object param) {

		printName("StructDefinition", node);

		super.visit(node, param);

		return null;
	}

	//	class FunDefinition { String name;  List<Definition> params;  Type return_t;  List<Definition> definitions;  List<Sentence> sentences; }
	public Object visit(FunDefinition node, Object param) {

		printName("FunDefinition", node);

		super.visit(node, param);

		return null;
	}

	//	class ParamDefinition { String name;  Type type; }
	public Object visit(ParamDefinition node, Object param) {

		printName("ParamDefinition", node);

		super.visit(node, param);

		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		return null;
	}

	//	class VarType { String type; }
	public Object visit(VarType node, Object param) {
		return null;
	}

	//	class Print { Expression expression;  String lex; }
	public Object visit(Print node, Object param) {

		printName("Print", node);

		super.visit(node, param);

		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {

		printName("Assignment", node);

		super.visit(node, param);

		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {

		printName("Return", node);

		super.visit(node, param);

		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {

		printName("Read", node);

		super.visit(node, param);

		return null;
	}

	//	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
	public Object visit(IfElse node, Object param) {

		printName("IfElse", node);

		super.visit(node, param);

		return null;
	}

	//	class While { Expression expression;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {

		printName("While", node);

		super.visit(node, param);

		return null;
	}

	//	class FunInvocation { String name;  List<Expression> params;  Expression expressions; }
	public Object visit(FunInvocation node, Object param) {

		printName("FunInvocation", node);

		super.visit(node, param);

		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		return null;
	}

	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		return null;
	}

	//	class BinaryExpression { Expression left;  String operator;  Expression right; }
	public Object visit(BinaryExpression node, Object param) {

		printName("BinaryExpression", node);

		super.visit(node, param);

		return null;
	}

	//	class UnaryExpression { Expression expr;  String operator; }
	public Object visit(UnaryExpression node, Object param) {

		printName("UnaryExpression", node);

		super.visit(node, param);

		return null;
	}

	//	class CastExpression { Type type;  Expression expression; }
	public Object visit(CastExpression node, Object param) {

		printName("CastExpression", node);

		super.visit(node, param);

		return null;
	}

	//	class FunInvocationExpression { String name;  List<Expression> params; }
	public Object visit(FunInvocationExpression node, Object param) {

		printName("FunInvocationExpression", node);

		super.visit(node, param);

		return null;
	}

	//	class FunFieldAccessExpression { Expression expression;  String name; }
	public Object visit(FunFieldAccessExpression node, Object param) {

		printName("FunFieldAccessExpression", node);

		super.visit(node, param);

		return null;
	}

	//	class IndexExpression { Expression call;  Expression index; }
	public Object visit(IndexExpression node, Object param) {

		printName("IndexExpressionExpression", node);

		super.visit(node, param);

		return null;
	}

	private void printName(String name, AST node) {
		System.out.println(printPosition(node) + " - " + name);
	}

	private String printPosition(AST node) {
		if(node.getStart() == null || node.getEnd() == null) {
			return "null\tnull";
		}

		return String.format("%d:%d\t%d:%d", node.getStart().getLine(), node.getStart().getColumn(), node.getEnd().getLine(), node.getEnd()
				.getColumn());
	}
}