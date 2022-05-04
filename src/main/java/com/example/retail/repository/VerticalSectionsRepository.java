package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.VerticalSections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerticalSectionsRepository  extends BaseRepository <VerticalSections, Integer>
{
    List<VerticalSections> findAll();
    VerticalSections getById(Integer id);
    void delete(VerticalSections verticalSections);
    VerticalSections getOne(Integer id);
}
