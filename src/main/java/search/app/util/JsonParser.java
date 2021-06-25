package search.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import search.app.constants.Constants;
import search.app.entity.Attribute;
import search.app.entity.DynamicClass;

public class JsonParser {
	
	static String FILTER_SYMBOLS = "[\\r\\n{}()\"'‘’“”]";

	static String regex = "\"(.*)\": ((\".*\")|(.*))";
	
	public static List<Attribute> parseAttributes2(String json){
		List<Attribute> attributes = new ArrayList<Attribute>();
		json = json.replace(",", "");
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(json);
		while(m.find()) {
			Class<?> c = m.group(3) != null ? String.class : Integer.class;
			String key = m.group(1);
			String value = (m.group(3) != null ? m.group(3) : m.group(4)).replace("\"", "");
			attributes.add(new Attribute(c, key, value));
		}
		return attributes;
	}
	
	public static List<Attribute> parseAttributes(String json){
		List<Attribute> attributes = new ArrayList<Attribute>();
		json = json.replaceAll(FILTER_SYMBOLS, "");
		String[] attributesArr = json.split(",");
		
		for(String attribute : attributesArr) {
			StringTokenizer t = new StringTokenizer(attribute, ":");
			while(t.hasMoreTokens())
				attributes.add(new Attribute(null, t.nextToken().trim(), t.nextToken().trim()));
		}
		return attributes;
	}
}
