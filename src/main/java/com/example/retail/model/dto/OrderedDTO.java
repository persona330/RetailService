package com.example.retail.model.dto;

import com.example.retail.model.Status;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderedDTO extends BaseDTO
{
    /** Свойство идентификатор адреса*/
    private Integer id_Ordered;
    /**Свойство дата оформления заказа*/
    private Date registrationDate;
    /**Свойство вес заказанных товаров*/
    private BigDecimal weight;
    /** Свойство полная стоимость*/
    private BigDecimal fullPrice;
    /**Свойство статус*/
    private Status status;

    public Integer getId_Ordered() { return id_Ordered; }
    public void setId_Ordered(Integer id_Ordered) { this.id_Ordered = id_Ordered; }

    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }

    public BigDecimal getFullPrice() { return fullPrice; }
    public void setFullPrice(BigDecimal fullPrice) { this.fullPrice = fullPrice; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
