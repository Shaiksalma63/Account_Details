package com.jsp.SpringBootJPA.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNo;
	private String accountholder;
	private String Branch;
	public Accounts(long accountNo, String accountholder, String branch) {
		super();
		this.accountNo = accountNo;
		this.accountholder = accountholder;
		Branch = branch;
	}
	
	public Accounts() {
		
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountholder() {
		return accountholder;
	}

	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}
}

	