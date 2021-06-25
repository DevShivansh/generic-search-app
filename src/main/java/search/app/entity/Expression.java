package search.app.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import search.app.constants.LogicGate;

public class Expression {

	List<QueryItem> qItems;
	
	List<LogicGate> logicGates;
	
	public Expression() {
		qItems = new ArrayList<QueryItem>();
		logicGates = new ArrayList<LogicGate>();
	}
	
	public void addQueryItem(QueryItem q) {
		qItems.add(q);
	}
	
	public void addLogicGates(LogicGate gate) {
		logicGates.add(gate);
	}
	
	public boolean evaluate(DynamicClass item) {
		
		Iterator<Boolean> queryResults = evaluateQueryItems(item);
		Iterator<LogicGate> logicGates = this.logicGates.iterator();
		Boolean result = queryResults.next();
		
		while(queryResults.hasNext())
			result = logicGates.next().evaluate(result, queryResults.next());
		
		return result;
		
	}

	private Iterator<Boolean> evaluateQueryItems(DynamicClass item) {
		Iterator<QueryItem> queryItems = qItems.iterator();
		List<Boolean> results = new ArrayList<Boolean>();
		
		while(queryItems.hasNext()) {
			QueryItem qItem = queryItems.next();
			results.add(item.equals(qItem));
		}
		return results.iterator();
		
	}
}
