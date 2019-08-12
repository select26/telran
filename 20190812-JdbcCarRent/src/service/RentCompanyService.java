package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import dto.Car;
import dto.Driver;
import dto.Model;

public class RentCompanyService implements IRentCompanyService {
	private Statement statement = null;
	private Connection connection;

	public RentCompanyService(Connection connection) throws SQLException {
		this.connection = connection;
		statement = connection.createStatement();
	}

	@Override
	public boolean addModel(String modelName, int tank, double dayPrice) throws SQLException {
		String sql = "INSERT IGNORE model VALUES ('" + modelName + "'," + tank + "," + dayPrice + ")";
		return statement.executeUpdate(sql) == 1;
	}

	@Override
	public Model getModel(String modelName) throws SQLException {
		String sql = "SELECT * FROM model WHERE id_model = '" + modelName + "'";
		ResultSet resultSet = statement.executeQuery(sql);
		if (!resultSet.next())
			return null;

		return new Model(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
	}

	@Override
	public Set<Model> getAllModels() throws SQLException {
		String sql = "SELECT * FROM model";
		ResultSet resultSet = statement.executeQuery(sql);
		Set<Model> resalt = new HashSet<>();
		while (resultSet.next()) {
			resalt.add(new Model(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3)));
		}
		return resalt;
	}

	@Override
	public boolean addDriver(int id, String name) throws SQLException {
		String sql = "INSERT IGNORE driver VALUES (" + id + ",'" + name + "')";
		return statement.executeUpdate(sql) == 1;	}

	@Override
	public Driver getDriver(int id) throws SQLException {
		String sql = "SELECT * FROM driver WHERE id_driver = " + id;
		ResultSet resultSet = statement.executeQuery(sql);
		if (!resultSet.next()) return null;
		return new Driver (resultSet.getInt(1),
							resultSet.getString(2));
	}

	@Override
	public Set<Driver> getAllDrivers() throws SQLException {
		String sql = "SELECT * FROM driver";
		ResultSet resultSet = statement.executeQuery(sql);
		if (!resultSet.next()) return null;
		
		Set<Driver> result = new HashSet<>();
		while (resultSet.next()) {
			result.add(new Driver(resultSet.getInt(1),resultSet.getString(2)));
		}
		return result;

	}

	@Override
	public boolean addCar(String regNumber, Model model) throws SQLException {
		String sql = "INSERT IGNORE car VALUES ('" + regNumber + "','" + model.getModelName() + "',0)";
//		System.out.println(sql);
		return statement.executeUpdate(sql) == 1;
	}

	@Override
	public Car getCar(String regNumber) throws SQLException {
		String sql = "SELECT * FROM car WHERE id_car = '" + regNumber + "'";
		System.out.println(sql);
		ResultSet resultSet = statement.executeQuery(sql);
		if (!resultSet.next()) return null;
		return new Car (resultSet.getString(1),
							getModel(resultSet.getString(2)),
							resultSet.getBoolean(3));	
	}

	@Override
	public Set<Car> getAllCars() throws SQLException {
		String sql = "SELECT * FROM car";
		ResultSet resultSet = statement.executeQuery(sql);
		if (!resultSet.next()) return null;
		
		Set<Car> result = new HashSet<>();
		while (resultSet.next()) {
			result.add(new Car(resultSet.getString(1),getModel(resultSet.getString(2)),resultSet.getBoolean(3)));
		}
		return result;	}

	@Override
	public Set<Car> getAllCarsNotInUse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rentRecord(Car car, Driver driver, LocalDate rentDate, int rentDays) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int returnRecord(Car car, LocalDate returnDate, int tankPersent) {
		// TODO Auto-generated method stub
		return 0;
	}

}