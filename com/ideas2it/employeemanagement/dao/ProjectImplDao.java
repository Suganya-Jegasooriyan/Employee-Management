package com.ideas2it.employeemanagement.dao;

import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeemanagement.connection.DatabaseConnection;
import com.ideas2it.employeemanagement.model.EmployeeProject;

public interface ProjectImplDao {
    
	public void setAllProject(EmployeeProject project);

    public EmployeeProject viewParticularProject(int projectId);

    public List<EmployeeProject> viewAllProject();

    public void updateCustomerId(int projectId, int customerId);

    public void updateCustomerMailId(int projectId, String customerMailId);

    public void updateProjectName(int projectId, String projectName);

    public void updateDateOfStart(int projectId, LocalDate dateOfStart);

    public void updateDateOfEnd(int projectId, LocalDate dateOfEnd);

    public void deleteParticularProject(int projectId);
}