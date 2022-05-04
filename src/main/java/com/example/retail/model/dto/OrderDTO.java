package com.example.retail.model.dto;

import com.example.retail.model.entity.Ordered;
import com.example.retail.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends BaseDTO
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

    public Integer getId_Order() { return id_Order; }
    public void setId_Order(Integer id_Order) { this.id_Order = id_Order; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Ordered getOrdered() { return ordered; }
    public void setOrdered(Ordered ordered) { this.ordered = ordered; }
}
