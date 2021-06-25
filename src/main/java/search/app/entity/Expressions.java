package search.app.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import search.app.constants.LogicGate;

public class Expressions {

	List<Expression> expressions;
	
	List<LogicGate> logicGates;
	
	public Expressions(List<Expression> expressions, List<LogicGate> logicGates) {
		super();
		this.expressions = expressions;
		this.logicGates = logicGates;
	}
	
	public boolean evaluation(DynamicClass item) {
		
		Iterator<Expression> i = expressions.iterator();
		List<Boolean> results = new ArrayList<Boolean>();
		
		while(i.hasNext()) {
			Expression ex = i.next();
			results.add(ex.evaluate(item));
		}
		Iterator<Boolean> i2 = results.iterator();
		Iterator<LogicGate> i3 = logicGates.iterator();
		Boolean result = i2.next();
		
		while(i2.hasNext()) {
			result = i3.next().evaluate(result, i2.next());
		}
		return result;
		
	}
}
