package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.GroupDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GroupController
{
    private final GroupService groupService;

    @Autowired // Внедрение зависимости через конструктор
    public GroupController(GroupService groupService)
    {
        this.groupService = groupService;
    }

    /**
     * Создание нового адреса
     * @param groupDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/group", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<GroupDTO> create(@RequestBody GroupDTO groupDTO) // Тип ответа явно не указан
    {
        try{
            groupService.create(groupDTO);
            return new ResponseEntity<>(groupDTO, HttpStatus.CREATED);
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
    @GetMapping(value = "/group", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<GroupDTO>> readAll()
    {
        try{
            final List<GroupDTO> groupDTOList = groupService.readAll();

            return new ResponseEntity<>(groupDTOList, HttpStatus.OK);
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
    @GetMapping(value = "/group/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<GroupDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{
            final GroupDTO groupDTO = groupService.read(id);

            return groupDTO != null // if else
                    ? new ResponseEntity<>(groupDTO, HttpStatus.OK)
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
     * @param groupDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/group/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<GroupDTO> update(@PathVariable(name = "id") int id, @RequestBody GroupDTO groupDTO)
    {
        try{
            GroupDTO updatedGroupDTO = groupService.update(groupDTO, id);

            return updatedGroupDTO != null
                    ? new ResponseEntity<>(updatedGroupDTO, HttpStatus.OK)
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
    @DeleteMapping(value = "/group/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<GroupDTO> delete(@PathVariable(name = "id") int id)
    {
        try{
            final boolean deleted = groupService.delete(id);

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
