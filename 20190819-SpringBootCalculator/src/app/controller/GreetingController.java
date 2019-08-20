package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping ("/calc")						//будет обрабатывать завпросы, начинающиеся на /greet 
public class GreetingController {
	
	@GetMapping("/calc")						//извлекаем параметры из GET-запроса
	public String testParam (@RequestParam ("first") double firstOp,
							@RequestParam ("second") double secondOp,
							@RequestParam ("oper") String oper ) {
		return calc (firstOp, secondOp, oper);
//		return firstOp + " " + secondOp + " "+ oper;
	}
	
	private String calc(double firstOp, double secondOp, String oper) {
		String result = "";
		if (oper.equals("+") || oper.equals("plus")) result = result + (firstOp + secondOp);
		else if (oper.equals("-") || oper.equals("munis")) result = result + (firstOp - secondOp);
		else if (oper.equals("*") || oper.equals("mul")) result = result + (firstOp * secondOp);
		else if (oper.equals("/") || oper.equals("dev")) {
			if (secondOp == 0) result = result + "devide by zero error!";
			else result = result +  (firstOp / secondOp);
		}
		else result = "non-supported operation!";
		return result;
	}

	@GetMapping("/name/{id}")					//извлекаем параметры из пути http-запроса
	public String getName(@PathVariable("id") int id){
		String[] names = {"Sasha","Masha","Dasha"};
		return id>=0 && id <3 ? names[id] : "wrong id!";
	}
	
}
