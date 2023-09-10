package com.fiappostech.fastfood.infrastructure.persistence.product;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductDeleteByIdRepository {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional
   public void execute(UUID productId) {
      var productOptional = productRepository.findById(productId);

      if(productOptional.isEmpty()) {
         throw new RecordNotFoundException(productId);
      }
      productRepository.delete(productOptional.get());
   }
}