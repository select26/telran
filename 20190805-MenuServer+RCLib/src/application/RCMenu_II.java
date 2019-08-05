package application;

import items.clerk.*;
import items.driver.*;
import items.manager.*;
import items.statist.*;
import items.technician.*;
import model.IRentCompany;
import model.RentCompanyEmbedded;
import screenmenu.ConsoleInputOutput;
import screenmenu.ExitItem;
import screenmenu.InputOutput;
import screenmenu.Item;
import screenmenu.Menu;
import screenmenu.SubmenuItem;
import screenmenu.TcpInputOutput;

public class RCMenu_II {
	
	static RentCompanyEmbedded company;
	static InputOutput inputOutput;

	public static void main(String[] args) {
		company=new RentCompanyEmbedded(); 					//new RentCompanyTcpProxy(hostname,port);
		RentCompanyEmbedded.restoreAllFromFile();
		System.out.println(company);						//DEBUG!!
		inputOutput=new TcpInputOutput();					//ConsoleInputOutput();
		
		Menu menu = new Menu(getMainMenuItems(), inputOutput);
		menu.runMenu();
		
		RentCompanyEmbedded.saveAllToFile();
	}

	private static Item[] getMainMenuItems() {
		Item[]items= {
				new SubmenuItem("Manager", inputOutput, getManagerItems()),
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
