package items.manager;

import java.util.List;

import dto.Car;
import dto.Model;
import items.RentCompanyItem;
import model.IRentCompany;
import model.RentCompanyEmbedded;
import screenmenu.InputOutput;
import util.RandomLib;

public class GetAllModels extends RentCompanyItem {

	public GetAllModels(InputOutput inputOutput, RentCompanyEmbedded company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "List all models";
	}

	@Override
	public void perform() {
		inputOutput.outputLine("Your choice is " + displayedName());
		for(Model c : ((RentCompanyEmbedded) company).getAllModels()) inputOutput.outputLine(c);

	}

}
