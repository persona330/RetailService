package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Ordered;

import java.util.List;

public interface OrderedRepository extends BaseRepository <Ordered, Integer>
{
    List<Ordered> findAll();
    Ordered getById(Integer id);
    void delete(Ordered ordered);
    Ordered getOne(Integer id);
}
