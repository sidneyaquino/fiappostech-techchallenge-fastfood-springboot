package com.fiappostech.fastfood.infrastructure.api.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapter.presenter.product.ProductInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPostRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductPostController {

   private final ProductInsertPresenter productInsertPresenter;

   @PostMapping
   public ResponseEntity<ProductResponseFull> productSave(
         @RequestBody @Valid ProductPostRequest productPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var productResponseFull = productInsertPresenter.execute(productPostRequest);
      var uri = uriComponentsBuilder.path("/products/{productId}").buildAndExpand(productResponseFull.productId()).toUri();

      return ResponseEntity.created(uri).body(productResponseFull);
   }
}