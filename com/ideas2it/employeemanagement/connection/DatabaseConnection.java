package com.ideas2it.employeemanagement.connection;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection {
     
    private static SessionFactory sessionFactory;

    private DatabaseConnection(){
        try{
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException hibernateException){
            hibernateException.printStackTrace();
        }
    }
     
	public static Session getConnection() {
        Session session;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        session = sessionFactory.openSession();
        return session;
	}
}