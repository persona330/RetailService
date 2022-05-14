package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ImportDTO;

import java.util.List;

public interface ImportService
{
    /**
     * Создает новый адрес
     * @param importDTO
     * @return
     */
    ImportDTO create(ImportDTO importDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<ImportDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    ImportDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param importDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    ImportDTO update(ImportDTO importDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
