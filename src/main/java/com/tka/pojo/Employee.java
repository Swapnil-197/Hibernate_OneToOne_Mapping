package com.tka.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	@Column(unique = false , nullable = false , length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@Column(unique = false , nullable = false , length = 10)
	private String empName;
	@OneToOne
	private Account account ;
	
	public Employee() {
		super();
		
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
