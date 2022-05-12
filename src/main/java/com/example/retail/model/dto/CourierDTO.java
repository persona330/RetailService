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
    private OrganizationDTO organization;
    /** Свойство транспорт*/
    private TransportDTO transport;

    @Override
    public boolean isFree() { return free; }
    @Override
    public void setFree(boolean free) { this.free = free; }

    @Override
    public OrganizationDTO getOrganizationDTO() { return organization; }
    @Override
    public void setOrganizationDTO(OrganizationDTO organization) { this.organization = organization; }

    public TransportDTO getTransportDTO() { return transport; }
    public void setTransportDTO(TransportDTO transport) { this.transport = transport; }
}
