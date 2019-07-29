package model;

import java.util.ArrayList;

import screenmenu.Item;

public class MealItem implements Item{

	private String name;
	private double price;
	private ArrayList<MealItem> orders;

	public MealItem(String name, double price, ArrayList<MealItem> orders) {
		super();
		this.name = name;
		this.price = price;
		this.orders = orders;
	}


	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealItem other = (MealItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}


	@Override
	public String displayedName() {
		return name+"  "+ price;
	}


	@Override
	public void perform() {
		System.out.println(displayedName());
		orders.add(this);
	}

}
