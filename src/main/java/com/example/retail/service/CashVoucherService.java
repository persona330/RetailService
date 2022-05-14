package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CashVoucherDTO;

import java.util.List;

public interface CashVoucherService
{
    /**
     * Создает новый адрес
     * @param cashVoucherDTO
     * @return
     */
    CashVoucherDTO create(CashVoucherDTO cashVoucherDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<CashVoucherDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    CashVoucherDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param cashVoucherDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    CashVoucherDTO update(CashVoucherDTO cashVoucherDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
