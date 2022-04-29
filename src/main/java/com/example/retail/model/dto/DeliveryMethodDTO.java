package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMethodDTO extends BaseDTO
{
    /** Свойство идентификатор метода доставки*/
    private Integer id_DeliveryMethod;
    /** Свойство название*/
    private String name;
    /** Свойство стоимость*/
    private BigDecimal cost;

    public Integer getId_DeliveryMethod() { return id_DeliveryMethod; }
    public void setId_DeliveryMethod(Integer id_DeliveryMethod) { this.id_DeliveryMethod = id_DeliveryMethod; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
}
