package items.driver;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetCarDriversItem extends RentCompanyItem {

	public GetCarDriversItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Display drivers data having been driving a given car";
	}

	@Override
	public void perform() {
		System.out.println("Your choice is " + displayedName());
//		String regNumber=getRegNumberExisted();
//		if(regNumber==null)return;
//		List<Driver> drivers=company.getDriversCar(regNumber);
//		if(drivers.isEmpty()) {
//			inputOutput.outputLine("No drivers of car with number "+regNumber);
//			return;
//		}
//		drivers.forEach(inputOutput::outputLine);

	}

}
