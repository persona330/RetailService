package com.example.retail.service;

import com.example.retail.model.dto.AccountDTO;
import com.example.retail.model.dto.WriteOffDTO;

import java.util.List;

public interface WriteOffService
{
    /**
     * Создает новый адрес
     * @param writeOffDTO
     * @return
     */
    WriteOffDTO create(WriteOffDTO writeOffDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<WriteOffDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    WriteOffDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param writeOffDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    WriteOffDTO update(WriteOffDTO writeOffDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
