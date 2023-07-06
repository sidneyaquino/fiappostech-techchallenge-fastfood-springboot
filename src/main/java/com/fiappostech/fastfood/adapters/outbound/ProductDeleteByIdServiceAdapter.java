package com.fiappostech.fastfood.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.outbound.ProductDeleteByIdOutputPort;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductDeleteByIdServiceAdapter implements ProductDeleteByIdOutputPort {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional
   @Override
   public void execute(UUID productId) {
      var productOptional = productRepository.findById(productId);
      
      if(productOptional.isEmpty()) {
         throw new RecordNotFoundException(productId);
      }
      productRepository.delete(productOptional.get());
   }
}