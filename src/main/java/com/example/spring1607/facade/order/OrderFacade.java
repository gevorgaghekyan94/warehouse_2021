package com.example.spring1607.facade.order;

import com.example.spring1607.annotations.Facade;
import com.example.spring1607.controller.order.models.OrderRequestModel;
import com.example.spring1607.controller.order.models.OrderResponseModel;
import com.example.spring1607.converter.OrderConverter;
import com.example.spring1607.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class OrderFacade {

    private final OrderConverter orderConverter;
    private final OrderService orderService;

    @Autowired
    public OrderFacade(OrderConverter orderConverter, OrderService orderService) {
        this.orderConverter = orderConverter;
        this.orderService = orderService;
    }

    public OrderResponseModel create(OrderRequestModel requestModel) {
        OrderDTO dto = orderConverter.buildDtoFromRequest(requestModel);
        OrderDTO orderDTO = orderService.create(dto);
        return orderConverter.buildResponseFromDto(orderDTO);
    }

    public OrderResponseModel getById(Long id) {
        OrderDTO byId = orderService.getById(id);
        return orderConverter.buildResponseFromDto(byId);
    }

    public ArrayList<OrderResponseModel> getAll() {
        ArrayList<OrderDTO> all = orderService.getAll();
        List<OrderResponseModel> collect1 = all.stream()
                .map(each -> orderConverter.buildResponseFromDto(each))
                .collect(Collectors.toList());
        return (ArrayList<OrderResponseModel>) collect1;
    }

    public void deleteById(Long id) {
        orderService.deleteById(id);
    }
}