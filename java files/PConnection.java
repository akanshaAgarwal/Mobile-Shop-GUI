package DolphinElectronics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PConnection {

	static Connection c;
	static Connection connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/dolphinElectronics", "root", "Akansha@1996");
			System.out.println("Connected");
			
		}
		catch (ClassNotFoundException se)
		{
			se.printStackTrace();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		return c;
		
	}
	public static void main(String args[])
	{
			connect();
	}
}
