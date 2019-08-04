package telran.cars.items.clerk;

import telran.cars.dto.Driver;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class AddDriverItem extends RentCompanyItem {

	public AddDriverItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Add driver";
	}

	@Override
	public void perform() {
			Long licenseId=getLicenseIdNotExisted();
			if(licenseId==null)return;
			String name=inputOutput.inputString("Enter name");
			if(name==null)return;
			Integer birthYear=inputOutput.inputInteger
					("Enter birth year", 1940, 2001);
			if(birthYear==null)return;
			String phone=inputOutput.inputString("Enter phone number");
			if (phone==null)return;
			Driver driver=new Driver(licenseId, name, birthYear, phone);
			inputOutput.outputLine(company.addDriver(driver));
	}

	

}
