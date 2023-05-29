package com.mrflorez.orderservices.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private UUID id;

    private String code;

    private String description;

    private Date paymentDate;

    private Long amount;
}
