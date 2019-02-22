/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);

	public Object visit(Instruction node, Object param);
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

	public Object visit(IfElse node, Object param);

	public Object visit(While node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(RealConstant node, Object param);
	public Object visit(Variable node, Object param);

	public Object visit(BinaryExpression node, Object param);

	public Object visit(UnaryExpression node, Object param);
	public Object visit(CastExpression node, Object param);

	public Object visit(FunInvocationExpression node, Object param);

	public Object visit(FunFieldAccessExpression node, Object param);

	public Object visit(IndexExpression node, Object param);
}
