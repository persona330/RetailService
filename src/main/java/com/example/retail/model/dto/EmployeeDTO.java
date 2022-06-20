package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO extends PersonDTO
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private OrganizationDTO organization;

    public boolean isFree() { return free; }
    public void setFree(boolean free) { this.free = free; }

    public OrganizationDTO getOrganizationDTO() { return organization; }
    public void setOrganizationDTO(OrganizationDTO organization) { this.organization = organization; }
}
