package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Position;

import java.util.List;

public interface PositionRepository extends BaseRepository <Position, Integer>
{
    List<Position> findAll();
    Position getById(Integer id);
    void delete(Position position);
    Position getOne(Integer id);
}
