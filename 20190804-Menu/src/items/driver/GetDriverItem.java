package items.driver;

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
//		Long licenseId=getLicenseIdExisted();
//		if(licenseId==null)return;
//		Driver driver=company.getDriver(licenseId);
//		inputOutput.outputLine(driver);

	}

	

}
