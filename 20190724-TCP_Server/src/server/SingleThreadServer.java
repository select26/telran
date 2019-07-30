package server;

import java.io.IOException;
import java.net.ServerSocket;

import config.IProtocol;

public class SingleThreadServer {
	
	private int port;
	IProtocol protocol;
	
	public SingleThreadServer(int port, IProtocol protocol)
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
			(new SocketThread(serverSocket.accept(), protocol)).run();
		
		//serverSocket.accept() - catch the client
	}
}
