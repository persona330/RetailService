package com.example.retail.repository;

import com.example.retail.model.entity.Group;
import com.example.retail.model.entity.Import;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportRepository extends BaseRepository <Import, Integer>
{
    List<Import> findAll();
    Import getById(Integer id);
    void delete(Import import_p);
    Import getOne(Integer id);
}
