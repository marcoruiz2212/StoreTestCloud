package com.mrflorez.orderservices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "order_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private Date orderDate;

    private UUID paymentId;

    private Long amount;

    @OneToMany(mappedBy = "order")
    Set<ProductOrder> products;

}
