package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.SupplierDTO;

import java.util.List;

public interface SupplierService
{
    /**
     * Создает новый адрес
     * @param supplierDTO
     * @return
     */
    SupplierDTO create(SupplierDTO supplierDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<SupplierDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    SupplierDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param supplierDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    SupplierDTO update(SupplierDTO supplierDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
