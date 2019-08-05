package screenmenu;

import model.IRentCompany;
import model.RentCompanyEmbedded;

public class SubmenuItem implements Item {
	String displayedName;
	InputOutput inputOutput;
	Item [] items;
//	RentCompanyEmbedded company;
	
	public SubmenuItem(String displayedName, InputOutput inputOutput, Item[] items) {
		super();
//		System.out.println("XXX"+company);
		this.displayedName = displayedName;
		this.inputOutput = inputOutput;
		this.items = items;
//		this.company = company;
	}
	
	@Override
	public String displayedName() {
		return displayedName;
	}

	@Override
	public void perform() {
		Menu menu=new Menu(items, inputOutput);
		menu.runMenu();

	}
}
