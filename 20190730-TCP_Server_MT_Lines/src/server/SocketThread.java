package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

import config.IConfig;
import config.IProtocol;

public class SocketThread implements Runnable{

	private Socket clientConnection;
	private IProtocol protocol;

	public SocketThread(Socket clientConnection, IProtocol protocol)
	{
		super();
		this.clientConnection = clientConnection;
		this.protocol = protocol;
	}

	public void run()
	{

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
				PrintStream writer = new PrintStream(clientConnection.getOutputStream()))
		{
			String request = null;
//			System.out.println("--New Client connected: " + clientConnection.getInetAddress() + " at " + LocalDateTime.now().toLocalTime());
			System.out.println("--New Client connected: " + clientConnection.getRemoteSocketAddress() + " at " + LocalDateTime.now().toLocalTime());
			while (true)
			{
				request = reader.readLine();
				if (request == null) break;
				if (request.equalsIgnoreCase(IConfig.EXIT)) break;
				writer.println(protocol.getResponse(request));
			}
			System.out.println("--Client disconnected:  " + clientConnection.getRemoteSocketAddress() + " at " + LocalDateTime.now().toLocalTime());
		} catch (SocketException e) {								// Proverka na avariynoe otkl clienta
			System.out.println("--Client disconnected unnormaly: " + clientConnection.getRemoteSocketAddress() + " at " + LocalDateTime.now().toLocalTime());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
