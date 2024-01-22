package com.example.transactionsproject.controller;

import com.example.transactionsproject.api.AccountApi;
import com.example.transactionsproject.dto.AccountDto;
import com.example.transactionsproject.service.AccountsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements AccountApi {

    private final AccountsService accountsService;
    public AccountControllerImpl(AccountsService accountsService) {
        this.accountsService = accountsService;
    }
    public AccountDto getSpecificAccountById(Integer id) {
        return accountsService.getAccountById(id);
    }
    public void createAccount(AccountDto accountDto) {
        accountsService.createAccount(accountDto);
    }
}
