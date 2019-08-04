package items.statist;

import java.util.List;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetMostActiveDriversItem extends RentCompanyItem {

	public GetMostActiveDriversItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Display most active drivers";
	}

	@Override
	public void perform() {
		System.out.println("Your choice is " + displayedName());
//		List<Driver> drivers=company.getMostActiveDrivers();
//		if(drivers.isEmpty()) {
//			inputOutput.outputLine("no drivers");
//			return;
//		}
//		drivers.forEach(inputOutput::outputLine);
		
	}

}
