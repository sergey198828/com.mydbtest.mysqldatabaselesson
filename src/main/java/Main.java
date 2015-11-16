import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "sergey88";
	
	public static void main(String[] args){
		//Register driver	
		try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);            
        } catch(SQLException e){
            e.printStackTrace();
        }
		//Establish connection
		try{
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); 
			Statement statement = connection.createStatement();
			statement.execute("insert into users(name, age, email) values('Ivan Ivanov', 32, 'Ivan.Ivanov@example.com')");
			int res1 = statement.executeUpdate("update users set age=31, email='Ivan.I.Ivanov@example.com' where name='Ivan Ivanov'");
			System.out.println(res1);
			ResultSet res2 = statement.executeQuery("Select * from users");
			statement.addBatch("delete from users where id=4");
			statement.addBatch("delete from users where id=5");
			statement.addBatch("delete from users where id=6");
			statement.addBatch("delete from users where id=7");
			statement.executeBatch();
			
			statement.close();
			connection.close();
			
		} catch (SQLException e){
			e.printStackTrace();
	} 

	}

}
