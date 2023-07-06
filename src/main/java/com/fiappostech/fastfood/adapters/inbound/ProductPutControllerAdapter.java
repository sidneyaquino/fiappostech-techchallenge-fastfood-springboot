package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.request.ProductPutRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.ProductFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductInsertInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductPutControllerAdapter {

   private final ProductInsertInputPort productInsertInputPort;

   @PutMapping
   public ResponseEntity<ProductFullResponse> productSave(@RequestBody @Valid ProductPutRequest productPutRequest){

      try {
         var productResponse = productInsertInputPort.execute(productPutRequest.toProductRequest());
         return ResponseEntity.status(HttpStatus.CREATED).body(new ProductFullResponse(productResponse));

      // } catch (DataIntegrityViolationException e) {
      //    return ResponseEntity.status(HttpStatus.CONFLICT).build();

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}