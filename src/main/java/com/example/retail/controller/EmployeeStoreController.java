package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.EmployeeStoreDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.EmployeeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeStoreController
{
    private final EmployeeStoreService employeeStoreService;

    @Autowired // Внедрение зависимости через конструктор
    public EmployeeStoreController(EmployeeStoreService employeeStoreService)
    {
        this.employeeStoreService = employeeStoreService;
    }

    /**
     * Создание нового адреса
     * @param employeeStoreDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/employee_store", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeStoreDTO> create(@RequestBody EmployeeStoreDTO employeeStoreDTO) // Тип ответа явно не указан
    {
        try{
            employeeStoreService.create(employeeStoreDTO);
            return new ResponseEntity<>(employeeStoreDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/employee_store", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<EmployeeStoreDTO>> readAll()
    {
        try{
            final List<EmployeeStoreDTO> employeeStoreDTOList = employeeStoreService.readAll();

            return new ResponseEntity<>(employeeStoreDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/employee_store/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeStoreDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final EmployeeStoreDTO employeeStoreDTO = employeeStoreService.read(id);

            return employeeStoreDTO != null // if else
                    ? new ResponseEntity<>(employeeStoreDTO, HttpStatus.OK)
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
     * @param employeeStoreDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/employee_store/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeStoreDTO> update(@PathVariable(name = "id") int id, @RequestBody EmployeeStoreDTO employeeStoreDTO)
    {
        try{
            EmployeeStoreDTO updatedEmployeeStoreDTO = employeeStoreService.update(employeeStoreDTO, id);

            return updatedEmployeeStoreDTO != null
                    ? new ResponseEntity<>(updatedEmployeeStoreDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/employee_store/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeStoreDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = employeeStoreService.delete(id);

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
