package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Courier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierRepository extends BaseRepository <Courier, Integer>
{
    List<Courier> findAll();
    Courier getById(Integer id);
    void delete(Courier courier);
    Courier getOne(Integer id);
}
