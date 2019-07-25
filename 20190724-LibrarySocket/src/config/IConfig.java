package config;

import server.response.ObjectDateRangeSelect;
import server.response.ObjectISBNSelect;
import server.response.Protocol;

public interface IConfig {
	static final String HOST = "localhost";
	static final int PORT = 2000;
	static final String EXIT = "EXIT";
	
//	static final Protocol ONE_THREAD_PROTOCOL = new ObjectDateRangeSelect();
	static final Protocol ONE_THREAD_PROTOCOL = new ObjectISBNSelect();	
}
