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

/*s the given input with validation and logics are present
 *
 * @version 1.0.0
 */
public class EmployeeService implements EmployeeImplService {

    EmployeeImplDao dao = new EmployeeDao();
 
    /**
     * Checks with validation with the given output
     *@ return boolean value
     */
    public boolean isValidOption(String option) {

        return Pattern.matches("[1234567]{1}", option);
    }

    /**
     * Checks with validation with the given input
     *@ return boolean value
     */
    public boolean validateId(int id) {

        return Pattern.matches("[0-9]{2}", Integer.toString(id));
    }

    /**
     * Checks the validation with the given put
     *@ return string value
     */
    public boolean validateFirstName(String firstName) {

        return Pattern.matches("[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$", firstName);
    }

    /**
     * Checks the validation with the given input
     *@ return string value
     */
    public boolean validateLastName(String lastName) {

        return Pattern.matches("[a-zA-Z]{1,20}", lastName);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateSalary(String salary) {
   
        return Pattern.matches("[0-9]{4,7}[\\.]?[0-9]?[0-9]?", salary);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateMobileNumber(String mobileNumber) {

        return Pattern.matches("[//+][0-9]{2}[6-9]{1}[0-9]{9}$|[9876]{1}[0-9]{9}$",
                mobileNumber);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateMailId(String mailId) {

        return Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9.]{5,30}+[@]"
                                + "[a-z0-9]{5,15}+[.][a-z]{1,3}$", mailId); 
    } 
    
    /**
     * Checks the validation with the given input and
     * Calculates tha age according to localdate
     *@ return boolean value
     */
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
    
    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public int age(LocalDate dateOfBirth) {

        int age;
        age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age;
    }     
    
    /**
     * Displays the particular employee details
     * @ return boolean value
     */
    public Employee viewParticularEmployee(int id) {

        Employee employee = dao.viewParticularEmployee(id);
        if (employee != null) { 
            employee.setAge(age(employee.getDateOfBirth()));
        }
        return employee;
    }  

    /**
     * Displays the all employee details
     * @ return list
     */
    public List viewAllEmployee() {

        List<Employee> list = new ArrayList<>(); 
        list = dao.viewAllEmployee();
        for(Employee employee : list) {
            employee.setAge(age(employee.getDateOfBirth()));
        }
        return list; 
    } 
  
    /**
     * Updates the first name of particular employee details
     */
    public void updateFirstName(int id, String firstName) {

        dao.updateFirstName(id, firstName);
    }

    /**
     * Updates the last name of particular employee details
     */
    public void updateLastName(int id, String lastName) {

        dao.updateLastName(id, lastName);
    }

    /**
     * Updates the mobile number of particular employee details
     */
    public void updateMobileNumber(int id, String mobileNumber) {

        dao.updateMobileNumber(id, mobileNumber);
    }

    /**
     * Updates the salary of particular employee details
     */
    public void updateSalary(int id, String salary) {

        dao.updateSalary(id, salary);
    }  

    /**
     * Updates the mail id of particular employee details
     */
    public void updateMailId(int id, String mailId) {

        dao.updateMailId(id, mailId);
    } 

    /**
     * Updates the date of birth of particular employee details
     */
    public void updateDateOfBirth(int id, LocalDate dateOfBirth) {

        dao.updateDateOfBirth(id, dateOfBirth);
    } 

    /**
     * Deletes the particular employee details
     */
    public void deleteParticularEmployee(int id) {

        dao.deleteParticularEmployee(id); 
    } 

    public boolean validateAddressType(String addressType) {

        return Pattern.matches("[A-z]{3,20}", addressType);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateFirstLine(String firstLine) {
		
        return Pattern.matches("[A-z0-9.,]{3,20}", firstLine);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateSecondLine(String secondLine) {
		
        return Pattern.matches("[A-z0-9.,]{3,20}", secondLine);
    }  

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */	
    public boolean validateCity(String city) {
		
	    return Pattern.matches("[A-z]{3,20}", city);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateDistrict(String district) {
		
	    return Pattern.matches("[A-z]{3,20}", district);
    }

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validateState(String state) {
		
	    return Pattern.matches("[A-z]{3,20}", state);
    } 

    /**
     * Checks the validation with the given input
     *@ return boolean value
     */
    public boolean validatePinCode(String pinCode) {
		
	    return Pattern.matches("[0-9]{1,6}", pinCode);
    } 

    public void updateCurrentAddress(int id, String addressType,
            String firstLine, String secondLine, String city, 
            String district, String state, String pinCode) {
    
        dao.updateCurrentAddress(id, addressType, firstLine, secondLine, city, 
                district, state, pinCode);
    }

    public void updatePermanentAddress(int id, String addressType, 
            String firstLine, String secondLine, String city, 
            String district, String state, String pinCode) {
    
        dao.updateCurrentAddress(id, addressType, firstLine, secondLine, city, 
                district, state, pinCode);
    }

    public void deleteCurrentAddress(int id, String addressType) {
    
        dao.deleteCurrentAddress(id, addressType);
    }

    public void deletePermanentAddress(int id, String addressType) {

        dao.deletePermanentAddress(id, addressType);
    }

    public int setEmployee(Employee employee) {

        return dao.setEmployee(employee);
    }
}


