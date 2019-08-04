package items.manager;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

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
		System.out.println("Your choice is " + displayedName());
//		String regNumber=getRegNumberNotExisted();
//		if(regNumber==null)
//			return;
//		String color=inputOutput.inputString("Enter color");
//		List<String> models=company.getModelNames();
//		String modelName=inputOutput.inputString("Enter model name"+models, models);
//		if(modelName==null)return;
//		Car car=new Car(regNumber, color, modelName);
//		inputOutput.outputLine(company.addCar(car));

	}

	

}
