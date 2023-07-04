package com.fiappostech.fastfood.adapters.outbound.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.adapters.outbound.entity.ProductEntity;
import com.fiappostech.fastfood.application.ports.dto.Category;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
   List<ProductEntity> findAllByCategory(Category category);
}