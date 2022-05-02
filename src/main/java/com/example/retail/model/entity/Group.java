package com.example.retail.model.entity;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Класс ГруппаТовара со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Group extends BaseEntity
{
    /** Свойство идентификатор группы товаров*/
    private Integer id_Order;
    /**Свойство название группы товаров*/
    private String name;
    /**Свойство дочерняя группа товаров*/
    private Group type;

    public Group(Integer id_Order, String name)
    {
        this.id_Order = id_Order;
        this.name = name;
    }

    public Integer getId_Order() { return id_Order; }
    public void setId_Order(Integer id_Order) { this.id_Order = id_Order; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Group getType() { return type; }
    public void setType(Group type) { this.type = type; }
}
