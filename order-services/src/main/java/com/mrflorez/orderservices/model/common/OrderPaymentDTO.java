package com.mrflorez.orderservices.model.common;

import com.mrflorez.orderservices.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPaymentDTO {
    private OrderDTO order;
    private PaymentDTO paymentDTO;
}
