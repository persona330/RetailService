package com.example.retail.model.entity;

/**
 * Класс УчетнаяЗапись со свойствами <b>id_Account<b/>, <b>password<b/>, <b>login<b/>
 */
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

    public Account(Integer id_Account, String password, String login, Person person)
    {
        this.id_Account = id_Account;
        this.password = password;
        this.login = login;
        this.person = person;
    }

    public Account(){}

    public Integer getId_Account() { return id_Account; }
    public void setId_Account(Integer id_Account) { this.id_Account = id_Account; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
