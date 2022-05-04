package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TransportDTO extends BaseDTO
{
    /** Свойство идентификатор транспорта*/
    private Integer id_Transport;
    /** Свойство название*/
    private String name;
    /** Свойство грузоподъемность*/
    private BigDecimal carryingCapacity;

    public Integer getId_Transport() { return id_Transport; }
    public void setId_Transport(Integer id_Transport) { this.id_Transport = id_Transport; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getCarryingCapacity() { return carryingCapacity; }
    public void setCarryingCapacity(BigDecimal carryingCapacity) { this.carryingCapacity = carryingCapacity; }
}
