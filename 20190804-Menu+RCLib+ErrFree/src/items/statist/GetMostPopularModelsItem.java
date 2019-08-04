package items.statist;

import java.time.LocalDate;
import java.util.List;

import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetMostPopularModelsItem extends RentCompanyItem {

	public GetMostPopularModelsItem(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		
		return "Display most popular model names";
	}

	@Override
	public void perform() {
		System.out.println("Your choice is " + displayedName());
//		fillFromToDates();
//		if(fromDate==null || toDate==null)
//			return;
//		Integer fromAge=inputOutput
//				.inputInteger("Enter age from(18,90)", 18, 90);
//		if(fromAge==null)
//			return;
//		Integer toAge=inputOutput
//				.inputInteger("Enter age to(18,90)", 18, 90);
//		
//		if(toAge==null)
//			return;
//		if(fromAge>toAge) {
//			inputOutput.outputLine("\"from\" age can't be greater than \"to\"" );
//			return;
//		}
//		List<String> models=company.getMostPopularCarModels(fromDate, toDate, fromAge, toAge);
//		if(models.isEmpty()) {
//			inputOutput.outputLine("no models");
//			return;
//		}
//		models.forEach(inputOutput::outputLine);
	}

}
