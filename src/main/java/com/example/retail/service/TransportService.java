package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.TransportDTO;

import java.util.List;

public interface TransportService
{
    /**
     * Создает новый транспорт
     * @param transportDTO
     * @return
     */
    TransportDTO create(TransportDTO transportDTO);

    /**Возвращает список имеющегося транспорта
     * @return список транспорта
     */
    List<TransportDTO> readAll();

    /**
     * Возвращает транспорт по его id
     * @param id
     * @return объект транспорта
     */
    TransportDTO read(Integer id);

    /**
     * Обновляет транспорт с заданным id, в соотвествии с переданным траспортом
     * @param transportDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    TransportDTO update(TransportDTO transportDTO, Integer id);

    /**
     * Удаляет траспорт с заданным id
     * @param id
     * @return true если транспорт был удален, иначе false
     */
    boolean delete(Integer id);
}
