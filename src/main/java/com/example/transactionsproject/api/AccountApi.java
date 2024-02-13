package com.example.transactionsproject.api;

import com.example.transactionsproject.dto.AccountDto;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RequestMapping("/accounts/")
public interface AccountApi {
    @GetMapping("{id}")
    AccountDto getSpecificAccountById(@Valid @PathVariable Integer id);
    @PostMapping("/create")
    void createAccount(@Valid @RequestBody AccountDto accountDto);
}
