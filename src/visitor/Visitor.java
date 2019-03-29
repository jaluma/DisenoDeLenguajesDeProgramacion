/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	Object visit(Program node, Object param);

	Object visit(Instruction node, Object param);

	Object visit(VarDefinition node, Object param);

	Object visit(StructDefinition node, Object param);

	Object visit(FunDefinition node, Object param);

	Object visit(ParamDefinition node, Object param);

	Object visit(StructField node, Object param);

	Object visit(IntType node, Object param);

	Object visit(RealType node, Object param);

	Object visit(CharType node, Object param);

	Object visit(VarType node, Object param);

	Object visit(VoidType node, Object param);

	Object visit(ArrayType node, Object param);

	Object visit(StructType node, Object param);

	Object visit(ErrorType node, Object param);

	Object visit(Print node, Object param);

	Object visit(Assignment node, Object param);

	Object visit(Return node, Object param);

	Object visit(Read node, Object param);

	Object visit(IfElse node, Object param);

	Object visit(While node, Object param);

	Object visit(FunInvocation node, Object param);

	Object visit(FunInvocationExpression node, Object param);

	Object visit(IntConstant node, Object param);

	Object visit(RealConstant node, Object param);

	Object visit(CharConstant node, Object param);

	Object visit(VoidConstant node, Object param);

	Object visit(Variable node, Object param);

	Object visit(ArithmeticExpression node, Object param);

	Object visit(ComparableExpression node, Object param);

	Object visit(LogicalExpression node, Object param);

	Object visit(UnaryExpression node, Object param);

	Object visit(CastExpression node, Object param);

	Object visit(FieldAccessExpression node, Object param);

	Object visit(IndexExpression node, Object param);
}
