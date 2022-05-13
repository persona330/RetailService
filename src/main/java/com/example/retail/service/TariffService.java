package com.example.retail.service;

import com.example.retail.model.dto.ProducerDTO;
import com.example.retail.model.dto.TariffDTO;

import java.util.List;

public interface TariffService
{
    /**
     * Создает нового производителя
     * @param tariffDTO
     * @return
     */
    TariffDTO create(TariffDTO tariffDTO);

    /**Возвращает список всех имеющихся производителей
     * @return список производителей
     */
    List<TariffDTO> readAll();

    /**
     * Возвращает производителя по его id
     * @param id
     * @return объект производителя
     */
    TariffDTO read(Integer id);

    /**
     * Обновляет производителя с заданным id, в соотвествии с переданным производителем
     * @param tariffDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    TariffDTO update(TariffDTO tariffDTO, Integer id);

    /**
     * Удаляет производителя с заданным id
     * @param id
     * @return true если производитель был удален, иначе false
     */
    boolean delete(Integer id);
}
