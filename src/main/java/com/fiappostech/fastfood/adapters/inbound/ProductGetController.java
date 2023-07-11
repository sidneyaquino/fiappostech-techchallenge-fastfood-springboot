package com.fiappostech.fastfood.adapters.inbound;

import java.util.List;
import java.util.UUID;

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
public class ProductGetController {

   private final ProductFindByIdInputPort productFindByIdInputPort;
   private final ProductFindByCategoryInputPort productFindByCategoryInputPort;

   @GetMapping("/{productId}")
   public ResponseEntity<ProductFullResponse> productFindById(@PathVariable UUID productId) {
      var productResponse = productFindByIdInputPort.execute(productId);
      return ResponseEntity.ok(new ProductFullResponse(productResponse));
   }

   @GetMapping
   public ResponseEntity<List<ProductFullResponse>> productFindByCatetory(@RequestParam Category category) {

      List<ProductResponse> listProductResponse = productFindByCategoryInputPort.execute(category);
      var listProductFullResponse = listProductResponse
            .stream().map(item -> new ProductFullResponse(item)).toList();

      return ResponseEntity.ok(listProductFullResponse);
   }
}