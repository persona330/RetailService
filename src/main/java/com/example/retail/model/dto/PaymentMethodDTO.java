package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDTO extends BaseDTO
{
    /** Свойство идентификатор способа оплаты*/
    private Integer id_PaymentMethod;
    /**Свойство название*/
    private String name;

    public Integer getId_PaymentMethod() { return id_PaymentMethod; }
    public void setId_PaymentMethod(Integer id_PaymentMethod) { this.id_PaymentMethod = id_PaymentMethod; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
