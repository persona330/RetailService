package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.NomenclatureDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.NomenclatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class NomenclatureController
{
    private final NomenclatureService nomenclatureService;

    @Autowired // Внедрение зависимости через конструктор
    public NomenclatureController(NomenclatureService nomenclatureService)
    {
        this.nomenclatureService = nomenclatureService;
    }

    /**
     * Создание нового адреса
     * @param nomenclatureDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/nomenclature", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<NomenclatureDTO> create(@RequestBody NomenclatureDTO nomenclatureDTO) // Тип ответа явно не указан
    {
        try{
            nomenclatureService.create(nomenclatureDTO);
            return new ResponseEntity<>(nomenclatureDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/nomenclature", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<NomenclatureDTO>> readAll()
    {
        try{
            final List<NomenclatureDTO> nomenclatureDTOList = nomenclatureService.readAll();

            return new ResponseEntity<>(nomenclatureDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/nomenclature/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<NomenclatureDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final NomenclatureDTO nomenclatureDTO = nomenclatureService.read(id);

            return nomenclatureDTO != null // if else
                    ? new ResponseEntity<>(nomenclatureDTO, HttpStatus.OK)
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
     * @param nomenclatureDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/nomenclature/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<NomenclatureDTO> update(@PathVariable(name = "id") int id, @RequestBody NomenclatureDTO nomenclatureDTO)
    {
        try{
            NomenclatureDTO updatedNomenclatureDTO = nomenclatureService.update(nomenclatureDTO, id);

            return updatedNomenclatureDTO != null
                    ? new ResponseEntity<>(updatedNomenclatureDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/nomenclature/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<NomenclatureDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = nomenclatureService.delete(id);

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
