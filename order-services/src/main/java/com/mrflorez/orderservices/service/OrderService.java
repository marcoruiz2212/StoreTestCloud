package com.mrflorez.orderservices.service;

import com.mrflorez.orderservices.model.Order;
import com.mrflorez.orderservices.model.common.OrderPaymentDTO;
import com.mrflorez.orderservices.model.common.PaymentDTO;
import com.mrflorez.orderservices.model.dto.OrderDTO;
import com.mrflorez.orderservices.repository.OrderRepository;
import com.mrflorez.orderservices.service.impl.IOrderService;
import com.mrflorez.orderservices.service.impl.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    private final IPaymentService paymentService;


    @Override
    public OrderDTO saveOrder(final OrderDTO orderDTO) {
        final Order order = Order.builder()
                .code(orderDTO.getCode())
                .orderDate(orderDTO.getOrderDate() != null ? orderDTO.getOrderDate(): new Date()).build();
        final Order orderCreated = orderRepository.save(order);
        return populateOrderDTO(orderCreated);
    }

    @Override
    public OrderPaymentDTO updatePaymentOrder(final OrderDTO orderDTO, final String code) {
        final Order order = Order.builder()
                .id(orderDTO.getId())
                .code(orderDTO.getCode())
                .orderDate(orderDTO.getOrderDate()).build();

        final PaymentDTO paymentDTO = paymentService.getPaymentByCode(code);
        order.setPaymentId(paymentDTO.getId());
        order.setAmount(paymentDTO.getAmount());
        final OrderPaymentDTO orderPaymentDTO = OrderPaymentDTO.builder().order(orderDTO).paymentDTO(paymentDTO).build();
        orderRepository.save(order);
        return orderPaymentDTO;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        final List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::populateOrderDTO).collect(Collectors.toList());
    }

    private OrderDTO populateOrderDTO(final Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .code(order.getCode())
                .build();
    }
}
