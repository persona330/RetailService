package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Класс СредствоСвязи со свойствами <b>id_Address<b/>, <b>apartment<b/>, <b>entrance<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "COMMUNICATION")
public class Communication extends BaseEntity
{
    /** Свойство идентификатор средства связи*/
    private Integer id_Communication;
    /**Свойство номер телефона*/
    private String phone;
    /**Свойство название электронного адреса*/
    private String email;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Communication
     * @param phone
     * @param email
     * @see Communication#Communication()
     */
    public Communication(Integer id_Communication, String phone, String email)
    {
        this.id_Communication = id_Communication;
        this.phone = phone;
        this.email = email;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Communication#Communication(Integer, String, String)
     */
    public Communication() {}

    @Id
    @GeneratedValue(generator = "SQLCommunication", strategy = GenerationType.AUTO)
    @Column(name = "ID_communication", unique = true, nullable = false)
    public Integer getId_Communication() { return id_Communication; }
    public void setId_Communication(Integer id_Communication) { this.id_Communication = id_Communication; }

    @Basic
    @NonNull
    @Column(name = "Phone", length = 10)
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Basic
    @Value("Нет")
    @Column(name = "Email", length = 254)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
