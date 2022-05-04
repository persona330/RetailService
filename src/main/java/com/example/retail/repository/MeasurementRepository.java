package com.example.retail.repository;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Measurement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends BaseRepository <Measurement, Integer>
{
    List<Measurement> findAll();
    Measurement getById(Integer id);
    void delete(Measurement measurement);
    Measurement getOne(Integer id);
}
