package com.example.transactionsproject.exceptions;

public enum EnumErrorCodes {
    GENERIC_ERROR(0, "Oops! Something went wrong..."),
    ACCOUNT_NOT_FOUND(10, "Account not found"),
    NOT_ENOUGH_BALANCE_ERROR(20, "The balance was not enough to debit the amount of money."),
    TRANSFER_MONEY_BETWEEN_THE_SAME_ACCOUNT(30, "The transaction must be made between different accounts");

    private final int code;
    private final String message;

    EnumErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
