package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.OrganizationMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrganizationDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Organization;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService
{
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper)
    {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public OrganizationDTO create(OrganizationDTO organizationDTO)
    {
        return organizationMapper.toDTO(organizationRepository.save(organizationMapper.toEntity(organizationDTO)));
    }

    @Override
    public List<OrganizationDTO> readAll()
    {
        List<Organization> organizationList = organizationRepository.findAll();
        return organizationMapper.listToDTO(organizationList);
    }

    @Override
    public OrganizationDTO read(Integer id)
    {
        Organization organization = organizationRepository.getById(id);
        return organizationMapper.toDTO(organization);
    }

    @Override
    public OrganizationDTO update(OrganizationDTO organizationDTO, Integer id)
    {
        Organization organization = organizationRepository.getById(id);
        Organization organizationtoEntity = organizationMapper.toEntity(organizationDTO);

        if (organization != null)
        {
            if (organizationtoEntity.getId_Organization() == null) organizationtoEntity.setId_Organization(organization.getId_Organization());

            if (organizationtoEntity.getName() == null) organizationtoEntity.setName(organization.getName());

            if (organizationtoEntity.getKpp() == null) organizationtoEntity.setKpp(organization.getKpp());

            if (organizationtoEntity.getInn() == null) organizationtoEntity.setInn(organization.getInn());

            if (organizationtoEntity.getAddress() == null) organizationtoEntity.setAddress(organization.getAddress());

            if (organizationtoEntity.getCommunication() == null) organizationtoEntity.setCommunication(organization.getCommunication());

            return organizationMapper.toDTO(organizationRepository.save(organizationtoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Organization organization = organizationRepository.getOne(id);
        if (organization != null)
        {
            organizationRepository.delete(organization);
            return true;
        }
        else return false;
    }
}
