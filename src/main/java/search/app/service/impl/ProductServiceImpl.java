package search.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import search.app.constants.Constants;
import search.app.entity.Attribute;
import search.app.entity.DynamicClass;
import search.app.entity.Expressions;
import search.app.service.ProductService;
import search.app.util.JsonParser;

public class ProductServiceImpl implements ProductService {

	List<DynamicClass> items = new ArrayList<DynamicClass>();

	@Override
	public DynamicClass identifyItem(String json) {
		List<Attribute> attributes = JsonParser.parseAttributes(json);
		DynamicClass d = new DynamicClass(attributes);
		items.add(d);
		return d;

	}

	@Override
	public List<DynamicClass> findProductBy(Expressions exps) {

		return items.stream().filter(i -> exps.evaluation(i)).collect(Collectors.toList())
				.stream().limit(Constants.FILTER_LIMIT).collect(Collectors.toList());

	}

}
