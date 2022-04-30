package com.example.retail.model.dto;

import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Position;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO
{
    /** Свойство идентификатор проставщика товаров от организации*/
    private Integer id_Supplier;
    /**Свойство полное имя поставщика*/
    private String name;
    /**Свойство должность*/
    private Position position;
    /**Свойство организация в которой работает*/
    private Organization organization;

    public Integer getId_Supplier() { return id_Supplier; }
    public void setId_Supplier(Integer id_Supplier) { this.id_Supplier = id_Supplier; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
