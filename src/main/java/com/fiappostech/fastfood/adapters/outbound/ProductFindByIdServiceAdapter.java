package com.fiappostech.fastfood.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByIdOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductFindByIdServiceAdapter implements ProductFindByIdOutputPort {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional(readOnly = true)
   @Override
   public ProductResponse execute(UUID productId) {
      return productRepository.getReferenceById(productId).toProductResponse();
   }
}