package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Заказ со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRODUCT_ORDER")
public class Order extends BaseEntity
{
    /**Свойство идентификатор заказа покупателя*/
    private Integer id_Order;
    /**Свойство стоимость заказа*/
    private BigDecimal cost;
    /**Свойство количество товара*/
    private int quantity;
    /**Свойство товар*/
    private Product product;
    /**Свойство заказано*/
    private Ordered ordered;

    public Order(Integer id_Order, BigDecimal cost, int quantity, Product product, Ordered ordered)
    {
        this.id_Order = id_Order;
        this.cost = cost;
        this.quantity = quantity;
        this.product = product;
        this.ordered = ordered;
    }
    public Order(){}

    @Id
    @GeneratedValue(generator = "SQLOrder", strategy = GenerationType.AUTO)
    @Column(name = "ID_order", unique = true, nullable = false)
    public Integer getId_Order() { return id_Order; }
    public void setId_Order(Integer id_Order) { this.id_Order = id_Order; }

    @NonNull
    @Column(name = "Cost")
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    @NonNull
    @Column(name = "Quantity")
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Product")
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Ordered")
    public Ordered getOrdered() { return ordered; }
    public void setOrdered(Ordered ordered) { this.ordered = ordered; }
}
