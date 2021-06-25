package search.app.service;

import java.util.List;

import search.app.entity.DynamicClass;
import search.app.entity.Expressions;

public interface ProductService {

	DynamicClass identifyItem(String json);

	List<DynamicClass> findProductBy(Expressions exps);
	
	
}
