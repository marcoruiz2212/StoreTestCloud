package com.mrflorez.orderservices.service.impl;

import com.mrflorez.orderservices.model.common.PaymentDTO;

public interface IPaymentService {
    PaymentDTO getPaymentByCode(final String code);
}
