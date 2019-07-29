package application;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Config;
import model.MealItem;
import screenmenu.Menu;

public class RestaurantMenuApp {
	public static void main(String[] args) throws IOException {
		
		Menu menu = new Menu(Config.submenues, Config.inputOutput);
		menu.runMenu();
		
		Map<MealItem, Long> order = 
				Config.orders.stream().collect(Collectors.groupingBy(Function.identity(), 
															  LinkedHashMap :: new,
						                                      Collectors.counting()));
		double total = 0.;
		System.out.println();
		for(Entry<MealItem, Long> e : order.entrySet()) {
			double price = e.getKey().getPrice();
			long number = e.getValue();
			total = total + price*number;
			System.out.println(e.getKey().getName()+"  "+ price +"  "+ number + "  "+ price*number);
		}
		System.out.println("---------------------");
		System.out.println("Total:       "+String.format("%.2f",total));
		
	}

}
