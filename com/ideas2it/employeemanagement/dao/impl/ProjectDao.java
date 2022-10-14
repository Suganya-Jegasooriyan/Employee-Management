package com.ideas2it.employeemanagement.dao.impl;

import java.time.LocalDate;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeemanagement.connection.DatabaseConnection;
import com.ideas2it.employeemanagement.model.EmployeeProject;
import com.ideas2it.employeemanagement.dao.ProjectImplDao;

public class ProjectDao implements ProjectImplDao {
    
	public void setAllProject(EmployeeProject project) {

        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           session.saveOrUpdate(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public EmployeeProject viewParticularProject(int projectId) {
    
        EmployeeProject project = null;
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           project = session.get(EmployeeProject.class, projectId); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
        return project;  
    }

    public List<EmployeeProject> viewAllProject() {
    
        List<EmployeeProject> allProject = new ArrayList<>();
        EmployeeProject project = null;
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           allProject = session.createQuery("from EmployeeProject").list();
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
        return allProject;  
    }

    public void	updateCustomerId(int projectId, int customerId) {
    
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           EmployeeProject project = (EmployeeProject)session.get(EmployeeProject.class, projectId);
           project.setCustomerId(customerId);
           session.update(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
       }
    }

    public void	updateCustomerMailId(int projectId, String customerMailId) {
    
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           EmployeeProject project = (EmployeeProject)session.get(EmployeeProject.class, projectId);
           project.setCustomerMailId(customerMailId);
           session.update(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
       }
    }

    public void	updateProjectName(int projectId, String projectName) {
    
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           EmployeeProject project = (EmployeeProject)session.get(EmployeeProject.class, projectId);
           project.setProjectName(projectName);
           session.update(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
       }
    }

    public void	updateDateOfStart(int projectId, LocalDate dateOfStart) {
    
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           EmployeeProject project = (EmployeeProject)session.get(EmployeeProject.class, projectId);
           project.setDateOfStart(dateOfStart);
           session.update(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
       }
    }

    public void	updateDateOfEnd(int projectId, LocalDate dateOfEnd) {
    
        Session session;

        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           EmployeeProject project = (EmployeeProject)session.get(EmployeeProject.class, projectId);
           project.setDateOfEnd(dateOfEnd);
           session.update(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
       }
    }

    public void deleteParticularProject(int projectId) {

        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           EmployeeProject project = (EmployeeProject)session.get(EmployeeProject.class, projectId);
           session.delete(project); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }
}