package com.mrflorez.paymentservices.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long id;

    private String code;

    private String description;

    private Date paymentDate;

    private Long amount;

    private List<PaymentMethodDTO> paymentMethods;



}
