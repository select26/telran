package application;

import java.io.IOException;
import model.ConfigRC;
//import model.MealItem;
import screenmenu.Menu;

public class RCMenu {
	public static void main(String[] args) throws IOException {
		
		Menu menu = new Menu(ConfigRC.submenues, ConfigRC.inputOutput);
		menu.runMenu();
		
//		Map<MealItem, Long> order = 
//				ConfigMeal.orders.stream().collect(Collectors.groupingBy(Function.identity(), 
//															  LinkedHashMap :: new,
//						                                      Collectors.counting()));
//		double total = 0.;
//		System.out.println();
//		for(Entry<MealItem, Long> e : order.entrySet()) {
//			double price = e.getKey().getPrice();
//			long number = e.getValue();
//			total = total + price*number;
//			System.out.println(e.getKey().getName()+"  "+ price +"  "+ number + "  "+ price*number);
//		}
//		System.out.println("---------------------");
//		System.out.println("Total:       "+String.format("%.2f",total));
		
	}

}
