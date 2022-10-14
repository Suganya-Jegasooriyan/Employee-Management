package com.ideas2it.employeemanagement.dao.impl;

import java.time.LocalDate;
import org.hibernate.HibernateException;
import org.hibernate.Query; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; 

import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.connection.DatabaseConnection;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.dao.EmployeeImplDao;

public class  EmployeeDao implements EmployeeImplDao {
    
    public void setEmployee(Employee employee) {

        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           session.saveOrUpdate(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
      }
    }

    public Employee viewParticularEmployee(int id) {
    
        Employee employee = null;
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           employee = session.get(Employee.class, id); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
        
        return employee;  
    }       
    
    public List<Employee> viewAllEmployee() {
    
        List<Employee> allEmployee = new ArrayList<>(); 
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           allEmployee = session.createQuery("from Employee").list();
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
        return allEmployee;  
    }    

    public void updateFirstName(int id, String firstName) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setFirstName(firstName);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
      }
    }
    
    public void updateLastName(int id, String lastName) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setLastName(lastName);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void updateMobileNumber(int id, String mobileNumber) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setMobileNumber(mobileNumber);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void updateSalary(int id, String salary) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setSalary(salary);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void updateMailId(int id, String mailId) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setMailId(mailId);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void updateDateOfBirth(int id, LocalDate dateOfBirth) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setDateOfBirth(dateOfBirth);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void updateCurrentAddress(List<Address> addressDetails, int id) {

        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setAddressDetails(addressDetails);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void updatePermanentAddress(List<Address> addressDetails, int id) {
    
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           employee.setAddressDetails(addressDetails);
           session.update(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }

    public void deleteParticularEmployee(int id) {

        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           session.delete(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }   
    }   

    public void deleteCurrentAddress(int id, String addressType) {
        
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           session.delete(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        } 
    }

    public void deletePermanentAddress(int id, String addressType) {
        
        Session session;
        try {
           session =  DatabaseConnection.getConnection();
           Transaction tx = session.beginTransaction();
           Employee employee = (Employee)session.get(Employee.class, id);
           session.delete(employee); 
           tx.commit();
        } catch (HibernateException exception) {

            exception.printStackTrace();
        }
    }
}