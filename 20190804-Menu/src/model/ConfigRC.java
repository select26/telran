package model;

import java.util.ArrayList;

import items.RentCompanyItem;
import screenmenu.ConsoleInputOutput;
import screenmenu.ExitItem;
import screenmenu.Item;
import screenmenu.SubmenuItem;

public class ConfigRC {

	public static final ConsoleInputOutput inputOutput = new ConsoleInputOutput();
//	company=n

	public static final Item[] manager = 
		{new RentCompanyItem("AddCarModel"), 
		 new RentCompanyItem("AddCarItem"), 
		 new RentCompanyItem("RemoveCarItem"),
		 new RentCompanyItem("RemoveModelItem"),
		 new ExitItem()};
	
	public static final Item[] сlerks = 
		{new RentCompanyItem("AddDriverItem"), 
		 new RentCompanyItem("GetCarsModelItem"), 
		 new RentCompanyItem("RentCarItem"), 
		 new RentCompanyItem("ReturnCarItem"), 
		 new ExitItem()};
	
	public static final Item[] driver = 
		{new RentCompanyItem("GetCarItem"), 
		 new RentCompanyItem("GetDriverItem"), 
		 new RentCompanyItem("GetCarDriversItem"), 
		 new ExitItem()};
	
	public static final Item[] statist = 
		{new RentCompanyItem("GetMostActiveDriversItem"), 
		 new RentCompanyItem("GetMostPopularModelsItem"), 
	 	 new RentCompanyItem("GetyMostProfitableModelsItem"), 
		 new ExitItem()};

	public static final Item[] technician = 
		{new RentCompanyItem("GetRecordsItem"), 
		 new ExitItem()};
	
	public static final Item[] submenues = 
		{new SubmenuItem("Manager", inputOutput, manager),
		 new SubmenuItem("Clerks", inputOutput, сlerks),
		 new SubmenuItem("Driver", inputOutput, driver),
		 new SubmenuItem("Statist", inputOutput, statist),
		 new SubmenuItem("Technician", inputOutput, technician),
		 new ExitItem()};

}
