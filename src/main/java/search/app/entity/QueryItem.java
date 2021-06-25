package search.app.entity;

import search.app.constants.Operator;

public class QueryItem {
	
	String key;
	
	Object value;
	
	Operator operator;

	public QueryItem(String key, String operator, Object value) {
		this.key = key;
		this.value = value;
		this.operator = Operator.operatorFor(operator);
	}

	@Override
	public boolean equals(Object value) {
		
		return operator.compare(this.value, value);
	}

}
