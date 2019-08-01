package telran.cars.items.driver;

import telran.cars.dto.Driver;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

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
		Long licenseId=getLicenseIdExisted();
		if(licenseId==null)return;
		Driver driver=company.getDriver(licenseId);
		inputOutput.outputLine(driver);

	}

	

}
