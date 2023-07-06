package com.fiappostech.fastfood.adapters.inbound;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.application.ports.inbound.ProductDeleteByIdInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductDeleteControllerAdapter {
   
   private final ProductDeleteByIdInputPort productDeleteByIdInputPort;

   @DeleteMapping("/{productID}")
   public ResponseEntity<Object> productDeleteById(@PathVariable UUID productID){
      
      productDeleteByIdInputPort.execute(productID);
      return ResponseEntity.noContent().build();
   }
}