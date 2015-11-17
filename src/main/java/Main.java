import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	
	public static void main(String[] args){

		
		try{
			DBWorker dbworker = new DBWorker();
			Statement statement = dbworker.getConnection().createStatement();
			statement.execute("insert into users(name, age, email) values('Ivan Ivanov', 32, 'Ivan.Ivanov@example.com')");
			int res1 = statement.executeUpdate("update users set age=31, email='Ivan.I.Ivanov@example.com' where name='Ivan Ivanov'");
			System.out.println(res1);
			statement.addBatch("delete from users where id=3");
			statement.addBatch("delete from users where id=8");
			statement.addBatch("delete from users where id=9");
			statement.addBatch("delete from users where id=10");
			statement.executeBatch();
			ResultSet res2 = statement.executeQuery("Select * from users");
			while(res2.next()){
				System.out.println("id: " + res2.getInt("id") + ", name: " + res2.getString("name") + ", age: " + 
			res2.getString("age") + ", email: " + res2.getString("email"));
			}
		} catch (SQLException e){
			e.printStackTrace();
	} 

	}

}
