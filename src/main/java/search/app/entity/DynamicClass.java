package search.app.entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicClass {

	private Map<String, Object> attributeMap;
	
	public DynamicClass(List<Attribute> attributes) {
		attributeMap = attributes.stream().collect(Collectors.toMap(a -> a.getName(), a->a.getValue()));
	}

	
	@Override
	public boolean equals(Object o) {
		
		if( o instanceof QueryItem ) {
			QueryItem q = (QueryItem) o;
			return q.equals(attributeMap.get(q.key));
			
		}
		
		return super.equals(o);
	}

	
	
}
