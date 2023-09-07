package com.fiappostech.fastfood.infrastructure.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderProductEntity;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderProductPk;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, OrderProductPk> {
   // List<OrderProductEntity> findAllByOrder(UUID orderI);
}