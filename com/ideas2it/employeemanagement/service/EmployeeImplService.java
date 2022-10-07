package com.ideas2it.employeemanagement.service;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.dao.EmployeeImplDao;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.dao.impl.EmployeeDao;



public interface EmployeeImplService {

	public boolean isValidOption(String option);

	public boolean validateId(int id);

	public boolean validateFirstName(String firstName);

	public boolean validateLastName(String lastName);

	public boolean validateSalary(String salary);

	public boolean validateMobileNumber(String mobileNumber);

	public boolean validateMailId(String mailId);

	public boolean validateDateOfBirth(String date);

	public int age(LocalDate dateOfBirth);

	public Employee viewParticularEmployee(int id);

	public List viewAllEmployee();

	public void updateFirstName(int id, String firstName);

	public void updateLastName(int id, String lastName);

	public void updateMobileNumber(int id, String mobileNumber);

	public void updateSalary(int id, String salary);

	public void updateMailId(int id, String mailId);

	public void updateDateOfBirth(int id, LocalDate dateOfBirth);
  
    public void deleteParticularEmployee(int id); 

    public boolean validateAddressType(String addressType);

    public boolean validateFirstLine(String firstLine);
		
    public boolean validateSecondLine(String secondLine);
		
    public boolean validateCity(String city);

    public boolean validateDistrict(String district);
 
    public boolean validateState(String state);

    public boolean validatePinCode(String pinCode); 

    public void updateCurrentAddress(int id, String addressType,
            String firstLine, String secondLine, String city, 
            String district, String state, String pinCode);

    public void updatePermanentAddress(int id, String addressType, 
            String firstLine, String secondLine, String city, 
            String district, String state, String pinCode);

    public void deleteCurrentAddress(int id, String addressType);

    public void deletePermanentAddress(int id, String addressType);

    public int setEmployee(Employee employee);
}