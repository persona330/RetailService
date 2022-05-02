package com.example.retail.model.entity;

import java.math.BigDecimal;

/**
 * Класс Ячейка со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
public class Box
{
    /** Свойство идентификатор ячейки*/
    private Integer id_Box;
    /** Свойство объем ячейки*/
    private BigDecimal size;
    /** Свойство полка*/
    private Shelf shelf;
    /** Свойство вертикальная секция*/
    private VerticalSections verticalSections;

    public Box(Integer id_Box, BigDecimal size, Shelf shelf, VerticalSections verticalSections)
    {
        this.id_Box = id_Box;
        this.size = size;
        this.shelf = shelf;
        this.verticalSections = verticalSections;
    }

    public Integer getId_Box() { return id_Box; }
    public void setId_Box(Integer id_Box) { this.id_Box = id_Box; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public Shelf getShelf() { return shelf; }
    public void setShelf(Shelf shelf) { this.shelf = shelf; }

    public VerticalSections getVerticalSections() { return verticalSections; }
    public void setVerticalSections(VerticalSections verticalSections) { this.verticalSections = verticalSections; }
}
