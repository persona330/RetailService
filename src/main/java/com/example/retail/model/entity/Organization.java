package com.example.retail.model.entity;

/**
 * Класс Организация со свойствами <b>id_produkt<b/>, <b>voll_name<b/>, <b>menge_auf_lager<b/>
 */
public class Organization extends BaseEntity
{
    /** Свойство идентификатор огранизации поставляемой товары*/
    private int id_Producer;
    /**Свойство название организации*/
    private String name;
    /** Свойство ИНН организации*/
    private String iin;
    /**Свойство КПП*/
    private String kpp;
}
