package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PaymentMethodDTO;

import java.util.List;

public interface PaymentMethodService
{
    /**
     * Создает новый адрес
     * @param paymentMethodDTO
     * @return
     */
    PaymentMethodDTO create(PaymentMethodDTO paymentMethodDTO);

    /**Возвращает список всех имеющихся товаров
     * @return список адресов
     */
    List<PaymentMethodDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    PaymentMethodDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param paymentMethodDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    PaymentMethodDTO update(PaymentMethodDTO paymentMethodDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
