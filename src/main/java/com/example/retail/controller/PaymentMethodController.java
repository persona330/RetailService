package com.example.retail.controller;

import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.PaymentMethodDTO;
import com.example.retail.service.AddressService;
import com.example.retail.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PaymentMethodController
{
    private final PaymentMethodService paymentMethodService;

    @Autowired // Внедрение зависимости через конструктор
    public PaymentMethodController(PaymentMethodService paymentMethodService)
    {
        this.paymentMethodService = paymentMethodService;
    }

    /**
     * Создание нового адреса
     * @param paymentMethodDTO аннатацией переобразуется содержимое запроса и подставляется в объект параметра функции
     * @return http статус
     */
    @PostMapping(value = "/payment_method", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PaymentMethodDTO> create(@RequestBody PaymentMethodDTO paymentMethodDTO) // Тип ответа явно не указан
    {
        try{ paymentMethodService.create(paymentMethodDTO); }
        catch (Exception e){System.out.println(e.getMessage());}

        return new ResponseEntity<>(paymentMethodDTO, HttpStatus.CREATED);
    }

    /**
     * Получение информации об адресах
     * @return http статус и/или адреса
     */
    @GetMapping(value = "/payment_method", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<PaymentMethodDTO>> readAll()
    {
        try{ paymentMethodService.readAll(); }
        catch (Exception e){System.out.println(e.getMessage());}

        final List<PaymentMethodDTO> paymentMethodDTOList = paymentMethodService.readAll();

        return new ResponseEntity<>(paymentMethodDTOList, HttpStatus.OK);
    }

    /**
     * Получение информации об адресе
     * @param id аннотацией извлекают значение из запроса
     * @return http статус и/или адрес
     */
    @GetMapping(value = "/payment_method/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PaymentMethodDTO> read(@PathVariable(name = "id") Integer id)
    {
        try{ paymentMethodService.read(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final PaymentMethodDTO paymentMethodDTO = paymentMethodService.read(id);

        return paymentMethodDTO != null // if else
                ? new ResponseEntity<>(paymentMethodDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение свойств адреса
     * @param id
     * @param paymentMethodDTO
     * @return http статус и/или измененный адрес
     */
    @PutMapping(value = "/payment_method/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PaymentMethodDTO> update(@PathVariable(name = "id") int id, @RequestBody PaymentMethodDTO paymentMethodDTO)
    {
        try{ paymentMethodService.update(paymentMethodDTO, id);}
        catch (Exception e){System.out.println(e.getMessage());}

        PaymentMethodDTO updatedPaymentMethodDTO = paymentMethodService.update(paymentMethodDTO, id);

        return updatedPaymentMethodDTO != null
                ? new ResponseEntity<>(updatedPaymentMethodDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление адреса
     * @param id
     * @return http статус
     */
    @DeleteMapping(value = "/payment_method/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<PaymentMethodDTO> delete(@PathVariable(name = "id") int id)
    {
        try{ paymentMethodService.delete(id); }
        catch (Exception e){System.out.println(e.getMessage());}

        final boolean deleted = paymentMethodService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
