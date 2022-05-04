package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.StorageConditions;
import com.example.retail.model.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageConditionsRepository extends BaseRepository <StorageConditions, Integer>
{
    List<StorageConditions> findAll();
    StorageConditions getById(Integer id);
    void delete(StorageConditions storageConditions);
    StorageConditions getOne(Integer id);
}
