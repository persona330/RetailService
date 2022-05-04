package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Transport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends BaseRepository <Transport, Integer>
{
    List<Transport> findAll();
    Transport getById(Integer id);
    void delete(Transport transport);
    Transport getOne(Integer id);
}
