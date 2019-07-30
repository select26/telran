package response;

import config.IProtocol;

public class FuckYouResponce implements IProtocol {

	@Override
	public String getResponse(String request)
	{
		return "Fuck You, " + request;
	}

}
