package com.example.retail.repository;

import com.example.retail.model.entity.Group;
import com.example.retail.model.entity.Measurement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends BaseRepository <Group, Integer>
{
    List<Group> findAll();
    Group getById(Integer id);
    void delete(Group group);
    Group getOne(Integer id);
}
