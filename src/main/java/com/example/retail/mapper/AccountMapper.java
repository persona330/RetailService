package com.example.retail.mapper;

import com.example.retail.model.dto.AccountDTO;
import com.example.retail.model.dto.ProductDTO;
import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface AccountMapper
{
    @Mapping(target = "person", source = "personDTO")
    Account toEntity(AccountDTO dto);
    @Mapping(target = "personDTO", source = "person")
    AccountDTO toDTO(Account entity);
    List<AccountDTO> listToDTO(List<Account> entityList);
}
