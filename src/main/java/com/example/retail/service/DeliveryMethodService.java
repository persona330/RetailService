package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.DeliveryMethodDTO;

import java.util.List;

public interface DeliveryMethodService
{
    /**
     * Создает новый адрес
     * @param deliveryMethodDTO
     * @return
     */
    DeliveryMethodDTO create(DeliveryMethodDTO deliveryMethodDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<DeliveryMethodDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    DeliveryMethodDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param deliveryMethodDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    DeliveryMethodDTO update(DeliveryMethodDTO deliveryMethodDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
