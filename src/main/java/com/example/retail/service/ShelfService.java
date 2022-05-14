package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ShelfDTO;

import java.util.List;

public interface ShelfService
{
    /**
     * Создает новый адрес
     * @param shelfDTO
     * @return
     */
    ShelfDTO create(ShelfDTO shelfDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<ShelfDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    ShelfDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param shelfDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    ShelfDTO update(ShelfDTO shelfDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
