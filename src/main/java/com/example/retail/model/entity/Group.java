package com.example.retail.model.entity;

/**
 * Класс ГруппаТовара со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Group extends BaseEntity
{
    /** Свойство идентификатор группы товаров*/
    private int id_Order;
    /**Свойство название группы товаров*/
    private String name;

    public Group(int id_Order, String name) {
        this.id_Order = id_Order;
        this.name = name;
    }

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
