package application;

import java.net.ServerSocket;
import java.net.Socket;

import TCP.Server.TcpConfig;
import model.RentCompanyEmbedded;
import screenmenu.InputOutput;

public class RCMenu_II {
	
	static RentCompanyEmbedded company;
	static InputOutput inputOutput;
//	private Socket clientConnection;
	static boolean appRunningFlag = true;

	public static void main(String[] args) {
		company=new RentCompanyEmbedded(); 					//new RentCompanyTcpProxy(hostname,port);
		RentCompanyEmbedded.restoreAllFromFile();
		System.out.println(company);						//DEBUG!!

		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(TcpConfig.PORT);

		while (appRunningFlag) {
			new Thread ( new MultiThreadRentalCars(company, serverSocket.accept())).start();
//			RentCompanyEmbedded.saveAllToFile();					//Transfered to MultiThreadRentalCars
		}
		} catch (Exception e) {
			System.out.println("Network error: " + e.getMessage());
		}

	}

	public static boolean isAppRunning() {
		return appRunningFlag;
	}

	public static void setAppRunning(boolean appRunningFlag) {
		RCMenu_II.appRunningFlag = appRunningFlag;
	}
}
