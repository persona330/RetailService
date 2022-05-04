package com.example.retail.repository;

import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.ConsignmentNote;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsignmentNoteRepository extends BaseRepository <ConsignmentNote, Integer>
{
    List<ConsignmentNote> findAll();
    ConsignmentNote getById(Integer id);
    void delete(ConsignmentNote consignmentNote);
    ConsignmentNote getOne(Integer id);
}
