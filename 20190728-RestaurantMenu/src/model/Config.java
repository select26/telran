package model;

import java.util.ArrayList;

import screenmenu.ConsoleInputOutput;
import screenmenu.ExitItem;
import screenmenu.Item;
import screenmenu.SubmenuItem;

public class Config {

	public static final ArrayList<MealItem> orders = new ArrayList<>();
	public static final ConsoleInputOutput inputOutput = new ConsoleInputOutput();

	public static final Item[] salads = 
				{new MealItem("Olivier",18.3, orders), 
				 new MealItem("Nicoise",24.6, orders), 
				 new MealItem("Cesar", 19.0, orders), 
				 new ExitItem()};
	
	public static final Item[] soups = 
		{new MealItem("Borzhch",26.8, orders), 
		 new MealItem("Shchee", 24.2, orders), 
		 new MealItem("Okroshka", 16.5, orders), 
		 new ExitItem()};
	
	public static final Item[] meals = 
		{new MealItem("Shashlyk", 44.3, orders), 
		 new MealItem("Pelmeni", 32.5, orders), 
		 new MealItem("Kasha", 14.3, orders), 
		 new ExitItem()};
	
	public static final Item[] desserts = 
		{new MealItem("Coffee", 8.0, orders), 
		 new MealItem("Ice cream", 14.3, orders), 
		 new MealItem("Cigar", 12.0, orders), 
		 new ExitItem()};
	
	public static final Item[] submenues = 
		{new SubmenuItem("Salads", inputOutput, salads),
		 new SubmenuItem("Soups", inputOutput, soups),
		 new SubmenuItem("Meals", inputOutput, meals),
		 new SubmenuItem("Desserts", inputOutput, desserts),
		 new ExitItem()};

}
