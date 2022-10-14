package com.ideas2it.employeemanagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeemanagement.model.EmployeeProject;
import com.ideas2it.employeemanagement.service.impl.ProjectService;
import com.ideas2it.employeemanagement.service.ProjectImplService;

/**
 * Transfers the information between view and service 
 *
 * @version  1.0.0
 * @author   Suganya J
 * 
 */
public class ProjectController {
 
    private ProjectImplService service = new ProjectService();

    /**
     * Passes the option  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean isValidOption(String option) {

        return service.isValidOption(option);   
    }

    /**
     * Passes the project id  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateProjectId(int projectId) {

        return service.validateProjectId(projectId);   
    } 

    /**
     * Passes the customerid  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateCustomerId(int customerId) {

        return service.validateCustomerId(customerId);   
    } 

    /**
     * Passes the mailid  from view to service for validation 
     *
     * @return boolean
     */
    public boolean validateCustomerMailId(String customerMailId) {
    
        return service.validateCustomerMailId(customerMailId);  
    }

    /**
     * Passes the project name  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateProjectName(String projectName) {
    
        return service.validateProjectName(projectName);  
    } 

    /**
     * Passes the date  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateDateOfStart(String date) {
    
        return service.validateDateOfStart(date);  
    } 

    /**
     * Passes the date  from view to service for validation 
     *
     * @return boolean value
     */
    public boolean validateDateOfEnd(String date) {
    
        return service.validateDateOfEnd(date);  
    }  

    /**
     * Passes the all project details from view to service  
     */
    public void setAllProject(EmployeeProject project) {

         service.setAllProject(project);
    }

    /**
     * Passes the particular employee details from view to service  
     */
    public EmployeeProject viewParticularProject(int projectId) {

        return service.viewParticularProject(projectId);
    }

    /**
     * Transfers the information from view to service for displays the
     * all employee details 
     * @return boolean
     */
    public List<EmployeeProject> viewAllProject() {

        return service.viewAllProject();
    } 

    /**
     * Passes the project id and customer id  from view to service for updating  
     *
     * @return boolean
     */
    public void updateCustomerId(int projectId, int customerId) {

        service.updateCustomerId(projectId, customerId);
    } 

    /**
     * Passes the id and customer mail id from view to service for updating  
     *
     * @return boolean
     */
    public void updateCustomerMailId(int projectId, String customerMailId) {

        service.updateCustomerMailId(projectId, customerMailId);
    } 

    /**
     * Passes the id and project name from view to service for updating 
     *
     * @return boolean
     */
    public void updateProjectName(int projectId, String projectName) {

        service.updateProjectName(projectId, projectName);
    }

    /**
     * Passes the id and date of start from view to service for updating  
     *
     * @return boolean
     */
    public void updateDateOfStart(int projectId, LocalDate dateOfStart) {

        service.updateDateOfStart(projectId, dateOfStart);
    }

    /**
     * Passes the id and date of start from view to service for updating  
     *
     * @return boolean
     */
    public void updateDateOfEnd(int projectId, LocalDate dateOfEnd) {

        service.updateDateOfEnd(projectId, dateOfEnd);
    }

    /**
     * Passes the id from view to service for deleting the   
     * particular employee
     * @return boolean
     */
    public void deleteParticularProject(int projectId) {

       service.deleteParticularProject(projectId);
    }
}
