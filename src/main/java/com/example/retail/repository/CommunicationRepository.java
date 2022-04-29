package com.example.retail.repository;

import com.example.retail.model.entity.Communication;

import java.util.List;

public interface CommunicationRepository extends BaseRepository <Communication, Integer>
{
    List<Communication> findAll();
    Communication getById(Integer id);
    void delete(Communication communication);
    Communication getOne(Integer id);
}
