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
public class Employee extends Person
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private Organization organization;

    public Employee(Integer id, String surname, String name, String patronymic, Address address, Communication communication, boolean free, Organization organization)
    {
        super(id, surname, name, patronymic, address, communication);
        this.free = free;
        this.organization = organization;
    }
    public Employee(){}

    @NonNull
    @Column(name = "Free")
    public boolean isFree() { return free; }
    public void setFree(boolean free) { this.free = free; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Organization")
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
