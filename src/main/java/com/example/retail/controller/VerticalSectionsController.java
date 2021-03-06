package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.VerticalSectionsDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.VerticalSectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VerticalSectionsController
{
    private final VerticalSectionsService verticalSectionsService;

    @Autowired // Внедрение зависимости через конструктор
    public VerticalSectionsController(VerticalSectionsService verticalSectionsService)
    {
        this.verticalSectionsService = verticalSectionsService;
    }

    /**
     * Создание нового адреса
     * @param verticalSectionsDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/vertical_sections", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<VerticalSectionsDTO> create(@RequestBody VerticalSectionsDTO verticalSectionsDTO) // Тип ответа явно не указан
    {
        try{
            verticalSectionsService.create(verticalSectionsDTO);
            return new ResponseEntity<>(verticalSectionsDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/vertical_sections", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<VerticalSectionsDTO>> readAll()
    {
        try{
            final List<VerticalSectionsDTO> verticalSectionsDTOList = verticalSectionsService.readAll();

            return new ResponseEntity<>(verticalSectionsDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/vertical_sections/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<VerticalSectionsDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final VerticalSectionsDTO verticalSectionsDTO = verticalSectionsService.read(id);

            return verticalSectionsDTO != null // if else
                    ? new ResponseEntity<>(verticalSectionsDTO, HttpStatus.OK)
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
     * @param verticalSectionsDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/vertical_sections/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<VerticalSectionsDTO> update(@PathVariable(name = "id") int id, @RequestBody VerticalSectionsDTO verticalSectionsDTO)
    {
        try{
            VerticalSectionsDTO updatedVerticalSectionsDTO = verticalSectionsService.update(verticalSectionsDTO, id);

            return updatedVerticalSectionsDTO != null
                    ? new ResponseEntity<>(updatedVerticalSectionsDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/vertical_sections/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<VerticalSectionsDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = verticalSectionsService.delete(id);

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
