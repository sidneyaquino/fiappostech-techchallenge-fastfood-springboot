package com.fiappostech.fastfood.infrastructure.api.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.product.ProductUpdatePresenter;
import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPutRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductPutController {

   private final ProductUpdatePresenter productUpdatePresenter;

   @PutMapping
   public ResponseEntity<ProductResponseFull> productSave(
         @RequestBody @Valid ProductPutRequest productPutRequest) {

      return ResponseEntity.ok(productUpdatePresenter.execute(productPutRequest));
   }
}