package com.example.transactionsproject.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
class ApplicationExceptionAdvice extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(value = AccountNotExistException.class)

    public ResponseEntity<Object> accountNotExist(AccountNotExistException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(EnumErrorCodes.ACCOUNT_NOT_FOUND.getCode(), EnumErrorCodes.ACCOUNT_NOT_FOUND.getMessage());
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(value = TransactionErrorException.class)
    public ResponseEntity<Object> notEnoughBalance(TransactionErrorException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(EnumErrorCodes.NOT_ENOUGH_BALANCE_ERROR.getCode(), EnumErrorCodes.NOT_ENOUGH_BALANCE_ERROR.getMessage());
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(value = TransferMoneyBetweenSameAccounts.class)
    public ResponseEntity<Object> transferMoneyBetweenSameAccount(TransferMoneyBetweenSameAccounts ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(EnumErrorCodes.TRANSFER_MONEY_BETWEEN_THE_SAME_ACCOUNT.getCode(), EnumErrorCodes.TRANSFER_MONEY_BETWEEN_THE_SAME_ACCOUNT.getMessage());
        return  handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}