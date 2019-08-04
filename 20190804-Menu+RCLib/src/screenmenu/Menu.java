package screenmenu;

import model.RentCompanyEmbedded;

public class Menu {
	
	String header;
	Item[]items;
	InputOutput inputOutput;
	RentCompanyEmbedded company;
	
	public Menu(Item[] items, InputOutput inputOutput, RentCompanyEmbedded company) {
		super();
		this.items = items;
		this.inputOutput = inputOutput;
		this.company = company;
	}
	
	public void runMenu() {
		while (true) {
			for (int i = 0; i < items.length; i++) {
				inputOutput.outputLine((i + 1) + ". " + items[i].displayedName());
			}
			Integer selected = inputOutput.inputInteger("Type item number", 1, items.length);
			if (selected == null) continue;
			try {
				items[selected - 1].perform();
			} catch (Exception e) {
				inputOutput.outputLine(e.getMessage());		//DEBUG!!! NF!
			}
			if (items[selected - 1].isExit())
				return;
		}
	}
}
