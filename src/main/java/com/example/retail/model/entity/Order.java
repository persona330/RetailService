package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Заказ со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Order extends BaseEntity
{
    /**Свойство идентификатор заказа покупателя*/
    private Integer id_Order;
    /**Свойство стоимость заказа*/
    private BigDecimal cost;
    /**Свойство количество товара*/
    private int quantity;
}
