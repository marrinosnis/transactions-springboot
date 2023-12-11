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
        accountsService = Mock(AccountsService)
        accountApi = new AccountControllerImpl(accountsService)

    }

    def "getSpecificAccountById calls accountService"() {
        when:
            def response = accountApi.getSpecificAccountById(2)

        then:
            1 * accountsService.getAccountById(2)  >> new AccountDto()
            response.class == AccountDto
            0 * _
    }
}
