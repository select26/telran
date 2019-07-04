package app;

public interface ICarDriver {

	default void drive() {
		System.out.println("I drive car.");
	}
	
	static void work() {
		System.out.println("I work day & night..");
	}
}
