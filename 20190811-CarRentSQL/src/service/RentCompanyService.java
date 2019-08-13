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

public class RentCompanyService implements IRentCarCompanyService{
	
	private Connection connection;

	public RentCompanyService(Connection connection) throws SQLException {
		this.connection = connection;
	}

	@Override
	public boolean addModel(String modelName, int tank, double dayPrice) throws SQLException {
		String sql = "INSERT IGNORE INTO model VALUES ("+
					"'"+modelName+"'"+","+
					tank+","+
					dayPrice+")";
		return connection.createStatement().executeUpdate(sql) == 1;
	}

	@Override
	public Model getModel(String modelName) throws SQLException {
		String sql = "SELECT * FROM model WHERE id_model = '" +
	                  modelName +"'";
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		if (!resultSet.next()) return null;		
		return new Model(resultSet.getString(1),
				         resultSet.getInt(2),
				         resultSet.getDouble(3));
	}

	@Override
	public Set<Model> getAllModels() throws SQLException {
		String sql = "SELECT * FROM model";
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		
		Set<Model> result = new HashSet<>();
		while(resultSet.next()) {
			result.add(new Model(resultSet.getString(1),
			         			resultSet.getInt(2),
			         			resultSet.getDouble(3)));
		}	
		return result;
	}

	@Override
	public boolean addDriver(int id, String name) throws SQLException {
		String sql = "INSERT IGNORE INTO driver VALUES ("+
				id+","+
				"'"+name+"'"+
				")";
	return connection.createStatement().executeUpdate(sql) == 1;
	}

	@Override
	public Driver getDriver(int id) throws SQLException {
		String sql = "SELECT * FROM driver WHERE id_driver = " + id;
                
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		if (!resultSet.next()) return null;		
		return new Driver(resultSet.getInt(1),
			         resultSet.getString(2));
	}

	@Override
	public Set<Driver> getAllDrivers() throws SQLException {
		String sql = "SELECT * FROM driver";
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		
		Set<Driver> result = new HashSet<>();
		while(resultSet.next()) {
			result.add(new Driver(resultSet.getInt(1),
			         			resultSet.getString(2)));
		}	
		return result;
	}

	@Override
	public boolean addCar(String regNumber, Model model) throws SQLException {
		
		String sql = "INSERT IGNORE INTO car VALUES ("+
				"'"+regNumber+"'"+","+
				"'"+model.getModelName()+"'"+","+
				0 +
				")";
		System.out.println(sql);
	return connection.createStatement().executeUpdate(sql) == 1;
	}

	@Override
	public Car getCar(String regNumber) throws SQLException {
		String sql = "SELECT * FROM car WHERE id_car = " + 
					"'"+regNumber+"'";
        
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		if (!resultSet.next()) return null;		
		return new Car(resultSet.getString(1),
			         getModel(resultSet.getString(2)),
			         resultSet.getInt(3) == 1);
	}

	private Set<Car> getAllCarsGeneral(boolean notInUseFlag) throws SQLException {
		String sql = "SELECT * FROM car" + 
					  (notInUseFlag ? " WHERE in_use=0" : "");
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		
		Set<Car> result = new HashSet<>();
		while(resultSet.next()) {
			result.add(new Car(resultSet.getString(1),
			         getModel(resultSet.getString(2)),
			         resultSet.getInt(3) == 1));
		}	
		return result;
	}

	@Override
	public Set<Car> getAllCars() throws SQLException {
		return getAllCarsGeneral(false);
	}
	
	@Override
	public Set<Car> getAllCarsNotInUse() throws SQLException {
		return getAllCarsGeneral(true);
	}
	
	@Override
	public boolean setCarInUse(Car car, boolean inUse) throws SQLException {
		String sql = "UPDATE car SET in_use="+
					 (inUse ? 1 : 0)+" WHERE id_car="+
					 "'"+car.getRegNumber()+"'";
		return connection.createStatement().executeUpdate(sql) == 1;
	}

	@Override
	public int rentRecord(Car car, Driver driver, LocalDate rentDate, int rentDays) throws SQLException {
		
		if (car.isInUse()) return -1;
		
		String sql = "INSERT INTO record (id_car, id_driver, rent_date, rent_days) VALUES("+
						"'"+car.getRegNumber()+"'"+","+
						driver.getId()+","+
						"'"+rentDate+"'"+","+
						rentDays+")";
		
		Statement statement= connection.createStatement();
		statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
		
		ResultSet resultSet = statement.getGeneratedKeys();
		resultSet.next();
		
		setCarInUse(car, true);
						
		return resultSet.getInt(1);
	}

	@Override
	public int returnRecord(Car car, LocalDate returnDate, int tankPercent) throws SQLException {
//		System.out.println("Car: " + car);
		if (!car.isInUse()) return -1;
		
		String sql = "SELECT id_record, rent_date, rent_days FROM record WHERE"+
					" id_car = '"+car.getRegNumber()+"'"+
					" AND "+
					"return_date is null";
		Statement statement = connection.createStatement(); 
		ResultSet resultSet = statement.executeQuery(sql);
		if (!resultSet.next()) return -1;
		int idRecord = resultSet.getInt(1);
		LocalDate rentDate = LocalDate.parse(resultSet.getString(2));
		int rentDays = resultSet.getInt(3);
		
		sql = "UPDATE record SET "+
				"return_date='"+returnDate+"'"+","+
				"tank_percent="+tankPercent+","+
				"cost="+computeCost(rentDate, returnDate,
						            rentDays, tankPercent, car)+
				" WHERE id_record="+idRecord;
		statement.executeUpdate(sql);
		setCarInUse(car, false);
		return idRecord;
	}
	
	public Set<Car> getRecordsTank(String driverName, int tankPercent) throws SQLException{
		String sql_poor = "SELECT record.id_car FROM record, driver, model,car where ((car.id_car=record.id_car)and(model.id_model=car.id_model)and(model.tank_model>="
				+ tankPercent
				+ ") and (driver.name_driver='"
				+ driverName
				+ "') and (record.id_driver=driver.id_driver));";
				
		String sql = "select id_car, id_model from record "
				+ "natural join (select * from driver where driver.name_driver='"
				+ driverName
				+ "') as driver "
				+ "natural join (select * from car natural join model where tank_model>"
				+ tankPercent
				+ ") as car;";
	Statement statement = connection.createStatement(); 
	ResultSet resultSet = statement.executeQuery(sql);
	if (!resultSet.next()) return null;
	
	Set<Car> result = new HashSet<>();
	while(resultSet.next()) {
		result.add(getCar(resultSet.getString(1)) ) ;
	}	
	return result;
	
	}
	
	private double computeCost(LocalDate rentDate, LocalDate returnDate, 
			            	int rentDays, int tankPercent, Car car) {

		int days = (int)(returnDate.toEpochDay() - rentDate.toEpochDay());
		int delay = days - rentDays;
		return car.getModel().getDayPrice()*(rentDays+
				(delay > 0 ? RentCompanyConfig.DELAY_COEFF*delay : 0))+
				(100-tankPercent)*RentCompanyConfig.FUEL_PRICE;
	}

	
	
	

}
