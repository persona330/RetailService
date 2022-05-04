package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Tariff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository extends BaseRepository <Tariff, Integer>
{
    List<Tariff> findAll();
    Tariff getById(Integer id);
    void delete(Tariff tariff);
    Tariff getOne(Integer id);
}
