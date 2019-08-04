package items.manager;

import java.util.List;

import dto.Car;
import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;
import util.RandomLib;

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
		String regNumber= randomRegNumber(); //getRegNumberNotExisted();
		if(regNumber==null) return;
		else System.out.println("reg number: " + regNumber);
		String color=inputOutput.inputString("Enter color");
		List<String> models=company.getModelNames();
		String modelName=inputOutput.inputString("Enter model name"+models, models);
		if(modelName==null)return;
		Car car=new Car(regNumber, color, modelName);
		inputOutput.outputLine(company.addCar(car));

	}

	private static String randomRegNumber() {
		return RandomLib.generateRandomWord(3) + Integer.toString(RandomLib.nextIntRange(100000, 999999));
	}

}
