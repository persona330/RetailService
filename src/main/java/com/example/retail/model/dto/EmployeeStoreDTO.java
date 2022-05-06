package com.example.retail.model.dto;

import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Position;
import com.example.retail.model.entity.Store;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeStoreDTO extends EmployeeDTO
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private Organization organization;
    /** Свойство должность*/
    private Position position;
    /** Свойство склад*/
    private Store store;

    @Override
    public boolean isFree() { return free; }
    @Override
    public void setFree(boolean free) { this.free = free; }

    @Override
    public Organization getOrganization() { return organization; }
    @Override
    public void setOrganization(Organization organization) { this.organization = organization; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
}
