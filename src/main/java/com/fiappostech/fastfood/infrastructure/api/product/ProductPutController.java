package com.fiappostech.fastfood.infrastructure.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.product.ProductUpdatePresenter;
import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPutRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Products") // , description = "the Product Api")
@RestController
@RequestMapping("/products")
public class ProductPutController {

   @Autowired
   private final ProductUpdatePresenter productUpdatePresenter;

   @PutMapping
   public ResponseEntity<ProductResponseFull> productSave(
         @RequestBody @Valid ProductPutRequest productPutRequest) {

      return ResponseEntity.ok(productUpdatePresenter.execute(productPutRequest));
   }
}