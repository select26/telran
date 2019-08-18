package appl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.BlogPost;

public class app {

	public static void main(String[] args) throws JsonProcessingException
	{
		String url = "http://jsonplaceholder.typicode.com/posts?id={id}&userId={userId}";
		 //url = "http://jsonplaceholder.typicode.com/posts?userId={userId}";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<String> httpEntity = new HttpEntity<>(null); //headers is null for GET request
/*		Map<String, Integer> uriVars = new HashMap<>();
		
		uriVars.put("id", 15);
		uriVars.put("userId", 2);
		
		//read arrays of posts
		ResponseEntity<BlogPost[]> responce = 
				restTemplate.exchange(url, HttpMethod.GET, httpEntity, BlogPost[].class, uriVars); //Jackson required
		
		System.out.println(responce);
		System.out.println();
		System.out.println(Arrays.toString(responce.getBody()));
		System.out.println();
		System.out.println();
		*/
		
		//create a new blogPost
		BlogPost post = new BlogPost(12, 100, "Haifa", "Test body");
		
		String body = new ObjectMapper().writeValueAsString(post);
		
		System.out.println(body);
		
		url = "http://jsonplaceholder.typicode.com/posts";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		httpEntity = new HttpEntity<>(body, headers);

		ResponseEntity<BlogPost> responce = 
				restTemplate.exchange(url, HttpMethod.POST, httpEntity, BlogPost.class);
		
		System.out.println(responce.getBody());
	}

}
