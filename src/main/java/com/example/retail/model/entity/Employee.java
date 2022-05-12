package com.example.retail.model.entity;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс Сотрудник со свойствами <b>id<b/>, <b>surname<b/>, <b>name<b/>, <b>patronymic<b/>, <b>address<b/>,
 * <b>communication<b/>
 */
@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
//@PrimaryKeyJoinColumn(name="id_employee")
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

    public Employee(String surname, String name, String patronymic, Address address, Communication communication)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.communication = communication;
    }
    public Employee(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer get_Id(){ return id; }
    public void set_Id(Integer id){ this.id = id; }

    @NonNull
    @Column(name = "Surname")
    public String getSurname(){ return surname; }
    public void setSurname(String surname){ this.surname = surname;}

    @NonNull
    @Column(name = "Name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Value("Нет")
    @Column(name = "Patronymic")
    public String getPatronymic(){ return patronymic; }
    public void setPatronymic(String patronymic){ this.patronymic = patronymic; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Address")
    public Address getAddress(){ return address; }
    public void setAddress(Address address){ this.address = address; }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Communication")
    public Communication getCommunication(){ return communication; }
    public void setCommunication(Communication communication){ this.communication = communication; }

    @Transient
    protected abstract boolean isFree();
    protected abstract void setFree(boolean free);

    @Transient
    protected abstract Organization getOrganization();
    protected abstract void setOrganization(Organization organization);
}
