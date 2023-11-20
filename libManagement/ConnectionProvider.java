package de.buw.se4de;
import java.sql.*;

public class ConnectionProvider {
	public static Connection getCon()
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagment","root","Sushma@9964");
		return con1;
	}
	catch(Exception e)
	{
		System.out.println(e);
	
	}
	return null;
	}
}