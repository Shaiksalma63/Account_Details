package com.jsp.SpringBootJPA.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SpringBootJPA.Exception.AccountisNotfound;
import com.jsp.SpringBootJPA.Exception.ErrorResponse;
import com.jsp.SpringBootJPA.Model.Accounts;
import com.jsp.SpringBootJPA.Service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountservice;
	
	@PostMapping("/saved")
	public ResponseEntity<Accounts> saveaccount(@RequestBody Accounts account) {
		
		Accounts addaccount = accountservice.addaccount(account);
		return new ResponseEntity<Accounts>(addaccount,HttpStatus.CREATED);
	
	}
@PostMapping("/saveAll")
public ResponseEntity<List<Accounts>>saveall(@RequestBody List<Accounts>accounts){
	List<Accounts> addaccounts = accountservice.addaccounts(accounts);
	return new ResponseEntity<List<Accounts>>(addaccounts,HttpStatus.CREATED);
}
@GetMapping("/findall")
public ResponseEntity<List<Accounts>>findall(){
	List<Accounts> findall = accountservice.findall();
	return new ResponseEntity<List<Accounts>>(findall,HttpStatus.OK);
}
@GetMapping("findbyid/{accountNo}")
public ResponseEntity<Accounts>findbyid(@PathVariable long accountNo){
	//try {
	Accounts findbyid = accountservice.findbyid(accountNo).orElseThrow(()->new AccountisNotfound("account id is not found with id:"+accountNo));
	return  ResponseEntity.ok(findbyid);
//}
//	catch(AccountisNotfound e) {
//		 ErrorResponse isNotfound=new ErrorResponse(LocalDateTime.now(), e.getMessage(), "id is not found with account");
//		 return new ResponseEntity(isNotfound,HttpStatus.NOT_FOUND);
//	}
}
//@ExceptionHandler(AccountisNotfound.class)
//public ResponseEntity<String> handleaccountisnotfound(AccountisNotfound exception){
//	ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "accountNo is not found");
//	return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
//}
 
}