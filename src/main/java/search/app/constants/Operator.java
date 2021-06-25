package search.app.constants;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

	EQUALS("=="), NOT_EQUALS("!=");
	
	private String sign;
	
	private static Map<String, Operator> signMap = new HashMap<String, Operator>();
	
	static {
		for(Operator o : Operator.values()) {
			signMap.put(o.sign, o);
		}
	}

	private Operator(String sign) {
		this.sign = sign;
	}
	
	public static Operator operatorFor(String sign) {
		return signMap.get(sign);
	}

	public boolean compare(Object value, Object value2) {
		
		switch (this) {
		case EQUALS:
			return value.toString().equals(value2.toString());
		case NOT_EQUALS:
			return !value.toString().equals(value2.toString());
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
		
	}
	
	
}
