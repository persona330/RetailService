package com.example.retail.repository;

import com.example.retail.model.entity.Delivery;
import com.example.retail.model.entity.Measurement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends BaseRepository <Delivery, Integer>
{
    List<Delivery> findAll();
    Delivery getById(Integer id);
    void delete(Delivery delivery);
    Delivery getOne(Integer id);
}
