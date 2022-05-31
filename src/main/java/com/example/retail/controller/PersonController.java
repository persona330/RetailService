package com.example.retail.controller;

import com.example.retail.model.dto.DeliveryMethodDTO;
import com.example.retail.model.dto.PersonDTO;
import com.example.retail.service.DeliveryMethodService;
import com.example.retail.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PersonController
{
    private final PersonService personService;

    @Autowired // Внедрение зависимости через конструктор
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    /**
     * Создание нового адреса
     * @param personDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/person", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO) // Тип ответа явно не указан
    {
        try{ personService.create(personDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(personDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/person", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<PersonDTO>> readAll()
    {
        try{ personService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<PersonDTO> personDTOList = personService.readAll();

        return new ResponseEntity<>(personDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/person/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PersonDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ personService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final PersonDTO personDTO = personService.read(id);

        return personDTO != null // if else
                ? new ResponseEntity<>(personDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param personDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/person/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PersonDTO> update(@PathVariable(name = "id") int id, @RequestBody PersonDTO personDTO)
    {
        try{ personService.update(personDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        PersonDTO updatedPersonMethodDTO = personService.update(personDTO, id);

        return updatedPersonMethodDTO != null
                ? new ResponseEntity<>(updatedPersonMethodDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/person/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PersonDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ personService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = personService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
