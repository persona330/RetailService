package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Producer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository extends BaseRepository <Producer, Integer>
{
    List<Producer> findAll();
    Producer getById(Integer id);
    void delete(Producer producer);
    Producer getOne(Integer id);
}
