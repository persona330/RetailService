package com.example.retail.service;

import com.example.retail.mapper.AccountMapper;
import com.example.retail.mapper.BoxMapper;
import com.example.retail.model.dto.AccountDTO;
import com.example.retail.model.dto.BoxDTO;
import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Box;
import com.example.retail.repository.AccountRepository;
import com.example.retail.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper)
    {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO create(AccountDTO accountDTO)
    {
        return accountMapper.toDTO(accountRepository.save(accountMapper.toEntity(accountDTO)));
    }

    @Override
    public List<AccountDTO> readAll()
    {
        List<Account> accountList = accountRepository.findAll();
        return accountMapper.listToDTO(accountList);
    }

    @Override
    public AccountDTO read(Integer id)
    {
        Account account = accountRepository.getById(id);
        return accountMapper.toDTO(account);
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO, Integer id)
    {
        Account account = accountRepository.getById(id);
        Account accounttoEntity = accountMapper.toEntity(accountDTO);

        if (account != null)
        {
            if (accounttoEntity.getId_Account() == null) accounttoEntity.setId_Account(account.getId_Account());

            if (accounttoEntity.getPassword() == null) accounttoEntity.setPassword(account.getPassword());

            if (accounttoEntity.getLogin() == null) accounttoEntity.setLogin(account.getLogin());

            if (accounttoEntity.getPerson() == null) accounttoEntity.setPerson(account.getPerson());

            return accountMapper.toDTO(accountRepository.save(accounttoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Account account = accountRepository.getOne(id);
        if (account != null)
        {
            accountRepository.delete(account);
            return true;
        }
        else return false;
    }
}
