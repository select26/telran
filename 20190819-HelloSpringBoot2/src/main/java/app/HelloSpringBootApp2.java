package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringBootApp2 {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApp2.class, args);
		System.out.println("test");
	}

}
