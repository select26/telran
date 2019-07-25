package server.server;


import java.io.IOException;

import java.net.ServerSocket;

import server.response.Protocol;

public class SingleThreadServer {
	
	private int port;
	Protocol protocol;

	
	public SingleThreadServer(int port, Protocol protocol) {
		super();
		this.port = port;
		this.protocol = protocol;
	}


	public void go() throws IOException, ClassNotFoundException {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server is listening on port "+port);
			while(true) {
				(new SocketThread(serverSocket.accept(), protocol)).run();
			}
	}
	
}
