package model;

public abstract class AbstractRentCompany implements IRentCompany {

	private int finePersent = 15;
	private int gasPrice	= 10;
	
	public int getFinePersent() {
		return finePersent;
	}
	public void setFinePersent(int finePersent) {
		this.finePersent = finePersent;
	}
	public int getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(int gasPrice) {
		this.gasPrice = gasPrice;
	}
	@Override
	public String toString() {
		return super.toString() + "AbstractRentCompany [finePersent=" + finePersent + ", gasPrice=" + gasPrice + "]";
	}
	
}
