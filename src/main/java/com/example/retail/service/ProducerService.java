package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ProducerDTO;

import java.util.List;

public interface ProducerService
{
    /**
     * Создает нового производителя
     * @param producerDTO
     * @return
     */
    ProducerDTO create(ProducerDTO producerDTO);

    /**Возвращает список всех имеющихся производителей
     * @return список производителей
     */
    List<ProducerDTO> readAll();

    /**
     * Возвращает производителя по его id
     * @param id
     * @return объект производителя
     */
    ProducerDTO read(Integer id);

    /**
     * Обновляет производителя с заданным id, в соотвествии с переданным производителем
     * @param producerDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    ProducerDTO update(ProducerDTO producerDTO, Integer id);

    /**
     * Удаляет производителя с заданным id
     * @param id
     * @return true если производитель был удален, иначе false
     */
    boolean delete(Integer id);
}
