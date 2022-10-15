package com.ideas2it.employeemanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class DatabaseConnection {
     
    private static Connection connection = null;

    private DatabaseConnection(){

    }
     
	public static Connection getConnection() {

        try{
            if(connection == null || connection.isClosed()){
		        Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://"
                        + "localhost:3306/employee_management_application",
                        "root","suganyai2i");
            }
        } catch (Exception e) {
        	System.out.println("Exception occured");
        }
        return connection;
	}
    
    public static Connection closeConnection() {

        try {
            if (connection != null ) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}