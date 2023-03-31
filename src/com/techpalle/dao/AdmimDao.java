package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmimDao
{
   
    private static final String dbUrl = "jdbc:mysql://localhost:3306/customer_management";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String ValidateQuery = "select * from store_admin where username =? and password=?";
	
	public static boolean validateAdmin(String user,String pass)
	{
		boolean b=false;
		try {
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			    ps = con.prepareStatement(ValidateQuery );
			    ps.setString(1, user);
			    ps.setString(2, pass);
			    rs = ps.executeQuery();
			    
			    b = rs.next();
			    
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return b;
		
	}
	   
}
