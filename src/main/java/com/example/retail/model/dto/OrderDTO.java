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
    private ProductDTO product;
    /**Свойство заказано*/
    private OrderedDTO ordered;

    public Integer getId_Order() { return id_Order; }
    public void setId_Order(Integer id_Order) { this.id_Order = id_Order; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ProductDTO getProductDTO() { return product; }
    public void setProductDTO(ProductDTO product) { this.product = product; }

    public OrderedDTO getOrderedDTO() { return ordered; }
    public void setOrderedDTO(OrderedDTO ordered) { this.ordered = ordered; }
}
