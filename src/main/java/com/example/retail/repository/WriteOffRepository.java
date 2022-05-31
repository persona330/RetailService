package com.example.retail.repository;

import com.example.retail.model.entity.VerticalSections;
import com.example.retail.model.entity.WriteOff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriteOffRepository  extends BaseRepository <WriteOff, Integer>
{
    List<WriteOff> findAll();
    WriteOff getById(Integer id);
    void delete(WriteOff writeOff);
    WriteOff getOne(Integer id);
}
