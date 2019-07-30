package server;

import java.io.IOException;
import java.net.ServerSocket;

import config.IProtocol;

public class MultiThreadServer {
	
	private int port;
	IProtocol protocol;
	
	public MultiThreadServer(int port, IProtocol protocol)
	{
		super();
		this.port = port;
		this.protocol = protocol;
	}

	public void go() throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server is listening on port " + port);
		while (true)
//			new SocketThread(serverSocket.accept(), protocol).run();
			new Thread (new SocketThread(serverSocket.accept(), protocol)).start();
		
		//serverSocket.accept() - catch the client
	}
}
