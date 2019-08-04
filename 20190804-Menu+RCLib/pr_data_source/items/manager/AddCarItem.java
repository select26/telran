package telran.cars.items.manager;

import java.util.List;

import telran.cars.dto.Car;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class AddCarItem extends RentCompanyItem {

	public AddCarItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Add new car";
	}

	@Override
	public void perform() {
		String regNumber=getRegNumberNotExisted();
		if(regNumber==null)
			return;
		String color=inputOutput.inputString("Enter color");
		List<String> models=company.getModelNames();
		String modelName=inputOutput.inputString("Enter model name"+models, models);
		if(modelName==null)return;
		Car car=new Car(regNumber, color, modelName);
		inputOutput.outputLine(company.addCar(car));

	}

	

}
