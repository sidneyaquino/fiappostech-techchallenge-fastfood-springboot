package com.fiappostech.fastfood.adapters.inbound;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.response.ProductFullResponse;
import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductFindByCategoryInputPort;
import com.fiappostech.fastfood.application.ports.inbound.ProductFindByIdInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductGetControllerAdapter {
   
   private final ProductFindByIdInputPort productFindByIdInputPort;
   private final ProductFindByCategoryInputPort productFindByCategoryInputPort;

   @GetMapping("/{productID}")
   public ResponseEntity<Object> productFindById(@PathVariable UUID productID){

      try {
         var productResponse = productFindByIdInputPort.execute(productID);
         return ResponseEntity.status(HttpStatus.OK).body(new ProductFullResponse(productResponse));
         
      // } catch (CustomerNotFoundException e) {
      //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }

   @GetMapping
   public ResponseEntity<Object> productFindByCatetory(@RequestParam Category category){

      try {
         List<ProductResponse> listProductResponse = productFindByCategoryInputPort.execute(category);
         var listProductFullResponse = listProductResponse.stream().map(productResponse -> new ProductFullResponse(productResponse)).toList();
         return ResponseEntity.status(HttpStatus.OK).body(listProductFullResponse);
         
      // } catch (CustomerNotFoundException e) {
      //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}