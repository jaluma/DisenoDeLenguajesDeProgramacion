/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(Instruccion node, Object param);
	public Object visit(VarDefinition node, Object param);
	public Object visit(StructDefinition node, Object param);
	public Object visit(FunDefinition node, Object param);
	public Object visit(ParamDefinition node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(RealType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(VarType node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(IfElseStatement node, Object param);
	public Object visit(WhileStatement node, Object param);
	public Object visit(Expresion node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(RealConstant node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(ArithmeticExpression node, Object param);
	public Object visit(FunCall node, Object param);
	public Object visit(CastExpression node, Object param);
	public Object visit(FunCallMethod node, Object param);
	public Object visit(ArrayCall node, Object param);
}
