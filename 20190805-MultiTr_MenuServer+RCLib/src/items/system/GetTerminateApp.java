package items.system;

import application.RCMenu_II;
import items.RentCompanyItem;
import model.IRentCompany;
import screenmenu.InputOutput;

public class GetTerminateApp extends RentCompanyItem {

	public GetTerminateApp(InputOutput inputOutput, IRentCompany company) {
		super(inputOutput, company);
	}

	@Override
	public String displayedName() {
		return "Terminate application (for new sessions)";
	}

	@Override
	public void perform() {
		inputOutput.outputLine("New session unavaible now.\n\rCurrent session will be close normaly.\n\r");
		RCMenu_II.setAppRunning(false);
	}

}
