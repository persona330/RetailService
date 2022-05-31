package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

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
