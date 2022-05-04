package com.example.retail.model.dto;

import com.example.retail.model.entity.Shelf;
import com.example.retail.model.entity.VerticalSections;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BoxDTO extends BaseDTO
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

    public Integer getId_Box() { return id_Box; }
    public void setId_Box(Integer id_Box) { this.id_Box = id_Box; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public BigDecimal getSize() { return size; }
    public void setSize(BigDecimal size) { this.size = size; }

    public Shelf getShelf() { return shelf; }
    public void setShelf(Shelf shelf) { this.shelf = shelf; }

    public VerticalSections getVerticalSections() { return verticalSections; }
    public void setVerticalSections(VerticalSections verticalSections) { this.verticalSections = verticalSections; }
}
