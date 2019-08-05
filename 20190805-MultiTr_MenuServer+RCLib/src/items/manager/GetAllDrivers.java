package items.manager;

import java.util.List;

import dto.Car;
import dto.Driver;
import items.RentCompanyItem;
import model.IRentCompany;
import model.RentCompanyEmbedded;
import screenmenu.InputOutput;
import util.RandomLib;

public class GetAllDrivers extends RentCompanyItem {

	public GetAllDrivers(InputOutput inputOutput, RentCompanyEmbedded company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "List all drivers";
	}

	@Override
	public void perform() {
		inputOutput.outputLine("Your choice is " + displayedName());
		for(Driver c : ((RentCompanyEmbedded) company).getAllDrivers()) inputOutput.outputLine(c);

	}

}
