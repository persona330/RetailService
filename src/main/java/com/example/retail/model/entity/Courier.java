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
@PrimaryKeyJoinColumn(name = "Id_courier")
public class Courier extends Employee
{
    /** Свойство транспорт*/
    private Transport transport;

    public Courier(Integer id, String surname, String name, String patronymic, Address address, Communication communication, boolean free, Organization organization, Transport transport)
    {
        super(id, surname, name, patronymic, address, communication, free, organization);
        this.transport = transport;
    }

    public Courier() {}

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Transport")
    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }
}
