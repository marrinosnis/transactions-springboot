package com.example.transactionsproject.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionDto {

    private String transaction_id;
    @NotNull(message = "you should put the account from which the money will withdraw")
    private Integer from_account_id;
    @NotNull(message = "you should put the account where the money will be debited")
    private Integer to_account_id;
    @NotNull(message = "you should put the amount of money")
    private BigDecimal amount;
    private Date time_of_transaction;

    public String getTransactionId() {
        return transaction_id;
    }

    public void setTransactionIdd(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getFromAccountId() {
        return from_account_id;
    }

    public void setFromAccountId(Integer from_account_id) {
        this.from_account_id = from_account_id;
    }

    public Integer getToAccountId() {
        return to_account_id;
    }

    public void setToAccountId(Integer to_account_id) {
        this.to_account_id = to_account_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTimeOfTransaction() {
        return time_of_transaction;
    }

    public void setTimeOfTransaction(Date time_of_transaction) {
        this.time_of_transaction = time_of_transaction;
    }
}
