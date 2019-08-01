package telran.cars.items.clerk;

import java.util.List;

import telran.cars.dto.Car;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

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
