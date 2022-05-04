package com.example.retail.model.dto;


import com.example.retail.model.entity.Group;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO extends BaseDTO
{
    /** Свойство идентификатор группы товаров*/
    private Integer id_Group;
    /**Свойство название группы товаров*/
    private String name;
    /**Свойство дочерняя группа товаров*/
    private Group type;

    public Integer getId_Group() { return id_Group; }
    public void setId_Group(Integer id_Group) { this.id_Group = id_Group; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Group getType() { return type; }
    public void setType(Group type) { this.type = type; }
}
