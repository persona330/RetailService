package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс СтоимостьУслуги со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "SERVICE_COST")
public class ServiceCost extends BaseEntity
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
    public ServiceCost(){}

    @Id
    @GeneratedValue(generator = "SQLServiceCost", strategy = GenerationType.AUTO)
    @Column(name = "ID_service_cost", unique = true, nullable = false)
    public Integer getId_ServiceCost() { return id_ServiceCost; }
    public void setId_ServiceCost(Integer id_ServiceCost) { this.id_ServiceCost = id_ServiceCost; }

    @NonNull
    @Column(name = "Full_cost")
    public BigDecimal getFullCost() { return fullCost; }
    public void setFullCost(BigDecimal fullCost) { this.fullCost = fullCost; }

    @NonNull
    @Column(name = "Paid_for_by")
    public boolean isPaidForBy() { return paidForBy; }
    public void setPaidForBy(boolean paidForBy) { this.paidForBy = paidForBy; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Ordered")
    public Ordered getOrdered() { return ordered; }
    public void setOrdered(Ordered ordered) { this.ordered = ordered; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Delivery")
    public Delivery getDelivery() { return delivery; }
    public void setDelivery(Delivery delivery) { this.delivery = delivery; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Payment_method")
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Customer")
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
