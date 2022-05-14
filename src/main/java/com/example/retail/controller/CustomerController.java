package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CustomerDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController
{
    private final CustomerService customerService;

    @Autowired // Внедрение зависимости через конструктор
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    /**
     * Создание нового адреса
     * @param customerDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/customer", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) // Тип ответа явно не указан
    {
        try{ customerService.create(customerDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/customer", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<CustomerDTO>> readAll()
    {
        try{ customerService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<CustomerDTO> customerDTOList = customerService.readAll();

        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/customer/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CustomerDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ customerService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final CustomerDTO customerDTO = customerService.read(id);

        return customerDTO != null // if else
                ? new ResponseEntity<>(customerDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param customerDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/customer/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CustomerDTO> update(@PathVariable(name = "id") int id, @RequestBody CustomerDTO customerDTO)
    {
        try{ customerService.update(customerDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        CustomerDTO updatedCustomerDTO = customerService.update(customerDTO, id);

        return updatedCustomerDTO != null
                ? new ResponseEntity<>(updatedCustomerDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/customer/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CustomerDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ customerService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = customerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
