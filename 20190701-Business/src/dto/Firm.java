package dto;

import randomlib.RandomLib;

public class Firm implements Comparable<Firm>{

	private static final String[] FIRM_NAMES = {"Omsktelecom", "TELE2", "MTS", 
			"DOM.RU", "ROSTELECOM", "BEELINE", "MegaFon", "Orange"};
	private static final int MIN_F_YEAR = 2000;
	private static final int MAX_F_YEAR = 2019;
	private static final double MIN_FUNDS = 10_000;
	private static final double MAX_FUNDS = 1_000_000;
	/*
	long taxNumber (11)
	String name;
	int foundationYear;
	double funds;
	boolean criminal;
	*/
	private long taxNumber;
	private String name;
	private int foundationYear;
	private double funds;
	private boolean criminal;
	
	public Firm(long taxNumber, String name, int foundationYear, double funds, boolean criminal) {
		super();
		setTaxNumber(taxNumber);
		this.name = name;
		setFoundationYear(foundationYear);
		this.funds = funds;
		this.criminal = criminal;
	}
	
	public static Firm randomFirm() {
		long inn = (long)RandomLib.nextDoubleRange(10000000000., 89999999999.);
		String name = RandomLib.nextStringFromSet(FIRM_NAMES);
		int foundationYear = RandomLib.nextIntRange(MIN_F_YEAR, MAX_F_YEAR);
		double funds = (int)(RandomLib.nextDoubleRange(MIN_FUNDS, MAX_FUNDS) * 100) / 100.;
		boolean crime = RandomLib.nextRandomBoolean(.15);
		return new Firm(inn, name, foundationYear, funds, crime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(int foundationYear) {
		if (foundationYear >= MIN_F_YEAR) this.foundationYear = foundationYear;
		else { 
			this.foundationYear = 0;
			System.err.println("Error setting foundationYear: " + foundationYear);
		}
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public boolean isCriminal() {
		return criminal;
	}

	public void setCriminal(boolean criminal) {
		this.criminal = criminal;
	}

	public long getTaxNumber() {
		return taxNumber;
	}
	
	private void setTaxNumber(long inn) {
		if ( (inn < 99_999_999_999L) && (inn > 9_999_999_999L) ) this.taxNumber = inn;
		else {
			this.taxNumber = 0;
			System.err.println("Error setting taxNumber!");
		}
	}

	@Override
	public String toString() {
		return "Firm [taxNumber=" + taxNumber + ", name=" + name + ", foundationYear=" + foundationYear + ", funds="
				+ funds + ", criminal=" + criminal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (criminal ? 1231 : 1237);
		result = prime * result + foundationYear;
		long temp;
		temp = Double.doubleToLongBits(funds);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (taxNumber ^ (taxNumber >>> 32));
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
		Firm other = (Firm) obj;
		if (criminal != other.criminal)
			return false;
		if (foundationYear != other.foundationYear)
			return false;
		if (Double.doubleToLongBits(funds) != Double.doubleToLongBits(other.funds))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (taxNumber != other.taxNumber)
			return false;
		return true;
	}

	@Override
	public int compareTo(Firm other) {
		return Long.compare(this.taxNumber, other.taxNumber);
	}
	
	
}
