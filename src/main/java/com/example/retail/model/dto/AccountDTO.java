package com.example.retail.model.dto;

import com.example.retail.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO extends BaseDTO
{
    /** Свойство идентификатор учетной записи*/
    private Integer id_Account;
    /** Свойство пароль*/
    private String password;
    /** Свойство логин*/
    private String login;
    /** Свойство человек*/
    private PersonDTO person;

    public Integer getId_Account() { return id_Account; }
    public void setId_Account(Integer id_Account) { this.id_Account = id_Account; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public PersonDTO getPersonDTO() { return person; }
    public void setPersonDTO(PersonDTO person) { this.person = person; }
}
