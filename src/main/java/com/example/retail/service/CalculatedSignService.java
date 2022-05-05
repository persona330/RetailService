package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CalculatedSignDTO;

import java.util.List;

public interface CalculatedSignService
{
    /**
     * Создает новый адрес
     * @param calculatedSignDTO
     * @return
     */
    CalculatedSignDTO create(CalculatedSignDTO calculatedSignDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<CalculatedSignDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    CalculatedSignDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param calculatedSignDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    CalculatedSignDTO update(CalculatedSignDTO calculatedSignDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
