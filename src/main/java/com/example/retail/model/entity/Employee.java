package com.example.retail.model.entity;

/**
 * Класс Сотрудник со свойствами <b>id<b/>, <b>surname<b/>, <b>name<b/>, <b>patronymic<b/>, <b>address<b/>,
 * <b>communication<b/>
 */
public abstract class Employee extends Person
{
    /** Свойство идентификатор сотрудника*/
    private Integer id;
    /** Свойство фамилия*/
    private String surname;
    /** Свойство имя*/
    private String name;
    /** Свойство отчество*/
    private String patronymic;
    /**Свойство адрес*/
    private Address address;
    /**Свойство связь*/
    private Communication communication;

    public Integer get_Id(){ return id; }
    public void set_Id(Integer id){ this.id = id; }

    public String getSurname(){ return surname; }
    public void setSurname(String surname){ this.surname = surname;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic(){ return patronymic; }
    public void setPatronymic(String patronymic){ this.patronymic = patronymic; }

    public Address getAddress(){ return address; }
    public void setAddress(Address address){ this.address = address; }

    public Communication getCommunication(){ return communication; }
    public void setCommunication(Communication communication){ this.communication = communication; }

    public abstract boolean isFree();
    public abstract void setFree(boolean free);

    public abstract Organization getOrganization();
    public abstract void setOrganization(Organization organization);
}
