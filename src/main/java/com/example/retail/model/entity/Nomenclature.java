package com.example.retail.model.entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Класс Номенклатуры со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class Nomenclature extends BaseEntity
{
    /** Свойство идентификатор номеклатуры на товар*/
    private int id_Nomenclature;
    /**Свойство наименование товара*/
    private String name;
    /**Свойство бренд*/
    private String brand;
    /** Свойство цена товара*/
    private BigDecimal cost;
    @Temporal(TemporalType.DATE)
    /**Свойство дата производства товара*/
    private Date productionDate;
    /**Свойство срок годности товара*/
    private int expirationDate;
    /**Свойство вес товара*/
    private BigDecimal weight;
    /**Свойство объем товара*/
    private BigDecimal size;
}
