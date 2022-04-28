package com.example.retail.model.entity;

import java.math.BigDecimal;

/*public enum Status
{

}*/

/**
 * Класс Заказано со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Ordered extends BaseEntity
{
    /** Свойство идентификатор адреса*/
    private int id_Ordered;
    /**Свойство дата оформления заказа*/
    private char apartment;
    /**Свойство вес заказанных товаров*/
    private BigDecimal weight;
    /** Свойство полная стоимость*/
    private BigDecimal fullPrice;
    /**Свойство статус*/
    //private Status status;
}
