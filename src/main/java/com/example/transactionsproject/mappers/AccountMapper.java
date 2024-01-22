package com.example.transactionsproject.mappers;

import com.example.transactionsproject.dto.AccountDto;
import com.example.transactionsproject.model.AccountEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    private final ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AccountDto convertAccountEntityToDto(AccountEntity accountEntity) {
        return modelMapper.map(accountEntity, AccountDto.class);
    }

    public AccountEntity convertDtoToAccountEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, AccountEntity.class);
    }
}
