package com.fiappostech.fastfood.infrastructure.api.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByCategoryPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.ProductFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.domain.entity.ProductCategory;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Products") // , description = "the Product Api")
@RestController
@RequestMapping("/products")
public class ProductGetController {

   @Autowired
   private final ProductFindByIdPresenter productFindByIdPresenter;
   @Autowired
   private final ProductFindByCategoryPresenter productFindByCategoryPresenter;

   @GetMapping("/{productId}")
   public ResponseEntity<ProductResponseFull> productFindById(@PathVariable UUID productId) {
      return ResponseEntity.ok(productFindByIdPresenter.execute(productId));
   }

   @GetMapping
   public ResponseEntity<List<ProductResponseFull>> productFindByCatetory(@RequestParam ProductCategory category) {
      return ResponseEntity.ok(productFindByCategoryPresenter.execute(category));
   }
}