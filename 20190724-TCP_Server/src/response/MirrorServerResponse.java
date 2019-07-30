package response;

import config.IProtocol;

public class MirrorServerResponse implements IProtocol {

	@Override
	public String getResponse(String request)
	{
		
		return (new StringBuilder(request)).reverse().toString();
	}

}
