package telran.cars;

import telran.cars.items.SaveAndExitItem;
import telran.cars.items.clerk.AddDriverItem;
import telran.cars.items.clerk.GetCarsModelItem;
import telran.cars.items.clerk.RentCarItem;
import telran.cars.items.clerk.ReturnCarItem;
import telran.cars.items.driver.GetCarDriversItem;
import telran.cars.items.driver.GetCarItem;
import telran.cars.items.driver.GetDriverItem;
import telran.cars.items.manager.AddCarItem;
import telran.cars.items.manager.AddCarModel;
import telran.cars.items.manager.RemoveCarItem;
import telran.cars.items.manager.RemoveModelItem;
import telran.cars.items.statist.GetMostActiveDriversItem;
import telran.cars.items.statist.GetMostPopularModelsItem;
import telran.cars.items.statist.GetyMostProfitableModelsItem;
import telran.cars.items.technician.GetRecordsItem;
import telran.cars.service.IRentCompany;
import telran.cars.service.RentCompanyTcpProxy;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SubmenuItem;

public class RentCompanyClientAppl {
private static final String LOCAL_HOST = "localhost";
private static final int PORT = 30000;
static IRentCompany company;
static InputOutput inputOutput;
	public static void main(String[] args) throws Exception {
		String hostname=args.length==2?args[1]:LOCAL_HOST;
		int port=args.length>0?Integer.parseInt(args[0]):PORT;
		inputOutput=new ConsoleInputOutput();
		company=new RentCompanyTcpProxy(hostname,port);
		Menu menu=new Menu(getMainMenuItems(), inputOutput);
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
		Item[] items= {
				new GetRecordsItem(inputOutput, company),
				new ExitItem()};
		return items;
	}
	private static Item[] getStatistItems() {
		Item[] items= {
				new GetMostActiveDriversItem(inputOutput, company),
				new GetMostPopularModelsItem(inputOutput, company),
				new GetyMostProfitableModelsItem(inputOutput, company),
				new ExitItem()};
		return items;
	}
	private static Item[] getDriverItems() {
		Item[]items= {
				new GetCarItem(inputOutput, company),
				new GetDriverItem(inputOutput, company),
				new GetCarDriversItem(inputOutput, company),
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
			new AddCarModel(inputOutput, company),
			new AddCarItem(inputOutput, company),
			new RemoveCarItem(inputOutput, company),
			new RemoveModelItem(inputOutput, company),
			new ExitItem()
		};
		return items;
	}

}
