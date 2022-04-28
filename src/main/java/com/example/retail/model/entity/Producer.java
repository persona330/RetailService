package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Производитель со свойствами <b>id_produkt<b/>, <b>voll_name<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "PRODUCER")
public class Producer extends BaseEntity
{
    /** Свойство идентификатор производителя товаров*/
    private Integer id_Producer;
    /**Свойство наименование компании производителя*/
    private String name;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Producer
     * @param name
     * @see Producer#Producer()
     */
    public Producer(Integer id_Producer, String name)
    {
        this.id_Producer = id_Producer;
        this.name = name;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Producer#Producer(Integer, String)
     */
    public Producer(){}

    @Id
    @GeneratedValue(generator = "SQLProducer", strategy = GenerationType.AUTO)
    @Column(name = "ID_Producer", unique = true, nullable = false)
    public Integer getId_Producer() { return id_Producer; }
    public void setId_Producer(Integer id_Producer) { this.id_Producer = id_Producer; }

    @Basic
    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
