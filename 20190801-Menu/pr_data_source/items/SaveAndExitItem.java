package telran.cars.items;

import telran.cars.service.IRentCompany;
import telran.util.Persistable;
import telran.view.InputOutput;

public class SaveAndExitItem extends RentCompanyItem {

	String fileName;

	public SaveAndExitItem(InputOutput inputOutput, IRentCompany company, String fileName) {
		super(inputOutput, company);
		this.fileName = fileName;
	}

	@Override
	public String displayedName() {
		return "Save and Exit";
	}

	@Override
	public void perform() {
		((Persistable)company).save(fileName);

	}
	@Override
	public boolean isExit() {
		return true;
	}

}
