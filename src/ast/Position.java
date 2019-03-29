/*
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public class Position {

	private int line, column;

	public Position(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public boolean lessThan(Position other) {
		return line < other.getLine() || (line == other.getLine() && column < other.getColumn());
	}

	public boolean greaterThan(Position other) {
		return line > other.getLine() || (line == other.getLine() && column > other.getColumn());
	}

	@Override
	public String toString() {
		return line + ":" + column;
	}
}
