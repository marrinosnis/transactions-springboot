package com.example.transactionsproject.dto;

import com.example.transactionsproject.customValidator.ValidName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountDto {
    @Valid
    @NotNull(message = "the id cannot be blank")
    private Integer id;
    @ValidName
    private String name;
    @NotBlank(message = "you should add the type of the currency")
    private String currency; //Currency
    @NotNull(message = "you should add the balance, or 0.0")
    private BigDecimal balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
