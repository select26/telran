package telran.cars.items.manager;

import telran.cars.dto.Model;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class AddCarModel extends RentCompanyItem {

	private static final int MIN_TANK = 35;
	private static final int MAX_TANK = 60;

	public AddCarModel(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Add car model";
	}

	@Override
	public void perform() {
		String modelName=inputOutput.inputString("Enter model name");
		if(modelName==null)//cancel processing
			return;
		
		Integer gasTank=inputOutput.inputInteger(String.format
				("Enter gas tank volume [%d-%d]", MIN_TANK,MAX_TANK),
				MIN_TANK,MAX_TANK);
		if(gasTank==null)return;
		String companyName=inputOutput.inputString("Enter company name");
		if(companyName==null)return;
		String country=inputOutput.inputString("Enter contry");
		if(country==null)return;
		Integer priceDay=inputOutput.inputInteger("Enter price day", 50, 1000);
		if(priceDay==null)return;
		Model model=
				new Model(modelName, gasTank, companyName,
						country, priceDay);
		inputOutput.outputLine(company.addModel(model));

	}

}
