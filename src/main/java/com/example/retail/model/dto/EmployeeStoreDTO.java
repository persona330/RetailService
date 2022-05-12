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
    private OrganizationDTO organization;
    /** Свойство должность*/
    private PositionDTO position;
    /** Свойство склад*/
    private StoreDTO store;

    @Override
    public boolean isFree() { return free; }
    @Override
    public void setFree(boolean free) { this.free = free; }

    @Override
    public OrganizationDTO getOrganizationDTO() { return organization; }
    @Override
    public void setOrganizationDTO(OrganizationDTO organization) { this.organization = organization; }

    public PositionDTO getPositionDTO() { return position; }
    public void setPositionDTO(PositionDTO position) { this.position = position; }

    public StoreDTO getStoreDTO() { return store; }
    public void setStoreDTO(StoreDTO store) { this.store = store; }
}
