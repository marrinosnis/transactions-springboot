package com.example.transactionsproject.mappers;

import com.example.transactionsproject.dto.TransactionDto;
import com.example.transactionsproject.model.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {
    private final ModelMapper modelMapper;

    public TransactionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TransactionDto convertTransactionEntityToDto(TransactionEntity transactionEntity) {
        return modelMapper.map(transactionEntity, TransactionDto.class);
    }

    public TransactionEntity convertDtoToTransactionEntity(TransactionDto transactionDto) {
        return modelMapper.map(transactionDto, TransactionEntity.class);
    }
}
