package telran.cars.items.technician;

import java.util.List;

import telran.cars.dto.RentRecord;
import telran.cars.items.RentCompanyItem;
import telran.cars.service.IRentCompany;
import telran.view.InputOutput;

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

}
