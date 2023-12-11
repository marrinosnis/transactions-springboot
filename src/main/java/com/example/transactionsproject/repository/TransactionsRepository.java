package com.example.transactionsproject.repository;

import com.example.transactionsproject.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionEntity, Integer> {
}
//we need this in order the Jpa repository to work correctly. It can be stay empty and it will work fine
