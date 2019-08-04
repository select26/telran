package application;

import items.clerk.*;
import items.driver.GetCarDriversItem;
import items.driver.GetCarItem;
import items.driver.GetDriverItem;
import items.manager.AddCarItem;
import items.manager.AddCarModel;
import items.manager.RemoveCarItem;
import items.manager.RemoveModelItem;
import items.statist.GetMostActiveDriversItem;
import items.statist.GetMostPopularModelsItem;
import items.statist.GetyMostProfitableModelsItem;
import items.technician.GetRecordsItem;
import model.IRentCompany;
import screenmenu.ConsoleInputOutput;
import screenmenu.ExitItem;
import screenmenu.InputOutput;
import screenmenu.Item;
import screenmenu.Menu;
import screenmenu.SubmenuItem;

public class RCMenu_II {
	static IRentCompany company;
	static InputOutput inputOutput;

	public static void main(String[] args) {
		inputOutput=new ConsoleInputOutput();
		company=null; //new RentCompanyTcpProxy(hostname,port);

		Menu menu = new Menu(getMainMenuItems(), inputOutput);
		menu.runMenu();
	}

	private static Item[] getMainMenuItems() {
		Item[]items= {
				new SubmenuItem("Manager", inputOutput,getManagerItems() ),
				new SubmenuItem("Clerk", inputOutput, getClerkItems()),
				new SubmenuItem("Driver", inputOutput, getDriverItems()),
				new SubmenuItem("Statist", inputOutput, getStatistItems()),
				new SubmenuItem("Technician", inputOutput, getTechnicianItems()),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getTechnicianItems() {
		Item[]items= {
				new GetRecordsItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getStatistItems() {
		Item[]items= {
				new GetMostActiveDriversItem(inputOutput, company),
				new GetMostPopularModelsItem(inputOutput, company),
				new GetyMostProfitableModelsItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getDriverItems() {
		Item[]items= {
				new GetCarDriversItem(inputOutput, company),
				new GetCarItem(inputOutput, company),
				new GetDriverItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getClerkItems() {
		Item[]items= {
				new AddDriverItem(inputOutput, company),
				new GetCarsModelItem(inputOutput, company),
				new RentCarItem(inputOutput, company),
				new ReturnCarItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private static Item[] getManagerItems() {
		Item[]items= {
				new AddCarItem(inputOutput, company),
				new AddCarModel(inputOutput, company),
				new RemoveCarItem(inputOutput, company),
				new RemoveModelItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

}
