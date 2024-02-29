package com.tka.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tka.pojo.Account;
import com.tka.pojo.Employee;
import com.tka.util.HibernateUtil;

public class AppTest {
	
	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getMysqlConnection().openSession()){
			
			Transaction tx = session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setEmpId(101);
			employee.setEmpName("Swapnil");
			
			Account account = new Account();
			account.setAccId("SBI_1010");
			account.setAccNo("123456");
			
			employee.setAccount(account);
			
			session.save(account);
			session.save(employee);
			
			tx.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erroe while insertion");
			e.printStackTrace();
		}
	}

}
