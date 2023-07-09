package com.fiappostech.fastfood.adapters.outbound.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;
import com.fiappostech.fastfood.application.ports.dto.Tracking;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
   List<OrderEntity> findAllByTracking(Tracking tracking);
}