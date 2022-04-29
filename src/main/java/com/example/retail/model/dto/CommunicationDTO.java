package com.example.retail.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationDTO extends BaseDTO
{
    /** Свойство идентификатор средства связи*/
    private Integer id_Communication;
    /**Свойство номер телефона*/
    private String phone;
    /**Свойство название электронного адреса*/
    private String email;

    public Integer getId_Communication() { return id_Communication; }
    public void setId_Communication(Integer id_Communication) { this.id_Communication = id_Communication; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
