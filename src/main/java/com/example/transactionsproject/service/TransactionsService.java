package com.example.transactionsproject.service;

import com.example.transactionsproject.controller.TransactionRequest;
import com.example.transactionsproject.exceptions.AccountNotExistException;
import com.example.transactionsproject.exceptions.TransactionErrorException;
import com.example.transactionsproject.model.TransactionsDatabaseTable;
import com.example.transactionsproject.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public TransactionsDatabaseTable getAccountById(Integer id) {
        return transactionsRepository.findById(id).orElseThrow(() -> new AccountNotExistException(id));
    }

    public void accountValidation(Integer fromId, Integer toId) {
        if (fromId.equals(toId)) {
            throw new TransactionErrorException("The accounts cannot be the same");
        }
    }

    public void checkBalanceAndTransfer(TransactionsDatabaseTable balanceFromAccount, TransactionsDatabaseTable balanceToAccount, Double amount) {
        if (balanceFromAccount.getBalance() >= amount) {
            balanceFromAccount.setBalance(balanceFromAccount.getBalance() - amount);
            balanceToAccount.setBalance(balanceToAccount.getBalance() + amount);

            transactionsRepository.save(balanceFromAccount);
            transactionsRepository.save(balanceToAccount);

        } else if (balanceFromAccount.getBalance() < amount) {
            throw new TransactionErrorException("The balance was not enough to debit the amount of money.");
        }

    }

    @Transactional
    public void transferMoneyBetweenAccounts(TransactionRequest transactionRequest) {
        TransactionsDatabaseTable fromAccount = getAccountById(transactionRequest.getFromAccount());
        TransactionsDatabaseTable toAccount = getAccountById(transactionRequest.getToAccount());

        accountValidation(fromAccount.getId(), toAccount.getId());

        checkBalanceAndTransfer(fromAccount, toAccount, transactionRequest.getAmount());
    }
}
