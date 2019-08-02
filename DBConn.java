package com.maren.jdbcdemo.controller;


	import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
	import java.sql.SQLException;
public class DBConn{
		public static Connection dbConn() throws IOException,SQLException,ClassNotFoundException
		{
			Connection db = null;
		Class.forName("com.mysql.jdbc.Driver");  
		db = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/soon","root","Richi@123456");  
		return  db;
			}
		public static void main(String [] args)
		{
			try {
				System.out.println(dbConn());
				if(dbConn()!=null)
				{
					System.out.println("Connected");
					
				}
				else
				{
					System.err.println("Not Connected");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}



