package com.mrflorez.orderservices.service.impl;

import com.mrflorez.orderservices.model.common.OrderPaymentDTO;
import com.mrflorez.orderservices.model.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface IOrderService {

    OrderDTO saveOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllOrders();

    OrderPaymentDTO updatePaymentOrder(final OrderDTO orderDTO, final String code);
}
