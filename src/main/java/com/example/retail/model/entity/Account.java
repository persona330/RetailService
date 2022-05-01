package com.example.retail.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Класс УчетнаяЗапись со свойствами <b>id_Account<b/>, <b>password<b/>, <b>login<b/>
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ACCOUNT")
public class Account extends BaseEntity
{
    /** Свойство идентификатор учетной записи*/
    private Integer id_Account;
    /** Свойство пароль*/
    private String password;
    /** Свойство логин*/
    private String login;
    /** Свойство человек*/
    private Person person;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_Account
     * @param password
     * @param login
     * @param person
     * @see Account#Account()
     */
    public Account(Integer id_Account, String password, String login, Person person)
    {
        this.id_Account = id_Account;
        this.password = password;
        this.login = login;
        this.person = person;
    }
    /**
     * Конструктор - создание нового объекта
     * @see Account#Account(Integer, String, String, Person)
     */
    public Account(){}

    @Id
    @GeneratedValue(generator = "SQLAccount", strategy = GenerationType.AUTO)
    @Column(name = "ID_account", unique = true, nullable = false)
    public Integer getId_Account() { return id_Account; }
    public void setId_Account(Integer id_Account) { this.id_Account = id_Account; }

    @NonNull
    @Column(name = "Password", length = 50)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @NonNull
    @Column(name = "Login", length = 20)
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
