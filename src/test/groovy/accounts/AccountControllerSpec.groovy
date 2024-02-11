package groovy.accounts

import com.example.transactionsproject.api.AccountApi
import com.example.transactionsproject.controller.AccountControllerImpl
import com.example.transactionsproject.dto.AccountDto
import com.example.transactionsproject.service.AccountsService
import spock.lang.Specification

class AccountControllerSpec extends Specification {

    AccountsService accountsService
    AccountApi accountApi


    def setup() {
        accountsService = Mock()
        accountApi = new AccountControllerImpl(accountsService)
    }

    def "getSpecificAccountById calls accountService"() {
        when: "A GET request is happened to get a specific account"
            def response = accountApi.getSpecificAccountById(2)

        then: "the getAccountById function executed once and return an accountDto object"
            1 * accountsService.getAccountById(2)  >> new AccountDto()
            response.class == AccountDto
            0 * _
    }

    def "createAccount calls accountService"() {
        given:
            AccountDto accountDto = new AccountDto()

        when: "a POST request is happened to create an account"
            accountApi.createAccount(accountDto)

        then: "the createAccount function is executed once"
            1 * accountsService.createAccount(accountDto)
            0 * _
    }
}
