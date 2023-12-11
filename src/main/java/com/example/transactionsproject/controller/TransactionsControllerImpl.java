package com.example.transactionsproject.controller;

import com.example.transactionsproject.api.TransactionApi;
import com.example.transactionsproject.service.TransactionsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionsControllerImpl implements TransactionApi {

    private final TransactionsService transactionsService;

    public TransactionsControllerImpl(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    public void transferMoneyFromAccount(@RequestBody TransactionRequest transactionRequest){
        transactionsService.transferMoneyBetweenAccounts(transactionRequest);
    }
}
