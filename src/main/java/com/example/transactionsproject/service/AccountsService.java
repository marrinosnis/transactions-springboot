package com.example.transactionsproject.service;

import com.example.transactionsproject.dto.AccountDto;
import com.example.transactionsproject.exceptions.AccountNotExistException;
import com.example.transactionsproject.mappers.AccountMapper;
import com.example.transactionsproject.model.AccountEntity;
import com.example.transactionsproject.repository.AccountsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    private final AccountsRepository accountsRepository;
    private final AccountMapper accountMapper;

    public AccountsService(AccountsRepository accountsRepository, AccountMapper accountMapper){
        this.accountsRepository = accountsRepository;
        this.accountMapper = accountMapper;
    }
    public AccountDto getAccountById(Integer id) {
        return accountsRepository.findById(id)
                .map(accountMapper::convertAccountEntityToDto)
                .orElseThrow(() -> new AccountNotExistException(id));
    }
    public boolean checkIfAccountsExists(Integer fromAccountId, Integer toAccountId){
        return accountsRepository.existsById(fromAccountId) && accountsRepository.existsById(toAccountId);
    }
    public void createAccount(AccountDto accountDto){
        AccountEntity account = accountMapper.convertDtoToAccountEntity(accountDto);
        accountsRepository.save(account);
    }

    public void saveTransactionToAccounts(AccountDto fromAccount, AccountDto toAccount){
        AccountEntity accountEntityFrom = accountMapper.convertDtoToAccountEntity(fromAccount);
        AccountEntity accountEntityTo = accountMapper.convertDtoToAccountEntity(toAccount);
        accountsRepository.save(accountEntityFrom);
        accountsRepository.save(accountEntityTo);
    }
}
