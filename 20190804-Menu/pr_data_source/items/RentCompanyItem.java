package telran.cars.items;

import telran.view.*;

import java.time.LocalDate;

import telran.cars.service.*;
public abstract class RentCompanyItem implements Item{
protected InputOutput inputOutput;
protected IRentCompany company;
public RentCompanyItem(InputOutput inputOutput, IRentCompany company) {
	super();
	this.inputOutput = inputOutput;
	this.company = company;
}
protected String getRegNumberNotExisted() {
	String regNumber=inputOutput.inputString("Enter new registration number");
	if(regNumber==null)return null;
	if(company.getCar(regNumber)!=null) {
		inputOutput.outputLine("Car already exists");
		return null;
	}
	return regNumber;
}
protected Long getLicenseIdNotExisted() {
	Long licenseId=inputOutput.inputLong("Enter new license id");
	if(licenseId==null)return null;
	if(company.getDriver(licenseId)!=null) {
		inputOutput.outputLine("Driver already exists");
		return null;
	}
	return licenseId;
}
protected Long getLicenseIdExisted() {
	Long licenseId=inputOutput.inputLong("Enter  license id");
	if(licenseId==null)return null;
	if(company.getDriver(licenseId)==null) {
		inputOutput.outputLine("Driver not found");
		return null;
	}
	return licenseId;
}
protected String getRegNumberExisted() {
	String regNumber=inputOutput.inputString("Enter  registration number");
	if(regNumber==null)return null;
	if(company.getCar(regNumber)==null) {
		inputOutput.outputLine("Car not found");
		return null;
	}
	return regNumber;
}
protected LocalDate fromDate;
protected LocalDate toDate;
protected void fillFromToDates() {
	String format="dd/MM/yyyy";;
	
	fromDate=
	inputOutput.inputDate("Enter pick date from", format);
	if(fromDate==null)
		return;
	toDate=inputOutput.inputDate("Enter pick date from", format);;
	if(toDate==null)
		return;
	if(fromDate.isAfter(toDate)) {
		inputOutput.outputLine("date from can't be after date to");
		fromDate=toDate=null;
		return;
	}
	
}
}
