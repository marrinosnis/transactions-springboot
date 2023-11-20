package com.example.transactionsproject.controller;

import com.example.transactionsproject.model.TransactionsDatabaseTable;
import com.example.transactionsproject.repository.TransactionsRepository;
import com.example.transactionsproject.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionsController {

    @Autowired
    private final TransactionsRepository transactionsRepository;

    @Autowired
    private final TransactionsService transactionsService;

    public TransactionsController(TransactionsRepository transactionsRepository, TransactionsService transactionsService) {
        this.transactionsRepository = transactionsRepository;
        this.transactionsService = transactionsService;
    }

    @GetMapping("/account/{id}")
    public TransactionsDatabaseTable getSpecificAccountById(@PathVariable Integer id) {
        return transactionsService.getAccountById(id);
    }

    @PostMapping("/create-account")
    public TransactionsDatabaseTable createAccount(@RequestBody TransactionsDatabaseTable insertToDatabase){
        return this.transactionsRepository.save(insertToDatabase);
    }

    @PostMapping("/transfer-money")
    public void transferMoneyFromAccount(@RequestBody TransactionRequest transactionRequest){
        transactionsService.transferMoneyBetweenAccounts(transactionRequest);
    }
}
