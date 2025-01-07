package com.banking.accounnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.accounnt.entity.Account;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByCustomerId(Integer customerId);
}
