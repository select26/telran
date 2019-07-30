import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;


public class TCPClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket client = new Socket(IConfig.HOST, IConfig.PORT);
		
		try (BufferedReader readerTCP = new BufferedReader(new InputStreamReader(client.getInputStream()));
				BufferedReader readerKeyboard = new BufferedReader(new InputStreamReader(System.in));
				PrintStream writerTCP = new PrintStream(client.getOutputStream()))
		{
			String line = null;
			while (true)
			{
				System.out.println("Enter any text or '" + IConfig.EXIT + "' to exit");
				line = readerKeyboard.readLine();
				if (line.equalsIgnoreCase(IConfig.EXIT)) break;
				
				writerTCP.println(line);
				
				String stringFromServer = readerTCP.readLine();
				System.out.println(stringFromServer.replaceAll("!!!", "\n"));
			}
		}
		finally
		{
			client.close();
		}

	}

}
