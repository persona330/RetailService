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
        try{ nomenclatureService.create(nomenclatureDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(nomenclatureDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/nomenclature", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<NomenclatureDTO>> readAll()
    {
        try{ nomenclatureService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<NomenclatureDTO> nomenclatureDTOList = nomenclatureService.readAll();

        return new ResponseEntity<>(nomenclatureDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/nomenclature/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<NomenclatureDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ nomenclatureService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final NomenclatureDTO nomenclatureDTO = nomenclatureService.read(id);

        return nomenclatureDTO != null // if else
                ? new ResponseEntity<>(nomenclatureDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        try{ nomenclatureService.update(nomenclatureDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        NomenclatureDTO updatedNomenclatureDTO = nomenclatureService.update(nomenclatureDTO, id);

        return updatedNomenclatureDTO != null
                ? new ResponseEntity<>(updatedNomenclatureDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/nomenclature/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<NomenclatureDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ nomenclatureService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = nomenclatureService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
