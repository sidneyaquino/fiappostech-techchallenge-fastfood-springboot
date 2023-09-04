package com.fiappostech.fastfood.adapters.outbound.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.adapters.outbound.entity.PaymentEntity;
import com.fiappostech.fastfood.adapters.outbound.projection.PaymentProjection;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
   // List<PaymentEntity> findAllByOrderId(UUID orderId);
   // PaymentEntity findFirstByOrderidOrderByCreatedDesc(UUID orderId);

   @Query(nativeQuery = true, value = """
         SELECT id AS paymentId,
               order_id AS orderId,
               created,
               approved,
               status,
               status_detail AS statusDetail,
               value
            FROM payments
            WHERE order_id = :orderId
            ORDER BY created DESC
            LIMIT 1
         """)
   PaymentProjection findByOrderId(UUID orderId);
}