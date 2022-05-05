package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService
{
    /**
     * Создает новый адрес
     * @param measurementDTO
     * @return
     */
    MeasurementDTO create(MeasurementDTO measurementDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<MeasurementDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    MeasurementDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param measurementDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    MeasurementDTO update(MeasurementDTO measurementDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
