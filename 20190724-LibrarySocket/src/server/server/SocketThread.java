package server.server;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

import server.response.Protocol;

public class SocketThread {

	private Socket clientConnection;
	private Protocol protocol;


	public SocketThread(Socket clientConnection, Protocol protocol) {
		super();
		this.clientConnection = clientConnection;
		this.protocol = protocol; 
	}

	public void run() throws IOException, ClassNotFoundException{
		

		try(
				BufferedReader reader=new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
				PrintStream writer=new PrintStream(clientConnection.getOutputStream())
			){
				String request = null;
				while (true) {
					request = reader.readLine();		//schityvaem stroku
					if(request == null) break;  		//esli klient zakrylsya
					writer.println(protocol.getResponse(request));
				}
		}

//		try(
//				ObjectInputStream ois = new ObjectInputStream(clientConnection.getInputStream());
//				ObjectOutputStream oos = new ObjectOutputStream(clientConnection.getOutputStream());
//			){				
//						Object request = ois.readObject();
//						System.out.println(request);
//						oos.writeObject(protocol.getResponse((String) request));
//		}
	}
}
