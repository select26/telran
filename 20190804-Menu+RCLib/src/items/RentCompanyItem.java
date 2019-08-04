package items;

import java.util.ArrayList;

import model.IRentCompany;
import model.RentCompanyEmbedded;
import screenmenu.InputOutput;
import screenmenu.Item;

public class RentCompanyItem implements Item{

	private String name;
	protected InputOutput inputOutput;
	public IRentCompany company;

	public RentCompanyItem(String name) {
		super();
		this.name = name;
	}

	public RentCompanyItem(InputOutput inputOutput, IRentCompany company) {
		super();
		this.inputOutput = inputOutput;
		this.company = company;
	}

	@Override
	public String displayedName() {
		return name;
	}

	@Override
	public void perform() {
		System.out.println("selected " + name);
	}

	public String getName() {
		return name;
	}


}
