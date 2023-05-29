package com.mrflorez.paymentservices.mapper;

import com.mrflorez.paymentservices.model.PaymentMethod;
import com.mrflorez.paymentservices.model.dto.PaymentMethodDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethod toEntity(PaymentMethodDTO paymentMethodDTO);

    PaymentMethodDTO toDto(PaymentMethod paymentMethod);

}
