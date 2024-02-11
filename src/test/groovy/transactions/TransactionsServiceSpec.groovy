package groovy.transactions

import com.example.transactionsproject.controller.TransactionRequest
import com.example.transactionsproject.dto.AccountDto
import com.example.transactionsproject.model.TransactionEntity
import com.example.transactionsproject.repository.TransactionsRepository
import com.example.transactionsproject.service.AccountsService
import com.example.transactionsproject.service.TransactionsService
import spock.lang.Specification

import java.sql.Timestamp

class TransactionsServiceSpec extends Specification {

    TransactionsRepository transactionsRepository
    AccountsService accountsService
    TransactionsService transactionsService

    def setup(){
        transactionsRepository = Mock(TransactionsRepository)
        accountsService = Mock(AccountsService)
        transactionsService = new TransactionsService(transactionsRepository, accountsService)
    }

    def "transferMoneyBetweenAccounts calls accountService and checkBalanceAndTransfer"() {
        given:
            TransactionRequest transactionRequest = new TransactionRequest()
            transactionRequest.setFromAccount(1)
            transactionRequest.setAmount(100 as BigDecimal)
            transactionRequest.setToAccount(2)

            AccountDto fromAccount = new AccountDto()
            fromAccount.setId(1)
            fromAccount.setCurrency('euro')
            fromAccount.setBalance(1000 as BigDecimal)

            AccountDto toAccount = new AccountDto()
            toAccount.setId(2)
            toAccount.setCurrency('dollar')
            toAccount.setBalance(2000 as BigDecimal)


        when:
            transactionsService.transferMoneyBetweenAccounts(transactionRequest)

        then:
            1 * accountsService.getAccountById(transactionRequest.getFromAccountId()) >> fromAccount
            1 * accountsService.getAccountById(transactionRequest.getToAccountId()) >> toAccount
            1 * accountsService.checkIfAccountsExists(fromAccount.getId(), toAccount.getId())
    }

    def "saveTransactionDetails calls transactionsEntity and save the record"() {
        given:
            Integer fromAccount = 1
            Integer toAccount = 2
            BigDecimal amount = BigDecimal.valueOf(1000.0)

        when:
            transactionsService.saveTransactionDetails(fromAccount, toAccount, amount)

        then:
            1 * transactionsRepository.save(_ as TransactionEntity)

        and:
            1 * transactionsRepository.save({ TransactionEntity transaction ->
                transaction.fromAccountId == fromAccount
                transaction.toAccountId == toAccount
                transaction.amount == amount
            })
    }
}
