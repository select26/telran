package log;

import java.util.ArrayList;

import model.Message;

public class MessageBoxLog {
	
	public static final ArrayList<Message> LOG = new ArrayList<>();
	public static int BOX_EMPTY = 0;
	public static int BOX_FULL = 0;
	
	public static void clear() {
		LOG.clear();
		BOX_EMPTY = 0;
		BOX_FULL = 0;
	}
	
}
