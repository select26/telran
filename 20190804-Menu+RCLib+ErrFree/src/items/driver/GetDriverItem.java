package items.driver;

import dto.Driver;
import enumerations.CarsReturnCode;
import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetDriverItem extends RentCompanyItem {

	public GetDriverItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Display driver's data";
	}

	@Override
	public void perform() {
		System.out.println("Your choice is " + displayedName());
		Long licenseId=inputOutput.inputLong("Enter drivers license: ");
//				getLicenseIdExisted();
		if(licenseId==null)return;
		Driver driver=company.getDriver(licenseId);
		if (driver == null) inputOutput.outputLine("NO_DRIVER"); 
		else inputOutput.outputLine(driver);

	}

	

}
