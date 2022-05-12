package com.example.retail.service;

import com.example.retail.mapper.OrderMapper;
import com.example.retail.mapper.PaymentMethodMapper;
import com.example.retail.model.dto.OrderDTO;
import com.example.retail.model.dto.PaymentMethodDTO;
import com.example.retail.model.entity.Order;
import com.example.retail.model.entity.PaymentMethod;
import com.example.retail.repository.OrderRepository;
import com.example.retail.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper)
    {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO)
    {
        return orderMapper.toDTO(orderRepository.save(orderMapper.toEntity(orderDTO)));
    }

    @Override
    public List<OrderDTO> readAll()
    {
        List<Order> paymentMethodList = orderRepository.findAll();
        return orderMapper.listToDTO(paymentMethodList);
    }

    @Override
    public OrderDTO read(Integer id)
    {
        Order order = orderRepository.getById(id);
        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO, Integer id)
    {
        Order order = orderRepository.getById(id);
        Order ordertoEntity = orderMapper.toEntity(orderDTO);

        if (order != null)
        {
            if (ordertoEntity.getId_Order() == null) ordertoEntity.setId_Order(order.getId_Order());

            if (ordertoEntity.getCost() == null) ordertoEntity.setCost(order.getCost());

            if (ordertoEntity.getQuantity() == 0) ordertoEntity.setQuantity(order.getQuantity());

            if (ordertoEntity.getProduct() == null) ordertoEntity.setProduct(order.getProduct());

            if (ordertoEntity.getOrdered() == null) ordertoEntity.setOrdered(order.getOrdered());

            return orderMapper.toDTO(orderRepository.save(ordertoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        Order order = orderRepository.getOne(id);
        if (order != null)
        {
            orderRepository.delete(order);
            return true;
        }
        else return false;
    }
}
