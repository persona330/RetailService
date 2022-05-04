package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Store;
import com.example.retail.model.entity.Tariff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends BaseRepository <Store, Integer>
{
    List<Store> findAll();
    Store getById(Integer id);
    void delete(Store store);
    Store getOne(Integer id);
}
