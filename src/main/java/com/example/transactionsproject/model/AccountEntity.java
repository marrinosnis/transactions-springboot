package com.example.transactionsproject.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Currency;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String currency;

    @Column
    private Double balance;

    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp createdAt;

    public AccountEntity(){}


    public AccountEntity(Integer id, String currency, Double balance, Timestamp createdAt) {
        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
