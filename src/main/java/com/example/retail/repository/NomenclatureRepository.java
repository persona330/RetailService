package com.example.retail.repository;

import com.example.retail.model.entity.Import;
import com.example.retail.model.entity.Nomenclature;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomenclatureRepository extends BaseRepository <Nomenclature, Integer>
{
    List<Nomenclature> findAll();
    Nomenclature getById(Integer id);
    void delete(Nomenclature nomenclature);
    Nomenclature getOne(Integer id);
}
