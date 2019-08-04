package items.driver;

import java.util.List;

import dto.Driver;
import items.RentCompanyItem;
import model.IRentCompany;
import model.RentCompanyEmbedded;
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
		String regNumber=inputOutput.inputString("Enter car number: ");
		if(regNumber==null)return;
		if (company.getCar(regNumber)==null)return;
		List<Driver> drivers=company.getDriversCar(regNumber);
		if(drivers.isEmpty()) {
			inputOutput.outputLine("No drivers of car with number "+regNumber);
			return;
		}
		drivers.forEach(inputOutput::outputLine);

	}

}
