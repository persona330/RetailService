package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends BaseRepository <Account, Integer>
{
    List<Account> findAll();
    Account getById(Integer id);
    void delete(Account account);
    Account getOne(Integer id);
}
