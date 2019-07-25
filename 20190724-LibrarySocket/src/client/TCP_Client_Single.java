package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import config.IConfig;

public class TCP_Client_Single {

	public static void tcpSimpleClient() throws UnknownHostException, IOException {
		try(
				Socket client = new Socket(IConfig.HOST, IConfig.PORT);
				BufferedReader readerTCP = new BufferedReader(new InputStreamReader(client.getInputStream()));
				BufferedReader readerKeyboard = new BufferedReader(new InputStreamReader(System.in));
				PrintStream writerTCP = new PrintStream(client.getOutputStream()) 	//vyhodnoy potok
			){
				String line =null;
				while(true) {
					System.out.println("Enter any text or '" +IConfig.EXIT+"' to exit");	//vyvodim soobshenie
					line = readerKeyboard.readLine();										//chitaem c klaviatury
					if (line.equalsIgnoreCase(IConfig.EXIT)) break;				//esli nabrano "exit", to preryvaetsya
					writerTCP.println(line); 												// peredacha na vyhod
//					System.out.println(readerTCP.readLine());					//vydaem to, chto prishlo na vyhod
					for (String s : readerTCP.readLine().split("=@="))
						System.out.println(s);
				}
				client.close();	
			}	
		}
}
