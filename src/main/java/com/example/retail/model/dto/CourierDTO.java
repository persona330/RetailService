package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
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
    /** Свойство транспорт*/
    private TransportDTO transport;

    public TransportDTO getTransportDTO() { return transport; }
    public void setTransportDTO(TransportDTO transport) { this.transport = transport; }
}
