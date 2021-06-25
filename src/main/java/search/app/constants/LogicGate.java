package search.app.constants;

public enum LogicGate {

	AND, OR;
	
	public boolean evaluate(boolean result, boolean nextVal) {
		switch (this) {
		case AND:
			return result && nextVal;
		case OR:
			return result || nextVal;
		default:
			throw new IllegalArgumentException("Unexpected value: " + nextVal);
		}
	}
}
