package com.ideas2it.employeemanagement.controller;

import java.time.LocalDate;
import java.util.List;

import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.service.impl.EmployeeService;
import com.ideas2it.employeemanagement.service.EmployeeImplService;

/**
 * Transfers the information between view and service 
 *
 * @version  1.0.0
 * @author   Suganya J
 * 
 */
public class EmployeeController {
 
    private EmployeeImplService service = new EmployeeService();

    /**
     * Passes the option  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean isValidOption(String option) {

        return service.isValidOption(option);   
    }

    /**
     * Passes the id  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateId(int id) {

        return service.validateId(id);   
    } 

    /**
     * Passes the firstname  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateFirstName(String firstName) {
    
        return service.validateFirstName(firstName);  
    } 
   
    /**
     * Passes the lastname  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateLastName(String lastName) {
    
        return service.validateLastName(lastName);  
    } 
  
    /**
     * Passes the salary  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateSalary(String salary) {
  
        return service.validateSalary(salary);  
    }

    /**
     * Passes the mobilenumber  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateMobileNumber(String mobileNumber) {
    
        return service.validateMobileNumber(mobileNumber);  
    }

    /**
     * Passes the mailid  from view to service for validation 
     *
     * @return boolean
     */
    public boolean validateMailId(String mailId) {
    
        return service.validateMailId(mailId);  
    }

    /**
     * Passes the date  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateDateOfBirth(String date) {
    
        return service.validateDateOfBirth(date);  
    }  

    /**
     * Transfers the information from view to service for displays the
     * all employee details 
     * @return boolean
     */
    public List<Employee> viewAllEmployee() {

        return service.viewAllEmployee();
    } 

    /**
     * Passes the id and first name  from view to service for updating  
     *
     * @return boolean
     */
    public void updateFirstName(int id, String firstName) {

        service.updateFirstName(id, firstName);
    } 

    /**
     * Passes the id and last name from view to service for updating 
     *
     * @return boolean
     */
    public void updateLastName(int id, String lastName) {

        service.updateLastName(id, lastName);
    }

    /**
     * Passes the id and mobile number from view to service for updating 
     *
     * @return boolean
     */
    public void updateMobileNumber(int id, String mobileNumber) {

        service.updateMobileNumber(id, mobileNumber);
    } 

    /**
     * Passes the id and salary from view to service for updating  
     *
     * @return boolean
     */
    public void updateSalary(int id, String salary) {

        service.updateSalary(id, salary);
    } 

    /**
     * Passes the id and mail id from view to service for updating  
     *
     * @return boolean
     */
    public void updateMailId(int id, String mailId) {

        service.updateMailId(id, mailId);
    } 

    /**
     * Passes the id and date of birth from view to service for updating  
     *
     * @return boolean
     */
    public void updateDateOfBirth(int id, LocalDate dateOfBirth) {

        service.updateDateOfBirth(id, dateOfBirth);
    }

    /**
     * Passes the id from view to service for deleting the   
     * particular employee
     * @return boolean
     */
    public void deleteParticularEmployee(int id) {

       service.deleteParticularEmployee(id);
    }

    /**
     * Passes the addresstype from view to service for address the   
     * particular employee
     * @return boolean
     */
    public boolean validateAddressType(String addressType) {

        return service.validateAddressType(addressType);
    }

    /**
     * Passes the firstline  from view to service for validation  
     *
     * @return boolean
     */
    public boolean validateFirstLine(String firstLine) {
        
        return service.validateFirstLine(firstLine);
    }

    /**
     * Passes the second line from view to service for validation  
     *
     * @return boolean
     */
    public boolean validateSecondLine(String secondLine) {
        
        return service.validateSecondLine(secondLine);
    } 

    /**
     * Passes the city from view to service for validation  
     *
     * @return boolean
     */
    public boolean validateCity(String city) {
        
        return service.validateCity(city);
    }

    /**
     * Passes the district from view to service for validation  
     *
     * @return boolean
     */
    public boolean validateDistrict(String district) {
        
    return service.validateDistrict(district);
    }   

    /**
     * Passes the state from view to service for validation  
     *
     * @return boolean
     */ 
    public boolean validateState(String state) {
        
        return service.validateState(state);
    }
  
    /*
     * Passes the pincode from view to service for validation 
     *
     * @return boolean
     */
    public boolean validatePinCode(String pinCode) {
        
        return service.validatePinCode(pinCode);
    }  
    
    /**
     * Passes the variables from view to service for update current address  
     */
    public void updateCurrentAddress(List<Address> addressDetails, int id) {
    
        service.updateCurrentAddress(addressDetails,id);
    }

    /**
     * Passes the variables from view to service for update permanent address  
     */
    public void updatePermanentAddress(List<Address> addressDetails, int id) {
    
        service.updatePermanentAddress(addressDetails,id);
    }

    /**
     * Passes the id from view to service for deleting the current address  
     */
    public void deleteCurrentAddress(int id, String addressType) {
    
        service.deleteCurrentAddress(id, addressType);
    }

    /**
     * Passes the id from view to service for deleting the permanent address  
     */
    public void deletePermanentAddress(int id, String addressType) {
    
        service.deletePermanentAddress(id, addressType);
    }

    /**
     * Passes the all employee details from view to service  
     */
    public void setEmployee(Employee employee) {

         service.setEmployee(employee);
    }

    /**
     * Passes the particular employee details from view to service  
     */
    public Employee viewParticularEmployee(int id) {

        return service.viewParticularEmployee(id);
    }

}            
       