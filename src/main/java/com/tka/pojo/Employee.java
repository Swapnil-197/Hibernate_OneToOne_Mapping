package com.tka.pojo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "empId")})
public class Employee {
	
	@Id
	@Column(unique = false , nullable = false , length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@Column(unique = false , nullable = false , length = 10)
	private String empName;

	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "empId" )
	private Set<Account> accounts ;

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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
