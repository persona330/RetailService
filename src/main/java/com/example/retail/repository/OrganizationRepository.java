package com.example.retail.repository;

import com.example.retail.model.entity.Import;
import com.example.retail.model.entity.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends BaseRepository <Organization, Integer>
{
    List<Organization> findAll();
    Organization getById(Integer id);
    void delete(Organization organization);
    Organization getOne(Integer id);
}
