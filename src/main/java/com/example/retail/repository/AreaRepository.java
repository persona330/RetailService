package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends BaseRepository <Area, Integer>
{
    List<Area> findAll();
    Area getById(Integer id);
    void delete(Area area);
    Area getOne(Integer id);
}
