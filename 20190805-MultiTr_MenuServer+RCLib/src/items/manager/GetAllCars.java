package items.manager;

import java.util.List;

import dto.Car;
import items.RentCompanyItem;
import model.IRentCompany;
import model.RentCompanyEmbedded;
import screenmenu.InputOutput;
import util.RandomLib;

public class GetAllCars extends RentCompanyItem {

	public GetAllCars(InputOutput inputOutput, RentCompanyEmbedded company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "List all cars";
	}

	@Override
	public void perform() {
		inputOutput.outputLine("Your choice is " + displayedName());
		for(Car c : ((RentCompanyEmbedded) company).getAllCars()) inputOutput.outputLine(c);

	}

}
