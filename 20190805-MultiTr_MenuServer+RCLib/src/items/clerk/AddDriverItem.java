package items.clerk;

import dto.Driver;
import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

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
			inputOutput.outputLine("Your choice is " + displayedName());
			Long licenseId=inputOutput.inputLong("Enter license number: ");
//					getLicenseIdNotExisted();
			if(licenseId==null)return;
			String name=inputOutput.inputString("Enter name: ");
			if(name==null)return;
			Integer birthYear=inputOutput.inputInteger
					("Enter birth year", 1940, 2001);
			if(birthYear==null)return;
			String phone=inputOutput.inputString("Enter phone number: ");
			if (phone==null)return;
			Driver driver=new Driver(licenseId, name, birthYear, phone);
			System.out.println(driver);
			inputOutput.outputLine(company.addDriver(driver));
	}

	

}
