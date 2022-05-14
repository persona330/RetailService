package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.SupplierDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SupplierController
{
    private final SupplierService supplierService;

    @Autowired // Внедрение зависимости через конструктор
    public SupplierController(SupplierService supplierService)
    {
        this.supplierService = supplierService;
    }

    /**
     * Создание нового адреса
     * @param supplierDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/supplier", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<SupplierDTO> create(@RequestBody SupplierDTO supplierDTO) // Тип ответа явно не указан
    {
        try{ supplierService.create(supplierDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(supplierDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/supplier", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<SupplierDTO>> readAll()
    {
        try{ supplierService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<SupplierDTO> supplierDTOList = supplierService.readAll();

        return new ResponseEntity<>(supplierDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/supplier/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<SupplierDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ supplierService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final SupplierDTO supplierDTO = supplierService.read(id);

        return supplierDTO != null // if else
                ? new ResponseEntity<>(supplierDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param supplierDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/supplier/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<SupplierDTO> update(@PathVariable(name = "id") int id, @RequestBody SupplierDTO supplierDTO)
    {
        try{ supplierService.update(supplierDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        SupplierDTO updatedSupplierDTO = supplierService.update(supplierDTO, id);

        return updatedSupplierDTO != null
                ? new ResponseEntity<>(updatedSupplierDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/supplier/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<SupplierDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ supplierService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = supplierService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
