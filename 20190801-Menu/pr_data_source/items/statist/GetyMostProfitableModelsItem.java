package telran.cars.items.statist;


import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

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
		fillFromToDates();
		company.getMostProfitableCarModels
		(fromDate, toDate).forEach(inputOutput::outputLine);

	}

}
