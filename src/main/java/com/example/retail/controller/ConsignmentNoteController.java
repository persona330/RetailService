package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ConsignmentNoteDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.ConsignmentNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ConsignmentNoteController
{
    private final ConsignmentNoteService consignmentNoteService;

    @Autowired // Внедрение зависимости через конструктор
    public ConsignmentNoteController(ConsignmentNoteService consignmentNoteService)
    {
        this.consignmentNoteService = consignmentNoteService;
    }

    /**
     * Создание нового адреса
     * @param consignmentNoteDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/consignment_note", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ConsignmentNoteDTO> create(@RequestBody ConsignmentNoteDTO consignmentNoteDTO) // Тип ответа явно не указан
    {
        try{
            consignmentNoteService.create(consignmentNoteDTO);
            return new ResponseEntity<>(consignmentNoteDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/consignment_note", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<ConsignmentNoteDTO>> readAll()
    {
        try{
            final List<ConsignmentNoteDTO> consignmentNoteDTOList = consignmentNoteService.readAll();

            return new ResponseEntity<>(consignmentNoteDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/consignment_note/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ConsignmentNoteDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final ConsignmentNoteDTO consignmentNoteDTO = consignmentNoteService.read(id);

            return consignmentNoteDTO != null // if else
                    ? new ResponseEntity<>(consignmentNoteDTO, HttpStatus.OK)
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
     * @param consignmentNoteDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/consignment_note/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ConsignmentNoteDTO> update(@PathVariable(name = "id") int id, @RequestBody ConsignmentNoteDTO consignmentNoteDTO)
    {
        try{
            ConsignmentNoteDTO updatedConsignmentNoteDTO = consignmentNoteService.update(consignmentNoteDTO, id);

            return updatedConsignmentNoteDTO != null
                    ? new ResponseEntity<>(updatedConsignmentNoteDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/consignment_note/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<ConsignmentNoteDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = consignmentNoteService.delete(id);

            return deleted
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED); }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
