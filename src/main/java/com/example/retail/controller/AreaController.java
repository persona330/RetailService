package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.AreaDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AreaController
{
    private final AreaService areaService;

    @Autowired // Внедрение зависимости через конструктор
    public AreaController(AreaService areaService)
    {
        this.areaService = areaService;
    }

    /**
     * Создание нового адреса
     * @param areaDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/area", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AreaDTO> create(@RequestBody AreaDTO areaDTO) // Тип ответа явно не указан
    {
        try{ areaService.create(areaDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(areaDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/area", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<AreaDTO>> readAll()
    {
        try{ areaService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<AreaDTO> areaDTOList = areaService.readAll();

        return new ResponseEntity<>(areaDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/area/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AreaDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ areaService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final AreaDTO areaDTO = areaService.read(id);

        return areaDTO != null // if else
                ? new ResponseEntity<>(areaDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param areaDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/area/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AreaDTO> update(@PathVariable(name = "id") int id, @RequestBody AreaDTO areaDTO)
    {
        try{ areaService.update(areaDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        AreaDTO updatedAreaDTO = areaService.update(areaDTO, id);

        return updatedAreaDTO != null
                ? new ResponseEntity<>(updatedAreaDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/area/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<AreaDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ areaService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = areaService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
