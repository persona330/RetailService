package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.AreaDTO;

import java.util.List;

public interface AreaService
{
    /**
     * Создает новый адрес
     * @param areaDTO
     * @return
     */
    AreaDTO create(AreaDTO areaDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<AreaDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    AreaDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param areaDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    AreaDTO update(AreaDTO areaDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
