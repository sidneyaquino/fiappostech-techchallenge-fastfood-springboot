package com.fiappostech.fastfood.infrastructure.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapter.presenter.product.ProductInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPostRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Products") // , description = "the Product Api")
@RestController
@RequestMapping("/products")
public class ProductPostController {

   @Autowired
   private final ProductInsertPresenter productInsertPresenter;

   @PostMapping
   public ResponseEntity<ProductResponseFull> productSave(
         @RequestBody @Valid ProductPostRequest productPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var productResponseFull = productInsertPresenter.execute(productPostRequest);
      var uri = uriComponentsBuilder.path("/products/{productId}").buildAndExpand(productResponseFull.productId())
            .toUri();

      return ResponseEntity.created(uri).body(productResponseFull);
   }
}