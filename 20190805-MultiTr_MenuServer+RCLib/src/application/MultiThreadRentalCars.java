package application;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

import TCP.Server.TcpInputOutput;
import items.clerk.AddDriverItem;
import items.clerk.GetCarsModelItem;
import items.clerk.RentCarItem;
import items.clerk.ReturnCarItem;
import items.driver.GetCarDriversItem;
import items.driver.GetCarItem;
import items.driver.GetDriverItem;
import items.manager.AddCarItem;
import items.manager.AddCarModel;
import items.manager.GetAllCars;
import items.manager.GetAllDrivers;
import items.manager.GetAllModels;
import items.manager.RemoveCarItem;
import items.manager.RemoveModelItem;
import items.statist.GetMostActiveDriversItem;
import items.statist.GetMostPopularModelsItem;
import items.statist.GetyMostProfitableModelsItem;
import items.system.GetTerminateApp;
import items.technician.GetRecordsItem;
import model.RentCompanyEmbedded;
import screenmenu.ExitItem;
import screenmenu.InputOutput;
import screenmenu.Item;
import screenmenu.Menu;
import screenmenu.SubmenuItem;

public class MultiThreadRentalCars implements Runnable{
	
	RentCompanyEmbedded company;
	InputOutput inputOutput;
	Socket clientConnection;
	
	public MultiThreadRentalCars(RentCompanyEmbedded company,/* InputOutput inputOutput,*/ Socket clientConnection) {
		super();
		this.company = company;
		this.clientConnection = clientConnection;
	}

	@Override
	public void run() {
		
		inputOutput=new TcpInputOutput(clientConnection);
		
		Menu menu = new Menu(getMainMenuItems(), inputOutput);
		menu.runMenu();
		RentCompanyEmbedded.saveAllToFile();
		try {
			System.out.println("--Client disconnected:  " + clientConnection.getRemoteSocketAddress() + " at " + LocalDateTime.now().toLocalTime());
			clientConnection.close();
		} catch (IOException e) {
			System.out.println("Unexpected network error!!");
		}
	}
	
	private Item[] getMainMenuItems() {
		Item[]items= {
				new SubmenuItem("Manager", inputOutput, getManagerItems()),
				new SubmenuItem("Clerk", inputOutput, getClerkItems()),
				new SubmenuItem("Driver", inputOutput, getDriverItems()),
				new SubmenuItem("Statist", inputOutput, getStatistItems()),
				new SubmenuItem("Technician", inputOutput, getTechnicianItems()),
				new SubmenuItem("System", inputOutput, getTerminateApp()),
				new ExitItem()
		};
		return items;
	}

	private Item[] getTerminateApp() {
		Item[]items= {
				new GetTerminateApp(inputOutput, company),
				new ExitItem()
		};
		return items;	}

	private Item[] getTechnicianItems() {
		Item[]items= {
				new GetRecordsItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private Item[] getStatistItems() {
		Item[]items= {
				new GetMostActiveDriversItem(inputOutput, company),
				new GetMostPopularModelsItem(inputOutput, company),
				new GetyMostProfitableModelsItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private Item[] getDriverItems() {
		Item[]items= {
				new GetCarDriversItem(inputOutput, company),
				new GetCarItem(inputOutput, company),
				new GetDriverItem(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private Item[] getClerkItems() {
		Item[]items= {
				new AddDriverItem(inputOutput, company),
				new GetCarsModelItem(inputOutput, company),
				new RentCarItem(inputOutput, company),
				new ReturnCarItem(inputOutput, company),
				new GetAllDrivers(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

	private Item[] getManagerItems() {
		Item[]items= {
				new AddCarItem(inputOutput, company),
				new AddCarModel(inputOutput, company),
				new RemoveCarItem(inputOutput, company),
				new RemoveModelItem(inputOutput, company),
				new GetAllCars(inputOutput, company),
				new GetAllModels(inputOutput, company),
				new ExitItem()
		};
		return items;
	}

}
