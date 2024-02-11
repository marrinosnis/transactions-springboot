package groovy.accounts
import com.example.transactionsproject.dto.AccountDto
import com.example.transactionsproject.mappers.AccountMapper
import com.example.transactionsproject.model.AccountEntity
import com.example.transactionsproject.repository.AccountsRepository
import com.example.transactionsproject.service.AccountsService
import org.modelmapper.ModelMapper
import spock.lang.Specification

import java.sql.Timestamp

class AccountServiceSpec extends Specification {

    AccountsRepository accountsRepository
    AccountMapper accountMapper
    AccountsService accountsService
    ModelMapper modelMapper = new ModelMapper()

    def setup() {
        accountsRepository = Mock(AccountsRepository)
        accountMapper = Mock(AccountMapper)
        accountsService = new AccountsService(accountsRepository, accountMapper)
    }

    def "getAccountById returns when the ID exists"() { //not quite right
        given:
            Timestamp timestamp = Timestamp.valueOf("2023-12-11 22:00:49.362307")
            AccountEntity accountEntity = new AccountEntity(2, 'Leva', 5000, timestamp)
        when:
            def response = accountsService.getAccountById(2)

        then:
            1 * accountsRepository.findById(2).map(accountMapper.convertAccountEntityToDto(accountEntity)) >> new AccountDto()
            response.class == AccountDto
    }

    def "checkIfAccountExists calls accountsRepository"() {
        when: "The accounts are not the same"
           def response = accountsService.checkIfAccountsExists(1, 3)

        then:
            1 * accountsRepository.existsById(1) >> true
            1 * accountsRepository.existsById(3) >> true
            response
            0 * accountsRepository.existsById(_)
    }

    def "createAccount calls accountMapper and accountsRepository"() {
        given:
            Timestamp timestamp =  Timestamp.valueOf("2023-12-11 22:00:49.362307")
            AccountDto accountDto = new AccountDto()

        when:
            accountsService.createAccount(accountDto)

        then:
            1 * accountMapper.convertDtoToAccountEntity(accountDto) >> new AccountEntity(1, 'euro', 2000, timestamp)
            1 * accountsRepository.save( _ as AccountEntity)
            0 * _
    }

    def "saveTransactionToAccounts calls accountsRepository"() {
        given:
            AccountDto fromAccount = new AccountDto()
            AccountDto toAccount = new AccountDto()
            Timestamp timestamp1 =  Timestamp.valueOf("2023-12-11 22:00:49.362307")
            Timestamp timestamp2 =  Timestamp.valueOf("2023-12-11 22:00:49.362307")

        when:
            accountsService.saveTransactionToAccounts(fromAccount, toAccount)

        then:
            1 * accountMapper.convertDtoToAccountEntity(fromAccount) >> new AccountEntity(1, 'dollar', 2000, timestamp1)
            1 * accountMapper.convertDtoToAccountEntity(toAccount) >> new AccountEntity(2, 'yen', 1000, timestamp2)

        and:
            2 * accountsRepository.save( _ as AccountEntity)
            0 * _
    }
}
