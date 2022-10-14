package com.ideas2it.employeemanagement.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * It presents employee details.
 * 
 * @version	1.0.2
 * @author	suganya J
 */
public class EmployeeProject {

    private List<Employee> employeeDetails;

    private int projectId;
    private int customerId;
    private String projectName;
    private String customerMailId;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd; 

    public void setProjectId(int projectId) {

        this.projectId = projectId;
    }

    public int getProjectId() {

        return projectId;
    } 

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public int getCustomerId() {

        return customerId;
    } 

    public void setProjectName(String projectName) {

        this.projectName = projectName;
    }
    
    public String getProjectName() {

        return projectName;
    }

    public void setCustomerMailId(String customerMailId) {

        this.customerMailId = customerMailId;
    }
    
    public String getCustomerMailId() {

        return customerMailId;
    }

    public void setDateOfStart(LocalDate dateOfStart) {

        this.dateOfStart = dateOfStart;
    }

    public LocalDate getDateOfStart() {

        return dateOfStart;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {

        this.dateOfEnd = dateOfEnd;
    }

    public LocalDate getDateOfEnd() {

        return dateOfEnd;
    }

    public void setEmployeeDetails(List<Employee> employeeDetails) {
   
        this.employeeDetails = employeeDetails;
    }

    public List<Employee> getEmployeeDetails() {
   
        return employeeDetails;
    }

    public String toString() {

        return "Project Id             : "+ projectId 
                + "\nCustomer Id            : " + customerId
                + "\nCustomer Email         : " + customerMailId
		        + "\nProject Name           : " + projectName
                + "\nProject date_of_start  : " + dateOfStart
                + "\nProject date_of_end    : " + dateOfEnd
                + "\nEmployee Details       : " + employeeDetails
                + "\n";
    }
}
