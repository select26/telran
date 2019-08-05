package items.manager;

import dto.Model;
import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

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
//		System.out.println(company);									//DEBUG!!
		inputOutput.outputLine("Your choice is " + displayedName());
		String modelName=inputOutput.inputString("Enter model name");
		if(modelName==null)//cancel processing
			return;
		
		Integer gasTank=inputOutput.inputInteger(String.format
				("Enter gas tank volume [%d-%d]", MIN_TANK,MAX_TANK),
				MIN_TANK,MAX_TANK);
		if(gasTank==null)return;
		String companyName=inputOutput.inputString("Enter company name");
		if(companyName==null)return;
		String country=inputOutput.inputString("Enter country");
		if(country==null)return;
		Integer priceDay=inputOutput.inputInteger("Enter price per day", 50, 1000);
		if(priceDay==null)return;
		Model model=
				new Model(modelName, gasTank, companyName,
						country, priceDay);
//		System.out.println(model);  									//DEBUG!!
		inputOutput.outputLine(company.addModel(model));
//		System.out.println("add result is: " + company.addModel(model));

	}

}
