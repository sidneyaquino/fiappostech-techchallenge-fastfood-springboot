package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapters.inbound.dto.request.ProductPostRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.ProductFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductSaveInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductPostControllerAdapter {

   private final ProductSaveInputPort productSaveInputPort;

   @PostMapping
   public ResponseEntity<ProductFullResponse> productSave(
         @RequestBody @Valid ProductPostRequest productPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var productResponse = productSaveInputPort.execute(productPostRequest.toProductRequest());
      var uri = uriComponentsBuilder.path("/products/{productId}").buildAndExpand(productResponse.productId()).toUri();

      return ResponseEntity.created(uri).body(new ProductFullResponse(productResponse));
   }
}