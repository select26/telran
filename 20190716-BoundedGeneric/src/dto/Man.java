package dto;

public class Man implements Comparable<Man>{
	
	private double money;

	public Man(double money) {
		super();
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public int compareTo(Man o) {
		return Double.compare(money, o.getMoney());
	}

	@Override
	public String toString() {
		return "Man [" + money + "]";
	}

}
