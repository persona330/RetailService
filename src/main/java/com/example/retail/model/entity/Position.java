package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Должность со свойствами <b>id_Position<b/>, <b>ame<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "POSITION")
public class Position extends BaseEntity
{
    /** Свойство идентификатор должности работника*/
    private Integer id_Position;
    /**Свойство наименование должности*/
    private String name;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Position
     * @param name
     * @see Position#Position()
     */
    public Position(Integer id_Position, String name)
    {
        this.id_Position = id_Position;
        this.name = name;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Position#Position(Integer, String)
     */
    public Position(){}

    @Id
    @GeneratedValue(generator = "SQLPosition", strategy = GenerationType.AUTO)
    @Column(name = "ID_position", unique = true, nullable = false)
    public Integer getId_Position() { return id_Position; }
    public void setId_Position(Integer id_Position) { this.id_Position = id_Position; }

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
