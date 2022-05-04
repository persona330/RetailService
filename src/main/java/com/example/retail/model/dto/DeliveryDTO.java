package com.example.retail.model.dto;

import com.example.retail.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO extends BaseEntity
{
    /** Свойство идентификатор доставки*/
    private Integer id_Delivery;
    /** Свойство дата достаки товара*/
    private Date date;
    /** Свойство время*/
    private Time time;
    /** Свойство общая стоимость*/
    private BigDecimal totalCost;
    /** Свойство общий размер*/
    private BigDecimal totalSize;
    /** Свойство общий вес*/
    private BigDecimal totalWeight;
    /** Свойство расстояние до адресата*/
    private BigDecimal distanceFromAddressee;
    /** Свойство метод доставки*/
    private DeliveryMethod deliveryMethod;
    /** Свойство тариф*/
    private Tariff tariff;
    /** Свойство транспорт*/
    private Transport transport;
    /** Свойство адрес*/
    private Address address;

    public Integer getId_Delivery() { return id_Delivery; }
    public void setId_Delivery(Integer id_Delivery) { this.id_Delivery = id_Delivery; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

    public BigDecimal getTotalSize() { return totalSize; }
    public void setTotalSize(BigDecimal totalSize) { this.totalSize = totalSize; }

    public BigDecimal getTotalWeight() { return totalWeight; }
    public void setTotalWeight(BigDecimal totalWeight) { this.totalWeight = totalWeight; }

    public BigDecimal getDistanceFromAddressee() { return distanceFromAddressee; }
    public void setDistanceFromAddressee(BigDecimal distanceFromAddressee) { this.distanceFromAddressee = distanceFromAddressee; }

    public DeliveryMethod getDeliveryMethod() { return deliveryMethod; }
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) { this.deliveryMethod = deliveryMethod; }

    public Tariff getTariff() { return tariff; }
    public void setTariff(Tariff tariff) { this.tariff = tariff; }

    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
