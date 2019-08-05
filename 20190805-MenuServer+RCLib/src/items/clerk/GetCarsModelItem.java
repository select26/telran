package items.clerk;

import java.util.List;

import dto.Car;
import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;


public class GetCarsModelItem extends RentCompanyItem {

	public GetCarsModelItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Display free cars of a given car model";
	}

	@Override
	public void perform() {
		inputOutput.outputLine("Your choice is " + displayedName());
		List<String> modelNames=company.getModelNames();
		String modelName=inputOutput.inputString("Enter model name"+modelNames,
				modelNames);
		if(modelName==null)return;
		
		List<Car> models=company.getCarsModel(modelName);
		if(models.isEmpty()) {
			inputOutput.outputLine("no cars of "+modelName);
			return;
		}
		models.forEach(inputOutput::outputLine);

	}

}
