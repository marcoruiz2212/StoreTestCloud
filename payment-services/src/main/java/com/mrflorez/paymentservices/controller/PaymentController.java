package com.mrflorez.paymentservices.controller;

import com.mrflorez.paymentservices.model.dto.PaymentDTO;
import com.mrflorez.paymentservices.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO){
       final PaymentDTO paymentCreated =  paymentService.createPayment(paymentDTO);
       return new ResponseEntity<>(paymentCreated, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentDTO>> getAll(){
        final List<PaymentDTO> payments = paymentService.allPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/getByCode/{code}")
    public ResponseEntity<PaymentDTO> getByCode(@PathVariable String code, @RequestHeader("x-username") final String username){
        final PaymentDTO payment = paymentService.getByCode(code);
        return new ResponseEntity<>(payment, HttpStatus.NOT_FOUND);
    }
}
