package telran.cars.items.manager;

import java.util.List;

import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class RemoveModelItem extends RentCompanyItem {

	public RemoveModelItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Remove model";
	}

	@Override
	public void perform() {
		
		List<String> models=company.getModelNames();
		String modelName=inputOutput.inputString("Enter model name"+models, models);
		if(modelName==null)return;
		company.removeModel(modelName)
		.forEach(inputOutput::outputLine);

	}

}
