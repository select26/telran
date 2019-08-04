package telran.cars.items.clerk;

import java.time.LocalDate;

import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

public class RentCarItem extends RentCompanyItem {

	public RentCarItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		
		return "Rent car";
	}

	@Override
	public void perform() {
		String regNumber=getRegNumberExisted();
		if(regNumber==null)return;
		Long licenseId=getLicenseIdExisted();
		if(licenseId==null)
			return;
		String format="dd/MM/yyyy";
		LocalDate rentDate=inputOutput.inputDate("Enter rent date "+format, format);
		if(rentDate==null)
			return;
		Integer rentDays=inputOutput.inputInteger("Enter rent days [1-30],1,30");
		
		inputOutput.outputLine(company.rentCar(regNumber,
				licenseId,
				rentDate,
				rentDays));

	}
	protected LocalDate fromDate;
	protected LocalDate toDate;
	protected void fillFromToDates() {
		String format="dd/MM/yyyy";
		
		fromDate=
		inputOutput.inputDate("Enter pick date from", format);
		if(fromDate==null)
			return;
		toDate=inputOutput.inputDate("Enter pick date from", format);;
		if(toDate==null)
			return;
		if(fromDate.isAfter(toDate)) {
			inputOutput.outputLine("date from can't be after date to");
			fromDate=toDate=null;
			return;
		}
		
	}

}
