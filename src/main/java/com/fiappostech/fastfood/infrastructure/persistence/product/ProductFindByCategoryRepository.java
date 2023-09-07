package com.fiappostech.fastfood.infrastructure.persistence.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.product.ProductFindByCategoryGateway;
import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;
import com.fiappostech.fastfood.infrastructure.persistence.product.entity.ProductEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductFindByCategoryRepository implements ProductFindByCategoryGateway {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional(readOnly = true)
   @Override
   public List<ProductResponse> execute(ProductCategory category) {
      List<ProductEntity> listProductEntity = productRepository.findAllByCategory(category);
      return listProductEntity.stream().map(productEntity -> productEntity.toProductResponse()).toList();
   }
}