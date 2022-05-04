package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.TransportDTO;

import java.util.List;

public interface TransportService
{
    /**
     * Создает новый адрес
     * @param transportDTO
     * @return
     */
    TransportDTO create(TransportDTO transportDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<TransportDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    TransportDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param transportDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    TransportDTO update(TransportDTO transportDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
