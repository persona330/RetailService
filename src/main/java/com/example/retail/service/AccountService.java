package com.example.retail.service;

import com.example.retail.model.dto.AccountDTO;
import com.example.retail.model.dto.BoxDTO;

import java.util.List;

public interface AccountService
{
    /**
     * Создает новый адрес
     * @param accountDTO
     * @return
     */
    AccountDTO create(AccountDTO accountDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<AccountDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    AccountDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param accountDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    AccountDTO update(AccountDTO accountDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
