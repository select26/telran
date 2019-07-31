package dto;

import java.util.List;

public class RemovedCarData {

	private Car car;
	private List<RentRecord> removedRecords;
	
	public RemovedCarData() {
		super();
	}

	public RemovedCarData(Car car, List<RentRecord> removedRecords) {
		super();
		this.car = car;
		this.removedRecords = removedRecords;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<RentRecord> getRemovedRecords() {
		return removedRecords;
	}

	public void setRemovedRecords(List<RentRecord> removedRecords) {
		this.removedRecords = removedRecords;
	}
	
	
	
}
