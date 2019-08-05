package screenmenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputOutput implements InputOutput {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public String inputString(String prompt) {
		outputLine("\n"+prompt+" or \"cancel\" to exit");
		try {
			String line=br.readLine();
			return line.equals("cancel")?null:line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void output(Object obj) {
		System.out.print(obj);
	}

}
