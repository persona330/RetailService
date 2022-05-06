package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO extends BaseDTO
{
    /** Свойство идентификатор человека*/
    private Integer id;

    Integer get_Id(){ return id; }
    void set_Id(Integer id){ this.id = id; }

    public abstract String getSurname();
    public abstract void setSurname(String surname);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getPatronymic();
    public abstract void setPatronymic(String patronymic);

    public abstract Address getAddress();
    public abstract void setAddress(Address address);

    public abstract Communication getCommunication();
    public abstract void setCommunication(Communication communication);
}
