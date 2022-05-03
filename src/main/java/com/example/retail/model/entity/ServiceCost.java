package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс СтоимостьУслуги со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class ServiceCost
{
    /** Свойство идентификатор стоимости услуги*/
    private Integer id_ServiceCost;
    /** Свойство полная стоимость*/
    private BigDecimal fullCost;
    /** Свойство оплачено*/
    private boolean paidForBy;
    /** Свойство заказано*/
    private Ordered ordered;
    /** Свойство доставка*/
    private Delivery delivery;
    /** Свойство способ оплаты*/
    private PaymentMethod paymentMethod;
    /** Свойство покупатель*/
    private Customer customer;

    public ServiceCost(Integer id_ServiceCost, BigDecimal fullCost, boolean paidForBy, Ordered ordered, Delivery delivery, PaymentMethod paymentMethod, Customer customer)
    {
        this.id_ServiceCost = id_ServiceCost;
        this.fullCost = fullCost;
        this.paidForBy = paidForBy;
        this.ordered = ordered;
        this.delivery = delivery;
        this.paymentMethod = paymentMethod;
        this.customer = customer;
    }

    public Integer getId_ServiceCost() { return id_ServiceCost; }
    public void setId_ServiceCost(Integer id_ServiceCost) { this.id_ServiceCost = id_ServiceCost; }

    public BigDecimal getFullCost() { return fullCost; }
    public void setFullCost(BigDecimal fullCost) { this.fullCost = fullCost; }

    public boolean isPaidForBy() { return paidForBy; }
    public void setPaidForBy(boolean paidForBy) { this.paidForBy = paidForBy; }

    public Ordered getOrdered() { return ordered; }
    public void setOrdered(Ordered ordered) { this.ordered = ordered; }

    public Delivery getDelivery() { return delivery; }
    public void setDelivery(Delivery delivery) { this.delivery = delivery; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
