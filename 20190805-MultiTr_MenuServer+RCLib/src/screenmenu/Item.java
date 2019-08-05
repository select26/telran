package screenmenu;

import model.RentCompanyEmbedded;

public interface Item {
	
	String displayedName();
	default boolean isExit() {
		return false;
	}
	void perform();
}
