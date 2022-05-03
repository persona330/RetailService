package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс Курьер со свойствами <b>free<b/>, <b>name<b/>, <b>organization<b/>, <b>transport<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "COURIER")
public class Courier extends Employee
{
    /** Свойство свободен ли сотрудник*/
    private boolean free;
    /** Свойство организация*/
    private Organization organization;
    /** Свойство транспорт*/
    private Transport transport;

    @Id
    @GeneratedValue(generator = "SQLCourier")
    @Column(name = "ID_courier", unique = true, nullable = false)
    @Override
    public Integer get_Id() { return super.get_Id(); }
    @Override
    public void set_Id(Integer id) { super.set_Id(id); }

    @NonNull
    @Column(name = "Surname")
    @Override
    public String getSurname() { return super.getSurname(); }
    @Override
    public void setSurname(String surname) { super.setSurname(surname); }

    @NonNull
    @Column(name = "Name")
    @Override
    public String getName() { return super.getName(); }
    @Override
    public void setName(String name) { super.setName(name); }

    @Value("Нет")
    @Column(name = "Patronymic")
    @Override
    public String getPatronymic() { return super.getPatronymic(); }
    @Override
    public void setPatronymic(String patronymic) { super.setPatronymic(patronymic); }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Address")
    @Override
    public Address getAddress() { return super.getAddress(); }
    @Override
    public void setAddress(Address address) { super.setAddress(address); }

    @NonNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "Communication")
    @Override
    public Communication getCommunication() { return super.getCommunication(); }
    @Override
    public void setCommunication(Communication communication) { super.setCommunication(communication); }

    @NonNull
    @Column(name = "Free")
    @Override
    public boolean isFree() { return free; }
    @Override
    public void setFree(boolean free) { this.free = free; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Organization")
    @Override
    public Organization getOrganization() { return organization; }
    @Override
    public void setOrganization(Organization organization) { this.organization = organization; }

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Transport")
    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }
}
