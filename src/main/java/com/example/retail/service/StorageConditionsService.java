package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StorageConditionsDTO;

import java.util.List;

public interface StorageConditionsService
{
    /**
     * Создает новый адрес
     * @param storageConditionsDTO
     * @return
     */
    StorageConditionsDTO create(StorageConditionsDTO storageConditionsDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<StorageConditionsDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    StorageConditionsDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param storageConditionsDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    StorageConditionsDTO update(StorageConditionsDTO storageConditionsDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
