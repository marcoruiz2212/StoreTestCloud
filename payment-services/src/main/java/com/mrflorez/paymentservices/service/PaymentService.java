package com.mrflorez.paymentservices.service;

import com.mrflorez.paymentservices.mapper.PaymentMapper;
import com.mrflorez.paymentservices.repository.PaymentRepository;
import com.mrflorez.paymentservices.model.Payment;
import com.mrflorez.paymentservices.model.dto.PaymentDTO;
import com.mrflorez.paymentservices.service.impl.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        final Payment payment = paymentMapper.toEntity(paymentDTO);
        final Payment paymentCreated =  paymentRepository.save(payment);
        return paymentMapper.toDTO(paymentCreated);
    }

    @Override
    public List<PaymentDTO> allPayments() {
        final List<Payment> payments = paymentRepository.findAll();
        return paymentMapper.mapToDTO(payments);
    }

    public PaymentDTO getByCode(final String code){
        final Payment payment = paymentRepository.findByCode(code);
        return paymentMapper.toDTO(payment);
    }



}
