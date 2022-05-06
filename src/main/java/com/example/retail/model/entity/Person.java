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
    Integer get_Id(){ return id; }
    void set_Id(Integer id){ this.id = id; }

    @Transient
    public abstract String getSurname();
    public abstract void setSurname(String surname);

    @Transient
    public abstract String getName();
    public abstract void setName(String name);

    @Transient
    public abstract String getPatronymic();
    public abstract void setPatronymic(String patronymic);

    @Transient
    public abstract Address getAddress();
    public abstract void setAddress(Address address);

    @Transient
    public abstract Communication getCommunication();
    public abstract void setCommunication(Communication communication);
}
