package items.manager;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class RemoveCarItem extends RentCompanyItem {

	public RemoveCarItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		
		return "Remove car item";
	}

	@Override
	public void perform() {
		inputOutput.outputLine("Your choice is " + displayedName());
		String regNumber=inputOutput.inputString("Enter car number: ");
		if(regNumber==null)return;
		inputOutput.outputLine(company.removeCar(regNumber));

	}

}
