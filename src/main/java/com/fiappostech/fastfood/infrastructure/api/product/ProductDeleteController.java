package com.fiappostech.fastfood.infrastructure.api.product;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.product.ProductDeleteByIdPresenter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductDeleteController {
   
   private final ProductDeleteByIdPresenter productDeleteByIdPresenter;

   @DeleteMapping("/{productID}")
   public ResponseEntity<Object> productDeleteById(@PathVariable UUID productID){
      productDeleteByIdPresenter.execute(productID);
      return ResponseEntity.noContent().build();
   }
}