package screenmenu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.function.Function;

public interface InputOutput {
	
	String inputString(String prompt);
	void output(Object obj);
	
	default void outputLine(Object obj) {
		if (obj!=null) output(obj.toString() ); //+"\n");			// Additional CRLF in string
		else output("Nothing to write!"+"\n");
	}
	
	default <R> R inputObject(String prompt,String errorPrompt,Function<String,R> mapper) {
		while (true) {
			String text = inputString(prompt);
			if (text == null)
				return null;
			R res = mapper.apply(text);
			if (res != null)
				return res;
			outputLine(errorPrompt);
		}
	}
	
	default Integer inputInteger(String prompt) {
		return inputObject(prompt,"it's not a number",s-> {
			try {
				Integer res=Integer.parseInt(s);
				return res;
			} 
			catch (NumberFormatException e) {
				return null;
			}
		});
	}
	default Integer inputInteger(String prompt,Integer minValue,Integer maxValue) {
		return inputObject(prompt,String.format("It's not number in range [%d-%d]",
				minValue,maxValue),s-> {
			try {
				Integer res=Integer.parseInt(s);
				return res>=minValue&&res<=maxValue?res:null;
			} catch (NumberFormatException e) {
				return null;
			}
		});
	}
	default Double inputDouble(String prompt) {
		return inputObject(prompt,"It's not  number",
			s->{
				try {
					Double number=Double.parseDouble(s);
					return number;
				} catch (NumberFormatException e) {
					return null;
				}
			});
	}
	
	default Double inputDouble(String prompt, Double min, Double max) {
		return inputObject(prompt, "It's not number in range ["+min+"-"+max+"]",
			s->{
				try {
					Double number=Double.parseDouble(s);
					return number;
				} catch (NumberFormatException e) {
					return null;
				}
			});
	}
	
	default Long inputLong(String prompt) {
		return inputObject(prompt,"It's not integer(long) number",
			s->{
				try {
					Long number=Long.parseLong(s);
					return number;
				} catch (NumberFormatException e) {
					return null;
				}
			});
	}

	default LocalDate inputDate(String prompt,String format) {
		return inputObject(prompt, "Wrong date "+format ,
			s->{
				try {
					DateTimeFormatter dtf=
						DateTimeFormatter.ofPattern(format);
					return LocalDate.parse(s, dtf);
				} catch (DateTimeParseException e) {
					return null;
				}
			});
	}

	default String inputString(String prompt,List<String> options) {
		return inputObject(prompt,"Not in options",
			s->options.contains(s)?s:null);
}

}
