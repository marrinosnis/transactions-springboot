package com.example.transactionsproject.exceptions;

public class AccountNotExistException extends RuntimeException{
    public AccountNotExistException(Integer id) {
        super("The account with id:" + id + " doesn't exist");
    }
}
