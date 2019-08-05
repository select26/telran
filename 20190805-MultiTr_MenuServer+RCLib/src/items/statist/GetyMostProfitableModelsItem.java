package items.statist;

import java.time.LocalDate;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetyMostProfitableModelsItem extends RentCompanyItem {

	protected LocalDate fromDate;
	protected LocalDate toDate;
	
	public GetyMostProfitableModelsItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Most profitable model names";
	}

	@Override
	public void perform() {

		inputOutput.outputLine("Your choice is " + displayedName());
		fillFromToDates();
		company.getMostProfitableCarModels
		(fromDate, toDate).forEach(inputOutput::outputLine);

	}
	

	protected void fillFromToDates() {
		String format="dd/MM/yyyy";
		
		fromDate=
		inputOutput.inputDate("Enter date from", format);
		if(fromDate==null)
			return;
		toDate=inputOutput.inputDate("Enter date to", format);;
		if(toDate==null)
			return;
		if(fromDate.isAfter(toDate)) {
			inputOutput.outputLine("date from can't be after date to");
			fromDate=toDate=null;
			return;
		}
		
	}
	
}
