package telran.cars.items.statist;

import java.util.List;

import telran.cars.dto.Driver;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

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
		List<Driver> drivers=company.getMostActiveDrivers();
		if(drivers.isEmpty()) {
			inputOutput.outputLine("no drivers");
			return;
		}
		drivers.forEach(inputOutput::outputLine);
		
	}

}
