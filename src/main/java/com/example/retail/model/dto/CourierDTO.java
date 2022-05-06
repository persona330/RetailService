package com.example.retail.model.dto;

import com.example.retail.model.entity.Organization;
import com.example.retail.model.entity.Transport;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CourierDTO extends EmployeeDTO
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private Organization organization;
    /** Свойство транспорт*/
    private Transport transport;

    @Override
    public boolean isFree() { return free; }
    @Override
    public void setFree(boolean free) { this.free = free; }

    @Override
    public Organization getOrganization() { return organization; }
    @Override
    public void setOrganization(Organization organization) { this.organization = organization; }

    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }
}
