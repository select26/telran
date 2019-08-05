package TCP.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

import screenmenu.InputOutput;

//import config.IProtocol;

public class TcpInputOutput implements InputOutput {

	// IProtocol protocol;
	private int port;
	Socket clientConnection;
	BufferedReader reader;
	PrintStream writer;

	public TcpInputOutput(Socket clientConnection) {
		super();
		port = TcpConfig.PORT;
		this.clientConnection = clientConnection;
//		try {
//			ServerSocket serverSocket = new ServerSocket(port);
//			clientConnection = serverSocket.accept();
//			// Create input & output streams
//			reader = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
//			writer = new PrintStream(clientConnection.getOutputStream());
//			System.out.println("--New Client connected: " + clientConnection.getRemoteSocketAddress()); // getInetAddress());
//		} catch (Exception e) {
//			System.out.println("Error establishing tcp connection..");
//		}

		
			try {
//				ServerSocket serverSocket = new ServerSocket(port);
//				clientConnection = serverSocket.accept();
				// Create input & output streams
				reader = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
				writer = new PrintStream(clientConnection.getOutputStream());
				System.out.println("--New Client connected: " + clientConnection.getRemoteSocketAddress() + " at " + LocalDateTime.now().toLocalTime());
			} catch (IOException e) {
				System.out.println("--Client disconnected unnormaly: " + clientConnection.getRemoteSocketAddress() + " at " + LocalDateTime.now().toLocalTime());
			} finally {
				// TODO: handle finally clause
			}
			 // getInetAddress());
		
		
		
	}

	@Override
	public String inputString(String prompt) {
		outputLine("\n"+prompt+" or \"cancel\" to exit");
		try {
			String line=reader.readLine();
			return line.equals("cancel")?null:line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void output(Object obj) {
		writer.println(obj);
	}

}
