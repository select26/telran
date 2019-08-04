package items.technician;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetRecordsItem extends RentCompanyItem {

	public GetRecordsItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Display records";
	}

	@Override
	public void perform() {
		System.out.println("Your choice is " + displayedName());

//		fillFromToDates();
//		if(fromDate==null||toDate==null)
//			return;
//		List<RentRecord> records=company.getRentRecordsAtDates(fromDate, toDate);
//		if(records.isEmpty()) {
//			inputOutput.outputLine("no records");
//			return;
//		}
//		records.forEach(inputOutput::outputLine);

	}

}
