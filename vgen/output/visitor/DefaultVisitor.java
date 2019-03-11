/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Instruction> instructions; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getInstructions(), param);
		return null;
	}

	//	class Instruction { Definition definitions; }
	public Object visit(Instruction node, Object param) {
		if (node.getDefinitions() != null)
			node.getDefinitions().accept(this, param);
		return null;
	}

	//	class VarDefinition { String name;  Type type; }
	public Object visit(VarDefinition node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class StructDefinition { String name;  List<StructField> definitions; }
	public Object visit(StructDefinition node, Object param) {
		visitChildren(node.getDefinitions(), param);
		return null;
	}

	//	class FunDefinition { String name;  List<Definition> params;  Type return_t;  List<Definition> definitions;  List<Sentence> sentences; }
	public Object visit(FunDefinition node, Object param) {
		visitChildren(node.getParams(), param);
		if (node.getReturn_t() != null)
			node.getReturn_t().accept(this, param);
		visitChildren(node.getDefinitions(), param);
		visitChildren(node.getSentences(), param);
		return null;
	}

	//	class ParamDefinition { String name;  Type type; }
	public Object visit(ParamDefinition node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
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

	//	class VoidType {  }
	public Object visit(VoidType node, Object param) {
		return null;
	}

	//	class ArrayType { IntConstant size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		if (node.getSize() != null)
			node.getSize().accept(this, param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class Print { Expression expression;  String lex; }
	public Object visit(Print node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
	public Object visit(IfElse node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		visitChildren(node.getIf_s(), param);
		visitChildren(node.getElse_s(), param);
		return null;
	}

	//	class While { Expression expression;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		visitChildren(node.getSentence(), param);
		return null;
	}

	//	class FunInvocation { String name;  List<Expression> params; }
	public Object visit(FunInvocation node, Object param) {
		visitChildren(node.getParams(), param);
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

	//	class VoidConstant {  }
	public Object visit(VoidConstant node, Object param) {
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		return null;
	}

	//	class BinaryExpression { Expression left;  String operator;  Expression right; }
	public Object visit(BinaryExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class UnaryExpression { Expression expr;  String operator; }
	public Object visit(UnaryExpression node, Object param) {
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class CastExpression { Type type;  Expression expression; }
	public Object visit(CastExpression node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class FunFieldAccessExpression { Expression expression;  String name; }
	public Object visit(FunFieldAccessExpression node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class IndexExpression { Expression call;  Expression index; }
	public Object visit(IndexExpression node, Object param) {
		if (node.getCall() != null)
			node.getCall().accept(this, param);
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
