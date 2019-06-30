package model;

public class Kolhoz {

	private static int zakroma = 0;
	
	public void harvest() {
		zakroma = zakroma + 1000000;
	}

	public int getZakroma() {
		return zakroma;
	}
	
}
