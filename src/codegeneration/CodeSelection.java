package codegeneration;

import ast.*;
import visitor.DefaultVisitor;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

enum CodeFunction {
	ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

	private PrintWriter writer;
	private String sourceFile;
	private Map<String, String> instruccion = new HashMap<>();

	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;

		instruccion.put("+", "add");
		instruccion.put("-", "sub");
		instruccion.put("*", "mul");
		instruccion.put("/", "div");
		instruccion.put(">", "gt");
		instruccion.put("<", "lt");
		instruccion.put(">=", "ge");
		instruccion.put("<=", "le");
		instruccion.put("==", "eq");
		instruccion.put("!=", "ne");
		instruccion.put("&&", "and");
		instruccion.put("||", "or");
		instruccion.put("!", "not");
	}

	public Object visit(Program node, Object param) {

		out("#source \"" + sourceFile + "\"");
		visitChildren(node.getInstructions(), param);
		out("halt");

		return null;
	}

	//	class VarDefinition { String name;  Type type; }
	public Object visit(VarDefinition node, Object param) {
		out("#" + node.getScope().toString() + " " + node.getName() + ":" + node.getType().getMAPLName());
		return null;
	}

	//	class StructDefinition { VarType name;  List<StructField> definitions; }
	public Object visit(StructDefinition node, Object param) {
		out("#type " + node.getName().getType() + ": {");
		visitChildren(node.getDefinitions(), CodeFunction.VALUE);
		out("}");
		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
		out("\t " + node.getName() + ":" + node.getType().getMAPLName());
		return null;
	}

	//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {
		out("#line " + node.getEnd().getLine());
		node.getExpression().accept(this, CodeFunction.VALUE);
		out("out", node.getExpression().getType());
		return null;
	}

	//	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getLeft().accept(this, CodeFunction.VALUE);
		node.getRight().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOperator()), node.getType());
		return null;
	}

	//	class ComparableExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ComparableExpression node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getLeft().accept(this, CodeFunction.VALUE);
		node.getRight().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOperator()), node.getLeft().getType().getClass().equals(RealType.class) ? new RealType() : node.getType());
		return null;
	}

	//	class LogicalExpression { Expression left;  String operator;  Expression right; }
	public Object visit(LogicalExpression node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getLeft().accept(this, CodeFunction.VALUE);
		node.getRight().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOperator()));
		return null;
	}

	//	class UnaryExpression { Expression expr;  String operator; }
	public Object visit(UnaryExpression node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getExpr().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOperator()), node.getType());
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		out("#line " + node.getEnd().getLine());
		node.getLeft().accept(this, CodeFunction.ADDRESS);
		node.getRight().accept(this, CodeFunction.VALUE);
		out("store", node.getLeft().getType());
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		if(param == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load", node.getType());
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			out("pusha " + node.getDefinition().getAddress());
		}
		return null;
	}

	//	class IntConstant { String valor; }
	public Object visit(IntConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("push " + node.getValue());
		return null;
	}

	//	class RealConstant { String valor; }
	public Object visit(RealConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushf " + node.getValue());
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushb " + node.getValue());
		return null;
	}

	//	class IndexExpression { Expression call;  Expression index; }
	public Object visit(IndexExpression node, Object param) {
		if(param == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load", node.getType());
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			out("pusha " + node.getAddress());
		}

		return null;
	}

	//	class FieldAccessExpression { Expression expression;  String name; }
	public Object visit(FieldAccessExpression node, Object param) {
		if(param == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load", node.getType());
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			out("pusha " + node.getAddress());
		}
		return null;
	}

	//	class CastExpression { Type type;  Expression expression; }
	public Object visit(CastExpression node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getExpression().accept(this, CodeFunction.VALUE);
		out(node.getExpression().getType().getSuffix() + "2" + node.getTypeChange().getSuffix());
		return null;
	}

	/* AUXILIARES */

	private void out(String instruccion, Type tipo) {
		out(instruccion + tipo.getSuffix());
	}

	private void out(String instruction) {
		writer.println(instruction);
	}

	private void line(Position pos) {
		out("\n#line " + pos.getLine());
	}

	private void line(AST node) {
		line(node.getEnd());
	}
}
