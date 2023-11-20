package com.example.transactionsproject.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "accounts")
public class TransactionsDatabaseTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String currency;

    @Column
    private Double balance;

    @Column
    private Date created_at;

    public TransactionsDatabaseTable(){}

    public TransactionsDatabaseTable(Integer id, String currency, Double balance, Date created_at){
        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
