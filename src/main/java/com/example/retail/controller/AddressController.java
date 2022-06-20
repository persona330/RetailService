package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AddressController
{
    private final AddressService addressService;

    @Autowired // Внедрение зависимости через конструктор
    public AddressController(AddressService addressService)
    {
        this.addressService = addressService;
    }

    /**
     * Создание нового адреса
     * @param addressDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/addresses", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) // Тип ответа явно не указан
    {
        try{
            addressService.create(addressDTO);
            return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/addresses", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<AddressDTO>> readAll()
    {
        try{
            final List<AddressDTO> addressesDTO = addressService.readAll();
            return new ResponseEntity<>(addressesDTO, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/addresses/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AddressDTO> read(@PathVariable(name = "id") Integer id)
    {
        try
        {
            final AddressDTO addressDTO = addressService.read(id);
            return addressDTO != null // if else
                    ? new ResponseEntity<>(addressDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param addressDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/addresses/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AddressDTO> update(@PathVariable(name = "id") int id, @RequestBody AddressDTO addressDTO)
    {
        try
        {
            AddressDTO updatedAddressDTO = addressService.update(addressDTO, id);
            return updatedAddressDTO != null
                    ? new ResponseEntity<>(updatedAddressDTO, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/addresses/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AddressDTO> delete(@PathVariable(name = "id") int id)
    {
        try
        {
            final boolean deleted = addressService.delete(id);
            return deleted
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
