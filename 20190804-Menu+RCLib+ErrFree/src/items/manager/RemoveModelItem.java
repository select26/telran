package items.manager;

import java.util.List;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

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
		System.out.println("Your choice is " + displayedName());
		List<String> models=company.getModelNames();
		String modelName=inputOutput.inputString("Enter model name "+models, models);
		if(modelName==null)return;
		company.removeModel(modelName)
		.forEach(inputOutput::outputLine);
	}

}
