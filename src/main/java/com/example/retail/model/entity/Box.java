package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс Ячейка со свойствами <b>id_Box<b/>, <b>number<b/>, <b>size<b/>, <b>shelf<b/>, <b>verticalSections<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "BOX")
public class Box extends BaseEntity
{
    /** Свойство идентификатор ячейки*/
    private Integer id_Box;
    /** Свойство номер*/
    private String number;
    /** Свойство объем ячейки*/
    private BigDecimal size;
    /** Свойство полка*/
    private Shelf shelf;
    /** Свойство вертикальная секция*/
    private VerticalSections verticalSections;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Box
     * @param size
     * @param shelf
     * @param verticalSections
     * @see Box#Box()
     */
    public Box(Integer id_Box, String number, BigDecimal size, Shelf shelf, VerticalSections verticalSections)
    {
        this.id_Box = id_Box;
        this.number = number;
        this.size = size;
        this.shelf = shelf;
        this.verticalSections = verticalSections;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Box#Box(Integer, String, BigDecimal, Shelf, VerticalSections)
     */
    public Box(){}

    @Id
    @GeneratedValue(generator = "SQLBox", strategy = GenerationType.AUTO)
    @Column(name = "ID_box", unique = true, nullable = false)
    public Integer getId_Box() { return id_Box; }
    public void setId_Box(Integer id_Box) { this.id_Box = id_Box; }

    @NonNull
    @Column(name = "Number")
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    @NonNull
    @Column(name = "Size")
    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Shelf")
    public Shelf getShelf() { return shelf; }
    public void setShelf(Shelf shelf) { this.shelf = shelf; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Vertical_sections")
    public VerticalSections getVerticalSections() { return verticalSections; }
    public void setVerticalSections(VerticalSections verticalSections) { this.verticalSections = verticalSections; }
}
