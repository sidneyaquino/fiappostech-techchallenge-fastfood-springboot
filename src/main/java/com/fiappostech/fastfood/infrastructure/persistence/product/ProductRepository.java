package com.fiappostech.fastfood.infrastructure.persistence.product;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.infrastructure.persistence.product.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
   List<ProductEntity> findAllByCategory(ProductCategory category);
}