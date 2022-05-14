package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CourierDTO;

import java.util.List;

public interface CourierService
{
    /**
     * Создает новый адрес
     * @param courierDTO
     * @return
     */
    CourierDTO create(CourierDTO courierDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<CourierDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    CourierDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param courierDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    CourierDTO update(CourierDTO courierDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
