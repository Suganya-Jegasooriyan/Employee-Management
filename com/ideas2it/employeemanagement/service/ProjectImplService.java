package com.ideas2it.employeemanagement.service;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.dao.ProjectImplDao;
import com.ideas2it.employeemanagement.model.EmployeeProject;
import com.ideas2it.employeemanagement.dao.impl.ProjectDao;

public interface ProjectImplService {

	public boolean isValidOption(String option);

	public boolean validateProjectId(int projectId);

	public boolean validateCustomerId(int customerId);

	public boolean validateProjectName(String projectName);

	public boolean validateCustomerMailId(String customerMailId);

	public boolean validateDateOfStart(String date);

	public boolean validateDateOfEnd(String date);

	public EmployeeProject viewParticularProject(int projectId);

	public List viewAllProject();

	public void updateCustomerId(int projectId, int customerId);

	public void updateCustomerMailId(int projectId, String customerMailId);

	public void updateProjectName(int projectId, String projectName);

	public void updateDateOfStart(int projectId, LocalDate dateOfStart);

	public void updateDateOfEnd(int projectId, LocalDate dateOfEnd); 

	public void deleteParticularProject(int projectId);

	public void setAllProject(EmployeeProject project);
}