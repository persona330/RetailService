package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends BaseRepository <Supplier, Integer>
{
    List<Supplier> findAll();
    Supplier getById(Integer id);
    void delete(Supplier supplier);
    Supplier getOne(Integer id);
}
