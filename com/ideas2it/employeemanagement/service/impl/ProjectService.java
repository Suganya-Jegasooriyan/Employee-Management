package com.ideas2it.employeemanagement.service.impl;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.model.EmployeeProject;
import com.ideas2it.employeemanagement.dao.ProjectImplDao;
import com.ideas2it.employeemanagement.dao.impl.ProjectDao;
import com.ideas2it.employeemanagement.service.ProjectImplService;

/** The given input with validation and logics are present
 *
 * @version 1.0.0
 */
public class ProjectService implements ProjectImplService {

    ProjectImplDao dao = new ProjectDao();
 
    public boolean isValidOption(String option) {

        return Pattern.matches("[1234567]{1}", option);
    }

    public boolean validateProjectId(int projectId) {

        return Pattern.matches("[0-9]{0,2}", Integer.toString(projectId));
    }

    public boolean validateCustomerId(int customerId) {

        return Pattern.matches("[0-9]{2}", Integer.toString(customerId));
    }

    public boolean validateCustomerMailId(String customerMailId) {

        return Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9.]{5,30}+[@]"
                                + "[a-z0-9]{5,15}+[.][a-z]{1,3}$", customerMailId); 
    } 

    public boolean validateProjectName(String projectName) {

        return Pattern.matches("[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$", projectName);
    }

    public boolean validateDateOfStart(String date) {
     
        boolean isValid = true;
        LocalDate dateOfBirth = null;

        try {   
            dateOfBirth = LocalDate.parse(date);
        } catch(DateTimeParseException dateTimeParseException) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateDateOfEnd(String date) {
     
        boolean isValid = true;
        LocalDate dateOfBirth = null;

        try {   
            dateOfBirth = LocalDate.parse(date);
        } catch(DateTimeParseException dateTimeParseException) {
            isValid = false;
        }
        return isValid;
    }

    public void setAllProject(EmployeeProject project) {

         dao.setAllProject(project);
    }

    public EmployeeProject viewParticularProject(int projectId) {

        EmployeeProject project = dao.viewParticularProject(projectId);
        return project;
    }

    public List viewAllProject() {

        List<EmployeeProject> list = new ArrayList<>(); 
        list = dao.viewAllProject();
        return list; 
    }

    public void updateCustomerId(int projectId, int customerId) {

        dao.updateCustomerId(projectId, customerId);
    }

    public void updateCustomerMailId(int projectId, String customerMailId) {

        dao.updateCustomerMailId(projectId, customerMailId);
    } 


    public void updateProjectName(int projectId, String projectName) {

        dao.updateProjectName(projectId, projectName);
    }

    public void updateDateOfStart(int projectId, LocalDate dateOfStart) {

        dao.updateDateOfStart(projectId, dateOfStart);
    } 

    public void updateDateOfEnd(int projectId, LocalDate dateOfEnd) {

        dao.updateDateOfEnd(projectId, dateOfEnd);
    } 

    public void deleteParticularProject(int projectId) {

        dao.deleteParticularProject(projectId); 
    }
}    
