package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService
{
    /**
     * Создает новый адрес
     * @param customerDTO
     * @return
     */
    CustomerDTO create(CustomerDTO customerDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<CustomerDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    CustomerDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param customerDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    CustomerDTO update(CustomerDTO customerDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
