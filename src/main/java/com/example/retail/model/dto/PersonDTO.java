package com.example.retail.model.dto;

import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.Communication;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO extends BaseDTO
{
    /** Свойство идентификатор человека*/
    private Integer id;

    public Integer get_Id(){ return id; }
    public void set_Id(Integer id){ this.id = id; }

    protected abstract String getSurname();
    protected abstract void setSurname(String surname);

    protected abstract String getName();
    protected abstract void setName(String name);

    protected abstract String getPatronymic();
    protected abstract void setPatronymic(String patronymic);

    protected abstract AddressDTO getAddressDTO();
    protected abstract void setAddressDTO(AddressDTO address);

    protected abstract CommunicationDTO getCommunicationDTO();
    protected abstract void setCommunicationDTO(CommunicationDTO communication);
}
