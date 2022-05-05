package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CommunicationDTO;

import java.util.List;

public interface CommunicationService
{
    /**
     * Создает новый адрес
     * @param communicationDTO
     * @return
     */
    CommunicationDTO create(CommunicationDTO communicationDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<CommunicationDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    CommunicationDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param communicationDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    CommunicationDTO update(CommunicationDTO communicationDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
