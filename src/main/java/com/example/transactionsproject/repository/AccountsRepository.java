package com.example.transactionsproject.repository;

import com.example.transactionsproject.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountEntity, Integer> {

}
