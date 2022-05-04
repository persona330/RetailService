package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Stillage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StillageRepository extends BaseRepository <Stillage, Integer>
{
    List<Stillage> findAll();
    Stillage getById(Integer id);
    void delete(Stillage stillage);
    Stillage getOne(Integer id);
}
