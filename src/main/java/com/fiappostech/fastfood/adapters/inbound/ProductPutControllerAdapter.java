package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.request.ProductPutRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.ProductFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductSaveInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductPutControllerAdapter {

   private final ProductSaveInputPort productSaveInputPort;

   @PutMapping
   public ResponseEntity<ProductFullResponse> productSave(
         @RequestBody @Valid ProductPutRequest productPutRequest) {

      var productResponse = productSaveInputPort.execute(productPutRequest.toProductRequest());
      return ResponseEntity.ok(new ProductFullResponse(productResponse));
   }
}