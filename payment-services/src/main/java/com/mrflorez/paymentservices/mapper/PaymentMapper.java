package com.mrflorez.paymentservices.mapper;

import com.mrflorez.paymentservices.model.Payment;
import com.mrflorez.paymentservices.model.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO toDTO(Payment payment);

    Payment toEntity(PaymentDTO paymentDTO);

    List<PaymentDTO> mapToDTO(List<Payment> payments);

    List<Payment> mapToEntity(List<PaymentDTO> paymentsDto);
}
