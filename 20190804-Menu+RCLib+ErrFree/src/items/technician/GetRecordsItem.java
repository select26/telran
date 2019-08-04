package items.technician;

import java.time.LocalDate;
import java.util.List;

import dto.RentRecord;
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

		fillFromToDates();
		if(fromDate==null||toDate==null)
			return;
		List<RentRecord> records=company.getRentRecordsAtDates(fromDate, toDate);
		if(records.isEmpty()) {
			inputOutput.outputLine("no records");
			return;
		}
		records.forEach(inputOutput::outputLine);

	}
	protected LocalDate fromDate;
	protected LocalDate toDate;

	protected void fillFromToDates() {
		String format = "dd/MM/yyyy";

		fromDate = inputOutput.inputDate("Enter pick date from", format);
		if (fromDate == null)	return;
		toDate = inputOutput.inputDate("Enter return date from", format);
		if (toDate == null)		return;
		if (fromDate.isAfter(toDate)) {
			inputOutput.outputLine("date from can't be after date to");
			fromDate = toDate = null;
			return;
		}
	}
}
