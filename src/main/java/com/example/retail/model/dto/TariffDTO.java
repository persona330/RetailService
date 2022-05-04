package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Time;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TariffDTO extends BaseDTO
{
    /** Свойство идентификатор тариф*/
    private Integer id_Tariff;
    /** Свойство название*/
    private String name;
    /** Свойство цена*/
    private BigDecimal cost;
    /** Свойство время доставки*/
    private Time deviliryTime;

    public Integer getId_Tariff() { return id_Tariff; }
    public void setId_Tariff(Integer id_Tariff) { this.id_Tariff = id_Tariff; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public Time getDeviliryTime() { return deviliryTime; }
    public void setDeviliryTime(Time deviliryTime) { this.deviliryTime = deviliryTime; }
}
