package config;

import response.FuckYouResponce;
import response.MirrorServerResponse;

public interface IConfig {
	public static final int PORT = 2000;
	public static final IProtocol ONE_THREAD_Protocol = new MirrorServerResponse();
//	public static final IProtocol ONE_THREAD_Protocol = new FuckYouResponce();
	static final String EXIT = "quit";
}
