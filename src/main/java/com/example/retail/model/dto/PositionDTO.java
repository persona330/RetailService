package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO extends BaseDTO
{
    /** Свойство идентификатор должности работника*/
    private Integer id_Position;
    /**Свойство наименование должности*/
    private String name;

    public Integer getId_Position() { return id_Position; }
    public void setId_Position(Integer id_Position) { this.id_Position = id_Position; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
