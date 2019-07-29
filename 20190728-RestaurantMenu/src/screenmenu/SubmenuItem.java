package screenmenu;

public class SubmenuItem implements Item {
	String displayedName;
	InputOutput inputOutput;
	Item [] items;
	
	public SubmenuItem(String displayedName, InputOutput inputOutput, Item[] items) {
		super();
		this.displayedName = displayedName;
		this.inputOutput = inputOutput;
		this.items = items;
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
