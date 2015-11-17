import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {
	private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "sergey88";
	private Connection connection;
	
	public DBWorker(){
		try {
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.connection;
	}
}
