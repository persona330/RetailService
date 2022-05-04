package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Класс ГруппаТовара со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRODUCT_GROUP")
public class Group extends BaseEntity
{
    /** Свойство идентификатор группы товаров*/
    private Integer id_Group;
    /**Свойство название группы товаров*/
    private String name;
    /**Свойство дочерняя группа товаров*/
    private Group type;

    public Group(Integer id_Group, String name, Group type)
    {
        this.id_Group = id_Group;
        this.name = name;
        this.type = type;
    }
    public Group(){}

    @Id
    @GeneratedValue(generator = "SQLGroup")
    @Column(name = "ID_group", unique = true, nullable = false)
    public Integer getId_Group() { return id_Group; }
    public void setId_Group(Integer id_Group) { this.id_Group = id_Group; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Type")
    public Group getType() { return type; }
    public void setType(Group type) { this.type = type; }
}
