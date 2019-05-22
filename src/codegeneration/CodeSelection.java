package codegeneration;

import ast.*;
import visitor.DefaultVisitor;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

enum CodeFunction {
	ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

	private PrintWriter writer;
	private String sourceFile;
	private Map<String, String> instruccion = new HashMap<>();
	private Stack<Integer> countsIf = new Stack<>();
	private Stack<Integer> countsWhile = new Stack<>();

	CodeSelection(Writer writer, String sourceFile) {
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

		countsIf.push(0);
		countsWhile.push(0);
	}

	public Object visit(Program node, Object param) {
		out("#source \"" + sourceFile + "\"");
		out("call main");
		out("halt");
		outln();

		visitChildren(node.getInstructions(), param);

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

	//	class FunDefinition { String name;  List<Definition> params;  Type return_t;  List<Definition> definitions;  List<Sentence> sentences; }
	public Object visit(FunDefinition node, Object param) {
		line(node);

		out(node.getName() + ":");
		outln();

		out("#func " + node.getName());
		out("#ret " + node.getReturn_t().getMAPLName());

		visitChildren(node.getParams(), CodeFunction.ADDRESS);
		node.getReturn_t().accept(this, CodeFunction.VALUE);
		visitChildren(node.getDefinitions(), CodeFunction.ADDRESS);

		out("enter " + node.getDefinitions().stream().mapToInt(d -> d.getType().getSizeMemory()).sum());

		visitChildren(node.getSentences(), CodeFunction.VALUE);

		if(node.getReturn_t() instanceof VoidType) {
			int retSize = node.getReturn_t().getSizeMemory();
			int localSize = node.getDefinitions().stream().mapToInt(d -> d.getType().getSizeMemory()).sum();
			int paramSize = node.getParams().stream().mapToInt(d -> d.getType().getSizeMemory()).sum();

			out("ret " + retSize + ", " + localSize + ", " + paramSize);

		}

		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
		out("\t " + node.getName() + ":" + node.getType().getMAPLName());
		return null;
	}

	//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {
		line(node);

		node.getExpression().accept(this, CodeFunction.VALUE);
		out("out", node.getExpression().getType());

		if (node.getLex().length() > 0){
			int lex = 10;       // salto de linea
			if(!node.getLex().equals(System.getProperty("line.separator"))){
				lex = (int) node.getLex().charAt(0);
			}

			out("pushb " + lex);
			out("outb");
		}

		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		line(node);

		node.getLeft().accept(this, CodeFunction.ADDRESS);
		node.getRight().accept(this, CodeFunction.VALUE);
		out("store", node.getLeft().getType());

		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {
		line(node);

		super.visit(node, param);

		int retSize = node.getExpression().getType().getSizeMemory();
		int localSize = node.getFunDefinition().getDefinitions().stream().mapToInt(d -> d.getType().getSizeMemory()).sum();
		int paramSize = node.getFunDefinition().getParams().stream().mapToInt(d -> d.getType().getSizeMemory()).sum();

		out("ret " + retSize + ", " + localSize + ", " + paramSize);

		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		line(node);

		super.visit(node, CodeFunction.ADDRESS);

		out("in", node.getDefinition().getType());
		out("store", node.getDefinition().getType());

		outln();
		return null;
	}

	//	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
	public Object visit(IfElse node, Object param) {
		line(node);

		int countIfs = countsIf.peek();
		node.getExpression().accept(this, param);

		String elseJump = node.getElse_s() != null ? "else" : "end_else";
		out("jz " + elseJump + "_" + countIfs);

		countsIf.push(countIfs + 1);
		node.getIf_s().forEach(s -> s.accept(this, param));
		int count = countsIf.pop();

		if(node.getElse_s() != null) {
			out("jmp end_else_" + countIfs);        //codigo muerto sino
			outln();
			out("else_" + countIfs + ":");
			countsIf.push(count + 1);
			node.getElse_s().forEach(s -> s.accept(this, param));
			count = countsIf.pop();
		}

		out("end_else_" + countIfs + ":");

		countsIf.pop();
		countsIf.push(count + 1);

		return null;
	}

	//	class While { Expression expression;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {
		line(node);

		int countWhile = countsWhile.peek();

		out("start_while_" + countWhile + ":");
		node.getExpression().accept(this, param);
		out("jz end_while_" + countWhile);

		countsWhile.push(countWhile + 1);
		node.getSentence().forEach(s -> s.accept(this, param));
		int count = countsWhile.pop();
		out("jmp start_while_" + countWhile);

		out("end_while_" + countWhile + ":");

		countsWhile.pop();
		countsWhile.push(count + 1);

		return null;
	}

	//	class FunInvocation { String name;  List<Expression> params; }
	public Object visit(FunInvocation node, Object param) {
		line(node);

		node.getParams().forEach(p -> p.accept(this, param));
		out("call " + node.getName());
		if(!node.getFunDefinition().getReturn_t().getClass().equals(VoidType.class)) {
			out("pop", node.getFunDefinition().getReturn_t());
		}

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
		out(instruccion.get(node.getOperator()));
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		if(param == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load", node.getType());
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			if(node.getDefinition().getScope() == ScopeEnum.LOCAL || node.getDefinition().getScope() == ScopeEnum.PARAM) {
				out("pusha BP");
				out("push " + node.getDefinition().getAddress());
				out(instruccion.get("+"));
			} else {
				out("pusha " + node.getDefinition().getAddress());
			}

		}
		return null;
	}

	//	class FunInvocationExpression { String name;  List<Expression> params; }
	public Object visit(FunInvocationExpression node, Object param) {
		node.getParams().forEach(p -> p.accept(this, param));
		out("call " + node.getName());
		return null;
	}

	//	class IntConstant { String valor; }
	public Object visit(IntConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("push " + node.getValue());
		return node.getValue();
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

		int ascii = (int) node.getValue().charAt(0);
		if (node.getValue().charAt(0) == '\\') {
			if (node.getValue().charAt(1) == 'n')
			ascii = 10;
		}

		out("pushb " + ascii);
		return null;
	}

	//	class IndexExpression { Expression call;  Expression index; }
	public Object visit(IndexExpression node, Object param) {
		if(param == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load", node.getType());
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			node.getCall().accept(this, param);
			node.getIndex().accept(this, CodeFunction.VALUE);
			out("push " + node.getType().getSizeMemory());
			out(instruccion.get("*"));
			out(instruccion.get("+"));
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
			node.getExpression().accept(this, param);
			VarType def = (VarType) node.getExpression().getType();
			StructField field = def.getField(node.getName());
			out("push " + field.getAddress());
			out(instruccion.get("+"));
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

	private void outln() {
		writer.println();
	}

	private void line(Position pos) {
		if(pos != null) {
			out("\n#line " + pos.getLine());
		}
	}

	private void line(AST node) {
		line(node.getStart());
	}
}
