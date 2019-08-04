package items.clerk;

import java.time.LocalDate;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

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
		System.out.println("Your choice is " + displayedName());		
		String regNumber=inputOutput.inputString("Enter car number: ");
		if (company.getCar(regNumber)==null) return;					// verify license exists
		if(regNumber==null)return;
		Long licenseId=inputOutput.inputLong("Enter license number: ");
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
