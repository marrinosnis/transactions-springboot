package com.example.transactionsproject.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions_details")
public class TransactionEntity {

    @Id
    private String transactionId;

    @Column
    private Integer fromAccountId;

    @Column
    private Integer toAccountId;

    @Column
    private BigDecimal amount;
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp timeOfTransaction;

    public TransactionEntity(){}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(Timestamp timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

}
