package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StillageDTO;

import java.util.List;

public interface StillageService
{
    /**
     * Создает новый адрес
     * @param stillageDTO
     * @return
     */
    StillageDTO create(StillageDTO stillageDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<StillageDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    StillageDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param stillageDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    StillageDTO update(StillageDTO stillageDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
