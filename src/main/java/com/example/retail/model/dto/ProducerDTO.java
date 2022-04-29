package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDTO extends BaseDTO
{
    /** Свойство идентификатор производителя товаров*/
    private Integer id_Producer;
    /**Свойство наименование компании производителя*/
    private String name;

    public Integer getId_Producer() { return id_Producer; }
    public void setId_Producer(Integer id_Producer) { this.id_Producer = id_Producer; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
