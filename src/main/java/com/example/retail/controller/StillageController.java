package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.StillageDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.StillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StillageController
{
    private final StillageService stillageService;

    @Autowired // Внедрение зависимости через конструктор
    public StillageController(StillageService stillageService)
    {
        this.stillageService = stillageService;
    }

    /**
     * Создание нового адреса
     * @param stillageDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/stillage", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StillageDTO> create(@RequestBody StillageDTO stillageDTO) // Тип ответа явно не указан
    {
        try{ stillageService.create(stillageDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(stillageDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/stillage", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<StillageDTO>> readAll()
    {
        try{ stillageService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<StillageDTO> stillageDTOList = stillageService.readAll();

        return new ResponseEntity<>(stillageDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/stillage/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StillageDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ stillageService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final StillageDTO stillageDTO = stillageService.read(id);

        return stillageDTO != null // if else
                ? new ResponseEntity<>(stillageDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param stillageDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/stillage/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StillageDTO> update(@PathVariable(name = "id") int id, @RequestBody StillageDTO stillageDTO)
    {
        try{ stillageService.update(stillageDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        StillageDTO updatedStillageDTO = stillageService.update(stillageDTO, id);

        return updatedStillageDTO != null
                ? new ResponseEntity<>(updatedStillageDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/stillage/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<StillageDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ stillageService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = stillageService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
