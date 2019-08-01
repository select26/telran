package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RentRecord implements Serializable{

	private String 		regNumber;
	private long 		licenseId;
	private LocalDate 	rentDate;
	private LocalDate 	returnDate;
	private int 		rentDays;
	private int 		damages;
	private int 		tankPersent;
	private double 		cost;
	
	public RentRecord(String regNumber, long licenseId, LocalDate rentDate, LocalDate returnDate, int rentDays,
			int damages, int tankPersent, double cost) {
		super();
		this.regNumber = regNumber;
		this.licenseId = licenseId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.rentDays = rentDays;
		this.damages = damages;
		this.tankPersent = tankPersent;
		this.cost = cost;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public long getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(long licenseId) {
		this.licenseId = licenseId;
	}
	public LocalDate getRentDate() {
		return rentDate;
	}
	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public int getRentDays() {
		return rentDays;
	}
	public void setRentDays(int rentDays) {
		this.rentDays = rentDays;
	}
	public int getDamages() {
		return damages;
	}
	public void setDamages(int damages) {
		this.damages = damages;
	}
	public int getTankPersent() {
		return tankPersent;
	}
	public void setTankPersent(int tankPersent) {
		this.tankPersent = tankPersent;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	
}
