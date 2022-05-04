package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.CalculatedSign;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatedSignRepository extends BaseRepository <CalculatedSign, Integer>
{
    List<CalculatedSign> findAll();
    CalculatedSign getById(Integer id);
    void delete(CalculatedSign calculatedSign);
    CalculatedSign getOne(Integer id);
}
