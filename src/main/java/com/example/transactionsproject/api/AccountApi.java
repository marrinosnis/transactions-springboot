package com.example.transactionsproject.api;

import com.example.transactionsproject.dto.AccountDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/accounts/")
public interface AccountApi {
    @GetMapping("{id}")
    AccountDto getSpecificAccountById(@PathVariable Integer id);
    @PostMapping("/create")
    void createAccount(@RequestBody AccountDto accountDto);
}
