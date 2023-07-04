package com.fiappostech.fastfood.adapters.inbound;

import java.util.UUID;

import org.springframework.http.HttpStatus;
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
public class ProductDeleteByIdControllerAdapter {
   
   private final ProductDeleteByIdInputPort productDeleteByIdInputPort;

   @DeleteMapping("/{productID}")
   public ResponseEntity<Object> deleteById(@PathVariable UUID productID){

      try {
         productDeleteByIdInputPort.execute(productID);
         return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
         
      // } catch (CustomerNotFoundException e) {
      //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}