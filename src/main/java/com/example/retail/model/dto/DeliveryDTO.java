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
    private DeliveryMethodDTO deliveryMethod;
    /** Свойство тариф*/
    private TariffDTO tariff;
    /** Свойство транспорт*/
    private TransportDTO transport;
    /** Свойство адрес*/
    private AddressDTO address;

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

    public DeliveryMethodDTO getDeliveryMethodDTO() { return deliveryMethod; }
    public void setDeliveryMethodDTO(DeliveryMethodDTO deliveryMethod) { this.deliveryMethod = deliveryMethod; }

    public TariffDTO getTariffDTO() { return tariff; }
    public void setTariffDTO(TariffDTO tariff) { this.tariff = tariff; }

    public TransportDTO getTransportDTO() { return transport; }
    public void setTransportDTO(TransportDTO transport) { this.transport = transport; }

    public AddressDTO getAddressDTO() { return address; }
    public void setAddressDTO(AddressDTO address) { this.address = address; }
}
