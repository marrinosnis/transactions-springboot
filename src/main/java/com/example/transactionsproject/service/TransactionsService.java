package com.example.transactionsproject.service;

import com.example.transactionsproject.controller.TransactionRequest;
import com.example.transactionsproject.dto.AccountDto;
import com.example.transactionsproject.dto.TransactionDto;
import com.example.transactionsproject.exceptions.AccountNotExistException;
import com.example.transactionsproject.exceptions.TransactionErrorException;
import com.example.transactionsproject.exceptions.TransferMoneyBetweenSameAccounts;
import com.example.transactionsproject.model.TransactionEntity;
import com.example.transactionsproject.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TransactionsService {
    private final AccountsService accountsService;
    private final TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository, AccountsService accountsService) {
        this.transactionsRepository = transactionsRepository;
        this.accountsService = accountsService;
    }
    public void saveTransactionDetails(Integer fromAccount, Integer toAccount, BigDecimal amount) {
        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setTransactionId(UUID.randomUUID().toString());
        transactionEntity.setFromAccountId(fromAccount);
        transactionEntity.setToAccountId(toAccount);
        transactionEntity.setAmount(amount);
        transactionsRepository.save(transactionEntity);
    }
    @Transactional
    public void transferMoneyBetweenAccounts(TransactionDto transactionDto) {
        AccountDto fromAccount = accountsService.getAccountById(transactionDto.getFromAccountId());
        AccountDto toAccount = accountsService.getAccountById(transactionDto.getToAccountId());
        accountsService.checkIfAccountsExists(fromAccount.getId(), toAccount.getId());
        if (transactionDto.getFromAccountId().equals(transactionDto.getToAccountId())) {
            throw new TransferMoneyBetweenSameAccounts();
        }
        checkBalanceAndTransfer(fromAccount, toAccount, transactionDto.getAmount());
    }

    private void checkBalanceAndTransfer(AccountDto balanceFromAccount, AccountDto balanceToAccount, BigDecimal amount) {
        if (balanceFromAccount.getBalance().compareTo(amount) >= 0) {
            balanceFromAccount.setBalance(balanceFromAccount.getBalance().subtract(amount));
            balanceToAccount.setBalance(balanceToAccount.getBalance().add(amount));
            accountsService.saveTransactionToAccounts(balanceFromAccount, balanceToAccount);

            saveTransactionDetails(balanceFromAccount.getId(), balanceToAccount.getId(), amount);

        } else if (balanceFromAccount.getBalance().compareTo(amount) < 0) {
            throw new TransactionErrorException("The balance was not enough to debit the amount of money.");
        }
    }
}
