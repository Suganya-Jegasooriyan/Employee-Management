package com.ideas2it.employeemanagement.dao;

import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.connection.DatabaseConnection;
import com.ideas2it.employeemanagement.model.Employee;

public interface EmployeeImplDao {

    public void setEmployee(Employee employee);

    public Employee viewParticularEmployee(int id);

    public List<Employee> viewAllEmployee();

    public void updateFirstName(int id, String firstName);

    public void updateLastName(int id, String lastName);

    public void updateMobileNumber(int id, String mobileNumber);

    public void updateSalary(int id, String salary);

    public void updateMailId(int id, String mailId);

    public void updateDateOfBirth(int id, LocalDate dateOfBirth);

    public void updateCurrentAddress(List<Address> addressDetails, int id);

    public void updatePermanentAddress(List<Address> addressDetails, int id);

    public void deleteParticularEmployee(int id);

    public void deleteCurrentAddress(int id, String addressType);

    public void deletePermanentAddress(int id, String addressType);
    
}