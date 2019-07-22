package parsers;

import java.util.HashMap;
import java.util.Map;

public class GetRequestParser implements IParser {

	@Override
	public Map<String, String> parse(String str) {
		Map<String, String> values 	= new HashMap<>();

		String[] pairs = str.split("&");
		for (String pair: pairs) {
			String [] property = pair.split("=");
			values.put(property[0], property[1]);
		}

		return values;
	}

}
