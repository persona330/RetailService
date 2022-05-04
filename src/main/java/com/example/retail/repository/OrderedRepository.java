package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Ordered;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedRepository extends BaseRepository <Ordered, Integer>
{
    List<Ordered> findAll();
    Ordered getById(Integer id);
    void delete(Ordered ordered);
    Ordered getOne(Integer id);
}
