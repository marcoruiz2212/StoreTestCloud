package com.mrflorez.paymentservices.repository;

import com.mrflorez.paymentservices.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    Payment findByCode(String code);

    @Query("SELECT n FROM Payment n WHERE n.id= ?1")
    Payment findOneByUuid(UUID id);
}
