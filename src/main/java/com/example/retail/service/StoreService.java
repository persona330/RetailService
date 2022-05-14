package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StoreDTO;

import java.util.List;

public interface StoreService
{
    /**
     * Создает новый адрес
     * @param storeDTO
     * @return
     */
    StoreDTO create(StoreDTO storeDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<StoreDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    StoreDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param storeDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    StoreDTO update(StoreDTO storeDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
