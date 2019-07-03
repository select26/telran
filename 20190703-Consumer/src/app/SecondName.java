package app;

import java.util.function.Consumer;

public class SecondName implements Consumer<Chinese>{

	String secondName;
	
	@Override
	public void accept(Chinese c) {
		c.setName(c.getName() + " " + secondName);
	}

	public SecondName(String secondName) {
		super();
		this.secondName = secondName;
	}

}
