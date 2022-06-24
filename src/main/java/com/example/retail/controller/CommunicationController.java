package com.example.retail.controller;

import com.example.retail.model.dto.CommunicationDTO;
import com.example.retail.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CommunicationController
{
    private final CommunicationService communicationService;

    @Autowired // Внедрение зависимости через конструктор
    public CommunicationController(CommunicationService communicationService)
    {
        this.communicationService = communicationService;
    }

    /**
     * Создание нового адреса
     * @param communicationDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/communication", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CommunicationDTO> create(@RequestBody CommunicationDTO communicationDTO) // Тип ответа явно не указан
    {
        try
        {
            communicationService.create(communicationDTO);
            return new ResponseEntity<>(communicationDTO, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/communication", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<CommunicationDTO>> readAll()
    {
        try
        {
            final List<CommunicationDTO> communicationsDTO = communicationService.readAll();
            return new ResponseEntity<>(communicationsDTO, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/communication/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CommunicationDTO> read(@PathVariable(name = "id") Integer id)
    {
        try
        {
            final CommunicationDTO communicationDTO = communicationService.read(id);
            return communicationDTO != null // if else
                    ? new ResponseEntity<>(communicationDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param communicationDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/communication/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CommunicationDTO> update(@PathVariable(name = "id") int id, @RequestBody CommunicationDTO communicationDTO)
    {
        try
        {
            CommunicationDTO updatedCommunicationDTO = communicationService.update(communicationDTO, id);
            return updatedCommunicationDTO != null
                    ? new ResponseEntity<>(updatedCommunicationDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/communication/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CommunicationDTO> delete(@PathVariable(name = "id") int id)
    {
        try
        {
            final boolean deleted = communicationService.delete(id);
            return deleted
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
