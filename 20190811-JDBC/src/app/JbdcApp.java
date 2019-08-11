package app;

import java.sql.*;

import randomlib.RandomLib;

public class JbdcApp {

	public static void main(String[] args) throws SQLException {
		
		String[] names = {"Dennis", "Olga", "Andrey", "Alexey", "Artiom", "Anatoly", "Arseny", "Boris",
						"Gennady", "Dmitry", "Anna", "Alla", "Tatyana", "Tamara", "Maria"};
		
		try (
				Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/2019?useSSL=false&serverTimezone=UTC", "select", "mailsheeva");
				)
		{
			Statement statement = connection.createStatement();
			System.out.println("Соединение с СУБД выполнено.");

			String sql;
			for (int i = 0; i < 1000; i++) {
				sql = "INSERT INTO person (id_person,name_person, age_person, height_person, married_person) "
						+ "VALUES ('0','" + RandomLib.nextStringFromSet(names) + "', " + RandomLib.nextIntRange(5, 50)
						+ ", " + RandomLib.nextIntRange(120, 192) + ", " + RandomLib.nextIntRange(0, 1) + ");";
				int result = statement.executeUpdate(sql);
			}
			
			sql = "SELECT * FROM person";
			ResultSet resultSet = statement.executeQuery(sql);
			
//			resultSet = statement.getGeneratedKeys();
//			resultSet.next();
//			System.out.println(resultSet.getInt(1));				// Print key of last inserted row	
			
			
			while (resultSet.next()) {
//				System.out.println(resultSet.getInt(1) + "\t" + 
//									resultSet.getString("name_person") + "\t" +
//									resultSet.getInt(3) + "\t" + 
//									resultSet.getDouble(4) + "\t" + 
//									resultSet.getBoolean(5));
				System.out.println(new Person(resultSet.getInt(1), 
						resultSet.getString("name_person"),
						resultSet.getInt(3),
						resultSet.getDouble(4), 
						resultSet.getBoolean(5)));
			} 
        } catch (SQLException e) {
            e.printStackTrace(); 								// обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
		
	}

}
