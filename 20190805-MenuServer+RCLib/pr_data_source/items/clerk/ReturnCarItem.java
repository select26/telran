package telran.cars.items.clerk;

import java.time.LocalDate;

import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class ReturnCarItem extends RentCompanyItem {

	public ReturnCarItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		
		return "Return car";
	}

	@Override
	public void perform() {
		String regNumber=getRegNumberExisted();
		if(regNumber==null)return;
		Long licenseId=getLicenseIdExisted();
		if(licenseId==null)
			return;
		String format="dd/MM/yyyy";
		LocalDate returnDate=inputOutput.inputDate("Enter return date "+format, format);
		if(returnDate==null)
			return;
		Integer damages=
				inputOutput.inputInteger("Enter percent of danages", 0, 100);
		if(damages==null)
			return;
		Integer tankPercent=
				inputOutput.inputInteger("Enter tank percent", 0, 100);
		if(tankPercent==null)
			return;
		inputOutput.outputLine
		(company.returnCar
				(regNumber, licenseId,
						returnDate,
						damages, 
						tankPercent));

	}

}
