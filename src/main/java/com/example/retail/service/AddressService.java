package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;

import java.util.List;

public interface AddressService
{
    /**
     * Создает новый адрес
     * @param addressDTO
     * @return
     */
    AddressDTO create(AddressDTO addressDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<AddressDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    AddressDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param addressDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    AddressDTO update(AddressDTO addressDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
