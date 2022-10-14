package com.ideas2it.employeemanagement.service.impl;

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
import com.ideas2it.employeemanagement.service.EmployeeImplService;

/** The given input with validation and logics are present
 *
 * @version 1.0.0
 */
public class EmployeeService implements EmployeeImplService {

    EmployeeImplDao dao = new EmployeeDao();
 
    public boolean isValidOption(String option) {

        return Pattern.matches("[1234567]{1}", option);
    }

    public boolean validateId(int id) {

        return Pattern.matches("[0-9]{0,2}", Integer.toString(id));
    }

    public boolean validateFirstName(String firstName) {

        return Pattern.matches("[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$", firstName);
    }

    public boolean validateLastName(String lastName) {

        return Pattern.matches("[a-zA-Z]{1,20}", lastName);
    }

    public boolean validateSalary(String salary) {
   
        return Pattern.matches("[0-9]{4,7}[\\.]?[0-9]?[0-9]?", salary);
    }

    public boolean validateMobileNumber(String mobileNumber) {

        return Pattern.matches("[//+][0-9]{2}[6-9]{1}[0-9]{9}$|[9876]{1}[0-9]{9}$",
                mobileNumber);
    }

    public boolean validateMailId(String mailId) {

        return Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9.]{5,30}+[@]"
                                + "[a-z0-9]{5,15}+[.][a-z]{1,3}$", mailId); 
    } 
    
    public boolean validateDateOfBirth(String date) {
     
        int age;
        boolean isValid = true;
        LocalDate dateOfBirth = null;

        try {   
            dateOfBirth = LocalDate.parse(date);
            age = age(dateOfBirth);
            if ((age > 18) && (age < 70)) {
                isValid = true;
            }
        } catch(DateTimeParseException dateTimeParseException) {
            isValid = false;
        }
        return isValid;
    }
    
    public int age(LocalDate dateOfBirth) {

        int age;
        age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age;
    }     
    
    public Employee viewParticularEmployee(int id) {

        Employee employee = dao.viewParticularEmployee(id);
        if (employee != null) { 
            employee.setAge(age(employee.getDateOfBirth()));
        }
        return employee;
    }  

    public List viewAllEmployee() {

        List<Employee> list = new ArrayList<>(); 
        list = dao.viewAllEmployee();
        for(Employee employee : list) {
            employee.setAge(age(employee.getDateOfBirth()));
        }
        return list; 
    } 
  
    public void updateFirstName(int id, String firstName) {

        dao.updateFirstName(id, firstName);
    }

    public void updateLastName(int id, String lastName) {

        dao.updateLastName(id, lastName);
    }

    public void updateMobileNumber(int id, String mobileNumber) {

        dao.updateMobileNumber(id, mobileNumber);
    }

    public void updateSalary(int id, String salary) {

        dao.updateSalary(id, salary);
    }  

    public void updateMailId(int id, String mailId) {

        dao.updateMailId(id, mailId);
    } 

    public void updateDateOfBirth(int id, LocalDate dateOfBirth) {

        dao.updateDateOfBirth(id, dateOfBirth);
    }

    public boolean validateAddressType(String addressType) {

        return Pattern.matches("[A-z]{3,20}", addressType);
    }

    public boolean validateFirstLine(String firstLine) {
        
        return Pattern.matches("[A-z0-9.,]{3,20}", firstLine);
    }

    public boolean validateSecondLine(String secondLine) {
        
        return Pattern.matches("[A-z0-9.,]{3,20}", secondLine);
    }  
    
    public boolean validateCity(String city) {
        
        return Pattern.matches("[A-z]{3,20}", city);
    }

    public boolean validateDistrict(String district) {
        
        return Pattern.matches("[A-z]{3,20}", district);
    }

    public boolean validateState(String state) {
        
        return Pattern.matches("[A-z]{3,20}", state);
    } 

    public boolean validatePinCode(String pinCode) {
        
        return Pattern.matches("[0-9]{1,6}", pinCode);
    } 

    public void updateCurrentAddress(List<Address> addressDetails, int id) {
    
        dao.updateCurrentAddress(addressDetails, id);
    }

    public void updatePermanentAddress(List<Address> addressDetails, int id) {
    
        dao.updateCurrentAddress(addressDetails, id);
    }

    public void deleteParticularEmployee(int id) {

        dao.deleteParticularEmployee(id); 
    }

    public void deleteCurrentAddress(int id, String addressType) {
    
        dao.deleteCurrentAddress(id, addressType);
    }

    public void deletePermanentAddress(int id, String addressType) {

        dao.deletePermanentAddress(id, addressType);
    }

    public void setEmployee(Employee employee) {

         dao.setEmployee(employee);
    }
}


