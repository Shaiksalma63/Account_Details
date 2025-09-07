package com.jsp.SpringBootJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.SpringBootJPA.Model.Accounts;
import com.jsp.SpringBootJPA.Repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
private AccountRepository accountrepo;
	
public Accounts addaccount(Accounts account) {
	return accountrepo.save(account);
}

public List<Accounts> addaccounts(List<Accounts>accounts){
	 return accountrepo.saveAll(accounts);
	
}
public List<Accounts>findall(){
	 return accountrepo.findAll();
}
public Optional<Accounts> findbyid(long accountNo) {
	 return accountrepo.findById(accountNo);
}
}
