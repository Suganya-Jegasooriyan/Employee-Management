package com.ideas2it.employeemanagement.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * It presents employee details.
 * 
 * @version 1.0.2
 * @author  suganya J
 */
public class Employee {

    private List<Address> addressDetails;
    private List<EmployeeProject> projectDetails;

    private int age;
    private int id;
    private String firstName;
    private String fullName; 
    private String lastName;
    private String mailId;
    private String mobileNumber;
    private String salary;
    private LocalDate dateOfBirth; 

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    } 

    public void setMobileNumber(String mobileNumber) {

        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {

        return mobileNumber;
    }

    public void setSalary(String salary) { 
 
        this.salary = salary;
    }

    public String getSalary() {

        return salary;
    }

    public void setMailId(String mailId) {

        this.mailId = mailId;
    }
    
    public String getMailId() {

        return mailId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
  
        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) { 

        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public int getAge() {

        return age;
    } 

    public void setAddressDetails(List<Address> addressDetails) {
   
        this.addressDetails = addressDetails;
    }

    public List<Address> getAddressDetails() {
   
        return addressDetails;
    }

    public void setProjectDetails(List<EmployeeProject> projectDetails) {
   
        this.projectDetails = projectDetails;
    }

    public List<EmployeeProject> getProjectDetails() {
   
        return projectDetails;
    }

    public String toString() {

        return "Employee Id            : "+ id 
                + "\nEmployee Name          : " + firstName + "" + lastName 
                + "\nEmployee Salary        : " + salary
                + "\nEmployee Gmail         : " + mailId 
                + "\nEmployee Mobile Number : " + mobileNumber
                + "\nEmployee DateOfBirth   : " + dateOfBirth
                + "\nEmployee Age           : " + age
                + "\nEmployee Addresses     : " + addressDetails
                + "\n";
    }
}
