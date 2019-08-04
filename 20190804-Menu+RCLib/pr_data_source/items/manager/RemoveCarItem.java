package telran.cars.items.manager;

import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

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
		String regNumber=getRegNumberExisted();
		if(regNumber==null)return;
		inputOutput.outputLine(company.removeCar(regNumber));

	}

}
