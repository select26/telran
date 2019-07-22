package parsers;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Parsers {

	public static Map<Class<?>, Method> PARSERS = primitivesMap();
	
	public static Map<Class<?>, Method> primitivesMap() {
		HashMap<Class<?>, Method> result = new HashMap<>();
		try {
			result.put(byte.class, Byte.class.getMethod("parseByte", String.class));
			result.put(short.class, Short.class.getMethod("parseShort", String.class));
			result.put(char.class, Parsers.class.getMethod("parseChar", String.class));
			result.put(int.class, Integer.class.getMethod("parseInt", String.class));
			result.put(long.class, Long.class.getMethod("parseLong", String.class));
			result.put(float.class, Float.class.getMethod("parseFloat", String.class));
			result.put(double.class, Double.class.getMethod("parseDouble", String.class));
			result.put(boolean.class, Boolean.class.getMethod("parseBoolean", String.class));
			result.put(String.class, Parsers.class.getMethod("parseString", String.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	public static char parseChar(String c) {
		return c.charAt(0);
	}
	
	public static String parseString(String c) {
		return c;
	}


	
}
