package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import dto.Car;
import dto.Driver;
import dto.Model;
import service.RentCompanyService;

public class CarRentSQLApp {

	public static void main(String[] args) throws SQLException {
		
		try(
				Connection connection 
					= DriverManager.getConnection(
							"jdbc:mysql://localhost/rent_company?useSSL=false&serverTimezone=UTC",
							"select",
							"mailsheeva");){
			
			RentCompanyService service = 
					new RentCompanyService(connection);
			
			//System.out.println(service.getModel("Ford"));
			//System.out.println(service.addModel("Honda", 25, 80.));
			for (Model model : service.getAllModels())
				System.out.println(model);
			//service.addDriver(666, "Lisa");
			for (Driver driver : service.getAllDrivers())
				System.out.println(driver);
			
			//service.addCar("FFF-666", 
			//		service.getModel("Honda"));
			for (Car car : service.getAllCarsNotInUse())
				System.out.println(car);
			
			//service.setCarInUse(service.getCar("CCC-333"), true);
		
			System.out.println("*********************");
			for (Car car : service.getAllCarsNotInUse())
				System.out.println(car);
			
			
			int rentId = service.rentRecord(service.getCar("CCC-333"), 
										service.getDriver(222),
										LocalDate.of(2019, 8, 14),
										10);
			System.out.println(rentId);
			
			int returnId = service.returnRecord(service.getCar("CCC-333"), 
								LocalDate.of(2019, 8, 20), 
								70);
			System.out.println(returnId);
			
			System.out.println(service.getRecordsTank("Dasha",20));
		}
		
		

	}

}
