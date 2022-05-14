package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.BoxDTO;

import java.util.List;

public interface BoxService
{
    /**
     * Создает новый адрес
     * @param boxDTO
     * @return
     */
    BoxDTO create(BoxDTO boxDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<BoxDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    BoxDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param boxDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    BoxDTO update(BoxDTO boxDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
