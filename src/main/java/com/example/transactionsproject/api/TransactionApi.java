package com.example.transactionsproject.api;

import com.example.transactionsproject.controller.TransactionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transactions/")
public interface TransactionApi {

    @PostMapping("/transfer-money")
    void transferMoneyFromAccount(@RequestBody TransactionRequest transactionRequest);
}
