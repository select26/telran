package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import config.IConfig;
import config.IProtocol;

public class SocketThread {

	private Socket clientConnection;
	private IProtocol protocol;

	public SocketThread(Socket clientConnection, IProtocol protocol)
	{
		super();
		this.clientConnection = clientConnection;
		this.protocol = protocol;
	}

	public void run() throws IOException
	{

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
				PrintStream writer = new PrintStream(clientConnection.getOutputStream()))
		{
			String request = null;
			System.out.println("--New Client connected: " + clientConnection.getInetAddress());
			while (true)
			{
				request = reader.readLine();
				if (request == null) break;
				if (request.equalsIgnoreCase(IConfig.EXIT)) break;
				writer.println(protocol.getResponse(request));
			}
		}
	}
}
