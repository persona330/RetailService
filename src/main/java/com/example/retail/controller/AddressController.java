package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AddressController
{
    private final AddressService addressService;

    @Autowired // Внедрение зависимости через конструктор
    public AddressController(AddressService addressService)
    {
        this.addressService = addressService;
    }

    @RequestMapping("/")
    public String home() { return "Привет"; }

    @RequestMapping("/admin")
    public String admin() { return "Привет"; }

    @RequestMapping("/header")
    public String header() { return "Привет"; }

    /**
     * Создание нового адреса
     * @param addressDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/addresses")
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) // Тип ответа явно не указан
    {
        try{ addressService.create(addressDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        addressService.create(addressDTO);
        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/addresses")
    public ResponseEntity<List<AddressDTO>> readAll()
    {
        try{ addressService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<AddressDTO> addressesDTO = addressService.readAll();

        return new ResponseEntity<>(addressesDTO, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/addresses/{id}")
    public ResponseEntity<AddressDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ addressService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final AddressDTO addressDTO = addressService.read(id);

        return addressDTO != null // if else
                ? new ResponseEntity<>(addressDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param addressDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/addresses/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable(name = "id") int id, @RequestBody AddressDTO addressDTO)
    {
        try{ addressService.update(addressDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean updated = addressService.update(addressDTO, id);

        return updated
                ? new ResponseEntity<>(addressDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/addresses/{id}")
    public ResponseEntity<AddressDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ addressService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = addressService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
