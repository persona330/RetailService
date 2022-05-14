package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.CashVoucherDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.CashVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CashVoucherController
{
    private final CashVoucherService cashVoucherService;

    @Autowired // Внедрение зависимости через конструктор
    public CashVoucherController(CashVoucherService cashVoucherService)
    {
        this.cashVoucherService = cashVoucherService;
    }

    /**
     * Создание нового адреса
     * @param cashVoucherDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/cash_voucher", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CashVoucherDTO> create(@RequestBody CashVoucherDTO cashVoucherDTO) // Тип ответа явно не указан
    {
        try{ cashVoucherService.create(cashVoucherDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(cashVoucherDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/cash_voucher", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<CashVoucherDTO>> readAll()
    {
        try{ cashVoucherService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<CashVoucherDTO> cashVoucherDTOList = cashVoucherService.readAll();

        return new ResponseEntity<>(cashVoucherDTOList, HttpStatus.OK);
        /*return addressesDTO != null &&  !addressesDTO.isEmpty()
                ? new ResponseEntity<>(addressesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/cash_voucher/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CashVoucherDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ cashVoucherService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final CashVoucherDTO cashVoucherDTO = cashVoucherService.read(id);

        return cashVoucherDTO != null // if else
                ? new ResponseEntity<>(cashVoucherDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param cashVoucherDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/cash_voucher/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CashVoucherDTO> update(@PathVariable(name = "id") int id, @RequestBody CashVoucherDTO cashVoucherDTO)
    {
        try{ cashVoucherService.update(cashVoucherDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        CashVoucherDTO updatedCashVoucherDTO = cashVoucherService.update(cashVoucherDTO, id);

        return updatedCashVoucherDTO != null
                ? new ResponseEntity<>(updatedCashVoucherDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/cash_voucher/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CashVoucherDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ cashVoucherService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = cashVoucherService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
