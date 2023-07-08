package com.fiappostech.fastfood.adapters.outbound.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
   // List<OrderEntity> findAllByTrackig(Tracking tracking);
}