package com.example.retail.model.entity;

/**
 * Класс Человек со свойством <b>id<b/>
 */
public abstract class Person extends BaseEntity
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
