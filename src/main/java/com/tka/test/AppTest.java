package com.tka.test;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tka.pojo.Account;
import com.tka.pojo.Employee;
import com.tka.util.HibernateUtil;

public class AppTest {
	
	//private static final Logger log = LogManager.getLogger(AppTest.class);
	
	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getMysqlConnection().openSession()){
			
			Transaction tx = session.beginTransaction();
			
			Account acc1 = new Account();
			acc1.setAccId("S_1234");
			acc1.setAccNo("1111");
			
			Account acc2 = new Account();
			acc2.setAccId("P_1234");
			acc2.setAccNo("7777");
			
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(acc1);
			accounts.add(acc2);
			
			Employee employee = new Employee();
			employee.setEmpName("Swapnil");
		    employee.setAccounts(accounts);
		    
		    session.save(employee);
			
			tx.commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			
			System.out.println("Erroe while insertion");
			e.printStackTrace();
		}
	}

}
