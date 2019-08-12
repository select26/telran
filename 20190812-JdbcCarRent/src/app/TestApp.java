package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import service.RentCompanyService;

public class TestApp {

	public static void main(String[] args) {

		try (
				Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/rent_company?useSSL=false&serverTimezone=UTC", "select", "mailsheeva");
				){
			RentCompanyService service = new RentCompanyService(connection); 
			System.out.println(service.getModel("Ford"));
			System.out.println(service.getDriver(111));
			System.out.println(service.getAllDrivers());
//			System.out.println(service.addDriver(666, "Vasisualy"));
//			System.out.println(service.addCar("PPC-118", service.getModel("Ford")));
			System.out.println(service.getCar("AAA-111"));
			
		} catch (SQLException e) {
            e.printStackTrace(); 								// обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
		} 
	}

}
