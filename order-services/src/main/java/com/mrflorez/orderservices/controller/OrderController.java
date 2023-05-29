package com.mrflorez.orderservices.controller;

import com.mrflorez.orderservices.model.common.OrderPaymentDTO;
import com.mrflorez.orderservices.model.dto.OrderDTO;
import com.mrflorez.orderservices.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO){
       final OrderDTO order = orderService.saveOrder(orderDTO);
       return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        final List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/updatePayment")
    public ResponseEntity<OrderPaymentDTO> updatePaymentOrder(@RequestBody OrderDTO orderDTO, @RequestParam("paymentCode") final String paymentCode){
        final OrderPaymentDTO order = orderService.updatePaymentOrder(orderDTO, paymentCode);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
