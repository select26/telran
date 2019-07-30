package appl;

import java.io.IOException;

import config.IConfig;
import server.SingleThreadServer;

public class TCPServerApp {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.out.println("Dont forget to launch the client side");
		(new SingleThreadServer(IConfig.PORT, IConfig.ONE_THREAD_Protocol)).go();
	}

}
