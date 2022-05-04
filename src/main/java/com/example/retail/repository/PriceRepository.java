package com.example.retail.repository;

import com.example.retail.model.entity.Import;
import com.example.retail.model.entity.Price;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends BaseRepository <Price, Integer>
{
    List<Price> findAll();
    Price getById(Integer id);
    void delete(Price price);
    Price getOne(Integer id);
}
