package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService
{
    /**
     * Создает новый адрес
     * @param organizationDTO
     * @return
     */
    OrganizationDTO create(OrganizationDTO organizationDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<OrganizationDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    OrganizationDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param organizationDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    OrganizationDTO update(OrganizationDTO organizationDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
