package com.fiappostech.fastfood.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.outbound.ProductDeleteByIdOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductDeleteByIdServiceAdapter implements ProductDeleteByIdOutputPort {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional
   @Override
   public void execute(UUID productId) {

      try {
         var productEntity = productRepository.findById(productId).get();
         productRepository.delete(productEntity);

      } catch (Exception e) {
         // throw new NotFoundException(personalId);
         throw e;
      }
   }
}