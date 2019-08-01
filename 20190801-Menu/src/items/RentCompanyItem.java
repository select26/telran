package items;

import java.util.ArrayList;

import model.IRentCompany;
import screenmenu.InputOutput;
import screenmenu.Item;

public class RentCompanyItem implements Item{

	private String name;
//	private ArrayList<MealItem> orders;

	public RentCompanyItem(String name) {
		super();
		this.name = name;
	}

	public RentCompanyItem(InputOutput inputOutput, IRentCompany company) {
		// TODO Auto-generated constructor stub
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
