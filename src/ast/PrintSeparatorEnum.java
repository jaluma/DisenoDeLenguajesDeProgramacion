package ast;

public enum PrintSeparatorEnum {
	LINE_BREAK("\n"), SPACE(" "), NONE("");

	private String value;

	PrintSeparatorEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}
}
