package app;

public interface IPrintDriver {
	default void drive() {
		System.out.println("I drive printers.");
	}
	
	static void work() {
		System.out.println("I never work!");
	}
}
