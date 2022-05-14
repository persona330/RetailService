package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryDTO;

import java.util.List;

public interface DeliveryService
{
    /**
     * Создает новый адрес
     * @param deliveryDTO
     * @return
     */
    DeliveryDTO create(DeliveryDTO deliveryDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<DeliveryDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    DeliveryDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param deliveryDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    DeliveryDTO update(DeliveryDTO deliveryDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
