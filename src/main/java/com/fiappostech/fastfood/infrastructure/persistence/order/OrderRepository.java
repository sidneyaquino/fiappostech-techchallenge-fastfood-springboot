package com.fiappostech.fastfood.infrastructure.persistence.order;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderEntity;
import com.fiappostech.fastfood.infrastructure.persistence.order.projection.OrderProductProjection;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
   List<OrderEntity> findAllByTracking(OrderTracking tracking);

   List<OrderEntity> findAllByTrackingInOrderByTrackingDesc(List<OrderTracking> listTracking);

   @Query(nativeQuery = true, value = """
         SELECT items.order_id AS orderId,
               items.product_id AS productId,
               products.description,
               items.quantity,
               items.value
            FROM order_products AS items, products
            WHERE items.product_id = products.id
               AND items.order_id = :orderId
         """)
   List<OrderProductProjection> findAllOrderProductById(UUID orderId);
}