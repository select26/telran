package app.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BeanLifecycleService {

	@Value("${secrecy_path}")
	private String	path;
	private HashMap<String,String> secrecy = new HashMap<>();
	
	@PostConstruct											// этот метод вызовется перед запуском
	private void setSecrecy() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));	
		String line = null;
		String[] data = null;
		while(true) {
			line= br.readLine();
			if (line==null) break;
			data = line.split(":");
			secrecy.put(data[0], data[1]);
		}
		br.close();
	}
	
	public String check(String login, String password) {
		String psw = secrecy.get(login);
		if (psw==null || !psw.equals(password)) return "Access denied!";
		return "Access allowed";
	}
}
