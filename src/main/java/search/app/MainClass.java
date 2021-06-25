package search.app;

import java.util.List;

import search.app.entity.DynamicClass;
import search.app.entity.Expressions;
import search.app.service.ProductService;
import search.app.service.impl.ProductServiceImpl;
import search.app.util.QueryParser;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		String query = "(category == ‘book’ AND subCategory == ‘education’) OR (category == ‘toys’)";
		ProductService productService = new ProductServiceImpl();
		DynamicClass item = productService.identifyItem(getJson());
		Expressions expressions = QueryParser.parseExpressions(query);
		List<DynamicClass> list = productService.findProductBy(expressions);
		System.out.println(list.size());
	}

	private static String getJson() {
		
		return "{\r\n"
				+ "\r\n"
				+ "\"product\": \"id1\",\r\n"
				+ "\r\n"
				+ "\"category\": \"book\",\r\n"
				+ "\r\n"
				+ "\"subCategory\": \"education\",\r\n"
				+ "\r\n"
				+ "\"price\": 200,\r\n"
				+ "\r\n"
				+ "“title”: \"Pedagogy of the Oppressed”,\r\n"
				+ "\r\n"
				+ "“author”: “Paulo Freire”,\r\n"
				+ "\r\n"
				+ "“description”: Is a book written by Brazilian educator Paulo Freire first written in Portuguese in 1968...”,\r\n"
				+ "\r\n"
				+ "\"size\": 10\r\n"
				+ "\r\n"
				+ "}\r\n";
	}

}
