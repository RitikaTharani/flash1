package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBHelper {


	static String provider=new String("jdbc:mysql://localhost:3306/carrental");
	static String uid="root";
	static String password="123";
public static Connection openConnection()
{try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,password);	
	return(cn);
}catch(Exception e)
{System.out.println("OpenConnection:"+e);}
return(null);
}
	
	public static boolean executeUpdate(Connection cn,String query)
	{try{Statement smt=cn.createStatement();
	     smt.executeUpdate(query);
	     return(true);
	}catch(Exception e){
		System.out.println("Error [executeUpdate]:"+e);
		return(false);
		
	}
	}
	
	public static ResultSet executeQuery(Connection cn,String query)
	{try{Statement smt=cn.createStatement();
	  ResultSet rs=   smt.executeQuery(query);
	     return(rs);
	}catch(Exception e){
		System.out.println("Error [executeUpdate]:"+e);
		return(null);
	}
	}
	
	
}



