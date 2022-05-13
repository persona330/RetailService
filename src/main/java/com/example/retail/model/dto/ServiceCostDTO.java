package com.example.retail.model.dto;

import com.example.retail.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCostDTO extends BaseDTO
{
    /** Свойство идентификатор стоимости услуги*/
    private Integer id_ServiceCost;
    /** Свойство полная стоимость*/
    private BigDecimal fullCost;
    /** Свойство оплачено*/
    private boolean paidForBy;
    /** Свойство заказано*/
    private OrderedDTO ordered;
    /** Свойство доставка*/
    private DeliveryDTO delivery;
    /** Свойство способ оплаты*/
    private PaymentMethodDTO paymentMethod;
    /** Свойство покупатель*/
    private CustomerDTO customer;

    public Integer getId_ServiceCost() { return id_ServiceCost; }
    public void setId_ServiceCost(Integer id_ServiceCost) { this.id_ServiceCost = id_ServiceCost; }

    public BigDecimal getFullCost() { return fullCost; }
    public void setFullCost(BigDecimal fullCost) { this.fullCost = fullCost; }

    public boolean isPaidForBy() { return paidForBy; }
    public void setPaidForBy(boolean paidForBy) { this.paidForBy = paidForBy; }

    public OrderedDTO getOrderedDTO() { return ordered; }
    public void setOrderedDTO(OrderedDTO ordered) { this.ordered = ordered; }

    public DeliveryDTO getDeliveryDTO() { return delivery; }
    public void setDeliveryDTO(DeliveryDTO delivery) { this.delivery = delivery; }

    public PaymentMethodDTO getPaymentMethodDTO() { return paymentMethod; }
    public void setPaymentMethodDTO(PaymentMethodDTO paymentMethod) { this.paymentMethod = paymentMethod; }

    public CustomerDTO getCustomerDTO() { return customer; }
    public void setCustomerDTO(CustomerDTO customer) { this.customer = customer; }

}
