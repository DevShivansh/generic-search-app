package search.app.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import search.app.constants.Constants;
import search.app.constants.LogicGate;
import search.app.entity.Expression;
import search.app.entity.Expressions;
import search.app.entity.QueryItem;

public class QueryParser {

	static String FILTER_SYMBOLS = "[()\"'‘’]";
	
	static Set<String> gates = new HashSet<String>();
	
	static {
		gates.add("AND");
		gates.add("OR");
	}
	
	public static Expressions parseExpressions(String query) {
		List<String> exps = extractExpressionStrings(query);
		Expressions expressions = new Expressions(parseToExpressionList(exps), parseLogicGates(query, exps));
		return expressions;
	}

	private static List<LogicGate> parseLogicGates(String query, List<String> exps) {
		List<LogicGate> gates = new ArrayList<LogicGate>();
		for(String ex : exps) {
			query = query.replace(ex, "");
		}
		query = query.replace(Constants.MULTI_WHITESPACE, Constants.WHITESPACE).trim();
		StringTokenizer t = new StringTokenizer(query, Constants.WHITESPACE);
		while(t.hasMoreElements())
			gates.add(LogicGate.valueOf(t.nextToken()));
		return gates;
	}

	private static List<Expression> parseToExpressionList(List<String> exps) {
		List<Expression> expressions = new ArrayList<Expression>();
		for(String exp : exps) {
			exp = exp.replaceAll(FILTER_SYMBOLS, Constants.EMPTY_STR).replace(Constants.MULTI_WHITESPACE, Constants.WHITESPACE);
			StringTokenizer t = new StringTokenizer(exp, Constants.WHITESPACE);
			Expression singelEx = new Expression();
			
			while(t.hasMoreTokens()) {
				String token = t.nextToken();
				if(gates.contains(token)) {
					singelEx.addLogicGates(LogicGate.valueOf(token));
				}else {
					singelEx.addQueryItem(new QueryItem(token, t.nextToken(), t.nextElement()));
				}
			}
			expressions.add(singelEx);
			
		}
		return expressions;
	}
	
	private static List<String> extractExpressionStrings(String query){
		Stack<Character> stack = new Stack<Character>();
		char[] arr = query.toCharArray();
		int start = -1;
		List<String> expressions = new ArrayList<String>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '(') {
				
				if(stack.isEmpty())
					start = i;
				
				stack.push('(');
			}
			
			if(arr[i] == ')')
				stack.pop();
			
			if(stack.isEmpty() && start != -1) {
				expressions.add(query.substring(start, i + 1));
				start = -1;
			}
			
		}
		return expressions;
	}
}
