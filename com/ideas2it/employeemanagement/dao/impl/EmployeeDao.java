package com.ideas2it.employeemanagement.dao.impl;

import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.connection.DatabaseConnection;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.dao.EmployeeImplDao;

public class  EmployeeDao implements EmployeeImplDao {

	public int setEmployee(Employee employee) {

        int id =0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME,"
            	    + "SALARY,MAIL_ID, MOBILE_NUMBER,DATE_OF_BIRTH, "
            	    + "IS_ACTIVE) VALUES(?,?,?,?,?,?,1)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getMailId());
            preparedStatement.setString(5, employee.getMobileNumber());
            preparedStatement.setString(6, employee.getDateOfBirth().toString());
            preparedStatement.execute();
            id = getEmployeeId(preparedStatement);
            setAddress(employee.getAddress(), id);
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
        return id;
	}

    public int getEmployeeId(PreparedStatement preparedStatement ) {

        int id = 0;
    	try{
            ResultSet result = preparedStatement.executeQuery("SELECT MAX(ID)"
            	+ " FROM EMPLOYEE");

            if (result.next()) {
                id = result.getInt(1);
            }
    	} catch (SQLException exception) {
    		exception.printStackTrace();
    	}
    	return id;
    }

    public void setAddress(List<Address> addressDetails, int id) {

        try{
        	for (Address address : addressDetails) {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("INSERT INTO ADDRESS(ADDRESS_TYPE, FIRST_LINE,"
            	    +" SECOND_LINE, CITY, DISTRICT, STATE, PINCODE, ID) "
            	    + "VALUES(?,?,?,?,?,?,?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, address.getAddressType());
            preparedStatement.setString(2, address.getFirstLine());
            preparedStatement.setString(3, address.getSecondLine());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getDistrict());
            preparedStatement.setString(6, address.getState());
            preparedStatement.setString(7, address.getPinCode());
            preparedStatement.setInt(8, id);
            preparedStatement.execute();
            }
        } catch(SQLException exception){

        	exception.printStackTrace();
        }	
    }

    public List getAddress(int id) {
  
        List<Address> addAddress = new ArrayList<>();
        ResultSet result;
        PreparedStatement preparestatement;
        String query = ("SELECT * FROM ADDRESS WHERE ID = ?");

        try{
            preparestatement = DatabaseConnection.getConnection(
            	    ).prepareStatement(query);
            preparestatement.setInt(1, id);
            result = preparestatement.executeQuery();
            while(result.next()) {
                Address address = new Address();
                address.setAddressType(result.getString(1));
                address.setFirstLine(result.getString(2));
                address.setSecondLine(result.getString(3));
                address.setCity(result.getString(4));
                address.setDistrict(result.getString(5));
                address.setState(result.getString(6));
                address.setPinCode(result.getString(7));
                addAddress.add(address);
            }  
        } catch(SQLException exception){

        	exception.printStackTrace();
        } 
        return addAddress;   
    }

	public Employee viewParticularEmployee(int id) {
    
        Employee employee = null;
        ResultSet result;
        PreparedStatement preparestatement;
        String query = ("SELECT * FROM EMPLOYEE WHERE ID = ?");
 
        try{
            preparestatement = DatabaseConnection.getConnection(
            	    ).prepareStatement(query);
            preparestatement.setInt(1, id);
            result = preparestatement.executeQuery();
            while(result.next()) {
                employee = new Employee();
                employee.setId(result.getInt(1));
                employee.setFirstName(result.getString(2));
                employee.setLastName(result.getString(3));
                employee.setSalary(result.getString(4));
                employee.setMailId(result.getString(5));
                employee.setMobileNumber(result.getString(6));
                employee.setDateOfBirth(result.getDate(7).toLocalDate());
                employee.setAddress(getAddress(id));
            }  

        } catch(SQLException exception){

        	exception.printStackTrace();
        }  
        return employee;  
    }		
	
	public List<Employee> viewAllEmployee() {
    
        List<Employee> allEmployee = new ArrayList<>();
        Employee employee = null;
        ResultSet result;
        PreparedStatement preparestatement;
        String query = ("SELECT * FROM EMPLOYEE");
 
        try{
            preparestatement = DatabaseConnection.getConnection(
            	    ).prepareStatement(query);
            result = preparestatement.executeQuery();
            while(result.next()) {
                employee = new Employee();
                employee.setId(result.getInt(1));
                employee.setFirstName(result.getString(2));
                employee.setLastName(result.getString(3));
                employee.setSalary(result.getString(4));
                employee.setMailId(result.getString(5));
                employee.setMobileNumber(result.getString(6));
                employee.setDateOfBirth(result.getDate(7).toLocalDate());

                employee.setAddress(getAllAddress(result.getInt(1)));

                allEmployee.add(employee);
            }  

        } catch(SQLException exception){

        	exception.printStackTrace();
        }  
        return allEmployee;  
    }	

    public List getAllAddress(int id) {
  
        List<Address> addAddress = new ArrayList<>();
        ResultSet result;
        PreparedStatement preparestatement;
        String query = ("SELECT * FROM ADDRESS WHERE ID = ?");

        try{
            preparestatement = DatabaseConnection.getConnection(
            	    ).prepareStatement(query);
            preparestatement.setInt(1, id);
            result = preparestatement.executeQuery();
            while(result.next()) {
                Address address = new Address();
                address.setAddressType(result.getString(1));
                address.setFirstLine(result.getString(2));
                address.setSecondLine(result.getString(3));
                address.setCity(result.getString(4));
                address.setDistrict(result.getString(5));
                address.setState(result.getString(6));
                address.setPinCode(result.getString(7));
                addAddress.add(address);
            }  
        } catch(SQLException exception){

        	exception.printStackTrace();
        } 
        return addAddress;   
    }

    public void	updateFirstName(int id, String firstName) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE EMPLOYEE SET FIRST_NAME = ? WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void	updateLastName(int id, String lastName) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE EMPLOYEE SET LAST_NAME = ? WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, lastName);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void	updateMobileNumber(int id, String mobileNumber) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE Employee SET MOBILE_NUMBER = ?"
            	    + " WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, mobileNumber);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void	updateSalary(int id, String salary) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE EMPLOYEE SET SALARY = ? WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, salary);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void	updateMailId(int id, String mailId) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE EMPLOYEE SET MAIL_ID = ? WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, mailId);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void	updateDateOfBirth(int id, LocalDate dateOfBirth) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE EMPLOYEE SET DATE_OF_BIRTH = ? "
            	    + "WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dateOfBirth.toString());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void updateCurrentAddress(int id, String addressType, 
            String firstLine,String secondLine,String city,
            String district, String state, String pinCode) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE ADDRESS SET FIRST_LINE = ?,"
                    + "SECOND_LINE = ?, CITY = ?, DISTRICT = ?, STATE = ?,"
                    + " PINCODE = ? WHERE ID = ? AND ADDRESS_TYPE = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstLine);
            preparedStatement.setString(2, secondLine);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, district);
            preparedStatement.setString(5, state);
            preparedStatement.setString(6, pinCode);
            preparedStatement.setInt(7, id);
            preparedStatement.setString(8, addressType);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void updatePermanentAddress(int id, String addressType,  
            String firstLine,String secondLine,String city,
            String district, String state, String pinCode) {
    
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("UPDATE ADDRESS SET FIRST_LINE = ?,"
            	    + " SECOND_LINE = ?, CITY = ?, DISTRICT = ?, STATE = ?,"
            	    + " PINCODE = ? WHERE ID = ? AND ADDRESS_TYPE = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstLine);
            preparedStatement.setString(2, secondLine);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, district);
            preparedStatement.setString(5, state);
            preparedStatement.setString(6, pinCode);
            preparedStatement.setInt(7, id);
            preparedStatement.setString(8, addressType);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void deleteParticularEmployee(int id) {

        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = (" UPDATE EMPLOYEE INNER JOIN ADDRESS ON"  
            	    + " EMPLOYEE.ID= ADDRESS.ID SET ADDRESS.IS_ACTIVE = 0,"
            	    + " EMPLOYEE.IS_ACTIVE = 0 WHERE EMPLOYEE.ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }	

    public void deleteCurrentAddress(int id, String addressType) {
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("DELETE FROM ADDRESS  WHERE ID = ? AND "
            	    + "ADDRESS_TYPE = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,addressType);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }

    public void deletePermanentAddress(int id, String addressType) {
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = ("DELETE FROM ADDRESS  WHERE ID = ? AND "
            	+ "ADDRESS_TYPE = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,addressType);
            preparedStatement.execute();
        } catch (SQLException exception) {

        	exception.printStackTrace();
        }
        DatabaseConnection.closeConnection();
    }
}