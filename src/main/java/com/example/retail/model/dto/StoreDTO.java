package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO extends BaseDTO
{
    /** Свойство идентификатор склада*/
    private Integer id_Store;
    /**Свойство название*/
    private String name;
    /**Свойство общая вместимость*/
    private BigDecimal totalCapacity;
    /** Свойство адрес*/
    private AddressDTO address;
    /** Свойство организация*/
    private OrganizationDTO organization;

    public Integer getId_Store() { return id_Store; }
    public void setId_Store(Integer id_Store) { this.id_Store = id_Store; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getTotalCapacity() { return totalCapacity; }
    public void setTotalCapacity(BigDecimal totalCapacity) { this.totalCapacity = totalCapacity; }

    public AddressDTO getAddressDTO() { return address; }
    public void setAddressDTO(AddressDTO address) { this.address = address; }

    public OrganizationDTO getOrganizationDTO() { return organization; }
    public void setOrganizationDTO(OrganizationDTO organization) { this.organization = organization; }
}
