package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DataBaseTools {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				connection = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return connection;
	}
		
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}		
	}

	private static Properties loadProperties () {		
		try (FileInputStream inputStream = new FileInputStream("db.properties")){
			Properties properties = new Properties();			
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}		
	}


	public static void closeStatment(Statement statement) {
		try {
			statement.close();			
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}
		
	}




}
