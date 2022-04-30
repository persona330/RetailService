package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Привоз со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class Import extends BaseEntity
{
    /** Свойство идентификатор привоза товара на склад*/
    private int id_Import;
    /**Свойство количество привезенного товара*/
    private int quantity;
    /** Свойство цена товаров*/
    private BigDecimal cost;
    /**Свойство НДС*/
    private int vat;
}
