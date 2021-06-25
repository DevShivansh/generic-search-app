package search.app.entity;

import java.util.function.Predicate;

public class Attribute {
	
	private Class dataType;
	
	private String name;
	
	private Object value;
	
	
	public Attribute(Class dataType, String name, Object value) {
		super();
		this.dataType = dataType;
		this.name = name;
		this.value = value;
	}

	public Class getDataType() {
		return dataType;
	}

	public void setDataType(Class dataType) {
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	

}
