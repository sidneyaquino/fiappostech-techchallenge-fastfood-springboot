package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.request.ProductRequestDTO;
import com.fiappostech.fastfood.adapters.inbound.dto.response.ProductResponseDTO;
import com.fiappostech.fastfood.application.ports.inbound.ProductAddInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductPostControllerAdapter {

   private final ProductAddInputPort productAddInputPort;

   @PostMapping
   public ResponseEntity<ProductResponseDTO> save(@RequestBody @Valid ProductRequestDTO productRequestDTO){

      try {
         var productResponse = productAddInputPort.execute(productRequestDTO.toProductRequest());
         return ResponseEntity.status(HttpStatus.CREATED).body(new ProductResponseDTO(productResponse));

      // } catch (DataIntegrityViolationException e) {
      //    return ResponseEntity.status(HttpStatus.CONFLICT).build();

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}