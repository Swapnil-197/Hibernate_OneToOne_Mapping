package com.tka.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.tka.pojo.Account;
import com.tka.pojo.Employee;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getMysqlConnection() {
		
		if(sessionFactory == null) {
			
		try {	
			
		Configuration cfg =  new Configuration();
		
		Properties settings = new Properties();
		
		settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_04");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "root");
		settings.put(Environment.SHOW_SQL, "true");
		settings.put(Environment.HBM2DDL_AUTO, "update");
		
	    cfg.setProperties(settings);
	    
	    cfg.addAnnotatedClass(Employee.class);
	    cfg.addAnnotatedClass(Account.class);
	    
	    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	    		.applySettings(cfg.getProperties()).build();
	    
	    return cfg.buildSessionFactory(serviceRegistry);
	
		}catch(Exception e) {
			
			System.out.println("Connection failed");
			e.printStackTrace();			
		}
	}
		return null;
  }
}
