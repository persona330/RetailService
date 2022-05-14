package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ServiceCostDTO;

import java.util.List;

public interface ServiceCostService
{
    /**
     * Создает новый адрес
     * @param serviceCostDTO
     * @return
     */
    ServiceCostDTO create(ServiceCostDTO serviceCostDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<ServiceCostDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    ServiceCostDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param serviceCostDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    ServiceCostDTO update(ServiceCostDTO serviceCostDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
