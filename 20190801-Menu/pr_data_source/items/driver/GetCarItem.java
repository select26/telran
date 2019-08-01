package telran.cars.items.driver;

import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class GetCarItem extends RentCompanyItem {

	public GetCarItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Display car data";
	}

	@Override
	public void perform() {
		String regNumber=getRegNumberExisted();
		if(regNumber==null)return;
		inputOutput.outputLine(company.getCar(regNumber));

	}

	

}
