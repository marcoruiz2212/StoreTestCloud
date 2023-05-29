package com.mrflorez.orderservices.service;

import com.mrflorez.orderservices.model.common.PaymentDTO;
import com.mrflorez.orderservices.service.impl.IPaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final RestTemplate template;


    @CircuitBreaker(name = "getPaymentByCode", fallbackMethod = "getPaymentDefault")
    public PaymentDTO getPaymentByCode(final String code){
        log.info("getPaymentByCode");
        final String url = "http://PAYMENT-SERVICE/payment/getByCode/".concat(code);
        final PaymentDTO paymentDTO = template.getForEntity(url, PaymentDTO.class).getBody();
        return  paymentDTO;
    }

    public PaymentDTO getPaymentDefault(final String code, Exception e){
        return PaymentDTO.builder().code("-01").paymentDate(new Date()).amount(0l).build();
    }

}
