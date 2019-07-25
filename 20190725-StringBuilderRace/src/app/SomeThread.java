package app;

import java.util.ArrayList;

public class SomeThread implements Runnable {
	
	private static final int NUM_APPENDS = 100_000;
	public 	static StringBuffer sb = new StringBuffer();
	
	@Override
	public void run() {
		for (int i = 0; i < NUM_APPENDS; i++) sb.append("hello");
	}

}
