package com.fiappostech.fastfood.adapters.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderProductEntity;
import com.fiappostech.fastfood.adapters.outbound.entity.OrderProductPk;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, OrderProductPk> {
   // List<OrderProductEntity> findAllByOrder(UUID orderI);
}