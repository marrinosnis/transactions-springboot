package transactions

import com.example.transactionsproject.api.TransactionApi
import com.example.transactionsproject.controller.TransactionRequest
import com.example.transactionsproject.controller.TransactionsControllerImpl
import com.example.transactionsproject.dto.TransactionDto
import com.example.transactionsproject.service.TransactionsService
import spock.lang.Specification

class TransactionControllerSpec extends Specification {

    TransactionsService transactionsService
    TransactionApi transactionApi

    def setup() {
        transactionsService = Mock(TransactionsService)
        transactionApi = new TransactionsControllerImpl(transactionsService)
    }

    def "transferMoneyFromAccount calls transferMoneyBetweenAccounts"() {
        given:
            TransactionRequest transactionRequest = new TransactionRequest()

        when:
            transactionApi.transferMoneyFromAccount(transactionRequest)

        then:
            1 * transactionsService.transferMoneyBetweenAccounts(transactionRequest)
            0 * _
    }
}
