package app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpApp {

	public static void main(String[] args) {
		
//		Pattern pattern = Pattern.compile("(\\+7|8)\\(?49[58]\\)?[ -]?\\d{3}[ -]?\\d{4}");
//		Matcher matcher = pattern.matcher("z+7(495)-123-4567k");
		
//		System.out.println(matcher.matches());
//		System.out.println(matcher.find(0));
////		System.out.println(matcher.lookingAt());
//		System.out.println(matcher.start());
//		System.out.println(matcher.end());
		
//		System.out.println(Pattern.matches("(\\+7|8)\\(?49[58]\\)?-\\d{3}-\\d{4}", "+7(495)-123-4567"));
		
//		pattern = Pattern.compile("(\\w)+@(\\w)+\\.(\\w)+");
		Pattern pattern = Pattern.compile("((\\w+)\\.)*(\\w+)@((\\w+)\\.)+[a-zA-Z]{2,6}");

		Matcher matcher = pattern.matcher("dennis@chertkov.info");
		System.out.println(matcher.find(0));
		
//		String stringToValidate = "1234567890123;
//									[Smith John, Fisher Thomas];
//									Love and Hate;
//									2008-07-14;
//									Red Star, France;
//									598.13";
		String dateRE = "[12]\\d{3}[-\\.]((0\\d)|(1[0-2]))[-\\.]((0[1-9])|([12]\\d)|(3[01]))";
		System.out.println(Pattern.matches(dateRE, "2019-08-15"));
		
	}

}
