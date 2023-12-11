package com.example.transactionsproject.dto;

import java.sql.Date;

public class TransactionDto {

    private String transaction_id;
    private Integer from_account_id;
    private Integer to_account_id;
    private Double amount;
    private Date time_of_transaction;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(Integer from_account_id) {
        this.from_account_id = from_account_id;
    }

    public Integer getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(Integer to_account_id) {
        this.to_account_id = to_account_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTime_of_transaction() {
        return time_of_transaction;
    }

    public void setTime_of_transaction(Date time_of_transaction) {
        this.time_of_transaction = time_of_transaction;
    }
}
