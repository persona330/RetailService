package com.example.retail.controller;

import com.example.retail.model.dto.DeliveryMethodDTO;
import com.example.retail.model.dto.EmployeeDTO;
import com.example.retail.service.DeliveryMethodService;
import com.example.retail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController
{
    private final EmployeeService employeeService;

    @Autowired // Внедрение зависимости через конструктор
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    /**
     * Создание нового адреса
     * @param employeeDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/employee", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employeeDTO) // Тип ответа явно не указан
    {
        try{ employeeService.create(employeeDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/employee", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<EmployeeDTO>> readAll()
    {
        try{ employeeService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<EmployeeDTO> employeeDTOList = employeeService.readAll();

        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/employee/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ employeeService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final EmployeeDTO employeeDTO = employeeService.read(id);

        return employeeDTO != null // if else
                ? new ResponseEntity<>(employeeDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param employeeDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/employee/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeDTO> update(@PathVariable(name = "id") int id, @RequestBody EmployeeDTO employeeDTO)
    {
        try{ employeeService.update(employeeDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        EmployeeDTO updatedEmployeedDTO = employeeService.update(employeeDTO, id);

        return updatedEmployeedDTO != null
                ? new ResponseEntity<>(updatedEmployeedDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/employee/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<EmployeeDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ employeeService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = employeeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
