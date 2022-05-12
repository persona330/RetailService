package com.example.retail.model.entity;

import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс Человек со свойством <b>id<b/>
 */

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends BaseEntity
{
    /** Свойство идентификатор человека*/
    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer get_Id(){ return id; }
    public void set_Id(Integer id){ this.id = id; }

    @Transient
    protected abstract String getSurname();
    protected abstract void setSurname(String surname);

    @Transient
    protected abstract String getName();
    protected abstract void setName(String name);

    @Transient
    protected abstract String getPatronymic();
    protected abstract void setPatronymic(String patronymic);

    @Transient
    protected abstract Address getAddress();
    protected abstract void setAddress(Address address);

    @Transient
    protected abstract Communication getCommunication();
    protected abstract void setCommunication(Communication communication);
}
