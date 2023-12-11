package com.example.transactionsproject.controller;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.lang.Integer;

@Service
public class TransactionRequest {
    private Integer fromAccountId;

    private Integer toAccountId;

    private BigDecimal amount;

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccount(Integer fromAccount) {
        this.fromAccountId = fromAccount;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccountId = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
