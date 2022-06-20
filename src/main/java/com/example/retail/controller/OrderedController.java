package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.OrderedDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrderedController
{
    private final OrderedService orderedService;

    @Autowired // Внедрение зависимости через конструктор
    public OrderedController(OrderedService orderedService)
    {
        this.orderedService = orderedService;
    }

    /**
     * Создание нового адреса
     * @param orderedDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/ordered", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderedDTO> create(@RequestBody OrderedDTO orderedDTO) // Тип ответа явно не указан
    {
        try{
            orderedService.create(orderedDTO);
            return new ResponseEntity<>(orderedDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/ordered", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<OrderedDTO>> readAll()
    {
        try{
            final List<OrderedDTO> orderedDTOList = orderedService.readAll();

            return new ResponseEntity<>(orderedDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/ordered/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderedDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final OrderedDTO orderedDTO = orderedService.read(id);

            return orderedDTO != null // if else
                    ? new ResponseEntity<>(orderedDTO, HttpStatus.OK)
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
     * @param orderedDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/ordered/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderedDTO> update(@PathVariable(name = "id") int id, @RequestBody OrderedDTO orderedDTO)
    {
        try{
            OrderedDTO updatedOrderedDTO = orderedService.update(orderedDTO, id);

            return updatedOrderedDTO != null
                    ? new ResponseEntity<>(updatedOrderedDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/ordered/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<OrderedDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = orderedService.delete(id);

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
