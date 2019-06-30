package app;

import model.Foo;

public class StaticBlockApp {

	public static void main(String[] args) {
		Foo foo = new Foo();
		
		System.out.println(toTitleCase("jhgkHGKHG76HGjh"));
		
		String str1 = "abracadabra";
		String str2 = "Abracadabra";
//		System.out.println(str.replace('a', 'ё'));
//		System.out.println(compare(str1, str2));
		
		System.out.println(countIncludes(str1, "a"));

	}

	public static String toTitleCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
	public static int compare(String s1, String s2) {
		int strLen1 = s1.length();
		int strLen2 = s2.length();
		
		int minLen = Math.min(strLen1, strLen2);
		
		for (int i = 0; i < minLen; i++) {
			if ( (s1.charAt(i) - s2.charAt(i) ) != 0 ) return s1.charAt(i) - s2.charAt(i); 
		}
		return strLen1 - strLen2;
	}
	
	public static int countIncludes(String str, String pattern) {
		
		int count = 0;
		int pos = 0; 
		
		while (pos < (str.length())) { 
			pos = str.indexOf(pattern, pos);
			if (pos >= 0) {
				count++ ;
				}
			else break;
		}
		return count;
	}
}
