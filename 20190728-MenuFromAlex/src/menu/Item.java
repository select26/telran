package menu;

public interface Item {
	String displayedName();

	void perform();

	default boolean isExit() {
		return false;
	}
}
