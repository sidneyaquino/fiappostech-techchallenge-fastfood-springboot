package com.fiappostech.fastfood.adapters.outbound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.ProductEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByCategoryOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductFindByCategoryServiceAdapter implements ProductFindByCategoryOutputPort {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional(readOnly = true)
   @Override
   public List<ProductResponse> execute(Category category) {
      List<ProductEntity> listProductEntity = productRepository.findAllByCategory(category);
      return listProductEntity.stream().map(productEntity -> productEntity.toProductResponse()).toList();
   }
}