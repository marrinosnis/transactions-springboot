package com.example.transactionsproject.api;

import com.example.transactionsproject.controller.TransactionRequest;
import com.example.transactionsproject.dto.TransactionDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transactions/")
public interface TransactionApi {

    @PostMapping("/transfer-money")
    void transferMoneyFromAccount(@Valid @RequestBody TransactionDto transactionDto);
}
