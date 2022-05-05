package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrderedDTO;

import java.util.List;

public interface OrderedService
{
    /**
     * Создает новый адрес
     * @param orderedDTO
     * @return
     */
    OrderedDTO create(OrderedDTO orderedDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<OrderedDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    OrderedDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param orderedDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    OrderedDTO update(OrderedDTO orderedDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
