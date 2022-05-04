package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Box;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxRepository extends BaseRepository <Box, Integer>
{
    List<Box> findAll();
    Box getById(Integer id);
    void delete(Box box);
    Box getOne(Integer id);
}
