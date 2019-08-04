package items.driver;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;


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
		System.out.println("Your choice is " + displayedName());
//		String regNumber=getRegNumberExisted();
//		if(regNumber==null)return;
//		inputOutput.outputLine(company.getCar(regNumber));

	}

	

}
