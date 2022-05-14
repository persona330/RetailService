package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StoreDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StoreController
{
    private final StoreService storeService;

    @Autowired // Внедрение зависимости через конструктор
    public StoreController(StoreService storeService)
    {
        this.storeService = storeService;
    }

    /**
     * Создание нового адреса
     * @param storeDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/store", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StoreDTO> create(@RequestBody StoreDTO storeDTO) // Тип ответа явно не указан
    {
        try{ storeService.create(storeDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(storeDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/store", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<StoreDTO>> readAll()
    {
        try{ storeService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<StoreDTO> storeDTOList = storeService.readAll();

        return new ResponseEntity<>(storeDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/store/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StoreDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ storeService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final StoreDTO storeDTO = storeService.read(id);

        return storeDTO != null // if else
                ? new ResponseEntity<>(storeDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param storeDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/store/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StoreDTO> update(@PathVariable(name = "id") int id, @RequestBody StoreDTO storeDTO)
    {
        try{ storeService.update(storeDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        StoreDTO updatedStoreDTO = storeService.update(storeDTO, id);

        return updatedStoreDTO != null
                ? new ResponseEntity<>(updatedStoreDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/store/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StoreDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ storeService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = storeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
