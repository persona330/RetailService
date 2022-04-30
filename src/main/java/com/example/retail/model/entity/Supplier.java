package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Поставщик со свойствами <b>id_Supplier<b/>, <b>name<b/>, <b>position<b/>, <b>organization<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "SIPPLIER")
public class Supplier extends BaseEntity
{
    /** Свойство идентификатор проставщика товаров от организации*/
    private Integer id_Supplier;
    /**Свойство полное имя поставщика*/
    private String name;
    /**Свойство должность*/
    private Position position;
    /**Свойство организация в которой работает*/
    private Organization organization;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Supplier
     * @param name
     * @param position
     * @param organization
     * @see Supplier#Supplier()
     */
    public Supplier(Integer id_Supplier, String name, Position position, Organization organization)
    {
        this.id_Supplier = id_Supplier;
        this.name = name;
        this.position = position;
        this.organization = organization;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Supplier#Supplier(Integer, String, Position, Organization)
     */
    public Supplier(){}

    @Id
    @GeneratedValue(generator = "SQLSupplier", strategy = GenerationType.AUTO)
    @Column(name = "ID_supplier", unique = true, nullable = false)
    public Integer getId_Supplier() { return id_Supplier; }
    public void setId_Supplier(Integer id_Supplier) { this.id_Supplier = id_Supplier; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Position")
    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Organization")
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
