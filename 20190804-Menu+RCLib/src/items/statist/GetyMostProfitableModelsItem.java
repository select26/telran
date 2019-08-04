package items.statist;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetyMostProfitableModelsItem extends RentCompanyItem {

	public GetyMostProfitableModelsItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Most profitable model names";
	}

	@Override
	public void perform() {

		System.out.println("Your choice is " + displayedName());
//		fillFromToDates();
//		company.getMostProfitableCarModels
//		(fromDate, toDate).forEach(inputOutput::outputLine);

	}

}
