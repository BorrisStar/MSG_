

import java.sql.*;

//jdbc:mysql://localhost/db?useUnicode=true&serverTimezone=UTC&useSSL=false
public class Main {
	public static void main(String[] args) {


		String url = "jdbc:mysql://localhost/gamesDB?useUnicode=true&serverTimezone=UTC&useSSL=false";
		String username = "root";
		String password = "root";
		System.out.println("Connecting...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
						System.out.println("Connection successful!");
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM games");
						while(resultSet.next()) System.out.println(resultSet.getString(5));
						resultSet.close();
						statement.close();
						//connection.close();
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
	}
}
