package com.example.retail.service;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.VerticalSectionsDTO;

import java.util.List;

public interface VerticalSectionsService
{
    /**
     * Создает новый адрес
     * @param verticalSectionsDTO
     * @return
     */
    VerticalSectionsDTO create(VerticalSectionsDTO verticalSectionsDTO);

    /**Возвращает список всех имеющихся адресов
     * @return список адресов
     */
    List<VerticalSectionsDTO> readAll();

    /**
     * Возвращает адрес по его id
     * @param id
     * @return объект адреса
     */
    VerticalSectionsDTO read(Integer id);

    /**
     * Обновляет адрес с заданным id, в соотвествии с переданным адесом
     * @param verticalSectionsDTO
     * @param id
     * @return true если данные были обновлены, иначе false
     */
    VerticalSectionsDTO update(VerticalSectionsDTO verticalSectionsDTO, Integer id);

    /**
     * Удаляет адрес с заданным id
     * @param id
     * @return true если адрес был удален, иначе false
     */
    boolean delete(Integer id);
}
