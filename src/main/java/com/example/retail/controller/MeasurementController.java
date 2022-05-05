package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.MeasurementDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MeasurementController
{
    private final MeasurementService measurementService;

    @Autowired // Внедрение зависимости через конструктор
    public MeasurementController(MeasurementService measurementService)
    {
        this.measurementService = measurementService;
    }

    /**
     * Создание нового адреса
     * @param measurementDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/measurement", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<MeasurementDTO> create(@RequestBody MeasurementDTO measurementDTO) // Тип ответа явно не указан
    {
        try{ measurementService.create(measurementDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(measurementDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/measurement", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<MeasurementDTO>> readAll()
    {
        try{ measurementService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<MeasurementDTO> measurementDTOList = measurementService.readAll();

        return new ResponseEntity<>(measurementDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/measurement/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<MeasurementDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ measurementService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final MeasurementDTO measurementDTO = measurementService.read(id);

        return measurementDTO != null // if else
                ? new ResponseEntity<>(measurementDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param measurementDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/measurement/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<MeasurementDTO> update(@PathVariable(name = "id") int id, @RequestBody MeasurementDTO measurementDTO)
    {
        try{ measurementService.update(measurementDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        MeasurementDTO updatedMeasurementDTO = measurementService.update(measurementDTO, id);

        return updatedMeasurementDTO != null
                ? new ResponseEntity<>(updatedMeasurementDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/measurement/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<MeasurementDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ measurementService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = measurementService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
