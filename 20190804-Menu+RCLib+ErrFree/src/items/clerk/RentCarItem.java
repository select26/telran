package items.clerk;

import java.time.LocalDate;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

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
		System.out.println("Your choice is " + displayedName());		
		String regNumber=inputOutput.inputString("Enter car number: ");
		if (company.getCar(regNumber)==null) return;					// verify license exists
		if(regNumber==null)return;
		Long licenseId=inputOutput.inputLong("Enter license number: ");
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
//	protected LocalDate fromDate;
//	protected LocalDate toDate;
//	protected void fillFromToDates() {
//		String format="dd/MM/yyyy";
//		
//		fromDate=
//		inputOutput.inputDate("Enter pick date from", format);
//		if(fromDate==null)
//			return;
//		toDate=inputOutput.inputDate("Enter pick date from", format);;
//		if(toDate==null)
//			return;
//		if(fromDate.isAfter(toDate)) {
//			inputOutput.outputLine("date from can't be after date to");
//			fromDate=toDate=null;
//			return;
//		}
//		
//	}

}
