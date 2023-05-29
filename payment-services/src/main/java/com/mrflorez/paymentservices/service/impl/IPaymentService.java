package com.mrflorez.paymentservices.service.impl;

import com.mrflorez.paymentservices.model.Payment;
import com.mrflorez.paymentservices.model.dto.PaymentDTO;

import java.util.List;
import java.util.UUID;

public interface IPaymentService {

    PaymentDTO createPayment(PaymentDTO paymentDTO);

    List<PaymentDTO> allPayments();

    PaymentDTO getByCode(final String code);

}
