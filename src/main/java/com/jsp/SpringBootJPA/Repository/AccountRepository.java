package com.jsp.SpringBootJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringBootJPA.Model.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long>{

}
